-- Eliminar la base de datos si ya existe
DROP DATABASE IF EXISTS macalz;
CREATE DATABASE IF NOT EXISTS macalz;

-- Seleccionar la base de datos
USE macalz;

-- Vaciar las tablas
DROP TABLE IF EXISTS user_types;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS taxes;
DROP TABLE IF EXISTS payment_types;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS purchases;
DROP TABLE IF EXISTS purchase_products;

-- Crear tablas
CREATE TABLE user_types (
    user_type_id TINYINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE users (
    user_id VARCHAR(11) NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(250) NOT NULL UNIQUE, -- Email único
    user_type_id TINYINT,
    CONSTRAINT fk_user_types_user_type_id FOREIGN KEY (user_type_id) 
    REFERENCES user_types(user_type_id) 
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE clients (
    client_id VARCHAR(10) NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(10) NOT NULL, 
    email VARCHAR(100) NOT NULL UNIQUE,
    created_date DATE NOT NULL
);

CREATE TABLE taxes (
    tax_id TINYINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    rate DECIMAL(5,2) NOT NULL CHECK (rate BETWEEN 0 AND 100)
);

CREATE TABLE payment_types (
    payment_type_id TINYINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE purchases (
    purchase_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    purchase_date DATETIME NOT NULL, -- No permite fechas futuras
    discount DECIMAL(5,2) DEFAULT 0 CHECK (discount BETWEEN 0 AND 100),
    client_id VARCHAR(10) NOT NULL,
    tax_id TINYINT NOT NULL,
    payment_type_id TINYINT NOT NULL,
    user_id VARCHAR(11) NOT NULL,
    CONSTRAINT fk_clients_client_id FOREIGN KEY (client_id) 
    REFERENCES clients(client_id) 
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_taxes_tax_id FOREIGN KEY (tax_id) 
    REFERENCES taxes(tax_id) 
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_payment_types_payment_type_id FOREIGN KEY (payment_type_id) 
    REFERENCES payment_types(payment_type_id) 
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_users_user_id FOREIGN KEY (user_id) 
    REFERENCES users(user_id) 
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE products (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
    stock INTEGER DEFAULT 0 CHECK (stock >= 0)
);

CREATE TABLE purchase_products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT NOT NULL,
    purchase_id BIGINT NOT NULL,
    quantity INT NOT NULL CHECK (quantity > 0), -- Cantidad positiva
    CONSTRAINT fk_products_product_id FOREIGN KEY (product_id) 
    REFERENCES products(product_id) 
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    CONSTRAINT fk_purchases_purchase_id FOREIGN KEY (purchase_id) 
    REFERENCES purchases(purchase_id) 
    ON UPDATE CASCADE
    ON DELETE CASCADE
);


-- Crear índices para mejorar rendimiento
CREATE INDEX idx_purchase_id ON purchase_products(purchase_id);
CREATE INDEX idx_product_id ON purchase_products(product_id);

-- Crear índices en nombres para búsqueda más rápida
CREATE INDEX idx_client_name ON clients(name);
CREATE INDEX idx_product_name ON products(name);

-- Insertar datos en user_types
INSERT INTO user_types (name) VALUES
('Admin'),
('Sales'),
('Support');

-- Insertar datos en users
INSERT INTO users (user_id, name, email, user_type_id) VALUES
('USR001', 'John Doe', 'john.doe@example.com', 1),
('USR002', 'Jane Smith', 'jane.smith@example.com', 2),
('USR003', 'Emily Davis', 'emily.davis@example.com', 3);

-- Insertar datos en clients
INSERT INTO clients (client_id, name, phone, email, created_date) VALUES
('CL001', 'Alice Brown', '1234567890', 'alice.brown@example.com', '2024-01-01'),
('CL002', 'Bob Johnson', '0987654321', 'bob.johnson@example.com', '2024-02-15'),
('CL003', 'Charlie Wilson', '1122334455', 'charlie.wilson@example.com', '2024-03-10');

-- Insertar datos en taxes
INSERT INTO taxes (name, rate) VALUES
('IVA', 19.00),
('Luxury Tax', 25.00),
('Reduced Tax', 5.00);

-- Insertar datos en payment_types
INSERT INTO payment_types (name) VALUES
('Credit Card'),
('Cash'),
('Bank Transfer');

-- Insertar datos en products
INSERT INTO products (name, price, stock) VALUES
('Laptop', 1200.00, 10),
('Smartphone', 800.00, 20),
('Luxury Watch', 5000.00, 5),
('Notebook', 2.00, 100);

INSERT INTO purchases (purchase_date, discount, client_id, tax_id, payment_type_id, user_id) 
VALUES 
('2024-04-01 10:30:00', 10.00, 'CL001', 1, 1, 'USR001');

INSERT INTO purchase_products (product_id, purchase_id, quantity) 
VALUES 
(1, 1, 2), -- 2 Laptops
(2, 1, 3); -- 3 Smartphones
