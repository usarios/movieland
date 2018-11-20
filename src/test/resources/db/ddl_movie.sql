CREATE TABLE movie
(
	id  INTEGER IDENTITY PRIMARY KEY,
	name_rus VARCHAR(100),
	name_native VARCHAR(100),
	year INTEGER ,
	country VARCHAR(30),
	rating double precision default 0,
	price double precision default 0,
	poster_url varchar(4000)
)
;

