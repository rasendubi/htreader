DROP TABLE IF EXISTS SchedulingInfo;
DROP TABLE IF EXISTS Article;
DROP TABLE IF EXISTS Card;
DROP TABLE IF EXISTS Extract;

CREATE TABLE SchedulingInfo (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    cardId bigint NOT NULL,
    eFactor DOUBLE NOT NULL,
    repetition INTEGER NOT NULL,
    interval bigint NOT NULL,
    nextDate DATE NOT NULL
);

CREATE TABLE Article (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title VARCHAR NOT NULL,
    text VARCHAR NOT NULL,
    source VARCHAR
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
    end bigint,
    repetition INTEGER NOT NULL,
    nextDate DATE NOT NULL
);
