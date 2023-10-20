const { MongoClient } = require('mongodb');
require ('custom-env').env('staging')

const uri = process.env.MONGODB_URI;

const client = new MongoClient(uri);
async function run() {
  try {
    await client.connect();
    await client.db("admin").command({ ping: 1 });
    console.log("Pinged your deployment. You successfully connected to MongoDB!");
  } finally {
    await client.close();
  }
}
run().catch(console.dir);