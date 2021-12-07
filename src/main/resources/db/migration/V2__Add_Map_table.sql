CREATE TABLE maps_entity
  (
     id INTEGER NOT NULL primary key,
     map_name VARCHAR(255),
     map_contents VARCHAR(3800)
  );

INSERT INTO maps_entity VALUES (
  0,
  'test_map',
  '########################################|#                                      #|#                                      #|#                                      #|#    ,,WWWWWWWWWW,                     #|#    ,,W        W,                     #|#    ,,W        W,                     #|#    ,,WWWWWW:WWW,                     #|#    ,,.,.,.   .,,                     #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|#                                      #|########################################|'
);