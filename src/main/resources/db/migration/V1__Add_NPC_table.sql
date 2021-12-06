CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE NPC
  (
     id UUID NOT NULL primary key DEFAULT uuid_generate_v1(),
     name VARCHAR(255),
     x_coordinate INT,
     y_coordinate INT
  );

  INSERT INTO NPC (name, x_coordinate, y_coordinate) VALUES 
  ('test_NPC_1', 80, 80),
  ('test_NPC_2', 180, 80),
  ('test_NPC_3', 80, 180),
  ('test_NPC_4', 180, 180),
  ('test_NPC_5', 180, 260);
