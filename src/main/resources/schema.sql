create table client(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(100),
    email varchar(100),
    phone_number varchar(100),
    address varchar(100),
    date_of_birth timestamp
);

create table product(
    id INT PRIMARY KEY AUTO_INCREMENT,
    description varchar(100),
    prod_value numeric(20,2)
);

create table cart(
    id INT PRIMARY KEY AUTO_INCREMENT,
    client_id integer references client(id),
    cart_date timestamp,
    cart_value numeric(20,2)
);

create table product_cart(
    id INT PRIMARY KEY AUTO_INCREMENT,
    prod_id integer references product(id),
    cart_id integer references cart(id),
    qtd integer
);

