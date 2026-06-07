insert into course(id, name) values(10001, 'JPA Crash Course');
insert into course(id, name) values(10002, 'Springboot Crash Course');
insert into course(id, name) values(10003, 'Core Java Crash Course');

insert into Passport(id, number) values(40001, 'YBO1012567');
insert into Passport(id, number) values(40002, 'GJU8925672');
insert into Passport(id, number) values(40003, 'DYI6202027');

insert into Student(id, name, passport_id) values(10001, 'John', 40001);
insert into Student(id, name, passport_id) values(10002, 'Jane', 40002);
insert into Student(id, name, passport_id) values(10003, 'Max', 40003);

insert into Review(id, rating, description, course_id) values(10001, '3', 'Not Satisfied', 10001);
insert into Review(id, rating, description, course_id) values(10002, '4', 'Excellent', 10002);
insert into Review(id, rating, description, course_id) values(10003, '8', '', 10003);

insert into student_course(student_id, course_id) values(10001, 10002);
insert into student_course(student_id, course_id) values(10002, 10002);
insert into student_course(student_id, course_id) values(10003, 10001);

