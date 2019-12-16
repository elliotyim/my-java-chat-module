let express = require('express')
  , http = require('http')
  , app = express()
  , server = http.createServer(app);

app.use(express.static(path.join(__dirname, 'html')));
app.get('/', (req, res) => {
  res.sendfile(path.join(__dirname, 'html', 'index.html'));
});

app.get('/test', (req, res) => {
  res.sendFile(path.join(__dirname, 'html', 'test.html'));
});

server.listen(8888, () => {
  console.log('Express server listening on port ' + server.address().port);
});