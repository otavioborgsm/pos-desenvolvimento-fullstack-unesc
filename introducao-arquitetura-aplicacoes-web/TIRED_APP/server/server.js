const express = require('express')
const cors = require('cors')
const server = express()
const port = 3001

sever.use(cors())

server.get('/', (req, res) => {
  res.json('Hello World!')
})

server.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})