CREATE TABLE books (
  book_id      VARCHAR(36)  NOT NULL,
  title        VARCHAR(125) NOT NULL,
  author       VARCHAR(50)  NOT NULL,
  summary      TEXT NULL,
  release_year CHAR(4) NOT NULL,
  PRIMARY KEY (book_id)
);

--//@UNDO
