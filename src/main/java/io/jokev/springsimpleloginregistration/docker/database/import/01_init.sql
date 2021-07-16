create schema if not exists db collate utf8_general_ci;

use db;

CREATE TABLE clients
(
    id            SERIAL PRIMARY KEY,
    email         TEXT     NOT NULL,
    username      TEXT     NOT NULL,
    password      TEXT     NOT NULL,
    role          TEXT     NOT NULL,
    blocked       BIT      NOT NULL,
    enabled       BIT      NOT NULL
);
