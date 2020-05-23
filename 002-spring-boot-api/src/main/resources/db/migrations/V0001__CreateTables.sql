CREATE TABLE actors (
  actor_id    VARCHAR(36) NOT NULL,
  actor_name  VARCHAR(25) NOT NULL,
  PRIMARY KEY (actor_id),
  UNIQUE(actor_name)
);

CREATE TABLE film_crew_people (
  person_id    VARCHAR(36) NOT NULL,
  person_name  VARCHAR(25) NOT NULL UNIQUE,
  PRIMARY KEY (person_id),
  UNIQUE(person_name)
);

CREATE TABLE film_crew_roles (
  role_id    VARCHAR(36) NOT NULL,
  role_name  VARCHAR(40) NOT NULL UNIQUE,
  PRIMARY KEY (role_id),
  UNIQUE(role_name)
);

CREATE TABLE acting_roles (
  role_id    VARCHAR(36) NOT NULL,
  role_name  VARCHAR(40) NOT NULL UNIQUE,
  PRIMARY KEY (role_id),
  UNIQUE(role_name)
);
