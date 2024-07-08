-- Selecionar os paises e ordernar pelo nome de forma decrescente
SELECT nome
FROM pais
ORDER BY nome DESC;

-- Selecionar logradouro e cep dos endereços que começam com a letra A
SELECT logradouro, cep
FROM endereco
WHERE logradouro LIKE 'a%';


-- Selecionar os endereços em que o CEP teminem com 0
SELECT *
FROM endereco
WHERE TRIM(cep) LIKE '%0';

-- Selecionar os endereços que com números de 1 a 100
SELECT *
FROM endereco
WHERE numero BETWEEN 1 AND 100;

-- Todos os endereços que tenham RUA no nome e ordenar de forma decrescente de acordo com o CEP
SELECT *
FROM endereco
WHERE logradouro LIKE 'RUA%'
ORDER BY cep DESC;

-- Selecionar a quantidade de endereços que constam na tabela
SELECT COUNT(*)
FROM endereco;

-- Selecionar a quantidade de endereços que constam na tabela de acordo com o id da cidade;
SELECT id_cidade, COUNT(*)
FROM endereco
GROUP BY id_cidade;



-- Atualizar o logradouro e o complemento dos endereços com id 2 e 3;
UPDATE endereco
SET logradouro = 'Rua Dinis Barreto', complemento = 'Fundos'
WHERE id IN(2, 3);


-- Atualizar o número do endereço onde o id é 4
UPDATE endereco
SET numero = 999999
WHERE id = 4;

-- Remover o último registro da tabela endereço utilizando a função max
DELETE FROM endereco
WHERE id = (SELECT MAX (id) from endereco)


-- Remover o endereço onde o número é 999999:
DELETE FROM endereco
WHERE numero = 999999;


-- Remover 2 registros da tabela endereço:
DELETE FROM endereco
WHERE id IN (SELECT id FROM endereco LIMIT 2);