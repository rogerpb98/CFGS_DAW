import express from 'express'
import dbclient from '../dbclient.js'

const router = express.Router()

router.get('/list', (req, res) => {
    
    console.log("Get product list")
    console.log(req.query)

    // Acceso a la base de datos
    let list_query = `select * from product where category = '${req.query.category}'`
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