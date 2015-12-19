CREATE TABLE SchedulingInfo (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    cardId bigint NOT NULL,
    eFactor DOUBLE NOT NULL,
    repetition INTEGER NOT NULL,
    interval bigint NOT NULL,
    nextDate DATE NOT NULL
);
