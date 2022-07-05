import pg from 'pg'

const dbclient = new pg.Client({
    user: 'postgres',
    host: 'localhost',
    database: 'botiga',
    password: 'postgres',
    port: 5432
})

export default dbclient