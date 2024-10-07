--USE;

DROP TABLE IF EXISTS Organization;


CREATE TABLE Organization (
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    street VARCHAR(255) NOT NULL,
    borough VARCHAR(10) NOT NULL,
    state VARCHAR(2) NOT NULL,
    zip_code INT(5) NOT NULL,
    phone_number VARCHAR(10) NOT NULL,
    website VARCHAR(255),
    description VARCHAR(255)
);
