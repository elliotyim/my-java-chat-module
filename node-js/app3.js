const express = require('express');
const app = express();
const methodOverride = require('method-override');
const bodyParser = require('body-parser');

app.use(methodOverride());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

app.get('/user/:name', (req, res) => {
  res.json({name: req.params.name});
  console.log('test');
  console.log(req.params.name);
}).listen(8888, () => {
  console.log('Server is on');
});