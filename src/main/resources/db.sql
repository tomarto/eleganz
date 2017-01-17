CREATE TABLE Location (
	id INTEGER IDENTITY PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	address VARCHAR(255) NOT NULL,
	city VARCHAR(50) NOT NULL,
	state VARCHAR(50) NOT NULL,
	country VARCHAR(50) NOT NULL,
	postal_code VARCHAR(10) NOT NULL,
	type VARCHAR(20) NOT NULL
);

CREATE TABLE Event (
	id INTEGER IDENTITY PRIMARY KEY,
	the_date DATE,
	the_time TIME,
	location_id INTEGER NOT NULL
);

CREATE TABLE Location_Event (
	location_id INTEGER,
	event_id INTEGER
);

CREATE TABLE Person (
	id INTEGER IDENTITY PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL
);

CREATE TABLE UserDetail (
	id INTEGER IDENTITY PRIMARY KEY,
	type VARCHAR(20) NOT NULL,
	bride_id INTEGER NOT NULL,
	groom_id INTEGER NOT NULL,
	church_event_id INTEGER,
	wedding_event_id INTEGER
);

CREATE TABLE User (
	id INTEGER IDENTITY PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	password_hash VARCHAR(255) NOT NULL,
	role VARCHAR(10) NOT NULL,
	email VARCHAR(254),
	user_detail_id INTEGER
);

INSERT INTO Location (name, address, city, state, country, postal_code, type) 
VALUES ('Iglesia la Pur&#237;sima', 'Hidalgo y Serafin Pe&#241;a 748 Zona Centro', 'Monterrey', 'Nuevo Le&#243;n', 'M&#233;xico', '64000', 'CHURCH');

INSERT INTO Location (name, address, city, state, country, postal_code, type) 
VALUES ('La Cantera', 'Carr. Nacional, 2700 Col. Valle de Cristal', 'Monterrey', 'Nuevo Le&#243;n', 'M&#233;xico', '64986', 'WEDDING');

INSERT INTO Event (the_date, the_time, location_id) VALUES (TO_DATE('12-12-2020', 'MM-DD-YYYY'), '12:00:00', 0);
INSERT INTO Event (the_date, the_time, location_id) VALUES (TO_DATE('12-12-2020', 'MM-DD-YYYY'), '17:00:00', 1);

INSERT INTO Person (first_name, last_name) VALUES ('Maria', 'Rodriguez');
INSERT INTO Person (first_name, last_name) VALUES ('Juan', 'Lopez');

INSERT INTO UserDetail(type, bride_id, groom_id, church_event_id, wedding_event_id) VALUES ('WEDDING', 0, 1, 0, 1);

INSERT INTO User(username, password_hash, role, user_detail_id) VALUES('eleganz-admin', '$2a$10$MRYcUdxwyH7RB1xGmoGIge.oJcf.8YoEmUDN3L/Emf5eg0Vy6Q7ym', 'ROLE_ADMIN', 0);
