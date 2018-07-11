CREATE DATABASE `vlearncom` CHARACTER SET utf8 COLLATE utf8_general_ci;

-- cj 和 123 分别对应你数据库的用户名和密码，需保持与 application.yml 中一致
GRANT ALL ON `vlearncom`.* TO `cj`@`%` IDENTIFIED BY '123';
FLUSH PRIVILEGES;