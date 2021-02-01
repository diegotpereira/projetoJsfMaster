create database db_projeto_jsf_master;

use db_projeto_jsf_master;

create table cliente(id int primary key auto_increment, nome varchar(50),
email varchar(50) unique);


insert into cliente (id, nome, email) values
(null, 'diego', 'diego@gmail.com'),
(null, 'luana', 'luana@gmail.com'),
(null, 'juliano', 'juliano@gmail.com'),
(null, 'fafabelem', 'fafabelem@gmail.com');
