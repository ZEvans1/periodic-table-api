SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS elements (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 symbol VARCHAR,
 atomicNumber INTEGER,
 atomicMass INTEGER,
 groupNumber INTEGER,
 groupId INTEGER,
 periodId INTEGER,
);