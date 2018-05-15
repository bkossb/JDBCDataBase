/* create table person
(
id integer not null,
name varchar(255) not null,
location varchar(255),
birth_date TIMESTAMP,
PRIMARY key(id)
);
*/

INSERT INTO PERSON (ID, NAME,LOCATION, BIRTH_DATE)
VALUES(10001, 'Ranga', 'Hydrebad', sysdate());
INSERT INTO PERSON (ID, NAME,LOCATION, BIRTH_DATE)
VALUES(10002, 'Tom', 'Hydrebad', sysdate());
INSERT INTO PERSON (ID, NAME,LOCATION, BIRTH_DATE)
VALUES(10003, 'John', 'Hydrebad', sysdate());
INSERT INTO PERSON (ID, NAME,LOCATION, BIRTH_DATE)
VALUES(10004, 'Beck', 'Hydrebad', sysdate());
INSERT INTO PERSON (ID, NAME,LOCATION, BIRTH_DATE)
VALUES(10005, 'Oliv', 'Hydrebad', sysdate());