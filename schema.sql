create database userappdb;

use userappdb;

create table users
(
Id integer auto_increment primary key,
Name varchar(100) not null,
Email varchar(50) not null unique,
Passwrd VARCHAR(255) NOT NULL,
Rollno integer not null unique
);