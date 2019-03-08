DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS routines;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
  id                     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name                   VARCHAR                           NOT NULL,
  email                  VARCHAR                           NOT NULL,
  password               VARCHAR                           NOT NULL,
  role                   VARCHAR                           NOT NULL,
  timeDateOfRegistration TIMESTAMP           DEFAULT now() NOT NULL
);

CREATE TABLE roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR NOT NULL,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

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