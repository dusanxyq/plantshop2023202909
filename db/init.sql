CREATE DATABASE IF NOT EXISTS plantshop CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE plantshop;

CREATE TABLE IF NOT EXISTS categories (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS plants (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price INT,
  category_id BIGINT,
  FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE SET NULL
);

INSERT INTO categories (name) VALUES ('Voće') ON DUPLICATE KEY UPDATE name=name;
INSERT INTO categories (name) VALUES ('Povrće') ON DUPLICATE KEY UPDATE name=name;

INSERT INTO plants (name, price, category_id) VALUES ('Jabuka', 120, (SELECT id FROM categories WHERE name='Voće')) ON DUPLICATE KEY UPDATE name=name;
INSERT INTO plants (name, price, category_id) VALUES ('Kruška', 150, (SELECT id FROM categories WHERE name='Voće')) ON DUPLICATE KEY UPDATE name=name;
INSERT INTO plants (name, price, category_id) VALUES ('Trešnja', 200, (SELECT id FROM categories WHERE name='Voće')) ON DUPLICATE KEY UPDATE name=name;
INSERT INTO plants (name, price, category_id) VALUES ('Banana', 90, (SELECT id FROM categories WHERE name='Voće')) ON DUPLICATE KEY UPDATE name=name;
INSERT INTO plants (name, price, category_id) VALUES ('Kupus', 80, (SELECT id FROM categories WHERE name='Povrće')) ON DUPLICATE KEY UPDATE name=name;
INSERT INTO plants (name, price, category_id) VALUES ('Luk', 60, (SELECT id FROM categories WHERE name='Povrće')) ON DUPLICATE KEY UPDATE name=name;
INSERT INTO plants (name, price, category_id) VALUES ('Paradajz', 140, (SELECT id FROM categories WHERE name='Povrće')) ON DUPLICATE KEY UPDATE name=name;
INSERT INTO plants (name, price, category_id) VALUES ('Krompir', 70, (SELECT id FROM categories WHERE name='Povrće')) ON DUPLICATE KEY UPDATE name=name;
