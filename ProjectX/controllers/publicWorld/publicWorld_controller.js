let express = require('express')
  , router = express.Router();
let request = require('request');
const fs = require('fs');
const ejs = require('ejs');

let PublicWorld = require('../../models/publicWorld/publicWorld_model')

let apikey = 'f09c17eb';

router.get('/', function(req, res){
  res.redirect('/publicWorlds');
});

router.get('/publicWorlds', function(req, res){
  let publicWorldList = PublicWorld.getAllPublicWorlds();

  res.status(200);
  res.setHeader('Content-Type', 'text/html');
  res.render('publicWorld/show_publicWorlds.ejs', {publicWorlds: publicWorldList});
});

router.get('/about', function(request, response) {
  response.status(200);
  response.setHeader('Content-Type', 'text/html')
  response.render("about.ejs");
});

router.get('/publicWorld/:id', function(req,res){
  let thisPublicWorld = PublicWorld.getPublicWorld(req.params.id);

  if(thisPublicWorld){
    res.status(200);
    res.setHeader('Content-Type', 'text/html');
    res.render("publicWorld/publicWorld_details.ejs", {publicWorld: thisPublicWorld} );
  }else{
    let errorCode=404;
    res.status(errorCode);
    res.setHeader('Content-Type', 'text/html');
    res.render("error.ejs", {"errorCode":errorCode});
  }

});

router.post('/publicWorld/like/:id', function(req, res) {
  console.log(req.params.id)
  let publicWorldList = PublicWorld.getAllPublicWorlds();
  let id = req.params.id;

  if(publicWorldList[id]){
    if (!publicWorldList[id].likes) publicWorldList[id].likes = 0;
    publicWorldList[id].likes++;
    fs.writeFileSync('data/publicWorld.json', JSON.stringify(publicWorldList));

    res.status(200);
    res.setHeader('Content-Type', 'text/json');
    res.send(publicWorldList[id]);
  }else{
    res.status(404);
    res.setHeader('Content-Type', 'text/json');
    res.send('{results: "no public world"}');
  }

});

router.post('/publicWorld/comment/:id', function(req, res) {
  let publicWorldList = PublicWorld.getAllPublicWorlds();
  let id = req.params.id;
  let authorID = publicWorldList[id].AuthorID;

  if(publicWorldList[id]){
    var u = {
      author: req.body.comment_author,
      date: req.body.comment_date,
      AuthorID: authorID,
      WorldID: id,
      text: req.body.comment_text
    }
    console.log(u);
    publicWorldList[id].comment.push(u);

    fs.writeFileSync('data/publicWorld.json', JSON.stringify(publicWorldList));

    res.status(200);
    res.setHeader('Content-Type', 'text/json');
    res.send(publicWorldList[id]);
  }else{
    res.status(404);
    res.setHeader('Content-Type', 'text/json');
    res.send('{results: "no public world"}');
  }

});

module.exports = router
