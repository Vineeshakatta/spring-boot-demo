CREATE TABLE student (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE teacher (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE student_teacher (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    student_id BIGINT NOT NULL,
    teacher_id BIGINT NOT NULL,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES student(id),
    CONSTRAINT fk_teacher FOREIGN KEY (teacher_id) REFERENCES teacher(id)
);