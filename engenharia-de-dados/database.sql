create database uol_unesc
	with
	owner = postgres
	encoding = 'UTF8'
	CONNECTION LIMIT = -1;


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

SELECT * FROM produtos;

/* PEDIDOS */
INSERT INTO pedidos (cod_cliente, cod_produto, qtd)
VALUES(1, 2, 3),
(2, 3, 2),
(1, 4, 5),
(3, 1, 3);

SELECT * FROM pedidos;




