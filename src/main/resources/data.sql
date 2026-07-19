-- Sample categories
INSERT IGNORE INTO categories (id, name, description) VALUES
(1, 'Electronics', 'Phones, laptops, gadgets and accessories'),
(2, 'Fashion', 'Clothing, footwear and accessories'),
(3, 'Home & Kitchen', 'Furniture, appliances and kitchenware'),
(4, 'Books', 'Fiction, non-fiction and academic books');

-- Sample products
INSERT IGNORE INTO products (id, name, description, price, stock, image_url, category_id) VALUES
(1, 'Wireless Bluetooth Headphones', 'Over-ear headphones with noise cancellation', 2499.00, 50, 'https://via.placeholder.com/300x180?text=Headphones', 1),
(2, 'Smartphone 128GB', 'Latest generation smartphone with 128GB storage', 18999.00, 30, 'https://via.placeholder.com/300x180?text=Smartphone', 1),
(3, 'Men Cotton T-Shirt', 'Comfortable regular-fit cotton t-shirt', 499.00, 100, 'https://via.placeholder.com/300x180?text=T-Shirt', 2),
(4, 'Running Shoes', 'Lightweight breathable running shoes', 1999.00, 60, 'https://via.placeholder.com/300x180?text=Shoes', 2),
(5, 'Non-Stick Cookware Set', '5-piece non-stick cookware set', 1799.00, 25, 'https://via.placeholder.com/300x180?text=Cookware', 3),
(6, 'Study Table Lamp', 'LED study lamp with adjustable brightness', 699.00, 40, 'https://via.placeholder.com/300x180?text=Lamp', 3),
(7, 'Spring Boot in Action', 'Comprehensive guide to Spring Boot development', 899.00, 20, 'https://via.placeholder.com/300x180?text=Book', 4),
(8, 'Clean Code', 'A handbook of agile software craftsmanship', 799.00, 35, 'https://via.placeholder.com/300x180?text=Book', 4);

-- Sample admin user (password = "admin123", BCrypt-encoded)
-- You can log in with email: admin@shopease.com / password: admin123
INSERT IGNORE INTO users (id, first_name, last_name, email, password, role) VALUES
(1, 'Admin', 'User', 'admin@shopease.com', '$2b$10$iO06o3Q7wqE8uCzJ25tCfe.wS4oWIULHS7M8cT.ZJTOEHkOC7GNr6', 'ADMIN');
