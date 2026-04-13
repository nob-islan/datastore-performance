CREATE DATABASE eadb;
USE eadb;

CREATE TABLE IF NOT EXISTS users (
    id varchar(36) PRIMARY KEY
    , name varchar(8)
    , password varchar(32)
);
