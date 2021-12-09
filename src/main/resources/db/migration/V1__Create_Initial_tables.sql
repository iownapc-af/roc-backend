CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE maps_entity
  (
     map_id INTEGER NOT NULL primary key,
     map_name VARCHAR(255),
     map_contents VARCHAR(3800)
  );

CREATE TABLE npc
  (
     id UUID NOT NULL primary key DEFAULT uuid_generate_v1(),
     name VARCHAR(255),
     type VARCHAR(255),
     x_coordinate INT,
     y_coordinate INT,
     spawn_x INT,
     spawn_y INT,
     leash INT,
     map_id INT,
     CONSTRAINT map_key
      FOREIGN KEY(map_id)
        REFERENCES maps_entity(map_id)
  );

CREATE TABLE player
  (
     id INT,
     player_name VARCHAR(255),
     player_direction VARCHAR(255),
     x_coordinate INT,
     y_coordinate INT,
     map_id INT,
     CONSTRAINT map_key
      FOREIGN KEY(map_id)
        REFERENCES maps_entity(map_id)
  );

