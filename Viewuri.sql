CREATE VIEW bon_fiscal AS
SELECT ziua, ora, pret AS 'Suma achitata'
FROM Programari_pacient AS p, Servicii_medicale AS s
WHERE p.serviciu LIKE s.denumire;

CREATE VIEW progromati AS
SELECT nume_pacient AS 'Nume', prenume_pacient AS 'Prenume', serviciu AS 'la serviciul'
FROM Programari_pacient AS p, Medici AS m
WHERE p.CNP_medic = m.CNP_utilizator
AND p.ziua = CURRENT_DATE;
