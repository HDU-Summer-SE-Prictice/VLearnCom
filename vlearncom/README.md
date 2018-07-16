# seclogin
spring security login register demo

使用spring boot+spring security的登录注册功能。
参考 [Anoyi](https://www.jianshu.com/u/7b7ec6f2db21)、汪云飞《Spring Boot实战》、
[使用 JPA 及 UserDetailsService](https://waylau.gitbooks.io/spring-security-tutorial/docs/jpa-userdetailsservice.html)

## Usage:
使用前请创建数据库，并设置用户名密码
```sql
CREATE DATABASE `vlearncom` CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON `vlearncom`.* TO `cj`@`%` IDENTIFIED BY '123';
FLUSH PRIVILEGES;
```

创建数据库后启动程序一次，然后杀掉，执行以下命令：
```sql
insert into SYS_ROLE(id,authority) values(1,'ROLE_TEACHER');
insert into SYS_ROLE(id,authority) values(2,'ROLE_STUDENT');
```

`ROLE_TEACHER` 和 `ROLE_STUDENT` 若要修改，则需同时修改 WebSecurityConfig.java 的 `hasRole("USER")` 句