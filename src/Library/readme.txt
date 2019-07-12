DATABASE TABLE STRUCTURE

Admin Table
 create table Admin(firstname varchar(200) not null, lastname varchar(200) not null,userid int not null primary key AUTO_INCREMENT, password varchar(200) not null,email varchar(500) not null, contact varchar(10) not null, address varchar(500) not null);
+-----------+--------------+------+-----+---------+----------------+
| Field     | Type         | Null | Key | Default | Extra          |
+-----------+--------------+------+-----+---------+----------------+
| firstname | varchar(200) | NO   |     | NULL    |                |
| lastname  | varchar(200) | NO   |     | NULL    |                |
| userid    | int(11)      | NO   | PRI | NULL    | auto_increment |
| password  | varchar(200) | NO   |     | NULL    |                |
| email     | varchar(500) | NO   |     | NULL    |                |
| contact   | varchar(10)  | NO   |     | NULL    |                |
| address   | varchar(500) | NO   |     | NULL    |                |
+-----------+--------------+------+-----+---------+----------------+

Librarian Table
 create table librarian(firstname varchar(200) not null, lastname varchar(200) not null, userid int not null AUTO_INCREMENT PRIMARY KEY,password varchar(200) not null,email varchar(500) not null,contact varchar(10) not null,address varchar(500) not null);
 +-----------+--------------+------+-----+---------+----------------+
 | Field     | Type         | Null | Key | Default | Extra          |
 +-----------+--------------+------+-----+---------+----------------+
 | firstname | varchar(200) | NO   |     | NULL    |                |
 | lastname  | varchar(200) | NO   |     | NULL    |                |
 | userid    | int(11)      | NO   | PRI | NULL    | auto_increment |
 | password  | varchar(200) | NO   |     | NULL    |                |
 | email     | varchar(500) | NO   |     | NULL    |                |
 | contact   | varchar(10)  | NO   |     | NULL    |                |
 | address   | varchar(500) | NO   |     | NULL    |                |
 +-----------+--------------+------+-----+---------+----------------+

**************************************************************************************************************
Prepared statement improves efficiency because it is compiled only once.
Prepared Statement important functions -
    executeQuery() - returns resultSet
    executeUpdate() - executes the query. For create,insert,update,drop - anything that changes db.

***************************************************************************************************************