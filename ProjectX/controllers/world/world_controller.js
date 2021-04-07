let express = require('express')
  , router = express.Router();
let request = require('request');

let World = require('../../models/world/world_model')

let apikey = 'f09c17eb';

router.get('/', function(req, res){
  res.redirect('/worlds');
});

router.get('/worlds', function(req, res){
  let worldList = World.getAllWorlds();

  res.status(200);
  res.setHeader('Content-Type', 'text/html');
  res.render('world/show_worlds.ejs', {worlds: worldList});
});

router.get('/about', function(request, response) {
  response.status(200);
  response.setHeader('Content-Type', 'text/html')
  response.render("about.ejs");
});

router.get('/world/create', function(req, res){
  let title=req.query.title;
  title=title.replace(/ /g, '+');
  console.log(title);
        let worldResponse = {
          "worldID": 22222,
          "AuthorID": title,
          "title": title,
          "creationDate": title,
          "tags": title,
          "public": false,
          "likes": title,
          "planet": title,
          "characters": title,
          "starships": title,
          "vehicles": title,
          "species": title};
        res.status(200);
        res.setHeader('Content-Type', 'text/html');
        res.render('world/new_world.ejs', {world: worldResponse})
});

router.post('/world/:worldID', function(req, res){
  let worldID = req.params.worldID;
              let newWorld={
                "worldID": 22222,
                "AuthorID": worldID,
                "title": worldID,
                "creationDate": worldID,
                "tags": worldID,
                "public": false,
                "likes": worldID,
                "planet": worldID,
                "characters": worldID,
                "starships": worldID,
                "vehicles": worldID,
                "species": worldID}
              let newID = ("22222").replace(/ /g,"_");
              World.saveWorld(newID, newWorld);
              res.redirect('/worlds');
});

router.get('/world/:id', function(req,res){
  let thisWorld = World.getWorld(req.params.id);

  if(thisWorld){
    res.status(200);
    res.setHeader('Content-Type', 'text/html');
    res.render("world/world_details.ejs", {world: thisWorld} );
  }else{
    let errorCode=404;
    res.status(errorCode);
    res.setHeader('Content-Type', 'text/html');
    res.render("error.ejs", {"errorCode":errorCode});
  }

});

router.get('/world/:id/edit', function(req,res){
  console.log("router.get");
  console.log(req.params.id);
  let thisWorld = World.getWorld(req.params.id);
  thisWorld.id=req.params.id;

  if(thisWorld){
    res.status(200);
    res.setHeader('Content-Type', 'text/html');
    res.render("world/edit_world.ejs", {world: thisWorld} );
  }
  else{
    let errorCode=404;
    res.status(errorCode);
    res.setHeader('Content-Type', 'text/html');
    res.render("error.ejs", {"errorCode":errorCode});
  }
});

router.put('/world/:id', function(req,res){
  let newWorldData = {};
  let id= req.body.id;
  newWorldData["worldID"] = req.body.id;
  newWorldData["AuthorID"] = req.body.AuthorID;
  newWorldData["title"]= req.body.title;
  newWorldData["creationDate"]= req.body.creationDate;
  newWorldData["tags"]= req.body.tags;
  newWorldData["public"]= req.body.public;
  newWorldData["likes"]= req.body.likes;
  newWorldData["comments"]= req.body.comments;
  newWorldData["planet"] = req.body.planet;
  newWorldData["characters"]= req.body.characters;
  newWorldData["starships"]= req.body.starships;
  newWorldData["vehicles"]= req.body.vehicles;
  newWorldData["species"]= req.body.species;

  World.updateWorld(id, newWorldData);
  res.redirect('/worlds');
});

router.delete('/world/:id', function(req, res){
  console.log(req.params.id);
  World.deleteWorld(req.params.id);
  res.redirect('/worlds');
});

router.post('/world/setprivate/:worldID', function(req, res){
  let worldList = World.getAllWorlds();
  let worldID = req.params.worldID;
  let id = req.params.id;
  console.log("id");
  console.log(id);
  console.log(worldList);
  World.makePrivate(worldID);

  res.redirect('/worlds');
});

router.post('/world/setpublic/:worldID', function(req, res){
  let worldList = World.getAllWorlds();
  let worldID = req.params.worldID;
  let id = req.params.id;

  World.makePublic(worldID);
  let newworldList = World.getAllWorlds();
  console.log(newworldList[id]);
  res.redirect('/worlds');
});

module.exports = router
