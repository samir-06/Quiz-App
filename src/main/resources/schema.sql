CREATE TABLE QUESTION (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    question_text VARCHAR(255),
    option_a VARCHAR(100),
    option_b VARCHAR(100),
    option_c VARCHAR(100),
    option_d VARCHAR(100),
    correct_option VARCHAR(1)
);
CREATE TABLE QUIZ_SESSION (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,

    total_questions INT NOT NULL,
    correct_answers INT NOT NULL,
    incorrect_answers INT NOT NULL
);