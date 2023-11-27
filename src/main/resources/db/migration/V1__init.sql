CREATE TABLE users (
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    username        VARCHAR(30) NOT NULL UNIQUE,
    password        VARCHAR(80) NOT NULL,
    email           VARCHAR(50) NOT NULL
);

CREATE TABLE roles (
    id              INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name            VARCHAR(50) NOT NULL
);

CREATE TABLE users_roles (
    user_id         BIGINT NOT NULL,
    role_id         INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

INSERT INTO roles (name)
VALUES ('ROLE_USER'), ('ROLE_ADMIN');

INSERT INTO users (username, password, email)
VALUES ('user', '$2a$12$J7XWTPK2GY7USJ6SJLZRwem2OvB55mTnhzROyovBBpvIFs4AbhphG', 'user@gmail.com'),
       ('admin', '$2a$12$J7XWTPK2GY7USJ6SJLZRwem2OvB55mTnhzROyovBBpvIFs4AbhphG', 'admin@gmail.com');

INSERT INTO users_roles (user_id, role_id)
VALUES (1, 1), (2, 2);