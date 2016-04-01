<?php
	if (!isset($_GET["api_host"]) || !isset($_GET["token"]))
	{
		exit();
	}
	$api_host = $_GET["api_host"];
	$token = $_GET["token"];
?>
<!DOCTYPE html>
<html>
<head>
	<title>Chat</title>
	<link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="scroll/jquery.scrollbar.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<?=$api_host?>socket.io/socket.io.js"></script>
	<script type="text/javascript" src="scroll/jquery.scrollbar.min.js"></script>
	<script type="text/javascript" src="js/core.js"></script>
	<link rel="stylesheet" href="style.css" />
</head>
<body>
<p>Current Room: <span id="current_room"></span></p>
<hr>
<div class="container">
	<div class="form-group row">
		<div class="col-xs-8">
			<input type="text" class="form-control" placeholder="Current Room Name" id="room_name">
		</div>
		<div class="col-xs-4">
			<button class="btn btn-primary" id="join_room">Enter to Room</button>
		</div>
	</div>
	
	<div class="form-group row">
		<div class="col-xs-4">
			<input type="text" class="form-control" placeholder="Old Room Name" id="room_name_old">
		</div>
		<div class="col-xs-4">
			<input type="text" class="form-control" placeholder="New Room Name" id="room_name_new">
		</div>
		<div class="col-xs-4">
			<button class="btn btn-primary" id="change_chat_name">Change to Room Name</button>
		</div>
	</div>
	
	<div class="form-group row">
		<div class="col-xs-8">
			<input type="text" class="form-control" placeholder="Invitation Path" id="inv_path">
		</div>
		<div class="col-xs-4">
			<button class="btn btn-primary" id="inv">Invite</button>
		</div>
	</div>
	
	<div class="form-group row">
		<div class="col-xs-12">
			<button data-toggle="collapse" data-target="#more" class="btn btn-primary">More Options</button>
		</div>		
	</div>
	
	<div class="collapse" id="more">
		<?php include_once("more.php"); ?>		
	</div>
	
</div>

<div class="container">	
	<div class="panel panel-info" id="panelGeneral">
		<div class="panel-heading">
			<div class="input-group">
	           <input type="text" id="chat_bar" class="form-control" placeholder="Enter Message">
	            <span class="input-group-btn">
	                <button class="btn btn-info" id="send" type="button">SEND</button>
	            </span>
	        </div>
        </div>     
        
        <div class="panel-body">        	
        	<div class="media-list scrolled scrollbar-light">
        		
        	</div>
        </div>
		
		<div id="clear_chat">x</div>
	</div>	
</div>

<div class="container">	
    <div class="row">
        <div class="col-md-5">
            <div class="panel panel-primary hide" id="panelPM">
                <div class="panel-heading">
                    <span class="glyphicon glyphicon-comment"></span> Chat
                    <div class="btn-group pull-right">
                        <button type="button" class="btn btn-default btn-xs dropdown-toggle" data-toggle="dropdown">
                            <span class="glyphicon glyphicon-chevron-down"></span>
                        </button>
                        
                    </div>
                </div>
                <div class="panel-body">
                    <ul class="chat" style="list-style:none;">
                        <li class="left clearfix chat_el hide"><span class="chat-img pull-left">
                            <img src="#" alt="User Avatar" class="img-circle">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <strong class="primary-font pm_name"></strong> 
                                    <small class="pull-right text-muted">
                                        <span class="glyphicon glyphicon-time"></span>12 mins ago
                                    </small>
                                </div>
                                <p class="pm_msg">
                                    
                                </p>
                            </div>
                        </li>                      
                        
                    </ul>
                </div>
                <div class="panel-footer">
                    <div class="input-group">
                        <input id="btn-input" type="text" class="form-control input-sm" placeholder="Type your message here...">
                        <span class="input-group-btn">
                            <button class="btn btn-warning btn-sm" id="btn-chat">
                                Send</button>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<li class="media hide">
	<div class="media-body">
		<div class="media">
            <a class="pull-left" href="#"><img width="50px" class="media-object img-circle " src=""></a>
            <div class="media-body"><span class="chat_msg">[MSG]</span><br><small class="text-muted"><span class="chat_name">[MSG]</span> | 23rd June at 5:00pm</small><hr></div>
        </div>
    </div>
</li>

<script type="text/javascript">
	(function() {
		var socket = io('<?=$api_host?>api?token=<?=$token?>');
		var room = null;
		var el = $(".media.hide");
		var pm_el = $(".chat_el");
		if(socket === undefined)
			return false;	
		
		$("#more").click(function() {
			socket.emit('triggerRoomHistory', {room: "public", offset:0, limit: 100});						
		});			

		$("#inv").click(function() {	
			var inv_path = $("#inv_path").val();
			var ids = inv_path.split(",");
			socket.emit('invite_to_chat', {uid:ids});
			//socket.emit('trigger_get_boxes');
		});	
		
		$("#clear_chat").click(function(){
			$(".media-list").html("");
			socket.emit("testsort", {ids:"33->61"});
		});

		$("#undone").click(function(){
			socket.emit('triggerUndoneRequests', {});
		});

		socket.on('getUndoneRequests', function(data){
			console.log(data);
		});


		socket.on('get_boxes', function(boxes){
			console.log(boxes);
		});
		
		$("#change_chat_name").click(function(){
			var old_room = $("#room_name_old").val();
			var new_room = $("#room_name_new").val();
			socket.emit("reorganized_current_chat", {current_room:old_room, new_room:new_room});
		});
		
		
		$("#reorg_chat").click(function(){
			//var data = prompt("Enter ids separated by comma");
			//var ids = data.split(",");
			socket.emit("reorganized_current_chat", {current_room:"12765->12745->12744->12712", new_room:"12765->12745->12744"});
		});
		
		$("#join_room").click(function(){
			room = $("#room_name").val();
			if (!room.length) {
				return false;
			}
			$(document).trigger("join_room", [socket, room]);
		});
		
		$("#kick").click(function(){
			var f_room = $("#kick_roomname").val();
			if (!f_room.length)
			{
				f_room = room;
			}
			var user_id = $("#kick_uid").val();
			if (!user_id.length)
			{
				return false;
			}
			socket.emit('kick_from_room', {uid:user_id, room:f_room});
		});

		socket.on('notifications', function(data){
			console.log(data);
		    if(data.request_method == 'connection' && data.status == 1){
		    	$(document).trigger("success_login", [data]);
		    	$(document).trigger("buildRooms", [socket, data.user_data]);					    	
		    }

		    if(data.request_type == 'invite'){
		        var reponse = confirm('You have recieved an invitation from  '+data.name + ". Accept? Room "+data.room);
		        if(reponse){
		            // Accept invitation					
		            socket.emit('accept_invitaion', {room: data.room, invite_id:data.invite_id}); // 
		        }
		        if(reponse === false){
		        	socket.emit('reject_invitation', {room: data.room, invite_id:data.invite_id});	
		        }
		    }

		    if(data.type == "accepted_invitation"){
		    	$("#panelGeneral").addClass("hide");
		    	$("#panelPM").removeClass("hide");
		    	var udata = data.params.userData;

		    	$("#btn-chat").click(function() {
					var val = $(this).closest(".input-group").find("input").val();
					console.log(data);					
					socket.emit("send_message", {room:data.params.room, msg:val});
				});

				$("#checkUsers").click(function() {
					socket.emit('get_room_users', {room: data.params.room}); 
				});			    	

		    }	
		});

		$(document).on("success_login", function(e, data) {
			var user_data = data.user_data;
			$("#user_rooms").html("");
			$("#user_rooms").append('<option value="0">Choose Roome</option>');
			for (var i = 0; i < user_data.string_rooms.length; i++)
			{
				$("#user_rooms").append('<option value="'+user_data.string_rooms[i]+'">'+user_data.string_rooms[i]+'</option>');
			}
		});
		
		$(document).on("change", "#user_rooms", function(){
			room = $(this).val();
			$(document).trigger("join_room", [socket, room]);
		});

		$("#send").click(function() {
			var msg = $("#chat_bar").val();
			//socket.emit('send_message', {room:"12765->12764->12745->12744->12712", msg:msg, cacheKey: hashCode(makeid()+makeid())});
			
			socket.emit('send_message', {room:room, msg:msg, cacheKey: hashCode(makeid()+makeid())});			
		});

		$("#chat_bar").keypress(function(e){
			if(e.which == 13){
				//socket.emit("kick_from_room", {"uid":"84", "room":"772->84"});
				//socket.emit("invite_to_chat", {"uid":"84"});				
				//socket.emit("vazcore_create_table", {"uid":"105"});
				var msg = $("#chat_bar").val();
				socket.emit('send_message', {room:room, msg:msg});	
			}
		});

		hashCode = function(str){
	        var hash = 0,
	            len = str.length;
	    
	        for (var i = 0; i < len; i++) {
	            hash = hash * 31 + str.charCodeAt(i);
	        }
	        return hash;
	    }

	    function makeid()
		{
		    var text = "";
		    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		    for( var i=0; i < 5; i++ )
		        text += possible.charAt(Math.floor(Math.random() * possible.length));

		    return text;
		}
		
		$(document).on("newMessages", ".media-list", function(){
			$('.scrolled').scrollbar();
		});
		

		socket.on('get_messages', function(data){			
		    var message_display = $(".media-list");
		    console.log(data);
		    var it = 0;
		    $.each(data, function(i, val){
		    	it++;
		    	if(it == 10)
		    		return false;
		        var chat = el.clone();
		        chat.removeClass("hide");
		        chat.find(".chat_msg").text(val.msg);
		        chat.find("img").attr("src", val.avatar);
		        chat.find(".chat_name").text(val.name);
		        message_display.append(chat);   
				// trigger scroll
				$(".media-list").trigger("newMessages");
		    });
			
		});

	})()
	
</script>
</body>
</html>