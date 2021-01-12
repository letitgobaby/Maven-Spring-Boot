module.exports = function (request, response) {
  if (!request.get('X-Token')) {
    response.status(403).send({
      message: "permission error"
    });
  } else {
    response.send({
      name: 'misolab',
      token: "username+password",
      roles: ['USER','ADMIN']
    })
  }
}
