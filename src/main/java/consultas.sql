USE AdventureWorks2014;

SHOW TABLES;

DESCRIBE Customer;
DESCRIBE Person;

-- filtro de texto (apellidos que empiezan con 'A')
SELECT BusinessEntityID, FirstName, LastName
FROM Person
WHERE LastName LIKE 'A%'
LIMIT 25;

-- filtro numérico (tarifa mayor a 40)
SELECT BusinessEntityID, Rate
FROM EmployeePayHistory
WHERE Rate > 40.0
LIMIT 10;

-- Consulta simple (los primeros 10 clientes)
SELECT CustomerID, AccountNumber
FROM Customer
LIMIT 15;

-- filtro numérico en productos (precio > 1000)
SELECT ProductID, Name, ListPrice
FROM Product
WHERE ListPrice > 1000.0
LIMIT 20;
