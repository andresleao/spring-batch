CREATE TABLE cliente (
	nome TEXT,
	sobrenome TEXT,
	idade TEXT,
	email TEXT
);

INSERT INTO cliente VALUES ("Joao", "Silva", "30", "joao@test.com");
INSERT INTO cliente VALUES ("Maria", "Silva", "30", "maria@test.com");

INSERT INTO cliente VALUES ("Zeca 1", "Silva", "30", "zeca1@test.com");
INSERT INTO cliente VALUES ("Zeca 2", "Silva", "30", "zeca2@test.com");
INSERT INTO cliente VALUES ("Zeca 3", "Silva", "30", "zeca3@test.com");
INSERT INTO cliente VALUES ("Zeca 4", "Silva", "30", "zeca4@test.com");
INSERT INTO cliente VALUES ("Zeca 5", "Silva", "30", "zeca5@test.com");
INSERT INTO cliente VALUES ("Zeca 6", "Silva", "30", "zeca6@test.com");
INSERT INTO cliente VALUES ("Zeca 7", "Silva", "30", "zeca7@test.com");
INSERT INTO cliente VALUES ("Zeca 8", "Silva", "30", "zeca8@test.com");
INSERT INTO cliente VALUES ("Zeca 9", "Silva", "30", "zeca9@test.com");

CREATE TABLE lancamento (
	codigoNaturezaDespesa INT,
	descricaoNaturezaDespesa TEXT,
	descricaoLancamento TEXT,
	dataLancamento DATE,
	valorLancamento DOUBLE
);

INSERT INTO lancamento VALUES (44905224,'EQUIPAMENTO DE PROTEÇÃO SEGURANÇA E SOCORRO','Alarme','2020-05-01',1000);
INSERT INTO lancamento VALUES (44905287,'MATERIAL DE CONSUMO DE USO DURADOURO','Cortina de sala','2020-05-02',1000);
INSERT INTO lancamento VALUES (44905287,'MATERIAL DE CONSUMO DE USO DURADOURO','Bandeiras','2020-05-03',500);
INSERT INTO lancamento VALUES (44905287,'MATERIAL DE CONSUMO DE USO DURADOURO','Guarda Sol','2020-05-04',500);
INSERT INTO lancamento VALUES (33903016,'MATERIAL DE EXPEDIENTE','Resma de Papel A4','2020-05-01',2000);
INSERT INTO lancamento VALUES (33903016,'MATERIAL DE EXPEDIENTE','Cartucho Impressora','2020-05-10',2000);
INSERT INTO lancamento VALUES (44905218,'COLEÇÕES E MATERIAIS BIBLIOGRÁFICOS','Dicionários','2020-05-12',4000);
INSERT INTO lancamento VALUES (44905218,'COLEÇÕES E MATERIAIS BIBLIOGRÁFICOS','Livro de Algoritmos','2020-05-11',4000);
INSERT INTO lancamento VALUES (33903024,'MATERIAL P/ MANUT. DE BENS IMÓVEIS/INSTALAÇÕES','Amianto','2020-05-13',8000);
INSERT INTO lancamento VALUES (33903024,'MATERIAL P/ MANUT. DE BENS IMÓVEIS/INSTALAÇÕES','Aparelhos Sanitários','2020-05-11',6000);
INSERT INTO lancamento VALUES (33903024,'MATERIAL P/ MANUT. DE BENS IMÓVEIS/INSTALAÇÕES','Cimento','2020-05-12',2000);
INSERT INTO lancamento VALUES (33903302,'PASSAGENS PARA O EXTERIOR','Viagem para Las Vegas','2020-05-01',32000);
