CREATE TABLE movies (
  movie_id      VARCHAR(36) NOT NULL,
  title         VARCHAR(40) NOT NULL,
  plot_synopsis TEXT NOT NULL,
  release_year  SMALLINT NOT NULL,
  UNIQUE(title),
  PRIMARY KEY (movie_id)
);

CREATE TABLE actors (
  actor_id    VARCHAR(36) NOT NULL,
  actor_name  VARCHAR(25) NOT NULL,
  PRIMARY KEY (actor_id),
  UNIQUE(actor_name)
);

CREATE TABLE film_crew_people (
  person_id    VARCHAR(36) NOT NULL,
  person_name  VARCHAR(25) NOT NULL,
  PRIMARY KEY (person_id),
  UNIQUE(person_name)
);

CREATE TABLE film_crew_roles (
  role_id           VARCHAR(36) NOT NULL,
  role_name         VARCHAR(40) NOT NULL,
  role_description  VARCHAR(500) NULL,
  PRIMARY KEY (role_id),
  UNIQUE(role_name)
);

CREATE TABLE acting_roles (
  role_id           VARCHAR(36) NOT NULL,
  role_name         VARCHAR(40) NOT NULL,
  role_description  VARCHAR(500) NULL,
  PRIMARY KEY (role_id),
  UNIQUE(role_name)
);

CREATE TABLE cast_members (
  actor_id  VARCHAR(36) NOT NULL,
  movie_id  VARCHAR(36) NOT NULL,
  role_id   VARCHAR(36) NOT NULL,
  FOREIGN KEY (movie_id) REFERENCES movies (movie_id),
  FOREIGN KEY (actor_id) REFERENCES actors (actor_id),
  FOREIGN KEY (role_id)  REFERENCES acting_roles (role_id)
);

CREATE TABLE film_crew_members (
  person_id  VARCHAR(36) NOT NULL,
  movie_id  VARCHAR(36) NOT NULL,
  role_id   VARCHAR(36) NOT NULL,
  FOREIGN KEY (movie_id)  REFERENCES movies (movie_id),
  FOREIGN KEY (role_id)   REFERENCES film_crew_roles (role_id),
  FOREIGN KEY (person_id) REFERENCES film_crew_people (person_id)
);

CREATE TABLE reviews (
  review_id     VARCHAR(36) NOT NULL,
  movie_id      VARCHAR(36) NOT NULL,
  comment       VARCHAR(500) NULL,
  reviewer_name VARCHAR(25) NOT NULL,
  rating        CHAR(1) NOT NULL,
  PRIMARY KEY (review_id),
  FOREIGN KEY (movie_id)  REFERENCES movies (movie_id)
);
