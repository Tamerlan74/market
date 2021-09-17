CREATE TABLE products (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE address (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  destination VARCHAR(250) NOT NULL
);

CREATE TABLE orders (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  address_id int(11),
  FOREIGN KEY (address_id) REFERENCES address (id)
);

CREATE TABLE orders_products (
  order_id int(11) NOT NULL,
  product_id int(11) NOT NULL,
  PRIMARY KEY (order_id, product_id),
  FOREIGN KEY (order_id) REFERENCES orders (id),
  FOREIGN KEY (product_id) REFERENCES products (id)
);

CREATE TABLE sales (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  rate INT NOT NULL
);

CREATE TABLE sales_products (
  sale_id int(11) NOT NULL,
  product_id int(11) NOT NULL,
  PRIMARY KEY (sale_id, product_id),
  FOREIGN KEY (sale_id) REFERENCES sales (id),
  FOREIGN KEY (product_id) REFERENCES products (id)
);
