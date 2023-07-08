create database Sushmitha;
use Sushmitha;
create table Login(username varchar(30),password varchar(30));
create table Product(productId int,productName varchar(30),minSellQuantity int,price int,quantity int);
insert into Login values('sush','1302');
insert into Product values(10,'product1',500,6000,40);
select * from Product;
select * from Login;