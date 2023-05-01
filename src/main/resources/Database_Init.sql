-- 创建数据库learnSpring:
DROP DATABASE IF EXISTS learnSpring;
CREATE DATABASE learnSpring;

-- 创建登录用户learnSpringUser / 口令learnSpringPassword
CREATE USER IF NOT EXISTS learnSpringUser@'%' IDENTIFIED BY 'learnSpringPassword';
GRANT ALL PRIVILEGES ON learnspring.* TO learnSpringUser@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;

USE learnSpring;

create table account(
                        id int primary key auto_increment,
                        name varchar(40),
                        money float
)character set utf8 collate utf8_general_ci;

insert into account(name,money) values('aaa',1000);
insert into account(name,money) values('bbb',1000);
insert into account(name,money) values('ccc',1000);


