import user from './routes/user.js'
import product from './routes/product.js'

export default (router) => {

    router.use('/user', user)
    router.use('/product', product)

}
