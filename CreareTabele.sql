CREATE DATABASE IF NOT EXISTS Policlinici;
USE Policlinici;

CREATE TABLE IF NOT EXISTS Unitati_medicale
(denumire VARCHAR(100) PRIMARY KEY NOT NULL,
adresa VARCHAR(255) NOT NULL,
id_program INT NOT NULL);

create table if not exists Programe
(id_program INT AUTO_INCREMENT PRIMARY KEY,
luni_ora_inceput TIME NOT NULL,
luni_ora_sfarsit TIME NOT NULL,
marti_ora_inceput TIME NOT NULL,
marti_ora_sfarsit TIME NOT NULL,
miercuri_ora_inceput TIME NOT NULL,
miercuri_ora_sfarsit TIME NOT NULL,
joi_ora_inceput TIME NOT NULL,
joi_ora_sfarsit TIME NOT NULL,
vineri_ora_inceput TIME NOT NULL,
vineri_ora_sfarsit TIME NOT NULL,
sambata_ora_inceput TIME NOT NULL,
sambata_ora_sfarsit TIME NOT NULL,
duminica_ora_inceput TIME NOT NULL,
duminica_ora_sfarsit TIME NOT NULL);

ALTER TABLE Unitati_medicale
ADD FOREIGN KEY (id_program) REFERENCES Programe(id_program);

CREATE TABLE IF NOT EXISTS Utilizatori
(CNP BIGINT(13) PRIMARY KEY NOT NULL,
nume VARCHAR(255) NOT NULL,
prenume VARCHAR(255) NOT NULL,
adresa VARCHAR(255),
nr_telefon VARCHAR(11) NOT NULL,
email VARCHAR(255),
IBAN VARCHAR(255) NOT NULL,
nr_contract BIGINT(10) NOT NULL,
data_angajarii DATE NOT NULL,
tip VARCHAR(255) NOT NULL,
functie VARCHAR(100) NOT NULL,
salar_neg FLOAT(7,2) NOT NULL,
nr_ore INT(3) NOT NULL,
parola VARCHAR(15) NOT NULL);

CREATE TABLE IF NOT EXISTS Orare_generice
(id_orar INT PRIMARY KEY AUTO_INCREMENT,
CNP_utilizator BIGINT(13) NOT NULL,
zi VARCHAR(100) NOT NULL,
ora_inceput TIME NOT NULL,
ora_sfarsit TIME NOT NULL,
unitate_medicala VARCHAR(100) NOT NULL,
FOREIGN KEY(CNP_utilizator) REFERENCES Utilizatori(CNP));

CREATE TABLE IF NOT EXISTS Orare_specifice
(id_orar INT PRIMARY KEY AUTO_INCREMENT,
CNP_utilizator BIGINT(13) NOT NULL,
zi DATE NOT NULL,
ora_inceput TIME NOT NULL,
ora_sfarsit TIME NOT NULL,
unitate_medicala VARCHAR(100) NOT NULL,
FOREIGN KEY(CNP_utilizator) REFERENCES Utilizatori(CNP));

CREATE TABLE IF NOT EXISTS Concedii
(id_concediu INT PRIMARY KEY AUTO_INCREMENT,
CNP_utilizator BIGINT(13) NOT NULL,
data_sfarsit DATE NOT NULL,
data_inceput DATE NOT NULL,
FOREIGN KEY(CNP_utilizator) REFERENCES Utilizatori(CNP));

CREATE TABLE IF NOT EXISTS Administratori
(CNP_admin BIGINT(13) NOT NULL,
FOREIGN KEY (CNP_admin) REFERENCES Utilizatori(CNP));

CREATE TABLE IF NOT EXISTS Super_Administratori
(CNP_super_admin BIGINT(13) NOT NULL,
FOREIGN KEY (CNP_super_admin) REFERENCES Utilizatori(CNP));

CREATE TABLE IF NOT EXISTS Asistenti_medicali
(CNP_utilizator BIGINT(13) PRIMARY KEY NOT NULL,
tip VARCHAR(255) NOT NULL,
grad INT NOT NULL,
FOREIGN KEY (CNP_utilizator) REFERENCES Utilizatori(CNP));

CREATE TABLE IF NOT EXISTS Medici
(CNP_utilizator BIGINT(13) PRIMARY KEY NOT NULL,
titlu_stiintific VARCHAR(255) NOT NULL,
cod_parafa INT NOT NULL,
postul_didactic VARCHAR(255),
procent_adaugat FLOAT(4,2),
FOREIGN KEY (CNP_utilizator) REFERENCES Utilizatori(CNP));

CREATE TABLE IF NOT EXISTS Specialitati
(id_specialitate INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
denumire VARCHAR(255) NOT NULL,
CNP_medic BIGINT(13) NOT NULL,
grad VARCHAR(255) NOT NULL,
FOREIGN KEY (CNP_medic) REFERENCES Medici(CNP_utilizator));

CREATE TABLE IF NOT EXISTS Competente
(id_competenta INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
denumire VARCHAR(255) NOT NULL,
CNP_medic BIGINT(13) NOT NULL,
FOREIGN KEY (CNP_medic) REFERENCES Medici(CNP_utilizator));

CREATE TABLE IF NOT EXISTS Servicii_medicale
(id_serviciu_medical INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
denumire VARCHAR(255) NOT NULL,
CNP_medic BIGINT(13) NOT NULL,
specialitate VARCHAR(255) NOT NULL,
competente VARCHAR(255),
pret INT NOT NULL,
durata INT NOT NULL,
FOREIGN KEY (CNP_medic) REFERENCES Medici(CNP_utilizator));

CREATE TABLE IF NOT EXISTS Programari_pacient
(id_programare INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
ziua DATE NOT NULL,
ora TIME NOT NULL,
durata INT NOT NULL,
CNP_medic BIGINT(13) NOT NULL,
serviciu VARCHAR(255) NOT NULL,
unitate_medicala VARCHAR(255) NOT NULL,
nume_pacient varchar(255) NOT NULL,
prenume_pacient varchar(255) NOT NULL,
FOREIGN KEY (cnp_medic) REFERENCES Medici(CNP_utilizator));

CREATE TABLE IF NOT EXISTS Istorice
(id_istoric INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
ziua DATE NOT NULL,
nume_pacient varchar(255) NOT NULL,
prenume_pacient varchar(255) NOT NULL);

CREATE TABLE IF NOT EXISTS Rapoarte_programare
(id_raport INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
ziua DATE NOT NULL,
nume_pacient varchar(255) NOT NULL,
prenume_pacient varchar(255) NOT NULL,
rezultat VARCHAR(255) NOT NULL,
cnp_medic_rec BIGINT,
cnp_asistent BIGINT,
recomandari TEXT,
simptome TEXT,
diagnostic TEXT,
id_istoric INT NOT NULL,
cod_parafa BOOLEAN,
investigatie TEXT,
FOREIGN KEY (id_istoric) REFERENCES Istorice(id_istoric),
FOREIGN KEY (cnp_medic_rec) REFERENCES Medici(CNP_utilizator),
FOREIGN KEY (cnp_asistent) REFERENCES Asistenti_medicali(CNP_utilizator));

CREATE TABLE IF NOT EXISTS Cabinete
(id_cabinet INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
specialitate VARCHAR(255) NOT NULL,
unitate_medicala VARCHAR(100) NOT NULL,
FOREIGN KEY (unitate_medicala) REFERENCES Unitati_medicale(denumire));

CREATE TABLE IF NOT EXISTS Repartizare
(id_repartizare INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
id_cabinet INT,
CNP_medic BIGINT(13),
FOREIGN KEY (id_cabinet) REFERENCES Cabinete(id_cabinet),
FOREIGN KEY (CNP_medic) REFERENCES Medici(CNP_utilizator));