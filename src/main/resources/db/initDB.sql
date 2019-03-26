DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS routines;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
  id                   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name                 VARCHAR                           NOT NULL,
  email                VARCHAR                           NOT NULL,
  password             VARCHAR                           NOT NULL,
  registered_time_date TIMESTAMP           DEFAULT now() NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

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
  user_id     INTEGER                           NOT NULL,
  name        VARCHAR                           NOT NULL,
  description VARCHAR                           NOT NULL,
  start_time  TIMESTAMP           DEFAULT now() NOT NULL,
  end_time    TIMESTAMP           DEFAULT now() NOT NULL,
  time_of_day TIME                DEFAULT now() NOT NULL,
  active      BOOL                DEFAULT TRUE  NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);