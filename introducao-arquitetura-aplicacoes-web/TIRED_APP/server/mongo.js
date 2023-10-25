const { MongoClient } = require('mongodb');
require('custom-env').env('staging')

const uri = process.env.MONGODB_URI;

const client = new MongoClient(uri);

var collection;

module.exports = {
  connect: () => {
    client.connect().then((_) => {
      console.log('chegou')
      collection = client.db('test').collection('devices');
    })
  },
  collection: () => {
    return collection
  }
}