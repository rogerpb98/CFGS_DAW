import express from 'express'
import dbclient from '../dbclient.js'

const router = express.Router()

router.get(`/list`, (req, res) => {
    console.log("Get categories")

    let select_query = 'select name from category'
    console.log(select_query)

    dbclient.query(select_query, (err, resdb) => {
        if (err) {
            console.log(err.stack)
            // If there is an error I do not return any category
            res.status(200)
                .json()
        } else {
            console.log(resdb.rows)
            // return one array
            let categories = []
            resdb.rows.forEach(category => {
                categories.push(category.name)
            })
            res.status(200)
                .json(categories)    
        }
    })
})

export default router