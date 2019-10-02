// Note to contributers.
// Feel free to add utils methods if you feel they are valuable.

// This pump doesn't close the write stream, so you can end the writable whenever
exports.pump = function pump (readable, writable, cb) {
  readable.addListener('data', function (data) {
    if (!writable.write(data)) readable.pause();
  });

  readable.addListener('end', function () {
    if (cb) cb();
  });

  writable.addListener('drain', function () {
    readable.resume();
  });
};

// So frameworks can set the default headers for the middleware.
var defaultHeaderKeys = [],
    defaultHeaders    = {};

exports.setDefaultHeaders = function (headers) {
  defaultHeaders    = headers;
  defaultHeaderKeys = Object.keys(defaultHeaders);
  return defaultHeaders;
};

// For merging in default headers.
exports.mergeDefaultHeaders = function (headers) {
  var keys, key,
      ret = {};

  for (var i = 0, il = defaultHeaderKeys.length; i < il; i++) {
    key = defaultHeaderKeys[i];
    ret[key] = defaultHeaders[key];
  }

  keys = Object.keys(headers);
  for (i = 0, il = keys.length; i < il; i++) {
    key = keys[i];
    ret[key] = headers[key];
  }

  return ret;
};

// For easily setting range headers.
exports.setRangeHeaders = function setRangeHeaders (request, stat, headers) {
  var range = request.headers['range'].slice(6).split('-'),
      ret   = {};

  ret.start = +range[0];
  ret.end   = +range[1];

  if (range[1].length === 0) {
    ret.end = stat.size - 1;
  } else if (range[0].length === 0) {
    ret.end   = stat.size - 1;
    ret.start = ret.end - (+range[1]) + 1;
  }

  headers['Accept-Ranges']  = 'bytes';
  headers['Content-Length'] = ret.end - ret.start + 1;
  headers['Content-Range']  = 'bytes ' + ret.start + '-' + ret.end + '/' + stat.size;

  return ret;
};

// For mime types.
var defaultMime = exports.defaultMime = 'application/octet-stream';

exports.mime = {
  /**
   * Return mime type for the given path, 
   * otherwise default to exports.defaultMime 
   * ("application/octet-stream").
   *
   * @param {String} path
   * @return {String}
   * @api public
   */
  type: function getMime(path) {
    var index = String(path).lastIndexOf(".");
    if (index < 0) {
      return defaultMime;
    }
    var type = exports.mime.types[path.substring(index).toLowerCase()] || defaultMime;
    return (/(text|javascript)/).test(type) ? type + "; charset=utf-8" : type;
  },

  /**
   * Mime types.
   */
  types: {
    ".3gp"   : "video/3gpp",
    ".a"     : "application/octet-stream",
    ".ai"    : "application/postscript",
    ".aif"   : "audio/x-aiff",
    ".aiff"  : "audio/x-aiff",
    ".asc"   : "application/pgp-signature",
    ".asf"   : "video/x-ms-asf",
    ".asm"   : "text/x-asm",
    ".asx"   : "video/x-ms-asf",
    ".atom"  : "application/atom+xml",
    ".au"    : "audio/basic",
    ".avi"   : "video/x-msvideo",
    ".bat"   : "application/x-msdownload",
    ".bin"   : "application/octet-stream",
    ".bmp"   : "image/bmp",
    ".bz2"   : "application/x-bzip2",
    ".c"     : "text/x-c",
    ".cab"   : "application/vnd.ms-cab-compressed",
    ".cc"    : "text/x-c",
    ".chm"   : "application/vnd.ms-htmlhelp",
    ".class" : "application/octet-stream",
    ".com"   : "application/x-msdownload",
    ".conf"  : "text/plain",
    ".cpp"   : "text/x-c",
    ".crt"   : "application/x-x509-ca-cert",
    ".css"   : "text/css",
    ".csv"   : "text/csv",
    ".cxx"   : "text/x-c",
    ".deb"   : "application/x-debian-package",
    ".der"   : "application/x-x509-ca-cert",
    ".diff"  : "text/x-diff",
    ".djv"   : "image/vnd.djvu",
    ".djvu"  : "image/vnd.djvu",
    ".dll"   : "application/x-msdownload",
    ".dmg"   : "application/octet-stream",
    ".doc"   : "application/msword",
    ".dot"   : "application/msword",
    ".dtd"   : "application/xml-dtd",
    ".dvi"   : "application/x-dvi",
    ".ear"   : "application/java-archive",
    ".eml"   : "message/rfc822",
    ".eps"   : "application/postscript",
    ".exe"   : "application/x-msdownload",
    ".f"     : "text/x-fortran",
    ".f77"   : "text/x-fortran",
    ".f90"   : "text/x-fortran",
    ".flv"   : "video/x-flv",
    ".for"   : "text/x-fortran",
    ".gem"   : "application/octet-stream",
    ".gemspec" : "text/x-script.ruby",
    ".gif"   : "image/gif",
    ".gz"    : "application/x-gzip",
    ".h"     : "text/x-c",
    ".hh"    : "text/x-c",
    ".htm"   : "text/html",
    ".html"  : "text/html",
    ".ico"   : "image/vnd.microsoft.icon",
    ".ics"   : "text/calendar",
    ".ifb"   : "text/calendar",
    ".iso"   : "application/octet-stream",
    ".jar"   : "application/java-archive",
    ".java"  : "text/x-java-source",
    ".jnlp"  : "application/x-java-jnlp-file",
    ".jpeg"  : "image/jpeg",
    ".jpg"   : "image/jpeg",
    ".js"    : "application/javascript",
    ".json"  : "application/json",
    ".log"   : "text/plain",
    ".m3u"   : "audio/x-mpegurl",
    ".m4v"   : "video/mp4",
    ".man"   : "text/troff",
    ".mathml" : "application/mathml+xml",
    ".mbox"  : "application/mbox",
    ".mdoc"  : "text/troff",
    ".me"    : "text/troff",
    ".mid"   : "audio/midi",
    ".midi"  : "audio/midi",
    ".mime"  : "message/rfc822",
    ".mml"   : "application/mathml+xml",
    ".mng"   : "video/x-mng",
    ".mov"   : "video/quicktime",
    ".mp3"   : "audio/mpeg",
    ".mp4"   : "video/mp4",
    ".mp4v"  : "video/mp4",
    ".mpeg"  : "video/mpeg",
    ".mpg"   : "video/mpeg",
    ".ms"    : "text/troff",
    ".msi"   : "application/x-msdownload",
    ".odp"   : "application/vnd.oasis.opendocument.presentation",
    ".ods"   : "application/vnd.oasis.opendocument.spreadsheet",
    ".odt"   : "application/vnd.oasis.opendocument.text",
    ".ogg"   : "application/ogg",
    ".p"     : "text/x-pascal",
    ".pas"   : "text/x-pascal",
    ".pbm"   : "image/x-portable-bitmap",
    ".pdf"   : "application/pdf",
    ".pem"   : "application/x-x509-ca-cert",
    ".pgm"   : "image/x-portable-graymap",
    ".pgp"   : "application/pgp-encrypted",
    ".pkg"   : "application/octet-stream",
    ".pl"    : "text/x-script.perl",
    ".pm"    : "text/x-script.perl-module",
    ".png"   : "image/png",
    ".pnm"   : "image/x-portable-anymap",
    ".ppm"   : "image/x-portable-pixmap",
    ".pps"   : "application/vnd.ms-powerpoint",
    ".ppt"   : "application/vnd.ms-powerpoint",
    ".ps"    : "application/postscript",
    ".psd"   : "image/vnd.adobe.photoshop",
    ".py"    : "text/x-script.python",
    ".qt"    : "video/quicktime",
    ".ra"    : "audio/x-pn-realaudio",
    ".rake"  : "text/x-script.ruby",
    ".ram"   : "audio/x-pn-realaudio",
    ".rar"   : "application/x-rar-compressed",
    ".rb"    : "text/x-script.ruby",
    ".rdf"   : "application/rdf+xml",
    ".roff"  : "text/troff",
    ".rpm"   : "application/x-redhat-package-manager",
    ".rss"   : "application/rss+xml",
    ".rtf"   : "application/rtf",
    ".ru"    : "text/x-script.ruby",
    ".s"     : "text/x-asm",
    ".sgm"   : "text/sgml",
    ".sgml"  : "text/sgml",
    ".sh"    : "application/x-sh",
    ".sig"   : "application/pgp-signature",
    ".snd"   : "audio/basic",
    ".so"    : "application/octet-stream",
    ".svg"   : "image/svg+xml",
    ".svgz"  : "image/svg+xml",
    ".swf"   : "application/x-shockwave-flash",
    ".t"     : "text/troff",
    ".tar"   : "application/x-tar",
    ".tbz"   : "application/x-bzip-compressed-tar",
    ".tci"   : "application/x-topcloud",
    ".tcl"   : "application/x-tcl",
    ".tex"   : "application/x-tex",
    ".texi"  : "application/x-texinfo",
    ".texinfo" : "application/x-texinfo",
    ".text"  : "text/plain",
    ".tif"   : "image/tiff",
    ".tiff"  : "image/tiff",
    ".torrent" : "application/x-bittorrent",
    ".tr"    : "text/troff",
    ".ttf"   : "application/x-font-ttf",
    ".txt"   : "text/plain",
    ".vcf"   : "text/x-vcard",
    ".vcs"   : "text/x-vcalendar",
    ".vrml"  : "model/vrml",
    ".war"   : "application/java-archive",
    ".wav"   : "audio/x-wav",
    ".wma"   : "audio/x-ms-wma",
    ".wmv"   : "video/x-ms-wmv",
    ".wmx"   : "video/x-ms-wmx",
    ".wrl"   : "model/vrml",
    ".wsdl"  : "application/wsdl+xml",
    ".xbm"   : "image/x-xbitmap",
    ".xhtml"   : "application/xhtml+xml",
    ".xls"   : "application/vnd.ms-excel",
    ".xml"   : "application/xml",
    ".xpm"   : "image/x-xpixmap",
    ".xsl"   : "application/xml",
    ".xslt"  : "application/xslt+xml",
    ".yaml"  : "text/yaml",
    ".yml"   : "text/yaml",
    ".zip"   : "application/zip"
  }
};
