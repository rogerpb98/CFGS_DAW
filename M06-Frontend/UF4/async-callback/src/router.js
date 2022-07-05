import user from './routes/user.js'
import category from './routes/category.js'
import product from './routes/product.js'

export default app => {
    app.use('/user', user)
    app.use('/category', category)
    app.use('/product', product)
}