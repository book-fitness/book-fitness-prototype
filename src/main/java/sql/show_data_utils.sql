select * from user;
select id, username, auth_via from user;
select * from role;
select * from role_user;
select * from user_roles;

select u.username, r.name from user u, user_roles ur, role r
where u.id = ur.user_id and ur.role_id = r.id and u.id = 1;

select u.username, r.name from user u, user_roles ur, role r
where u.id = ur.user_id and ur.role_id = r.id;
