//
// biggie-router: Default gzip module
// (c) Tim Smart 2010
//
// Released under the MIT license
// See {insert_link} for license
//

var child_process = require('child_process');

module.exports = function () {
  return function (request, response, next) {
    // Does the client even support gzip awesomeness?
    if (!request.headers['accept-encoding'] ||
        (request.headers['accept-encoding'] &&
         request.headers['accept-encoding'].indexOf('gzip') <= -1)) {
      return next();
    }

    var old_writeHead = response.writeHead,
        old_write, old_end;

    response.writeHead = function writeHead(code, headers) {
      if (code === 304) {
        response.writeHead = old_writeHead;
        return response.writeHead(code, headers);
      }

      old_write = response.write;
      old_end = response.end;

      headers['Content-Encoding'] = 'gzip';
      delete headers['Content-Length'];
      response.writeHead = old_writeHead;
      response.writeHead(code, headers);

      var gzip = child_process.spawn('gzip', ['-9']),
          paused;

      response.write = function write(data, encoding) {
        if (paused) return false;
        return gzip.stdin.write(data, encoding);
      };

      response.end = function end(data, encoding) {
        if (data) {
          response.write(data, encoding);
        }
        return gzip.stdin.end();
      };

      response.addListener('drain', function () {
        gzip.stdout.resume();
        paused = false;
      });

      gzip.stdout.addListener('data', function (buffer) {
        if (!old_write.call(response, buffer)) {
          gzip.stdout.pause();
          paused = true;
        }
      });

      gzip.stdin.addListener('drain', function () {
        paused = false;
        response.emit('drain');
      });

      gzip.addListener('exit', function () {
        response.write = old_write;
        response.end = old_end;
        response.end();
      });
    };

    next();
  };
};
