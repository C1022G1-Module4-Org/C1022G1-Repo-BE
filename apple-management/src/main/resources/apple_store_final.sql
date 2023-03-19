CREATE DATABASE apple_store_final;

USE apple_store_final;

CREATE TABLE product
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    data_size VARCHAR(10),
    img VARCHAR(250),
    price DOUBLE,
    quantity INT,
    description VARCHAR(250),
    id_made_in INT,
    FOREIGN KEY (id_made_in) REFERENCES made_in(id)
);

CREATE TABLE made_in
(
    id INT primary key,
    name VARCHAR(50)
);

CREATE TABLE customer
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    date_of_birth VARCHAR(50),
    address VARCHAR(250),
    id_card VARCHAR(15),
    phone_number VARCHAR(10),
    img VARCHAR(250),
    id_customer_type INT,
    FOREIGN KEY (id_customer_type) REFERENCES customer_type(id)
);

CREATE TABLE customer_type
(
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE employee
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    date_of_birth VARCHAR(50),
    address VARCHAR(250),
    id_card VARCHAR(15),
    phone_number VARCHAR(10),
    img VARCHAR(250),
    id_position INT,
    FOREIGN KEY (id_position) REFERENCES job_position(id)
);

CREATE TABLE job_position
(
    id INT PRIMARY KEY,
    name VARCHAR(50),
    seniority INT
);

CREATE TABLE store
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    address varchar(250),
    city VARCHAR(50),
    email VARCHAR(50),
    phone_number VARCHAR(10),
    id_store_type INT,
    FOREIGN KEY (id_store_type) REFERENCES store_type(id)
);

CREATE TABLE store_type
(
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE bill_detail
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    product_id INT,
    customer_id INT,
    bill_id INT,
    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (bill_id) REFERENCES bill(id)
);

CREATE TABLE bill
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT,
    store_id INT,
    FOREIGN KEY (employee_id) REFERENCES employee(id),
    FOREIGN KEY (store_id) REFERENCES store(id)
);


CREATE TABLE app_user
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL UNIQUE ,
    password VARCHAR(50) NOT NULL UNIQUE,
    enabled BOOLEAN UNIQUE
);

CREATE TABLE app_role
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE user_role
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT UNIQUE ,
    role_id INT UNIQUE ,
    FOREIGN KEY (user_id) REFERENCES app_user(id),
    FOREIGN KEY (role_id) REFERENCES app_role(id)
)
