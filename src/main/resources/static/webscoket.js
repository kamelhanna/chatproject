const url = "http://localhost:8088";
let stompClient = null;
let selectedUserOrGroup="402880f883e9e01b0183e9e028df0000";
let newMessages = new Map();
let userId = null;


window.onload = function() {
    $.get(url + "/users/userId", function (response) {
        let user  = response;
        userId = user['id'];
        console.log(userId);

        if (userId == null) {
            window.location.href = "index.html";
            return false;
        }

        fetchAll();
        connectToChat(userId);
    });

};

function fetchAll() {

    console.log(userId);

    $.get(url + "/chats/user/"+userId, function (response) {
        let groups = response;
        let groupsTemplateHTML = "";
        for (let i = 0; i < groups.length; i++) {
            console.log(groups[i]['chatTopic'])
            groupsTemplateHTML = groupsTemplateHTML + '<li class="active" id="child_message" onclick="formMessageLaunch(\''+groups[i]['id']+'\',\''+groups[i]['chatTopic']+'\',\'group\')" data-groupid="'+groups[i]['id']+'" data-type="group">'+
                '<div class="d-flex bd-highlight">'+
                '<div class="img_cont">'+
                '<img src="https://static.turbosquid.com/Preview/001292/481/WV/_D.jpg" class="rounded-circle user_img">'+
                '<span class="online_icon"></span>'+
                '</div>'+
                '<div class="user_info" id="userGroupAppender_' + groups[i]['id'] + '">'+
                '<span>'+groups[i]['chatTopic']+'</span>'+
                '<p>'+groups[i]['chatTopic']+' is active</p>'+
                '</div>'+
                '</div>'+
                '</li>';
        }
        $('#groupList').html(groupsTemplateHTML);

    });
}

function formMessageLaunch(id,name,type){

    let buttonSend= document.getElementById("buttonSend");
    if(buttonSend!==null){
        buttonSend.parentNode.removeChild(buttonSend);
    }

    let nama=$('#formMessageHeader .user_info').find('span')

    nama.html("Chat With "+name);
    nama.attr("data-id",id);
    let isNew = document.getElementById("newMessage_" + id) !== null;
    if (isNew) {
        let element = document.getElementById("newMessage_" + id);
        element.parentNode.removeChild(element);
    }

    let username = $('#userName').attr("data-id");
    selectedUserOrGroup=username;

    let isHistoryMessage = document.getElementById("formMessageBody");
    if(isHistoryMessage!== null && isHistoryMessage.hasChildNodes()){
        isHistoryMessage.innerHTML="";
    }

    if(type == "group"){
        $.get(url + "/messages/chats/"+id, function (response) {
            let messagesGroup = response;
            let messageGroupTemplateHTML = "";
            for (let i = 0; i < messagesGroup.length; i++) {
                if(messagesGroup[i]['userId']==userId){
                    messageGroupTemplateHTML = messageGroupTemplateHTML + '<div id="child_message" class="d-flex justify-content-start mb-4">'+
                        '<div id="child_message" class="msg_cotainer">'+messagesGroup[i]['messageText']+
                        '</div>'+
                        '</div>';
                }else{
                    messageGroupTemplateHTML = messageGroupTemplateHTML + '<div id="child_message" class="d-flex justify-content-end mb-4">'+
                        '<div id="child_message" class="msg_cotainer_send">'+messagesGroup[i]['messageText']+
                        '</div>'+
                        '<p>'+messagesGroup[i]['userName']+'</>'+
                        '</div>';
                }

            }
            $('#formMessageBody').append(messageGroupTemplateHTML);
        });
    }

    let dataType = type;

    let submitButton='<div class="input-group-append" id="buttonSend">'+
        '<button class="input-group-text send_btn" onclick="sendMessage(\''+dataType+'\')"><i class="fas fa-location-arrow"></i></button>'+
        '</div>';
    $('#formSubmit').append(submitButton)
}

function sendMessage(type) {
    let username = $('#userName').attr("data-id");
    let message=$('#message-to-send').val();

    selectedUserOrGroup=username;
    console.log("type : "+type)
    console.log("userId: ", userId)
    console.log("message: ", message)
    if(type=="group"){
        sendMsgGroup(userId, message);
    }

    let messageTemplateHTML = "";
    messageTemplateHTML = messageTemplateHTML + '<div id="child_message" class="d-flex justify-content-start mb-4">'+
        '<div id="child_message" class="msg_cotainer">'+message+
        '</div>'+
        '</div>';
    $('#formMessageBody').append(messageTemplateHTML);
    console.log("append success")

    document.getElementById("message-to-send").value="";

}

function sendMsgGroup(from, text) {
    console.log("send message to group", selectedUserOrGroup);
    stompClient.send("/app/messages/chats/" + selectedUserOrGroup, {}, JSON.stringify({
        messageText:text,
        userId:from,
        chatId:selectedUserOrGroup
    }));

}

function connectToChat(userId) {
    console.log("connecting to chat...")
    let socket = new SockJS(url + '/ws');
    // let socket=new WebSocket("wss://localhost:8080/ws")
    stompClient = Stomp.over(socket);
    //stompClient = webstomp.over(new SockJS('/ws'));
    stompClient.connect({"X-Authorization":"Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJVQmppQkZXYmM4NnpBaER0M1QtTUJ6cnl3R3FnYkF5QlFxYjRjN0w3VHpNIn0.eyJleHAiOjE2MzE1ODc4NzksImlhdCI6MTYzMDM3ODI3OSwianRpIjoiODAyZGQyYzAtNjlhYi00Yjk2LTllZjgtODA5YWY3MWJmNmFmIiwiaXNzIjoiaHR0cHM6Ly9rZXljbG9hay1kZXYuZ2l0c29sdXRpb25zLmlkL2F1dGgvcmVhbG1zL2dpdCIsImF1ZCI6WyJyZWFsbS1tYW5hZ2VtZW50IiwiYWNjb3VudCJdLCJzdWIiOiJhYTkzMzMxMi0wMjhkLTQ3MzQtYTlhNC1hMGYxNmNlZDY5ZTEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJnaXQtY2xpZW50Iiwic2Vzc2lvbl9zdGF0ZSI6IjM5YTRhNzFhLTJmZWYtNDkwMS1hNjdlLTYwYTViNjI0YjllNyIsImFjciI6IjEiLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7InJlYWxtLW1hbmFnZW1lbnQiOnsicm9sZXMiOlsidmlldy1yZWFsbSIsInZpZXctaWRlbnRpdHktcHJvdmlkZXJzIiwibWFuYWdlLWlkZW50aXR5LXByb3ZpZGVycyIsImltcGVyc29uYXRpb24iLCJyZWFsbS1hZG1pbiIsImNyZWF0ZS1jbGllbnQiLCJtYW5hZ2UtdXNlcnMiLCJxdWVyeS1yZWFsbXMiLCJ2aWV3LWF1dGhvcml6YXRpb24iLCJxdWVyeS1jbGllbnRzIiwicXVlcnktdXNlcnMiLCJtYW5hZ2UtZXZlbnRzIiwibWFuYWdlLXJlYWxtIiwidmlldy1ldmVudHMiLCJ2aWV3LXVzZXJzIiwidmlldy1jbGllbnRzIiwibWFuYWdlLWF1dGhvcml6YXRpb24iLCJtYW5hZ2UtY2xpZW50cyIsInF1ZXJ5LWdyb3VwcyJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsInZpZXctYXBwbGljYXRpb25zIiwidmlldy1jb25zZW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJkZWxldGUtYWNjb3VudCIsIm1hbmFnZS1jb25zZW50Iiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJnaXRzY29wZSIsInRlbmFudF9pZCI6WyI1ZDEyNWI2OS05YzcxLTRhYzktODVhNi1lMWQ4NGU3ZDFiNWIiXSwiZ3JvdXBfbmFtZSI6IklEU3RhciIsInVzZXJfbmFtZSI6ImZyZWR5LmZlcm5hbmRvIiwiaW5zdGFuY2VfdXJsIjpbImh0dHBzOi8vZGV2LmdpdHNvbHV0aW9ucy5pZCJdLCJpbnN0YW5jZV9hcGkiOlsiaHR0cHM6Ly9hcGktZGV2LmdpdHNvbHV0aW9ucy5pZCJdLCJlbXBfaWQiOiJlYmEyYjQ2Yi05MjljLTExZWItOTdjZS0wYWRiY2M5ZWFhYTgifQ.SAW95PiA3DZFwjOCeY3-aLzHPKkH9J_ucbZQ6rV9b8QjZ8zbzW_0F2yrYa7GpKjFNmZ7cL1mFm46wepnGwZvqUIb08EDN0wIqgf20XUsnck7Ji8av4HVEgAuLseiOwoHKHSjRGY8Rj-AeOQ3clbmYz_wy0RtlRResmr0_M59X-iYBtIaWxIDnfarqKvAWHz1Sus0y1abPvRyahLTjtAeKYNITmVhYQb66vWomttJiEDvKmCcNpQtJjW2WkJi7SiojxrsjFOo9R_PiPnYV3vMjsZMRfa8n3PXeG1g-cRst6nYZ0YYoarhAS_aLv-cCzEty5-rgEOMPGWPtyYGtKbJbg"}, function (frame) {
        console.log("connected to: " + frame);

        $.get(url + "/chats/user/"+userId, function (response) {
            let chats = response;
            for (let i = 0; i < chats.length; i++) {
                stompClient.subscribe("/topic/messages/chat/" + chats[i]["id"], function (response) {
                    let data = JSON.parse(response.body);
                    console.log("selectedUserOrGrup = "+selectedUserOrGroup)
                    console.log("data.group_id = "+data.chatId)
                    if (selectedUserOrGroup == data.chatId && data.userId == userId){
                    }
                    else if (selectedUserOrGroup == data.chatId && data.userId != userId){
                        console.log("selectedUserOrGrup == data.fromLogin")

                        let messageTemplateHTML = "";
                        messageTemplateHTML = messageTemplateHTML + '<div id="child_message" class="d-flex justify-content-end mb-4">'+
                            '<div id="child_message" class="msg_cotainer_send">'+data.messageText+
                            '</div>'+
                            '<p>'+data.userName+'</>'+
                            '</div>';
                        $('#formMessageBody').append(messageTemplateHTML);
                        console.log("append success")
                    }

                    else {
                        newMessages.set(data.chatId, data.messageText);
                        $('#userGroupAppender_' + data.chatId).append('<span id="newMessage_' + data.chatId + '" style="color: red">+1</span>');
                        let messageTemplateHTML = "";
                        messageTemplateHTML = messageTemplateHTML + '<div id="child_message" class="d-flex justify-content-end mb-4">'+
                            '<div id="child_message" class="msg_cotainer_send">'+data.messageText+
                            '</div>'+
                            '</div>';
                        console.log("append success")
                    }
                })
            }
        });
    },onError);
}

function onError() {
    console.log("Disconnected from console")
}


