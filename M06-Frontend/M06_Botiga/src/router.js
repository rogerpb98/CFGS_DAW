import product from './routes/product.js'
import user from './routes/user.js'

export default (app) => {
    app.use('/product', product)
    app.use('/user', user)    
}
