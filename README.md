ORT -- https://www.ort-france.fr/

A working example of DB request.

It uses the following DB :

CREATE TABLE TestJDBC (
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
