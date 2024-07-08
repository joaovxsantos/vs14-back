-- Fazer um RIGHT JOIN entre tabelas:


--  Pessoa e Contato:
SELECT *
FROM Pessoa p
RIGHT JOIN Contato c ON p.id = c.pessoa_id;


--  Pessoa, PESSOA_X_PESSOA_ENDERECO e Endereco_Pessoa
SELECT *
FROM Pessoa p
RIGHT JOIN PESSOA_X_PESSOA_ENDERECO pe ON p.id = pe.pessoa_id
RIGHT JOIN Endereco_Pessoa e ON pe.endereco_id = e.id;


--  Todas as tabelas (começando por pessoa)
SELECT *
FROM Pessoa p
RIGHT JOIN Contato c ON p.id = c.pessoa_id
RIGHT JOIN PESSOA_X_PESSOA_ENDERECO pe ON p.id = pe.pessoa_id
RIGHT JOIN Endereco_Pessoa e ON pe.endereco_id = e.id;


--  Fazer um FULL JOIN entre tabelas:


--  Pessoa e Contato
SELECT *
FROM Pessoa p
FULL JOIN Contato c ON p.id = c.pessoa_id;


--  Pessoa, PESSOA_X_PESSOA_ENDERECO e Endereco_Pessoa
SELECT *
FROM Pessoa p
FULL JOIN PESSOA_X_PESSOA_ENDERECO pe ON p.id = pe.pessoa_id
FULL JOIN Endereco_Pessoa e ON pe.endereco_id = e.id;


--  Todas as tabelas (começando por pessoa)
SELECT *
FROM Pessoa p
FULL JOIN PESSOA_X_PESSOA_ENDERECO pe ON p.id = pe.pessoa_id
FULL JOIN Endereco_Pessoa e ON pe.endereco_id = e.id
FULL JOIN Contato c ON p.id = c.pessoa_id;


--  Utilizando o EXISTS, selecione as pessoas que tem endereço
SELECT p.id, p.nome
FROM Pessoa p
WHERE EXISTS (
    SELECT 1
    FROM PESSOA_X_PESSOA_ENDERECO pe
    WHERE pe.pessoa_id = p.id
);


--  Selecione id, nome da tabela pessoa junto com id, logradouro da tabela endereço
SELECT p.id , p.nome , e.id , e.logradouro
FROM Pessoa p
JOIN PESSOA_X_PESSOA_ENDERECO pe ON p.id = pe.pessoa_id
JOIN Endereco_Pessoa e ON pe.endereco_id = e.id;
