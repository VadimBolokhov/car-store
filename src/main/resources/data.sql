--------------
-- Fill tables
--------------

-- Users
INSERT INTO users(login, password, firstname, lastname, email) VALUES
('root', '$2y$11$lWVkpNNtme0l7Mzj1kVWY.5ijbwc8f39JFyuVRcJCM1MO1WJBrBcK', 'root', 'root', 'root@email.com'),
('user1', '$2y$11$si7O3JeiV2pw7UFKtDQ/EeW/9kHUOakLPvOQ/03jjSXlhdt11JezC', 'Vadim', 'Bolokhov', 'some@email.com');

-- User roles
INSERT INTO user_roles(username, role) VALUES
('root', 'ADMIN'), ('root', 'USER'), ('user1', 'USER');

-- Makes
INSERT INTO make(name) VALUES
('Opel'), ('Dodge'), ('Lada');

-- Bodies
INSERT INTO body(name) VALUES
('Supermini'), ('Hatchback'), ('MPV'), ('Sedan'), ('Coupe'), ('SUV');

-- Gearboxes
INSERT INTO gearbox(name)
VALUES ('manual'), ('automatic');

-- Transmissions
INSERT INTO transmission(name)
VALUES ('Front-wheel drive'), ('Rear-wheel drive'), ('All-wheel drive');

-- Engines
INSERT INTO engine(name)
VALUES ('Gasoline'), ('Diesel'), ('Electric'), ('Hybrid');

-- Models
INSERT INTO model(name, make_id, body_id, engine_id, trans_id) VALUES
('Insignia OPC', 1, 4, 1, 3),
('Astra 5 Doors', 1, 2, 1, 1),
('Viper', 2, 5, 1, 2),
('Journey', 2, 6, 1, 1),
('Dart', 2, 5, 1, 1),
('Challenger SRT Demon', 2, 5, 1, 2),
('Kalina', 3, 4, 1, 1),
('Priora', 3, 2, 1, 1);

-- Cars
INSERT INTO car(mod_id, gear_id, odometer, price, color, user_id, description) VALUES
(1, 2, 50000, 10000, 1, 2, 'My first car'),
(3, 1, 50000, 40000, 2, 2, 'My second car'),
(5, 2, 100000, 10000, 3, 2, 'My third car'),
(7, 1, 150000, 2000, 4, 2, 'My fourth car');