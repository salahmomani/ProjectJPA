CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE teachers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);


CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    code VARCHAR(100),
    title VARCHAR(255)
);

CREATE TABLE student_courses (
    student_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,

    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (course_id) REFERENCES courses(id),

    PRIMARY KEY (student_id, course_id)
);

CREATE TABLE teacher_courses (
    teacher_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,

    FOREIGN KEY (teacher_id) REFERENCES teachers(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    PRIMARY KEY (teacher_id, course_id)
);

CREATE TABLE exams (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    max_score INT NOT NULL,
    course_id BIGINT NOT NULL,

    FOREIGN KEY (course_id) REFERENCES courses(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE marks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    score INT NOT NULL,
    grade VARCHAR(50),
    student_id BIGINT NOT NULL,
    exam_id BIGINT NOT NULL,

    FOREIGN KEY (student_id) REFERENCES students(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    FOREIGN KEY (exam_id) REFERENCES exams(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,

    UNIQUE (student_id, exam_id)
);
