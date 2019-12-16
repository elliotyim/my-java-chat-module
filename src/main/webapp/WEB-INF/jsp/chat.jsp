<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <div id="data"></div>
  <textarea id="textarea" cols="30" rows="10"></textarea><br/>
  <input type="button" id="sendBtn" value="전송">

  <script src="/node_modules/sockjs-client/dist/sockjs.min.js"></script>
  <script src="/js/socket_event.js"></script>
  <script>
    let socket = new SockJS('/app/socketHandler');
    let sendBtn = document.getElementById('sendBtn');

    socket.onopen = onOpen;
    socket.onmessage = onMessage;
    socket.onclose = onClose;

    sendBtn.addEventListener('click', sendMessage);
  </script>
</body>
</html>