drop database if exists foromotos;
create database foromotos;
drop user if exists 'roger'@'localhost';
create user 'roger'@'localhost' identified by 'roger';
GRANT ALL PRIVILEGES ON *.* TO 'roger'@'localhost';
use foromotos;

/*
 * insert into users(user_name, password, role) values('usertest','password123','standard');
 */
CREATE TABLE `users` (
  `user_name`   varchar(24) PRIMARY KEY,
  `password`    varchar(255),
  `created_at`  timestamp,
  `role`        enum('standard', 'moderator')
);

CREATE TABLE `uuid` (
  `uuid` char(36) PRIMARY KEY,
  `user_name` varchar(24)
);

CREATE TABLE `categories` (
  `id`          int         PRIMARY KEY,
  `name`        varchar(50)
);

CREATE TABLE `posts` (
  `id`          varchar(255) PRIMARY KEY,
  `title`       varchar(255),
  `content`     text,
  `author`      varchar(24),
  `category`    int,
  `created_at`  timestamp,
  `parent_id`   varchar(255)
);

ALTER TABLE `uuid` ADD FOREIGN KEY (`user_name`) REFERENCES `users` (`user_name`);

ALTER TABLE `posts` ADD FOREIGN KEY (`parent_id`) REFERENCES `posts` (`id`);

ALTER TABLE `posts` ADD FOREIGN KEY (`author`) REFERENCES `users` (`user_name`);

ALTER TABLE `posts` ADD FOREIGN KEY (`category`) REFERENCES `categories` (`id`);

insert into users (user_name, password, role) values ('pepito', '123', 'standard');
insert into categories values(1,'cat1');
insert into posts (id, title, content, author, category) values('1', 'post1', 'body of the post', 'pepito', 1);
insert into posts (id, title, content, author, category) values('2', 'post2', 'body of the post', 'pepito', 1);
insert into posts (id, title, content, author, category) values('3', 'post3', 'body of the post', 'pepito', 1);
insert into posts (id, title, content, author, category) values('4', 'post4', 'body of the post', 'pepito', 1);