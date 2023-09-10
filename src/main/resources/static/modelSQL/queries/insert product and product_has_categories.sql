-- Inserciones para la tabla "product"
-- Producto 1 - Superhero Action Figure
INSERT INTO product (active, price, stock, created_at, description, image, name) VALUES (1, 29.99, 150, '2023-09-10 10:00:00', 'Collectible superhero action figure with articulated joints.', 'superhero_action_figure.jpg', 'Superhero Action Figure');

-- Producto 2 - Beautiful Doll
INSERT INTO product (active, price, stock, created_at, description, image, name) VALUES (1, 19.99, 100, '2023-09-10 10:15:00', 'Beautiful doll with realistic features and accessories.', 'beautiful_doll.jpg', 'Beautiful Doll');

-- Producto 3 - Educational Robot Toy
INSERT INTO product (active, price, stock, created_at, description, image, name) VALUES (1, 59.99, 75, '2023-09-10 10:30:00', 'Interactive educational robot toy with programming capabilities.', 'educational_robot.jpg', 'Educational Robot Toy');

-- Producto 4 - Art Supplies Kit
INSERT INTO product (active, price, stock, created_at, description, image, name) VALUES (1, 34.99, 200, '2023-09-10 10:45:00', 'Complete art supplies kit for young artists.', 'art_supplies_kit.jpg', 'Art Supplies Kit');

-- Producto 5 - High-Speed Racing Car
INSERT INTO product (active, price, stock, created_at, description, image, name) VALUES (1, 44.99, 80, '2023-09-10 11:00:00', 'High-speed remote control racing car for thrilling races.', 'racing_car.jpg', 'High-Speed Racing Car');

-- Producto 6 - Space-themed Puzzle
INSERT INTO product (active, price, stock, created_at, description, image, name) VALUES (1, 14.99, 120, '2023-09-10 11:15:00', '1000-piece jigsaw puzzle featuring a space theme.', 'space_puzzle.jpg', 'Space-themed Puzzle');

-- Producto 7 - Plush Teddy Bear
INSERT INTO product (active, price, stock, created_at, description, image, name) VALUES (1, 9.99, 300, '2023-09-10 11:30:00', 'Soft and cuddly plush teddy bear for all ages.', 'plush_teddy_bear.jpg', 'Plush Teddy Bear');

-- Producto 8 - LEGO Creative Set
INSERT INTO product (active, price, stock, created_at, description, image, name) VALUES (1, 49.99, 150, '2023-09-10 11:45:00', 'Creative LEGO set with a variety of building pieces.', 'lego_creative_set.jpg', 'LEGO Creative Set');

-- Producto 9 - Family Board Game
INSERT INTO product (active, price, stock, created_at, description, image, name) VALUES (1, 24.99, 90, '2023-09-10 12:00:00', 'Classic family board game for hours of fun.', 'family_board_game.jpg', 'Family Board Game');

-- Producto 10 - Outdoor Exploration Kit
INSERT INTO product (active, price, stock, created_at, description, image, name) VALUES (1, 39.99, 50, '2023-09-10 12:15:00', 'Kit for outdoor exploration and adventure.', 'outdoor_exploration_kit.jpg', 'Outdoor Exploration Kit');


-- Inserciones para la tabla "product_has_categories"

-- Asociar Producto 1 a categorías "Action Figures" y "Toys for Boys"
INSERT INTO product_has_categories (product_id, category_id) VALUES (1, 1), (1, 6);  -- Toys for Boys

-- Asociar Producto 2 a categorías "Dolls" y "Girls' Toys"
INSERT INTO product_has_categories (product_id, category_id) VALUES (2, 2), (2, 7);  -- Girls' Toys

-- Asociar Producto 3 a categorías "Educational Toys" y "Robotics"
INSERT INTO product_has_categories (product_id, category_id) VALUES (3, 3), (3, 8);  -- Robotics

-- Asociar Producto 4 a categoría "Arts and Crafts"
INSERT INTO product_has_categories (product_id, category_id) VALUES (4, 10);

-- Asociar Producto 5 a categorías "Remote Control Toys" y "Boys' Toys"
INSERT INTO product_has_categories (product_id, category_id) VALUES (5, 4), (5, 5);  -- Boys' Toys

-- Asociar Producto 6 a categoría "Puzzles"
INSERT INTO product_has_categories (product_id, category_id) VALUES (6, 9);  -- Puzzles

-- Asociar Producto 7 a categoría "Plush Toys"
INSERT INTO product_has_categories (product_id, category_id) VALUES (7, 8);  -- Plush Toys

-- Asociar Producto 8 a categoría "Building Blocks"
INSERT INTO product_has_categories (product_id, category_id) VALUES (8, 5);  -- Building Blocks

-- Asociar Producto 9 a categoría "Board Games"
INSERT INTO product_has_categories (product_id, category_id) VALUES (9, 7);  -- Board Games

-- Asociar Producto 10 a categoría "Outdoor Toys"
INSERT INTO product_has_categories (product_id, category_id) VALUES (10, 6);  -- Outdoor Toys
