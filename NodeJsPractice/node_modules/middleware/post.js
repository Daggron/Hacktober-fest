

module.exports = function () {
  return function (request, response, next) {
    var data = '';

    request.setEncoding('utf8');

    request.addListener('data', function (chunk) {
      data += chunk;
    });

    request.addListener('end', function () {
      response.body = data;
      request.body  = data;
      next();
    });
  };
};
