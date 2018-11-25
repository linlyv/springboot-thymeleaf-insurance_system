

# 后端技术sprintboot+thymeleaf+mybatis 前端使用boostrap框架，数据库MySQL


1、这是一个简单得到保单后台管理系统。

2、需要一个MySQL数据库，在application.properties文件里配置数据连接，如下：

spring.datasource.druid.url=jdbc:mysql://127.0.0.1:3306/03lgh?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT&nullNamePatternMatchesAll=true

spring.datasource.druid.username=root

spring.datasource.druid.password=admin

3、把user.sql和insurance.sql文件导入你的数据库

4、运行成功后浏览器访问你的本机ip加端口号8080即可，可以用管理员登录，其中一个账号密码都是root。

5、此系统实现了保单和账户的增删改查，还有一个小小的排序功能


本地运行，将index.html 和 static/js 目录下的utils.js 里的baseUrl的值改为你电脑的ip即可。


![image](https://github.com/linlyv/springboot-thymeleaf-insrance_system/blob/master/%E7%99%BB%E5%BD%95.gif?raw=true)

