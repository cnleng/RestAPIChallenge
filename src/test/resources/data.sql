insert into user ( id, name, email) values ( 1, 'user1', 'user1@mail.com');
insert into user ( id, name, email) values ( 2, 'user2', 'user2@mail.com');

INSERT INTO booking (id, check_in, check_out, user_id) VALUES(1, parsedatetime('2021-01-11', 'yyyy-MM-dd'), parsedatetime('2021-01-13', 'yyyy-MM-dd'), 1 );
INSERT INTO booking (id, check_in, check_out, user_id) VALUES(2, parsedatetime('2021-01-14', 'yyyy-MM-dd'), parsedatetime('2021-01-17', 'yyyy-MM-dd'), 1 );
INSERT INTO booking (id, check_in, check_out, user_id) VALUES(3, parsedatetime('2021-02-20', 'yyyy-MM-dd'), parsedatetime('2021-02-23', 'yyyy-MM-dd'), 1 );
INSERT INTO booking (id, check_in, check_out, user_id) VALUES(4, parsedatetime('2021-01-18', 'yyyy-MM-dd'), parsedatetime('2021-01-21', 'yyyy-MM-dd'), 2 );