INSERT INTO users (username, user_password, email, location, state, user_type, about_bug, is_confirmed)
VALUES
('test1', 'test1', 'test1@email.com', 'Melbourne', 'VIC', 'SEEKING', 'Sourdough bug, low maintenance. Feed once a week or whenever used', true),
('test2', 'test2', 'test2@email.com', 'Sydney', 'NSW', 'OFFERING', 'Sourdough bug, low maintenance. Feed once a week or whenever used', true),
('test3', 'test3', 'test3@email.com', 'Adelaide', 'SA', 'CARER', 'Sourdough bug, low maintenance. Feed once a week or whenever used', true),
('test4', 'test4', 'test4@email.com', 'Perth', 'WA', 'SEEKING', 'Sourdough bug, low maintenance. Feed once a week or whenever used', true),
('test5', 'test5', 'test5@email.com', 'Darwin', 'NT', 'OFFERING', 'Sourdough bug, low maintenance. Feed once a week or whenever used', true),
('test6', 'test6', 'test6@email.com', 'Brisbane', 'QLD', 'CARER', 'Sourdough bug, low maintenance. Feed once a week or whenever used', false),
('test7', 'test7', 'test7@email.com', 'Hobart', 'TAS', 'SEEKING', 'Sourdough bug, low maintenance. Feed once a week or whenever used', false);

INSERT INTO reviews (author, user_reviewed, review)
VALUES
(1, 2, 'Super friendly and generous with their bug'),
(3, 4, 'Willing to provide me with heaps of their bug'),
(5, 6, 'They done a great job of looking after my bug and it came back to me in a great state'),
(6, 7, 'Avoid. Unhelpful and unfriendly. Their bug was of low quality and smelt awful!');

INSERT INTO dates (user_dates, date_from, date_to)
VALUES
(1, '2022-07-01', '2022-07-10'),
(2, '2022-08-01', '2022-08-07'),
(3, '2022-09-10', '2022-09-21'),
(4, '2022-10-01', '2022-10-30');

INSERT INTO chats (from_user, to_user)
VALUES
(1, 2),
(3, 4),
(1, 6),
(3, 4);

INSERT INTO messages (chat_id, message)
VALUES
(1, 'Hi there'),
(1, 'Hey - how`s it going?'),
(2, 'Are you still available to look after my bug?'),
(3, 'Thanks again for the starter'),
(3, 'No problem! Enjoy :)'),
(4, 'Thanks for doing a great job caring for my bug')

INSERT INTO messages2 (chat_id, from_user, to_user, message)
VALUES
(1, 1, 2, 'Hi there!'),
(1, 2, 1, 'Hey! How is it going?'),
(1, 1, 2, 'Good thanks, n u?'),
(1, 2, 1, 'Fine thanks!'),
(2, 1, 3, 'test 2'),
(2, 3, 1, 'reply 2'),
(2, 1, 3, 'test 2a'),
(2, 3, 1, 'reply 2a')

INSERT INTO messages2 (chat_id, from_user, to_user, message)
VALUES
(1, 1, 2, 'Great to hear :)'),
(1, 2, 1, 'Thanks'),
(1, 2, 1, 'neway did you want to look after my bug'),
(1, 1, 2, 'yeah sure')