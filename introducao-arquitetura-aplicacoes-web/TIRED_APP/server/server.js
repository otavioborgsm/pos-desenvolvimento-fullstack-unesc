const express = require('express');
const cors = require('cors');
const mongo = require('./mongo.js');

const app = express();
app.use(cors());

app.get('/', (_, res) => {
  mongo.collection().findOne({ greeting: 'Hello Mongo' }).then((document) => res.json(`${document.greeting} + Express`))
})

app.listen(3001, () => {
  mongo.connect();
  console.log("Sevidor rodando na porta 3001.")
})