import express from 'express'
import dbclient from '../dbclient.js'

const router = express.Router()

router.get('/list', (req, res) => {
    console.log("Product list GET")
    console.log(req.query)

    let list_query = "select * from product"
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

//return single product info given id
router.get('/list/:product_id', (req, res) => {
    console.log("Product list GET")
    console.log(req.query)
    const id = req.params['product_id'];

    let list_query = `select * from product where product_id=${id}`;
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

//return single product info given owner
router.get('/list/owner/:email_owner', (req, res) => {
    console.log("Product list GET")
    console.log(req.query)
    const email_owner = req.params['email_owner'];

    let list_query = `select * from product where email_owner='${email_owner}'`;
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

// owner, product_name, description, price, category, img
router.post('/add', (req, res) => {
    console.log("Add Product POST")
    console.log(req.body)
    const insert_query = `insert into product (email_owner, product_name, description, price, category, img) values ('${req.body.owner}','${req.body.product_name}','${req.body.description}','${req.body.price}','${req.body.category}','${req.body.img}',)`
    dbclient.query(insert_query, (err) => {
        if (err) {
            console.log(err.stack)
            res.status(200).json({ success: false, err })
        } else {
            res.status(200).json({ success: true })
        }
    })
})

router.post('/upload-file', (req, res) => {
    console.log("Upload File POST")

    if (!req.files || Object.keys(req.files).length === 0) {
        return res.status(400).send('No files were uploaded.');
    }

    // The name of the input field (i.e. "sampleFile") is used to retrieve the uploaded file
    let productFile = req.files.productFile;
    let uploadPath = './src/html/img/' + productFile.name;

    // Use the mv() method to place the file somewhere on your server
    productFile.mv(uploadPath, function (err) {
        if (err)
            return res.status(500).send(err);

        res.send('File uploaded!');
    });


})

export default router
