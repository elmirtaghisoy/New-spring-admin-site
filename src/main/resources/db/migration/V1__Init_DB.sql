# create table hibernate_sequence (next_val bigint) engine=InnoDB;
# insert into hibernate_sequence values ( 1 );
# insert into hibernate_sequence values ( 1 );
# create table user (id bigint not null, activation_code varchar(255), active bit not null, email varchar(255), password varchar(255), username varchar(255), primary key (id)) engine=InnoDB;
# create table user_role (user_id bigint not null, roles varchar(255)) engine=InnoDB;
# alter table user_role add constraint user_role_fk foreign key (user_id) references user (id);