CREATE TABLE Article (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title VARCHAR NOT NULL,
    text VARCHAR NOT NULL,
    source VARCHAR NOT NULL
);

CREATE TABLE Card (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    question VARCHAR NOT NULL,
    answer VARCHAR NOT NULL,
    article bigint,
    extract bigint

);

CREATE TABLE Extract (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    text VARCHAR NOT NULL,
    article bigint,
    begin bigint,
    end bigint
);
