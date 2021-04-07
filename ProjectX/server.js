var express = require('express');
var app = express();
var ejs = require('ejs');
var methodOverride = require('method-override');

app.use(express.json());
app.use(express.urlencoded());
app.use(methodOverride('_method'));
app.set('view_engine', 'ejs');
app.use(express.static('public'));

//app.use(require('./controllers/movie_controller'));
app.use(require('./controllers/world/world_controller'));
app.use(require('./controllers/publicWorld/publicWorld_controller'));

//insert catch all error

const port = process.env.PORT || 3000;
app.listen(port, function(){
	console.log('listening on port:'+port+'!')
});
