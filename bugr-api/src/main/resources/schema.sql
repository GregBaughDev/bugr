DROP TABLE IF EXISTS users;
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    user_password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    location VARCHAR(100) NOT NULL,
   	state ENUM('VIC', 'NSW', 'QLD', 'SA', 'WA', 'NT', 'TAS', 'ACT') NOT NULL,
	user_type ENUM('SEEKING', 'OFFERING', 'CARER') NOT NULL,
    about_bug VARCHAR(10000) NOT NULL,
    is_confirmed BIT NOT NULL DEFAULT 0,
    date_registered DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
)

DROP TABLE IF EXISTS reviews;
CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    author INT NOT NULL,
    user INT NOT NULL,
    date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    review VARCHAR(10000) NOT NULL,
    FOREIGN KEY (author) REFERENCES users(user_id),
    FOREIGN KEY (user) REFERENCES users(user_id)
    )

DROP TABLE IF EXISTS dates;
CREATE TABLE dates (
    date_id INT AUTO_INCREMENT PRIMARY KEY,
    user INT NOT NULL,
    date_from DATE NOT NULL,
    date_to DATE NOT NULL,
    FOREIGN KEY (user) REFERENCES users(user_id)
    )

DROP TABLE IF EXISTS chats;
CREATE TABLE chats (
    chat_id INT AUTO_INCREMENT PRIMARY KEY,
    from_user INT NOT NULL,
    to_user INT NOT NULL,
    chat_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (from_user) REFERENCES users(user_id),
    FOREIGN KEY (to_user) REFERENCES users(user_id)
    )

DROP TABLE IF EXISTS messages;
CREATE TABLE messages (
    message_id INT AUTO_INCREMENT PRIMARY KEY,
    chat_id INT NOT NULL,
    message VARCHAR(1000) NOT NULL,
    message_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (chat_id) REFERENCES chats(chat_id)
    )

