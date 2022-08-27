create database sagnikb_cms;
use sagnikb_cms;

create table customer (
custId int primary key,
custFName varchar(50) not null,
custLName varchar(50) not null,
custAdress varchar(255) not null,
custPhoneNo varchar(12) not null unique,
custWalletBal double check(cust_WalletBal > 0),
custEmail varchar(100) not null unique
);

create table login(
userName varchar(50) not null,
password varchar(20) not null
);
create table vendor(
vendorId int primary key,
vendorPhoneNo varchar(12) not null unique,
vendorFName varchar(50) not null,
vendorLName varchar(50) not null,
vendorEmail varchar(100) not null unique);


create table food(
foodCode int not null unique,
foodName varchar(100) not null,
foodPrice int not null,
cuisine varchar(30),
hasNonVeg bool,
calorie double,
vendorId int, 
foreign key (vendorId) references vendor(vendorId));



create table order_list(
orderId int not null unique,
custId int ,
totalPrice double not null,
foodCode int,
orderDate date ,
orderStatus varchar(20),
vendorId int,
quantity int
);

alter table order_list add constraint fk_custID foreign key (custId) references customer(custId);
alter table order_list add constraint fk_vendorID foreign key (vendorId) references vendor(vendorId);


alter table food add constraint pk_foodID primary key (foodCode);

alter table order_list add constraint fk_foodID foreign key (foodCode) references food(foodCode);


Rename table order_list to OrderList;

desc orderlist;
desc food;
desc customer;
desc vendor;

insert into customer values
(1,"Sagnik","Bhattacharjee","Kolkata,West Bengal","4548921654",45.0,"demo@example.com"),
(2,"Suman","Mazumdar","Asansol,West Bengal","4544565404",22.0,"demo1@example.com"),
(3,"Hemant","Goenka","New Delhi,Delhi","5554891654",40.0,"demo2@example.com"),
(4,"Ankita","Jaiswal","Kolkata,West Bengal","8789421217",65.0,"demo3@example.com"),
(5,"Shalini","Bhatt","Howrah,West Bengal","4548665564",42.0,"demo4@example.com");

insert into vendor values
(100,"7841345614","Suresh","Raina","vendor@example.com"),
(101,"7523456142","Mukesh","Adaya","vendor1@example.com"),
(102,"7554156144","Harish","Raut","vendor2@example.com"),
(103,"6256545445","Sunil","Narine","vendor3@example.com"),
(104,"9615156144","Michael","Francis","vendor4@example.com");


insert into food values
(1000,"Chicken Biriyani",250,"Indian",True,465.2,101),
(1001,"Veg Biriyani",200,"Indian",false,330.2,102),
(1002,"Cheese Pasta",150,"Italian",false,200.7,104),
(1003,"Chicken Pizza",400,"Italian",True,550.2,104);

insert into login values
("demo@example.com","dorwssap"),
("demo1@example.com","password"),
("demo2@example.com","pass"),
("demo3@example.com","passw"),
("demo4@example.com","passwo"),
("vendor@example.com","passvendor"),
("vendor1@example.com","passvendor123"),
("vendor2@example.com","passvendor321"),
("vendor3@example.com","passvendor222"),
("vendor4@example.com","passvendor456");

select * from food ;



alter table vendor add column rating int ;





insert into orderList values (3001,1,550.00,1001,"2022-04-13","ACCEPTED",102,2);

select * from orderList where orderDate = current_date();

alter table customer add column coupon varchar(25);

select * from login;

UPDATE CUSTOMER SET custWalletBal = 200000 WHERE custId = 1;