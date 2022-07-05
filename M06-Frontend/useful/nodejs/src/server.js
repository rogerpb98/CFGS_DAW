import express from 'express'
import middleware from './middleware.js'
import router from './router.js'
import dbclient from './dbclient.js'

const app = express()

dbclient.connect()

middleware(app)

router(app)

app.listen('9000', () => {
  console.log('Server listening in http://localhost:9000')
})