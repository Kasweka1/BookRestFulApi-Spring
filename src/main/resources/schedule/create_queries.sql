
MariaDB [bookappdb]> create table start_times (
    -> start_time int primary key
    -> );
Query OK, 0 rows affected (0.026 sec)

MariaDB [bookappdb]> create table venues (
    -> venue_name varchar(100) primary key
    -> );
Query OK, 0 rows affected (0.028 sec)

MariaDB [bookappdb]> create table courses (
    -> course_id varchar(10) primary key,
    -> course_name varchar(100)
    -> );
Query OK, 0 rows affected (0.021 sec)

MariaDB [bookappdb]> create table course_times (
    -> course_id varchar(10),
    -> start_time int,
    -> venue_name varchar(100),
    -> day varchar(9),
    -> foreign key (course_id) references courses(course_id),
    -> foreign key (start_time) references start_times(start_time),
    -> foreign key (venue_name) references venues(venue_name),
    -> primary key (start_time, venue_name, day)
    -> );
Query OK, 0 rows affected (0.021 sec)

MariaDB [bookappdb]> show tables;
+---------------------+
| Tables_in_bookappdb |
+---------------------+
| book                |
| course_times        |
| courses             |
| start_times         |
| venues              |
+---------------------+
5 rows in set (0.002 sec)

MariaDB [bookappdb]> describe course_times;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| course_id  | varchar(10)  | YES  | MUL | NULL    |       |
| start_time | int(11)      | NO   | PRI | NULL    |       |
| venue_name | varchar(100) | NO   | PRI | NULL    |       |
| day        | varchar(9)   | NO   | PRI | NULL    |       |
+------------+--------------+------+-----+---------+-------+
4 rows in set (0.074 sec)

MariaDB [bookappdb]> describe courses;
+-------------+--------------+------+-----+---------+-------+
| Field       | Type         | Null | Key | Default | Extra |
+-------------+--------------+------+-----+---------+-------+
| course_id   | varchar(10)  | NO   | PRI | NULL    |       |
| course_name | varchar(100) | YES  |     | NULL    |       |
+-------------+--------------+------+-----+---------+-------+
2 rows in set (0.052 sec)

MariaDB [bookappdb]> describe start_times;
+------------+---------+------+-----+---------+-------+
| Field      | Type    | Null | Key | Default | Extra |
+------------+---------+------+-----+---------+-------+
| start_time | int(11) | NO   | PRI | NULL    |       |
+------------+---------+------+-----+---------+-------+
1 row in set (0.039 sec)

MariaDB [bookappdb]> describe venues;
+------------+--------------+------+-----+---------+-------+
| Field      | Type         | Null | Key | Default | Extra |
+------------+--------------+------+-----+---------+-------+
| venue_name | varchar(100) | NO   | PRI | NULL    |       |
+------------+--------------+------+-----+---------+-------+