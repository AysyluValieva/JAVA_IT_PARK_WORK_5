CREATE TABLE  owner (
  id SERIAL PRIMARY KEY,
  login VARCHAR(100) UNIQUE NOT NULL,
  hash_password VARCHAR(100),
  name VARCHAR(100) NOT NULL
);