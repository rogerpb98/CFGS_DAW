import pg from 'pg'

const dbclient = new pg.Client({
    user: 'postgres',
    host: 'localhost',
    database: 'test1',
    password: 'p4ssword!',
    port: 5432
})

export default dbclient