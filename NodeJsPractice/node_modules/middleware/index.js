var fs   = require('fs'),
    path = require('path');

var modules = module.exports = {},
    list, file, name, module;

list = fs.readdirSync(__dirname);

for (var i = 0, il = list.length; i < il; i++) {
  file = list[i];

  if ('.js' !== path.extname(file) ||
      file === 'index.js' ||
      file === 'utils.js') {
    continue;
  }

  file = /^(.*)\..*$/.exec(file);

  if (file) {
    try {
      name   = file[1];
      module = require('./' + name);

      if (typeof module === 'function') {
        modules[name] = module;
      }
    } catch (error) {
      throw error;
    }
  }
}
