function sendMessage() {
  console.log('메시지 전송 중');
  socket.send(document.getElementById('textarea').value);
  console.log('메시지 전송 완료!');
}

function onOpen(socket) {
  console.log('연결 성공!');
}

function onMessage(msg) {
  let data = msg.data;
  console.log(data);
}

function onClose(event) {
  console.log('연결 끊김!');
}