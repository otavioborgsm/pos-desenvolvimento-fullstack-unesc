create database uol_unesc
	with
	owner = postgres
	encoding = 'UTF8'
	CONNECTION LIMIT = -1;

----------------------------------------

/* CRIANDO TABELAS */

CREATE TABLE clientes (
	cod_cliente INT PRIMARY KEY,
	nome_cliente varchar(30) NOT NULL,
	sobrenome_cliente varchar(100) NOT NULL
);

CREATE TABLE produtos (
	cod_produto INT PRIMARY KEY,
	nome_produto varchar(30) NOT NULL,
	descricao text NULL,
	preco numeric check(preco > 0) NOT NULL,
	qtde_estoque smallint default 0
); 

create table pedidos (
	cod_pedido SERIAL PRIMARY KEY,
	cod_cliente int NOT NULL references clientes(cod_cliente),
	cod_produto int not null references produtos(cod_produto),
	qtd smallint NOT NULL
);

----------------------------------------

/* INSERINDO DADOS */

/* CLIENTES */
INSERT INTO clientes (cod_cliente, nome_cliente, sobrenome_cliente)
VALUES(1, 'Mateus', 'Ferreira');

INSERT INTO clientes (cod_cliente, nome_cliente, sobrenome_cliente)
VALUES(2, 'Vanessa', 'Alexandre');

INSERT INTO clientes (cod_cliente, nome_cliente, sobrenome_cliente)
VALUES(3, 'Lucas', 'Ferreira');

INSERT INTO clientes (cod_cliente, nome_cliente, sobrenome_cliente)
VALUES(4, 'Giovanna', 'Ferreira');

SELECT * FROM clientes;

/* PRODUTOS */
INSERT INTO produtos (cod_produto, nome_produto, descricao, preco, qtde_estoque)
VALUES(1, 'Alcool em Gel', 'Garrafa de Alcool de 1 litro', 12.90, 5),
(2, 'Cerveja', 'Cerveja em Garrafa', 4.90, 30),
(3, 'Carvao', 'Pacote de carvao de 5kg', 9.50, 120),
(4, 'Picanha', 'Picanha refinada', 63.90, 300);

INSERT INTO produtos (cod_produto, nome_produto, descricao, preco, qtde_estoque)
VALUES(5, 'Detergente', 'Detergente Liquido de 500ml', 1.99, 32),
(6, 'Leite Integral', 'Leite Integral', 6.90, 72),
(7, 'Refrigerante', 'Refrigerante ZERO', 3.50, 14),
(8, 'Agua', 'Agua sem gas', 2.90, 100),
(9, 'Refrigerante', 'Refrigerante em Lata', 2.50, 17),
(10, 'Suco Integral', 'Suco integral de laranja', 9.90, 100);

INSERT INTO produtos (cod_produto, nome_produto, descricao, preco, qtde_estoque)
VALUES(11, 'Margarina', null, 11, 70);

SELECT * FROM produtos;

/* PEDIDOS */
INSERT INTO pedidos (cod_cliente, cod_produto, qtd)
VALUES(1, 2, 3),
(2, 3, 2),
(1, 4, 5),
(3, 1, 3);

INSERT INTO pedidos (cod_cliente, cod_produto, qtd)
VALUES(1,1,50);

INSERT INTO pedidos (cod_cliente, cod_produto, qtd)
VALUES(1,4,50),
(1, 8, 100),
(2, 3, 130),
(2, 1, 70),
(4, 9, 10);

INSERT INTO pedidos (cod_cliente, cod_produto, qtd)
VALUES(3,3,100);

SELECT * FROM pedidos;

------------------------------------------------

/* SELECT com Condições */

SELECT nome_produto, preco from produtos order by nome_produto;
SELECT nome_produto, descricao from produtos order by descricao Nulls first;
SELECT nome_produto, descricao from produtos order by descricao Nulls last;
SELECT nome_produto, preco from produtos where preco > 10 order by preco;

SELECT * FROM produtos
LIMIT 3;

SELECT * FROM produtos
order by preco desc
LIMIT 3;

SELECT * FROM produtos
order by preco desc
LIMIT 3 OFFSET 2;

SELECT * FROM produtos WHERE preco BETWEEN 3.50 AND 5.00 AND qtde_estoque >= 30;

-----------------------------------------

/* UPDATE */

UPDATE produtos SET descricao = 'Margarina com sal' WHERE cod_produto = 11;
SELECT * FROM produtos WHERE cod_produto = 11;

UPDATE produtos SET qtde_estoque = qtde_estoque - 10 WHERE cod_produto = 11;
SELECT * FROM produtos WHERE cod_produto = 11;

UPDATE produtos SET preco = preco * 1.10;

UPDATE PRODUTOS
SET NOME_PRODUTO = 'Cerveja em Lata',
	DESCRICAO = 'Cerveja em Lata 300ml',
	PRECO = 2.90,
	QTDE_ESTOQUE = 100
WHERE COD_PRODUTO = 2;

SELECT * FROM produtos;

-------------------------------------------

/* DELETE */

DELETE FROM pedidos WHERE cod_pedido = 4;
TRUNCATE TABLE pedidos CASCADE; -- Exclui pedidos e ralcionados

-------------------------------------------

SELECT count(*) from produtos where preco > 10;
SELECT count(distinct nome_produto) from produtos;
SELECT MAX(qtde_estoque) from produtos;
SELECT round(AVG(preco), 2) from produtos;

-------------------------------------------

/* ALIAS */

SELECT NOME_PRODUTO AS PRODUTO,
	QTDE_ESTOQUE AS QUANTIDADE
FROM PRODUTOS
LIMIT 5;

-------------------------------------------

/* JOIN */

SELECT * from pedidos pd
INNER JOIN clientes c ON (pd.cod_cliente = c.cod_cliente);

SELECT PD.COD_PEDIDO,
	C.NOME_CLIENTE,
	PD.COD_PRODUTO,
	PD.QTD
FROM PEDIDOS PD
INNER JOIN CLIENTES C ON (PD.COD_CLIENTE = C.COD_CLIENTE);

SELECT PD.COD_PEDIDO,
	C.NOME_CLIENTE AS CLIENTE,
	P.NOME_PRODUTO AS PRODUTO,
	PD.QTD AS QUANTIDADE,
	P.PRECO AS PRECO_UNIDADE,
	PD.QTD * P.PRECO AS VALOR_PEDIDO
FROM PEDIDOS PD
INNER JOIN CLIENTES C ON (PD.COD_CLIENTE = C.COD_CLIENTE)
INNER JOIN PRODUTOS P ON (PD.COD_PRODUTO = P.COD_PRODUTO);

-----------------------------------------------------

/* VIEW */

CREATE OR REPLACE VIEW VW_PEDIDOS AS
SELECT PD.COD_PEDIDO,
	C.NOME_CLIENTE AS CLIENTE,
	P.NOME_PRODUTO AS PRODUTO,
	PD.QTD AS QUANTIDADE,
	P.PRECO AS PRECO_UNIDADE,
	PD.QTD * P.PRECO AS VALOR_PEDIDO
FROM PEDIDOS PD
INNER JOIN CLIENTES C ON (PD.COD_CLIENTE = C.COD_CLIENTE)
INNER JOIN PRODUTOS P ON (PD.COD_PRODUTO = P.COD_PRODUTO);

SELECT * FROM VW_PEDIDOS;

SELECT * FROM VW_PEDIDOS WHERE CLIENTE = 'Mateus';

SELECT * FROM VW_PEDIDOS WHERE CLIENTE = 'Mateus' LIMIT 1;

SELECT CLIENTE, SUM(VALOR_PEDIDO) FROM VW_PEDIDOS WHERE CLIENTE = 'Mateus' GROUP BY 1;

DROP VIEW VW_PEDIDOS;

---------------------------------------

/* VIEW MATERIALIZADA */
-- Fica com dados salvos temporariamente na base

CREATE MATERIALIZED VIEW VW_PEDIDOS AS
SELECT PD.COD_PEDIDO,
	C.NOME_CLIENTE AS CLIENTE,
	P.NOME_PRODUTO AS PRODUTO,
	PD.QTD AS QUANTIDADE,
	P.PRECO AS PRECO_UNIDADE,
	PD.QTD * P.PRECO AS VALOR_PEDIDO
FROM PEDIDOS PD
INNER JOIN CLIENTES C ON (PD.COD_CLIENTE = C.COD_CLIENTE)
INNER JOIN PRODUTOS P ON (PD.COD_PRODUTO = P.COD_PRODUTO);

SELECT * FROM VW_PEDIDOS;

REFRESH MATERIALIZED VIEW VW_PEDIDOS;

-------------------------------------

/* SUB CONSULTA */

-- Produtos que possuem pedidos.
SELECT *
FROM PRODUTOS
WHERE COD_PRODUTO IN
		(SELECT COD_PRODUTO
			FROM PEDIDOS);
			
SELECT MAX(PRECO),
	NOME_PRODUTO
FROM PRODUTOS
GROUP BY NOME_PRODUTO;

SELECT NOME_PRODUTO,
	PRECO
FROM PRODUTOS
WHERE PRECO =
		(SELECT MAX(PRECO)
			FROM PRODUTOS);
			
SELECT PD.COD_PEDIDO,
	PD.COD_PRODUTO,
	P.NOME_PRODUTO,
	(SELECT NOME_CLIENTE
		FROM CLIENTES
		WHERE COD_CLIENTE = PD.COD_CLIENTE)
FROM PEDIDOS PD
JOIN PRODUTOS P ON (PD.COD_PRODUTO = P.COD_PRODUTO)

-------------------------------------------

/* VACUUM */

CREATE TABLE professor (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	salario DECIMAL(10,2)
);

DO $$
	DECLARE
	BEGIN
		FOR i IN 1..1000000 LOOP
			INSERT INTO professor (nome, salario) VALUES ('Professor' || i, random() * 1000 + 1);
		END LOOP;
	END;
$$;

SELECT relname, n_dead_tup FROM pg_stat_user_tables;
SELECT pg_size_pretty(pg_relation_size('professor'));
DELETE FROM professor WHERE id % 2 = 0; -- Remove professores com id par.

VACUUM ANALYSE professor; -- Este comando bloqueia a base

--------------------------------

/* BACKUP e RESTORE */

-- %3 -> host
-- %2 -> local onde será salvo o arquivo .dump
-- %1 -> nome do banco 

-- Comando de Backup
-- "C:\Program Files\PostgreSQL\15\bin" -h %3 -p 5432 -U postgres -F c -b -v -f %2 %1

-- Comando Restore
-- "C:\Program Files\PostgreSQL\15\bin\dropdb.exe" -h %3 -U postgres %1
-- "C:\Program Files\PostgreSQL\15\bin\createdb.exe" -E UTF8 -U postgres -h localhost -p 5432 %1
-- "C:\Program Files\PostgreSQL\15\bin\pg_restore.exe" -h %3 -p 5432 -U postgres -d %1 -v %2
