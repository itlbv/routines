DROP TABLE IF EXISTS routines;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE routines
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR                           NOT NULL,
  description VARCHAR                           NOT NULL,
  startTime   TIMESTAMP           DEFAULT now() NOT NULL,
  endTime     TIMESTAMP           DEFAULT now() NOT NULL,
  timeOfDay   TIME                DEFAULT now() NOT NULL,
  active      BOOL                DEFAULT TRUE  NOT NULL
);