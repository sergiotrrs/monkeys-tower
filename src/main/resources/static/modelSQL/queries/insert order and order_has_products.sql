-- >>>>>>>>>>>>>>   Inserciones para la tabla product_order <<<<<<<<<<<<<<<<

-- Orden 1
INSERT INTO product_order (total_amount, address_id, delivery_date, purchase_date, user_id) VALUES (79.98, 1, '2023-09-10 14:00:00.000000', '2023-09-10 10:00:00.000000', 1);

-- Orden 2
INSERT INTO product_order (total_amount, address_id, delivery_date, purchase_date, user_id) VALUES (59.99, 2, '2023-09-11 14:30:00.000000', '2023-09-11 10:15:00.000000', 1);

-- Orden 3
INSERT INTO product_order (total_amount, address_id, delivery_date, purchase_date, user_id) VALUES (149.97, 3, '2023-09-12 15:00:00.000000', '2023-09-12 10:30:00.000000', 2);

-- Orden 4
INSERT INTO product_order (total_amount, address_id, delivery_date, purchase_date, user_id) VALUES (44.99, 4, '2023-09-13 15:30:00.000000', '2023-09-13 10:45:00.000000', 2);

-- Orden 5
INSERT INTO product_order (total_amount, address_id, delivery_date, purchase_date, user_id) VALUES (89.98, 5, '2023-09-14 16:00:00.000000', '2023-09-14 11:00:00.000000', 2);

-- Orden 6
INSERT INTO product_order (total_amount, address_id, delivery_date, purchase_date, user_id) VALUES (24.99, 6, '2023-09-15 16:30:00.000000', '2023-09-15 11:15:00.000000', 3);

-- Orden 7
INSERT INTO product_order (total_amount, address_id, delivery_date, purchase_date, user_id) VALUES (19.99, 7, '2023-09-16 17:00:00.000000', '2023-09-16 11:30:00.000000', 4);

-- Orden 8
INSERT INTO product_order (total_amount, address_id, delivery_date, purchase_date, user_id) VALUES (129.97, 8, '2023-09-17 17:30:00.000000', '2023-09-17 11:45:00.000000', 5);

-- Orden 9
INSERT INTO product_order (total_amount, address_id, delivery_date, purchase_date, user_id) VALUES (49.99, 9, '2023-09-18 18:00:00.000000', '2023-09-18 12:00:00.000000', 5);

-- Orden 10
INSERT INTO product_order (total_amount, address_id, delivery_date, purchase_date, user_id) VALUES (14.99, 10, '2023-09-19 18:30:00.000000', '2023-09-19 12:15:00.000000', 10);

-- >>>>>>>>>>>>>>   Inserciones para la tabla order_has_product <<<<<<<<<<<<<<<<

-- Productos en la Orden 1  -- Superhero Action Figure -- Educational Robot Toy
INSERT INTO order_has_products (order_id, product_id) VALUES (1, 1), (1, 3);  

-- Productos en la Orden 2  -- Beautiful Doll  -- Art Supplies Kit
INSERT INTO order_has_products (order_id, product_id) VALUES (2, 2), (2, 4); 

-- Productos en la Orden 3 -- High-Speed Racing Car -- Space-themed Puzzle
INSERT INTO order_has_products (order_id, product_id) VALUES (3, 5), (3, 6);  

-- Productos en la Orden 4   -- Plush Teddy Bear
INSERT INTO order_has_products (order_id, product_id) VALUES (4, 7);

-- Productos en la Orden 5  -- LEGO Creative Set  -- Family Board Game
INSERT INTO order_has_products (order_id, product_id) VALUES (5, 8), (5, 9);

-- Productos en la Orden 6  -- Outdoor Exploration Kit
INSERT INTO order_has_products (order_id, product_id) VALUES (6, 10);

-- Productos en la Orden 7   -- Superhero Action Figure   -- Art Supplies Kit
INSERT INTO order_has_products (order_id, product_id) VALUES (7, 1), (7, 4);

-- Productos en la Orden 8   -- Educational Robot Toy   -- High-Speed Racing Car
INSERT INTO order_has_products (order_id, product_id) VALUES (8, 3), (8, 5);

-- Productos en la Orden 9   -- Beautiful Doll
INSERT INTO order_has_products (order_id, product_id) VALUES (9, 2);

-- Productos en la Orden 10   -- Space-themed Puzzle
INSERT INTO order_has_products (order_id, product_id) VALUES (10, 6);
