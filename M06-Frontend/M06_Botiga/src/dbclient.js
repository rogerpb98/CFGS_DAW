import pg from 'pg'

const dbclient = new pg.Client({
    user: 'postgres',
    host: 'localhost',
    database: 'm6botiga',
    password: 'p4ssword!',
    port: 5432
})

export default dbclient