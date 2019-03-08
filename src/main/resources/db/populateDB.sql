-- noinspection SqlWithoutWhereForFile
DELETE
FROM roles;
DELETE
FROM users;
DELETE
FROM routines;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password, timeDateOfRegistration)
VALUES ('User1', 'email1', 'password1', '2000-01-01'),
       ('User2', 'email2', 'password2', '2000-01-02');

INSERT INTO roles (user_id, role)
VALUES ('100000', 'ROLE_USER'),
       ('100001', 'ROLE_ADMIN');

INSERT INTO routines (name, description, startTime, endTime, timeofDay)
VALUES ('Name1', 'Description1', '2001-01-01', '2001-01-02', '11:00'),
       ('Name2', 'Description2', '2001-01-01', '2001-01-02', '11:00'),
       ('Name3', 'Description3', '2001-01-01', '2001-01-02', '11:00'),
       ('Name4', 'Description4', '2001-01-01', '2001-01-02', '11:00');