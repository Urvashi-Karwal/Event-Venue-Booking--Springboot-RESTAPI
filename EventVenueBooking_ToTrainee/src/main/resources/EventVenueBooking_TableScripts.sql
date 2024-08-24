DROP SCHEMA IF EXISTS event_venue_booking_db;

CREATE SCHEMA event_venue_booking_db;
USE event_venue_booking_db;

CREATE TABLE event (
	event_id INT PRIMARY KEY,
	event_name VARCHAR(50) NOT NULL UNIQUE,
	venue VARCHAR(50) NOT NULL,
	slot_available INT NOT NULL
);

CREATE TABLE customer (
	customer_id INT AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	email_id VARCHAR(100) NOT NULL,
	event_date DATE NOT NULL,
	event_name VARCHAR(100) NOT NULL,
	event_id INT,
	CONSTRAINT ps_customer_id_pk PRIMARY KEY (customer_id),
	CONSTRAINT fs_event_customer_fk FOREIGN KEY (event_id) REFERENCES event(event_id)
);

INSERT INTO event(event_id, event_name, venue, slot_available) VALUES (1011, 'Meeting', 'ConferenceCentre',  3);
INSERT INTO event(event_id, event_name, venue, slot_available) VALUES (1012, 'Concert', 'Arena', 1);
INSERT INTO event(event_id, event_name, venue, slot_available) VALUES (1013, 'Workshop', 'AcademicVenue', 2);

INSERT INTO customer(customer_id, name, email_id,  event_date, event_name,  event_id) VALUES (1001, 'Jake', 'jake@abc.com', '2021-11-28', 'Meeting', 1011);
INSERT INTO customer(customer_id, name, email_id,  event_date, event_name,  event_id) VALUES (1002, 'Mary', 'mary@abc.com', '2022-05-10', 'Concert', 1012);
INSERT INTO customer(customer_id, name, email_id,  event_date, event_name,  event_id) VALUES (1003, 'Kenny', 'kenny@abc.com', '2022-02-17', 'Workshop',  1013);
INSERT INTO customer(customer_id, name, email_id,  event_date, event_name,  event_id) VALUES (1004, 'Brad', 'brad@abc.com', '2021-11-10', 'Meeting', 1011);
INSERT INTO customer(customer_id, name, email_id,  event_date, event_name,  event_id) VALUES (1005, 'Alice', 'alice@abc.com', '2021-12-13', 'Workshop',  1013);
INSERT INTO customer(customer_id, name, email_id,  event_date, event_name,  event_id) VALUES (1006, 'Smith', 'smith@abc.com', '2021-11-09', 'Concert', 1012);
INSERT INTO customer(customer_id, name, email_id,  event_date, event_name,  event_id) VALUES (1007, 'John', 'john@abc.com', '2022-03-25', 'Concert',1012);


select*from event;
select*from customer;