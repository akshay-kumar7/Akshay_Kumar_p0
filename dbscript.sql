create table userinfo (
				userid int generated always as identity,
				pwd varchar(200),
				username varchar(20)
				user_first_name varchar(20),
				user_last_name varchar(20),
				primary key(userid)
			);

insert into userinfo(pwd, user_first_name, user_last_name, username) values('rootpostgres','Admin','Root', 'rootuser');
insert into userinfo(pwd, user_first_name, user_last_name, username) values('samplepostgres','Sample','User', 'sampleuser');
