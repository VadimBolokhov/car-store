----------------
-- Create tables
----------------

-- Makes
CREATE TABLE make
(
  id 	serial 		PRIMARY KEY,
  name 	varchar(50) 	NOT NULL
);

-- Bodies
CREATE TABLE body
(
  id 	serial 		PRIMARY KEY,
  name 	varchar(50) 	NOT NULL
);

-- Gearboxes
CREATE TABLE gearbox
(
  id 	serial 		PRIMARY KEY,
  name varchar(50) NOT NULL
);

-- Engines
CREATE TABLE engine
(
  id 	serial 		PRIMARY KEY,
  name 	varchar(50) 	NOT NULL
);

-- Transmissions
CREATE TABLE transmission
(
  id 	serial 		PRIMARY KEY,
  name 	varchar(50) 	NOT NULL
);

-- Models
CREATE TABLE model
(
  id         serial       PRIMARY KEY,
  name       varchar(50)  NOT NULL,
  make_id    int          NOT NULL REFERENCES make(id),
  body_id    int          NOT NULL REFERENCES body(id),
  engine_id  int          NOT NULL REFERENCES engine(id),
  trans_id   int          NOT NULL REFERENCES transmission(id)
);

-- Users
CREATE TABLE users
(
  id serial PRIMARY KEY,
  login varchar(20) UNIQUE NOT NULL,
  password varchar(256) NOT NULL,
  firstname varchar(20) NOT NULL,
  lastname  varchar(20) NOT NULL,
  email varchar(256) NOT NULL,
  reg_date timestamp NOT NULL DEFAULT NOW()
);

-- User roles
CREATE TABLE user_roles
(
  id serial PRIMARY KEY,
  username varchar(20) NOT NULL REFERENCES users(login),
  role varchar(20) NOT NULL,
  UNIQUE (username, role)
);

-- Cars
CREATE TABLE car
(
  id serial PRIMARY KEY,
  mod_id int NOT NULL REFERENCES model(id),
  gear_id    int          NOT NULL REFERENCES gearbox(id),
  odometer real NOT NULL DEFAULT 0,
  price real DEFAULT 0,
  color int NOT NULL,
  sold boolean NOT NULL DEFAULT false,
  description text NULL,
  post_date timestamp NOT NULL DEFAULT NOW(),
  user_id int NOT NULL REFERENCES users(id)
);