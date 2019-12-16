let sql = require('./db_sql')();

console.log('app2.js started');
sql.select((err, data) => {
  if (err) console.log(err);
  else console.log(data);

  sql.pool.end((err) => {
    if (err) console.log(err);
    else {
      console.log('Connection pool has closed');
      console.log('app2.js finished');
    }
  });
});