-- Check if table is empty, then insert data
INSERT INTO products (name, category, price, currency, rating, inventory, origin, arrival_status)
SELECT 'Acer Laptop', 'electronics', 60000, 'INR', 4.5, 50, 'India', 'new'
    WHERE NOT EXISTS (SELECT 1 FROM products WHERE name ='Acer Laptop');

INSERT INTO products (name, category, price, currency, rating, inventory, origin, arrival_status)
SELECT 'Wakefit Mattress', 'furnishing', 15000, 'INR', 3.5, 10, 'UAE', 'new'
    WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Wakefit Mattress');

INSERT INTO products (name, category, price, currency, rating, inventory, origin, arrival_status)
SELECT 'Samsung Smartphone', 'electronics', 35000, 'INR', 4.0, 20, 'South Korea', 'used'
    WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Samsung Smartphone' );