CREATE TABLE users (
    id INT AUTO_INCREMET PRIMARY KEY, 
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE registers (
    id INT AUTO_INCREMET PRIMARY KEY,
    user_id INT,
    date_work DATE,
    entry_hour TIME, 
    exit_hour TIME,
    FOREIGN KEY (user_id) REFERENCES users(id) 
)