USE Policlinici;

INSERT INTO utilizatori (CNP, nume, prenume, adresa, nr_telefon, email, IBAN, nr_contract, data_angajarii, tip, functie, salar_neg, nr_ore)
VALUES ('6020420298635', 'Gheorghidiu', 'Stefan', 'Str. Emil Isac, nr. 89', '0774167876', 'gheor_stefan@yahoo.com', 'NL43RABO7138432496', '1', CURRENT_DATE(), 'angajat',
'medic', '900', '40');

INSERT INTO medici (CNP_utilizator, cod_parafa)
VALUES ('6020420298635', '1');

INSERT INTO programari_pacient (ziua, ora, durata, CNP_medic, serviciu, nume_pacient, prenume_pacient)
VALUES (CURRENT_DATE(), CURRENT_TIME(), '125', '6020420298635', 'discutie_misogina', 'Varvara', 'Raluca');

INSERT INTO utilizatori (CNP, nume, prenume, adresa, nr_telefon, email, IBAN, nr_contract, data_angajarii, tip, functie, salar_neg, nr_ore)
VALUES ('6000901302020', 'Varvara', 'Raluca', 'Str. Tractorului 23', '0790123123', 'raluca@varvara@yahoo.com', 'BR3239119969684219657626134R7', '2', CURRENT_DATE(), 'administrator',
'medic', '4230', '40');

DELETE FROM programari_pacient
WHERE nume_pacient LIKE 'Varvara' AND prenume_pacient LIKE 'Raluca';

INSERT INTO Cabinete (specialitate, unitate_medicala) VALUES ('secs', 'Regina Maria');
INSERT INTO specialitati (denumire, CNP_medic, grad) VALUES ('secs', '6000901302020', 'super_secs');

SET @rezultat := NULL;

CALL stergere_serviciu ('6020420298635','ecografie', @rezultat);
CALL adaugare_serviciu ('6020420298635', 'ecografie', 'ecografie', 'ecografie', 100, 30, @rezultat);

CALL creare_programare('Negruzzi', 'Costache', 'Varvara', 'Raluca', '2020-12-29', '09:00:00', 'ecocardiologie', 'Regina Maria', @rezultat);
SELECT @rezultat;

CALL afisare_date_angajat ('Negruzzi', 'Costache', 'medic',@rezultat);
SELECT @rezultat;

CALL calculare_salariu_angajat('Leanca', 'David', '12',  @rezultat);
SELECT @rezultat;

SET @f:= NULL;
CALL determinare_functie ('2920318527823', 'iiiiiiii', @f);
SELECT @f;