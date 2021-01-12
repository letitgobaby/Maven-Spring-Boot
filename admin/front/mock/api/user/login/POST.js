module.exports = function (request, response) {
  const { username, password } = request.body
  let roles = ['USER']
  if (username === 'admin') {
    roles.push('ADMIN')
  }

  response.send({
    name: 'misolab',
    token: username+password,
    roles
  })
}
