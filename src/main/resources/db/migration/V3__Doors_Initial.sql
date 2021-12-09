CREATE TABLE doors
  (
     id INT NOT NULL primary key,
     door_x_coordinate INT,
     door_y_coordinate INT,
     door_map_id INT,
     new_player_x_coordinate INT,
     new_player_y_coordinate INT,
     new_player_map_id INT
  );

INSERT INTO doors (id, door_x_coordinate, door_y_coordinate, door_map_id, new_player_x_coordinate, new_player_y_coordinate, new_player_map_id) VALUES
  (0, 13, 7, 0, 20, 20, 1),
  (1, 8, 7, 1, 9, 8, 0);