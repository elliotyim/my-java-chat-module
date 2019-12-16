module.exports = (io) => {
  io.on('connection', (socket) => {
    socket.on('disconnect', () => {
      console.log('disconnected');
    })
  });
}