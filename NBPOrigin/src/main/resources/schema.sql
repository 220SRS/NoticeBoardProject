drop table if exists post;

CREATE TABLE post (
  postId INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  body VARCHAR(255) NOT NULL,
  primary key(postId)
);