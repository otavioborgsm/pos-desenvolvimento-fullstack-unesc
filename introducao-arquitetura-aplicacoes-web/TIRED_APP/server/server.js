const http = require('http');
const server = http.createServer((_, res) => {
  res.end('Hello World');
});
 
server.listen(3000, '127.0.0.1', () => {});