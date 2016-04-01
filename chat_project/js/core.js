$(function(){

	var $rooms_list = $("#rooms_list");
	var socket = null;

	$(document).on("buildRooms", function(e, s, data){		
		for(var i=0;i<data.string_rooms.length;i++){
			$rooms_list.append("<li class='room_entry'>"+data.string_rooms[i]+"</li>");
		}
		socket = s;

	});
		
	
	$(document).on("join_room", function(e, socket, room){	
		$("#current_room").text(room);
		socket.emit('join_room', {room:room});
	});

	$(document).on("click", ".room_entry", function(){
		var room = $(this).text();
		socket.emit("join_room", {room:room});
		$(".media-list").html("");
		$(".media-list").attr("room", room);		
	});

	$("#getUndoneThings").click(function() {
		socket.emit("triggerUndoneRequests", {});

		socket.on('getUndoneRequests', function(data){
			console.log(data);
		});
	});

	$("#start_invite").click(function() {
		var ids = prompt("Type users IDs for inviting, with comas");

		if(ids.indexOf(",") != -1){
			ids = ids.split(",");
		}else{
			ids = [ids];
		}
		console.log(ids);
		socket.emit("invite_to_chat", {uid:ids});

	});
	

	

});