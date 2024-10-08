DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(40) UNIQUE
);

-- INSERT INTO users (email) VALUES ('kudienko');

