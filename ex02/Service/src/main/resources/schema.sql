DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(40) UNIQUE,
    password VARCHAR(40)
);

-- INSERT INTO users (email) VALUES ('kudienko');

