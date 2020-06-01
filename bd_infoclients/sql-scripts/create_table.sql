CREATE TABLE country (
  code int NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  PRIMARY KEY (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE state (
  code int NOT NULL AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  code_country int DEFAULT NULL,
  PRIMARY KEY (code),
  KEY code_country_idx (code_country),
  CONSTRAINT fk_state_country FOREIGN KEY (code_country) REFERENCES country (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE city (
  code int NOT NULL AUTO_INCREMENT,
  name varchar(45) DEFAULT NULL,
  code_state int DEFAULT NULL,
  PRIMARY KEY (code),
  KEY fk_city_state_idx (code_state),
  CONSTRAINT fk_city_state FOREIGN KEY (code_state) REFERENCES state (code)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE customer (
  id int NOT NULL AUTO_INCREMENT,
  nit varchar(500) NOT NULL,
  full_name varchar(300) DEFAULT NULL,
  address varchar(500) DEFAULT NULL,
  phone varchar(30) DEFAULT NULL,
  credit_limit int NOT NULL,
  username varchar(200),
  password varchar(200),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE sale_representative (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(400) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE visit (
  id int NOT NULL AUTO_INCREMENT,
  id_customer int DEFAULT NULL,
  id_city int DEFAULT NULL,
  id_sale_representative int DEFAULT NULL,
  net double DEFAULT NULL,
  total double DEFAULT NULL,
  description varchar(45) DEFAULT NULL,
  date_visit datetime DEFAULT NULL,
  PRIMARY KEY (id),
  KEY fk_visit_customer_idx (id_customer),
  KEY fk_vistit_city_idx (id_city),
  KEY fk_visit_sale_representative_idx (id_sale_representative),
  CONSTRAINT fk_visit_city FOREIGN KEY (id_city) REFERENCES city (code),
  CONSTRAINT fk_visit_customer FOREIGN KEY (id_customer) REFERENCES customer (id),
  CONSTRAINT fk_visit_sale_representative FOREIGN KEY (id_sale_representative) REFERENCES sale_representative (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


