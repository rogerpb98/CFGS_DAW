import express from 'express'
import dbclient from '../dbclient.js'

const router = express.Router()

router.post('/register', (req, res) => {
    console.log("Register POST")
    console.log(req.body)
    const insert_query = `insert into uuser values ('${req.body.user_name}', '${req.body.password}', '${req.body.email}')`
    dbclient.query(insert_query, (err) => {
      if (err){
        console.log(err.stack)
        res.status(200).json({success: false, err})
      } else {
        res.status(200).json({success: true})
      }
    })
  })
  
router.post('/login', (req, res) => {
    console.log("Login POST")
    console.log(req.body)
  })

  export default router
 