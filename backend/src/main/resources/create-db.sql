create table Profesor(
	id			int not null primary key
				generated by default as identity (start with 1, increment by 1),
	nombre		varchar(200) not null,
	email		varchar(200)
);

create table Curso(
	id			int not null primary key
				generated by default as identity (start with 1, increment by 1),
	titulo		varchar(200) not null,
	activo		boolean not null,
	horas		int,
	nivel		varchar(20),
	idProfesor	int references Profesor(id)
);
