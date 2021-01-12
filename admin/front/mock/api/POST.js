module.exports = function (request, response) {
  if (!request.get('X-Token')) {
    response.status(403).send({
      message: "permission error"
    });
  } else {
    response.send({
      result: true
    })
  }
}
