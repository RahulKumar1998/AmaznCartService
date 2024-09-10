CREATE DATABASE IF NOT EXISTS amazncart;

USE amazncart;

CREATE TABLE IF NOT EXISTS products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    rating DECIMAL(2, 1),
    inventory INT,
    origin VARCHAR(50),
    arrival_status VARCHAR(50)
    );