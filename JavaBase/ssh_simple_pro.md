```sql
CREATE TABLE `ssh_employ` (  
    id INT PRIMARY KEY AUTO_INCREMENT,  
    last_name VARCHAR(255) NOT NULL,  
    email VARCHAR(255) UNIQUE NOT NULL,  
    birth DATE,  
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP,  
    department_id INT,  
    FOREIGN KEY (department_id) REFERENCES ssh_department(id)  
);

create table `ssh_department`(
	id INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(255) NOT NULL
);
```

更换表名

```sql
RENAME TABLE employ TO ssh_employ;
```

```sql
insert into ssh_department values (1, "销售部");
insert into ssh_department values(2, "研发部");

INSERT INTO ssh_employ (last_name, email, birth, department_id)
   VALUES 
   ('张三', '123131@example.com', '2023-01-01', 2),
   ('里斯', '2220131@example.com', '2023-01-01', 2);
```



