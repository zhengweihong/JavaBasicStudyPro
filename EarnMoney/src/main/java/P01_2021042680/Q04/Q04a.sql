CREATE TABLE item
(
number char(10) primary key,
price decimal(8,2)
);

INSERT INTO item(number, price) values ('Milk-01',13.8);

SELECT * FROM item WHERE price > 10;