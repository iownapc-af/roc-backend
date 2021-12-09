INSERT INTO maps_entity (map_id, map_name, map_contents) VALUES
  (0,
  'test_map',
  '########################################|#                                      #|#                                      #|#                                      #|#    ,,WWWWWWWWWW,                     #|#    ,,W        W,                     #|#    ,,W        W,                     #|#    ,,WWWWWW:WWW,                     #|#    ,,.,.,.   .,,                     #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|########################################|'),
  -- (1,
  -- 'test_combat_map',
  -- '####################|:                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|####################|');
  (1,
  'test_combat_map2',
  '########################################|########################################|########################################|########################################|########################################|########################################|########################################|#################      #################|###############          ###############|##############            ##############|#############              #############|#############              #############|############                ############|############                ############|############                ############|############                ############|############                ############|############                ############|#############              #############|#############              #############|##############            ##############|###############          ###############|#################      #################|########################################|########################################|########################################|########################################|########################################|########################################|########################################|');

INSERT INTO npc (name, type, x_coordinate, y_coordinate, spawn_x, spawn_y, leash, map_id) VALUES 
  ('test_NPC_1', 'gorilla', 80, 80, 80, 80, 100, 0),
  ('test_NPC_2', 'squid', 180, 60, 180, 60, 0, 0),
  ('test_NPC_3', 'frog', 80, 180, 80, 180, 100, 0),
  ('test_NPC_4', 'squid', 180, 180, 180, 180, 0, 0),
  ('test_NPC_5', 'frog', 180, 260, 180, 260, 100, 0);


INSERT INTO player VALUES
  (0, 'Steve', 'south', 20, 20, 0);
