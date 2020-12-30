DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS User;

CREATE TABLE User (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE Booking (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  check_in TIMESTAMP NOT NULL,
  check_out TIMESTAMP NOT NULL,
  user_id BIGINT,
  foreign key (user_id) references User(id)
);
