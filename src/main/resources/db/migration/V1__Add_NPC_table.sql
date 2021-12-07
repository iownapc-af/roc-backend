CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE NPC
  (
     id UUID NOT NULL primary key DEFAULT uuid_generate_v1(),
     name VARCHAR(255),
     type VARCHAR(255),
     x_coordinate INT,
     y_coordinate INT
  );

INSERT INTO NPC (name, type, x_coordinate, y_coordinate) VALUES 
  ('test_NPC_1', 'gorilla', 80, 80),
  ('test_NPC_2', 'squid', 180, 80),
  ('test_NPC_3', 'frog', 80, 180),
  ('test_NPC_4', 'squid', 180, 180),
  ('test_NPC_5', 'frog', 180, 260);
