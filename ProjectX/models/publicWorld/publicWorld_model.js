var fs = require('fs');

exports.getAllPublicWorlds = function() {
  var publicWorldData = fs.readFileSync('data/publicWorld.json', 'utf8');
  return JSON.parse(publicWorldData);
}

exports.getPublicWorld = function(id) {
  var publicWorldData = exports.getAllPublicWorlds();

  if (publicWorldData[id]) return publicWorldData[id];

  return {};
}

exports.savePublicWorld = function(id, newPublicWorld) {
  var publicWorldData = exports.getAllPublicWorlds();
  publicWorldData[id] = newPublicWorld;
  fs.writeFileSync('data/publicWorld.json', JSON.stringify(publicWorldData));
}

exports.deletePublicWorld = function(id) {
  var publicWorldData = exports.getAllPublicWorlds();
  delete publicWorldData[id];
  fs.writeFileSync('data/publicWorld.json', JSON.stringify(publicWorldData));
}
