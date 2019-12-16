const express = require('express');
const app = express();
const path = require('path');
const http = require('http');
const server = http.createServer(app);

app.use(express.static(path.join(__dirname, 'html')));
app.use((req, res, next) => {
  console.log('안녕!');
  next();
})

app.get('/', (req, res) => {
  res.sendfile(path.join(__dirname, 'html', 'index.html'));
});

app.get('/test', (req, res) => {
  res.sendFile(path.join(__dirname, 'html', 'test.html'));
});

server.listen(8888, () => {
  console.log('Express server listening on port ' + server.address().port);
});