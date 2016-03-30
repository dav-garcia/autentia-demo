insert into Profesor(nombre, email) values
	('Primer profesor', null),
	('Segundo profesor', 'segundo@profesor.com'),
	('Tercer profesor externo', 'externo@gmail.com');
	
insert into Curso(titulo, activo, horas, nivel, idProfesor) values
	('Introducción a la programación orientada a objetos', true, 50, 'BASICO', 1),
	('COBOL orientado a objetos', false, 100, 'AVANZADO', 1),
	('Desarrollo de aplicaciones web Java', true, 50, 'INTERMEDIO', 2),
	('AngularJS con Spring', true, 20, 'AVANZADO', 3);