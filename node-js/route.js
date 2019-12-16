const express = require('express');
const path = require('path');
const router = express.Router();

router.get('/', (req, res) =>{
  res.sendFile(path.join(__dirname, 'html', 'index.html'));
});

router.get('/test', (req, res) => {
  res.sendFile(path.join(__dirname, 'html', 'test.html'));
});

router.get('/:name', (req, res) =>{
  URLSearchParams.find({ name : req.params.name }, (err, user) => {
    res.render('main', {user: user});
  });
});

module.exports = router;