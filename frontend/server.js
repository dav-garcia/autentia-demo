var express  = require('express');
var app = express();

app.use(express.static(__dirname + '/app'));
app.use('/bower_components', express.static(__dirname + '/bower_components'))
app.listen(8080);
console.log("App listening on port: 8080");
