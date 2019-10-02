var util = require('./utils');

module.exports = function (statusCode, headers) {
  statusCode = statusCode || 200;
  headers    = headers    || {};
  headers    = util.mergeDefaultHeaders(headers);

  return function (request, response) {
    response.writeHead(statusCode, headers);
    response.end(response.body);
  };
};
