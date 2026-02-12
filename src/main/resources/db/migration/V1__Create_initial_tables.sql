CREATE TABLE tb_department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(255) NOT NULL
);

CREATE TABLE tb_employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(255) UNIQUE,
    department_id BIGINT,

    CONSTRAINT fk_employee_department
        FOREIGN KEY (department_id)
        REFERENCES tb_department(id)
        ON DELETE SET NULL
);
