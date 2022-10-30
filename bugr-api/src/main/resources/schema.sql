CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    user_password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    location VARCHAR(100) NOT NULL,
   	state VARCHAR(10) NOT NULL,
	user_type VARCHAR(10) NOT NULL,
    about_bug VARCHAR(10000) NOT NULL,
    is_confirmed BOOLEAN NOT NULL DEFAULT FALSE,
    date_registered TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    chats INT ARRAY DEFAULT '{}'
);

CREATE TABLE reviews (
    review_id SERIAL PRIMARY KEY,
    author INT NOT NULL,
    user_reviewed SERIAL NOT NULL,
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    review VARCHAR(10000) NOT NULL,
    CONSTRAINT reviews_fkey_author FOREIGN KEY (author) REFERENCES users(user_id),
    CONSTRAINT reviews_fkey_user FOREIGN KEY (user_reviewed) REFERENCES users(user_id)
    ON DELETE CASCADE
);

CREATE TABLE dates (
    date_id SERIAL PRIMARY KEY,
    user_dates INT NOT NULL,
    date_from DATE NOT NULL,
    date_to DATE NOT NULL,
    CONSTRAINT dates_fkey FOREIGN KEY (user_dates) REFERENCES users(user_id)
    ON DELETE CASCADE
);

CREATE TABLE messages (
    message_id SERIAL PRIMARY KEY,
    chat_id INT NOT NULL,
    from_user INT NOT NULL,
    to_user INT NOT NULL,
    message VARCHAR(1000) NOT NULL,
    message_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    opened BOOLEAN NOT NULL DEFAULT false
);