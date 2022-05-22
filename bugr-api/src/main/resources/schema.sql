CREATE TYPE state AS ENUM ('VIC', 'NSW', 'QLD', 'SA', 'WA', 'NT', 'TAS', 'ACT');
CREATE TYPE user_type AS ENUM ('SEEKING', 'OFFERING', 'CARER');
CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    user_password VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    location VARCHAR(100) NOT NULL,
   	state state NOT NULL,
	user_type user_type NOT NULL,
    about_bug VARCHAR(10000) NOT NULL,
    is_confirmed BOOLEAN NOT NULL DEFAULT FALSE,
    date_registered TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
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

CREATE TABLE chats (
    chat_id SERIAL PRIMARY KEY,
    from_user INT NOT NULL,
    to_user INT NOT NULL,
    chat_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT chats_from_fkey FOREIGN KEY (from_user) REFERENCES users(user_id),
    CONSTRAINT chats_to_fkey FOREIGN KEY (to_user) REFERENCES users(user_id)
    ON DELETE CASCADE
);

CREATE TABLE messages (
    message_id SERIAL PRIMARY KEY,
    chat_id INT NOT NULL,
    message VARCHAR(1000) NOT NULL,
    message_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT messages_chatid_fkey FOREIGN KEY (chat_id) REFERENCES chats(chat_id)
    ON DELETE CASCADE
);