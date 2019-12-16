const express = require('express');
const path = require('path');
const app = express();
const db = require('./db.js');
const route = require('./route.js');

db();

app.use('/', route);
app.use((req, res, next) => {
  res.status(404).send('일치하는 주소가 없습니다!');
});

app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).send('서버 에러!');
});

app.listen(8888, () => {
  console.log('Server is on');
});