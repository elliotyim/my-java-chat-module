let mysql = require('mysql');

module.exports = function() {
  let config = require('./db_config');
  let pool = mysql.createPool({
    host: config.host,
    user: config.user,
    password: config.password,
    database: config.database
  });

  return {
    getConnection: (callback)  => {
      pool.getConnection(callback);
    },
    end: (callback) => {
      pool.end(callback);
    }
  }
}();