drop database bookprototypetestdb;

create database bookprototypetestdb;

use bookprototypetestdb;

show tables;

select * from user;
select * from role;
INSERT INTO role VALUES (1, 'ROLE_USER');
INSERT INTO role VALUES (2, 'ROLE_ADMIN');
select * from role_user;
select * from user_roles;


