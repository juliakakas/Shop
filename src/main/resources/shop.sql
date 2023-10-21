drop database shop;
create database shop;
use shop;

create table user(
                     id int primary key auto_increment,
                     username varchar(800),
                     birth_place varchar(50),
                     birth_date date,
                     email varchar(50)
);

create table cart(
                     id int primary key auto_increment,
                     shop varchar(200),
                     product varchar(500),
                     price int,
                     user_id int,
                     foreign key (user_id)references user(id)
);

INSERT INTO user (username, birth_place, birth_date, email)
VALUES
    ('Kovács Lajos', 'Budapest', '1985-05-20', 'kovacs.lajos@gmail.com'),
    ('Kovács Ágnes', 'Buadpest', '1990-12-15', 'kovacs.agnes@yahoo.com'),
    ('Kovács Tamás', 'Budapest', '1988-07-10', 'kovacs.tamas@icloud.com');

INSERT INTO cart (shop, product, price, user_id)
VALUES
    ('kifli.hu', 'szombati bevásárlás', 9726, 1),
    ('alza.hu', 'kávéfőző', 15000, 2),
    ('konzolvilag.hu', 'PS5', 150000, 2),
    ('barbershop.hu', 'hajzselé', 3500, 1),
    ('utazzvelunk.hu', 'Cairo 5 nap', 120000, 3);


