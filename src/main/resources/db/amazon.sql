create database amazon;

INSERT INTO Customer (username, password, name, email, phone_number, photo, is_activated, is_admin) VALUES
('user1', 'pass1', 'Customer One', 'customer1@example.com', '0123456789', 'photo1.jpg', 1, 1),
('user2', 'pass2', 'Customer Two', 'customer2@example.com', '0123456790', 'photo1.jpg', 1, 0),
('user3', 'pass3', 'Customer Three', 'customer3@example.com', '0123456791', 'photo1.jpg', 1, 0),
('user4', 'pass4', 'Customer Four', 'customer4@example.com', '0123456792', 'photo1.jpg', 1, 0),
('user5', 'pass5', 'Customer Five', 'customer5@example.com', '0123456793', 'photo1.jpg', 1, 0),
('user6', 'pass6', 'Customer Six', 'customer6@example.com', '0123456794', 'photo1.jpg', 1, 0),
('user7', 'pass7', 'Customer Seven', 'customer7@example.com', '0123456795', 'photo1.jpg', 1, 0),
('user8', 'pass8', 'Customer Eight', 'customer8@example.com', '0123456796', 'photo1.jpg', 1, 0),
('user9', 'pass9', 'Customer Nine', 'customer9@example.com', '0123456797', 'photo1.jpg', 1, 0),
('user10', 'pass10', 'Customer Ten', 'customer10@example.com', '0123456798', 'photo1.jpg', 1, 0);
INSERT INTO Orders (order_date, customer_id, amount,is_activated, status) VALUES
('2024-06-01', 1, 100.0,1, 1),
('2024-06-02', 2, 200.0,1, 1),
('2024-06-03', 3, 300.0,1, 1),
('2024-06-04', 4, 400.0,1, 1),
('2024-06-05', 5, 500.0,1, 1),
('2024-06-06', 6, 600.0,1, 1),
('2024-06-07', 7, 700.0,1, 1),
('2024-06-08', 8, 800.0,1, 1),
('2024-06-09', 9, 900.0,1, 1),
('2024-06-10', 10, 1000.0,1, 1);
INSERT INTO order_details (is_activated,quantity, price, product_id, order_id) VALUES
(1,1, 10.0, 2, 1),
(1,2, 20.0, 11, 2),
(1,3, 30.0, 3, 3),
(1,4, 40.0, 4, 4),
(1,5, 50.0, 5, 5),
(1,6, 60.0, 6, 6),
(1,7, 70.0, 7, 7),
(1,8, 80.0, 8, 8),
(1,9, 90.0, 9, 9),
(1,10, 100.0, 10, 10);
INSERT INTO Categories (name, description,is_activated) VALUES
('Category One', 'Description for category one',1),
('Category Two', 'Description for category two',1),
('Category Three', 'Description for category three',1),
('Category Four', 'Description for category four',1),
('Category Five', 'Description for category five',1),
('Category Six', 'Description for category six',1),
('Category Seven', 'Description for category seven',1),
('Category Eight', 'Description for category eight',1),
('Category Nine', 'Description for category nine',1),
('Category Ten', 'Description for category ten',1);
INSERT INTO cart_items (product_id, customer_id, quantity, price) VALUES
(2, 1,2, 10.0),
(11, 2,4, 20.0),
(3, 3,5, 30.0),
(4, 4,6, 40.0),
(5, 5, 6, 50.0),
(6, 6, 5, 60.0),
(7, 7, 4, 70.0),
(8, 8, 6, 80.0),
(9, 9,5, 90.0),
(10, 10,5, 100.0);
INSERT INTO Products (name, quantity, price, weight, image, description, discount, create_date, stock, category_id) VALUES
('Product One', 10, 100.0, 1.0, 'image1.jpg', 'Description for product one', 0.1, '2024-06-01', 1, 1),
('Product Two', 20, 200.0, 2.0, 'image1.jpg', 'Description for product two', 0.2, '2024-06-02', 1, 2),
('Product Three', 30, 300.0, 3.0, 'image1.jpg', 'Description for product three', 0.3, '2024-06-03', 1, 3),
('Product Four', 40, 400.0, 4.0, 'image1.jpg', 'Description for product four', 0.4, '2024-06-04', 1, 4),
('Product Five', 50, 500.0, 5.0, 'image1.jpg', 'Description for product five', 0.5, '2024-06-05', 1, 5),
('Product Six', 60, 600.0, 6.0, 'image1.jpg', 'Description for product six', 0.6, '2024-06-06', 1, 6),
('Product Seven', 70, 700.0, 7.0, 'image1.jpg', 'Description for product seven', 0.7, '2024-06-07', 1, 7),
('Product Eight', 80, 800.0, 8.0, 'image1.jpg', 'Description for product eight', 0.8, '2024-06-08', 1, 8),
('Product Nine', 90, 900.0, 9.0, 'image1.jpg', 'Description for product nine', 0.9, '2024-06-09', 1, 9),
('Product Ten', 100, 1000.0, 10.0, 'image1.jpg', 'Description for product ten', 1.0, '2024-06-10', 1, 10);
