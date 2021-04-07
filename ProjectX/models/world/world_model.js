var fs = require('fs');

var admin = require("firebase-admin");

var serviceAccount = require("./firebase_config.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount)
});

// Create a database reference
var db = admin.firestore();

exports.getAllWorlds = function() {
  var worldData = fs.readFileSync('data/world.json', 'utf8');
  db.collection('users').get()
    .then(function(snapshot){
      snapshot.forEach(function(doc){
        console.log(doc.id, '=>', doc.data());
      });
    })
    .catch(function(err){
      console.log('Error getting documents', err);
    });

  return JSON.parse(worldData);
}

exports.makePublic = function(id){
  var worldData = exports.getAllWorlds();
  worldData[id].public = true;
  //exports.saveWorld(id, worldData);
  fs.writeFileSync('data/world.json', JSON.stringify(worldData));
  //fs.writeFileSync('data/publicWorld.json', JSON.stringify(worldData));
}

exports.makePrivate = function(id){
  var worldData = exports.getAllWorlds();
  worldData[id].public = false;
  return(worldData);
  //fs.writeFileSync('data/world.json', JSON.stringify(worldData));
}

exports.getWorld = function(id) {
  var worldData = exports.getAllWorlds();

  if (worldData[id]) return worldData[id];

  return {};
}

exports.saveWorld = function(id, newWorld) {
  var worldData = exports.getAllWorlds();
  worldData[id] = newWorld;
  fs.writeFileSync('data/world.json', JSON.stringify(worldData));
}

exports.updateWorld = function(id, worldData) {
  exports.saveWorld(id, worldData)
}

exports.deleteWorld = function(id) {
  var worldData = exports.getAllWorlds();
  delete worldData[id];
  fs.writeFileSync('data/world.json', JSON.stringify(worldData));
}
