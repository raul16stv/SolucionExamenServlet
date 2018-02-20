
create table IF NOT EXISTS Consoles(
	name varchar(25) PRIMARY KEY,
	companyId int,

);


create table IF NOT EXISTS Videogames(
	name varchar(25) PRIMARY KEY,
	recommendedAge varchar(25),
	releaseDate Date,
	companyId int,

);
create table IF NOT EXISTS Companies(
	id int ,
	name varchar(25) PRIMARY KEY,
	creationDate Date,
	
	
	
);