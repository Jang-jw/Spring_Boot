$(document).ready(function() {

	// 1. WebSocketController 와 연결 
	const url = "ws://172.30.1.86:8087/msg/chat";
	const ws = new WebSocket(url);

	// 1. 연결되면 뭐할지? 
	ws.onopen = onOpen;

	// 2. (Server 로부터 메세지를 받으면 뭐할지)
	ws.onmessage = onMessage;

	// 3. 연결 해제시 뭐할지?? 
	ws.onclose = onClose;

	// 4. 메세지 보내는 이벤트 
	// 누가? 내용?
	$('#chatBtn').on('click', function() {

		// 1) 보내줄 데이터 정리 (Javascript Object)
		var msg = {

			"email": $('#userEmail').html(),
			"message": $('#message').val()
		}
		
		$('#message').val('');

		console.log(msg);

		var chat = `
										
			<div class="mychat">
				<p>${msg.message}</p>
			</div>
		`;

		$('div.chat').append(chat);

		// 채팅창 스크롤을 가장 아래로 내리기 
		$('div.chat').scrollTop($('div.chat')[0].scrollHeight);

		// WebSocket 을 통해서 message 를 보내주기
		// Javascript Object => JSON String  
		ws.send(JSON.stringify(msg));
	});

});

function onOpen() {

	console.log("채팅에 연결됨~~~");

	// 예시로 작성된 내용을 삭제
	$('div.chat').html('');

	// DB 를 사용한다면, 기존 채팅내역 불러오기 
}

function onMessage(msg) {

	console.log(msg);
	var json = JSON.parse(msg.data);

	var chat = `

			<div class="other">
				<p>${json.email} :</p>
				<p>${json.message}</p>
			</div>
	`;

	$('div.chat').append(chat);

	// 채팅창 스크롤을 가장 아래로 내리기 
	$('div.chat').scrollTop($('div.chat')[0].scrollHeight);
}

function onClose() {


}