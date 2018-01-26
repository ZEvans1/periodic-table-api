SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS elements (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 symbol VARCHAR,
 atomicNumber INTEGER,
 atomicMass DOUBLE,
 groupNumber INTEGER,
 periodNumber INTEGER,
 groupId INTEGER,
 periodId INTEGER
);

CREATE TABLE IF NOT EXISTS groups (
 id int PRIMARY KEY auto_increment,
 name INTEGER
);

CREATE TABLE IF NOT EXISTS periods (
 id int PRIMARY KEY auto_increment,
 name INTEGER
);

CREATE TABLE IF NOT EXISTS groups_elements (
 id int PRIMARY KEY auto_increment,
 elementid INTEGER,
 groupid INTEGER
);