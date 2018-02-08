
create table IF NOT EXISTS Consoles(
	name varchar(25) PRIMARY KEY,
	company varchar(25),

);


create table IF NOT EXISTS Videogames(
	name varchar(25) PRIMARY KEY,
	recommendedAge varchar(25),
	releaseDate Date

);