-- users
INSERT INTO `users` (`uuid`, `email`) VALUES ('014KG56DC01GG4TEB01ZEX7WFJ', 'user1@example.com');
INSERT INTO `users` (`uuid`, `email`) VALUES ('014KG56DC01GG4TEB01ZEX7WF2', 'user2@example.com');

-- user_connection_informations
INSERT INTO `user_connection_informations` (`user_uuid`, `connection_type`) VALUES ('014KG56DC01GG4TEB01ZEX7WFJ', 'email');
INSERT INTO `user_connection_informations` (`user_uuid`, `connection_type`) VALUES ('014KG56DC01GG4TEB01ZEX7WF2', 'email');