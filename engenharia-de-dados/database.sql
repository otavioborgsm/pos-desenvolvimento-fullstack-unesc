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







