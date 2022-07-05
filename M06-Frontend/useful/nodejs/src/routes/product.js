import express from 'express'
import dbclient from '../dbclient.js'

const router = express.Router()

router.get('/list',(req, res) => {
    console.log("Product list GET")
    console.log(req.query)

    let list_query = "select * from product"
    console.log(list_query)

    dbclient.query(list_query, (err, resdb) => {
        if (err){
            console.log(err.stack)
            res.status(200).json()
        } else {
            console.log(resdb.rows)
            res.status(200).json(resdb.rows)
        }
    })
    
})

export default router
  