DELETE
FROM routines;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO routines (name, description, startTime, endTime, timeofDay)
VALUES ('Name1', 'Description1', '2001-01-01', '2001-01-02', '11:00'),
       ('Name2', 'Description2', '2001-01-01', '2001-01-02', '11:00'),
       ('Name3', 'Description3', '2001-01-01', '2001-01-02', '11:00'),
       ('Name4', 'Description4', '2001-01-01', '2001-01-02', '11:00');