insert into role (id, name)
value (1, 'ROLE_USER'), (2, 'ROLE_ANONYMOUS'), (3, 'ROLE_ADMIN');

select * from user;
select * from role;
select * from role_user;
select * from user_roles;