const express = require('express');
const app = express();
const http = require('http').Server(app);
const io = require('socket.io')(http);
const path = require('path');

app.use(express.static(path.join(__dirname, '../')));

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, '../', 'chat.html'));
});

let count = 1;

// io: 서버, socket: 클라이언트
// on: 대기, emit: 호출
io.on('connection', (socket) => {
  console.log('user connected: ', socket.id);
  let name = 'user' + count++;

  io.to(socket.id).emit('change name', name);

  socket.on('disconnect', () => {
    console.log('user disconnected: ', socket.id);
  });

  socket.on('send message', (name, text) => {
    let msg = socket.id +' : ' + text;
    console.log(msg);
    io.emit('receive message', msg);
  });
});

http.listen(8888, () => {
  console.log('Server is on!');
});
