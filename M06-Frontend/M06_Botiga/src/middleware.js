import express from 'express'
import bodyParser from 'body-parser'
import cors from 'cors'
import fileUpload from 'express-fileupload'

export default (app) => {

    app.use('/', express.static('src/html'))

    app.use(bodyParser.json())
    app.use(bodyParser.urlencoded({extended: false}))
    app.use(cors())

    app.use(fileUpload())
}
