import express from 'express'
import dbclient from '../dbclient.js'

const router = express.Router()

router.get('/list', (req, res) => {
  console.log("User list GET")
  console.log(req.query)

  let list_query = "select * from uuser"
  console.log(list_query)

  dbclient.query(list_query, (err, resdb) => {
    if (err) {
      console.log(err.stack)
      res.status(200).json()
    } else {
      console.log(resdb.rows)
      res.status(200).json(resdb.rows)
    }
  })

})

// email, name, lname, pwd, tlf, dni, adress, lat, long
router.post('/register', (req, res) => {
  console.log("Register POST")
  console.log(req.body)
  const insert_query = `insert into uuser (email, name, last_name, password, adress) values ('${req.body.email}','${req.body.name}','${req.body.lname}','${req.body.pwd}','${req.body.adress}')` //,'${req.body.lat}','${req.body.long}
  dbclient.query(insert_query, (err) => {
    if (err) {
      console.log(err.stack)
      res.status(200).json({ success: false, err })
    } else {
      res.status(200).json({ success: true })
    }
  })
})

// email, password
router.post('/login', (req, res) => {
  console.log("Login POST")
  console.log(req.body)

  const select_query = `select * from uuser where email = '${req.body.email}' and password = '${req.body.password}'`
  dbclient.query(select_query, (err, resdb) => {
    if (err) {
      console.log(err.stack)
      res.status(200).json({ success: false, err })
    } else {
      if (resdb.rows.length == 1) {
        res.status(200).json({ success: true })
      } else {
        res.status(200).json({ success: false })
      }
    }
  })

})

export default router
