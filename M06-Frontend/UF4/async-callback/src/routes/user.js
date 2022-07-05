import express from 'express'
import dbclient from '../dbclient.js'

const router = express.Router()

router.get(`/get`, (req, res) => {
    
    console.log("Get user")
    console.log(req.query)

    // Acceso a la base de datos
    let list_query = `select * from uuser where email = '${req.query.username}'`
    console.log(list_query)
    
    dbclient.query(list_query, (err, resdb) => {
        if (err) {
            console.log(err.stack)
            // If there is an error I do not return any product
            res.status(200)
                .json()
        } else {
            console.log(resdb.rows)
            res.status(200)
            .json(resdb.rows)    
        }
    })
})

export default router