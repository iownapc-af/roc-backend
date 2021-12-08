INSERT INTO maps_entity (map_id, map_name, map_contents) VALUES
  (0,
  'test_map',
  '########################################|#                                      #|#                                      #|#                                      #|#    ,,WWWWWWWWWW,                     #|#    ,,W        W,                     #|#    ,,W        W,                     #|#    ,,WWWWWW:WWW,                     #|#    ,,.,.,.   .,,                     #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|########################################|'),
  (1,
  'test_combat_map',
  '####################|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|#                  #|####################|');

INSERT INTO NPC (name, type, x_coordinate, y_coordinate, map_id) VALUES 
  ('test_NPC_1', 'gorilla', 80, 80, 0),
  ('test_NPC_2', 'squid', 180, 60, 0),
  ('test_NPC_3', 'frog', 80, 180, 0),
  ('test_NPC_4', 'squid', 180, 180, 0),
  ('test_NPC_5', 'frog', 180, 260, 0);


INSERT INTO Player VALUES
  (0, 'Steve', 'south', 20, 20, 0);
