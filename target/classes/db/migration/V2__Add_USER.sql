insert into user (id,username,password,active) values(1,'admin','$2y$08$RoNpxYeX5.Oqxw.taAsDweCwBVgW6uU0ea30JWQdDZNEcaS1.t6ji',true);

insert into user_role (user_id,roles) values (1,'USER'), (1,'ADMIN')