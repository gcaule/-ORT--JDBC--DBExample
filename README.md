ORT -- https://www.ort-france.fr/

A working example of DB request.

It uses the following DB :

CREATE DATABASE TestJDBC;
USE TestJDBC;

CREATE TABLE Etudiants (
Id INT AUTO_INCREMENT PRIMARY KEY,
Nom VARCHAR(50) NOT NULL,
Prénom VARCHAR(50) NOT NULL,
Filière VARCHAR(10) NOT NULL);

INSERT INTO TestJDBC (Nom, Prénom, Filière) VALUES
('Clay', 'Alexis', 'CDA'),
('Cahuzac', 'Pierre', 'CDA'),
('Schwarzenegger', 'Arnold', 'Lift'),
('Crews', 'Terry', 'Lift'),
('Croft', 'Lara', 'JV');

It only works once though - you will have to manually delete the Foreign Key in Etudiants if you want to make it work again (easy enough with PHPMyAdmin).
