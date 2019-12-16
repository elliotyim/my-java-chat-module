let pool = require('./db_connect');
module.exports = () => {
  return {
    select: (callback) => {
      pool.getConnection(function(err, con) {
        let sql = 'select * from test_member';
        con.query(sql, (err, result) => {
          con.release();
          if (err) return callback(err);
          callback(null, result);
        });
      });
    },
    pool: pool
  }
};