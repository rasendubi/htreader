HT-reader
=========

Project written by

 - Oleksandr Sochka
 - Alexey Shmalko
 - Yurii Talashko

during #hackTbilisi 2015 hackathon.

Run
=====
Install sqlite3 and add it to ``$PATH`.
```
sqlite3 database.db3 < db/evolutions/create_tables.sql
cd public
npm install
npm tsc # npm tsc -w for live compile
cd ..
sbt run # sbt start for production
```
