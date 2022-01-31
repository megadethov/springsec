-- docker run --name springsec-pg-13.3 -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=eazybank -d postgres:13.3

-- jdbc:postgresql://localhost:5432/eazybank
-- postgres
-- postgres


CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       enabled SMALLINT NOT NULL
);

CREATE TABLE authorities (
                             id SERIAL PRIMARY KEY,
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL
);

INSERT INTO users (username, password, enabled)
VALUES
('user_login', 'user_password', 1);

INSERT INTO authorities (username, authority)
VALUES
('user_login', 'write');

CREATE TABLE customer (
                          id SERIAL PRIMARY KEY,
                          email VARCHAR(50) NOT NULL,
                          pwd VARCHAR(50) NOT NULL,
                          role VARCHAR(50) NOT NULL
);