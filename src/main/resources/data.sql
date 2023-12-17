-- Inserções para a tabela Categoria
INSERT INTO Categoria (nome, descricao) VALUES ('Alimentação', 'Despesas com alimentação');
INSERT INTO Categoria (nome, descricao) VALUES ('Transporte', 'Despesas com transporte');

-- Inserções para a tabela ComprasParceladas
INSERT INTO ComprasParceladas (valorTotal, qtdParcela, parcelasPagas) VALUES (1000.00, 10, 5);
INSERT INTO ComprasParceladas (valorTotal, qtdParcela, parcelasPagas) VALUES (500.00, 5, 2);

-- Inserções para a tabela FormaDePagamento
INSERT INTO FormaDePagamento (descricao) VALUES ('Cartão de Crédito');
INSERT INTO FormaDePagamento (descricao) VALUES ('Dinheiro');

-- Inserções para a tabela Roles
INSERT INTO Roles (autorizacao) VALUES ('USER');
INSERT INTO Roles (autorizacao) VALUES ('ADM');

-- Inserções para a tabela Usuario
-- Supondo que a senha seja armazenada como texto simples por simplicidade. Na prática, você deve armazenar uma versão hash da senha.
INSERT INTO Usuario (nome, email, senha, dataCadastro) VALUES ('João', 'joao@email.com', 'senha123', CURRENT_TIMESTAMP);
INSERT INTO Usuario (nome, email, senha, dataCadastro) VALUES ('Maria', 'maria@email.com', 'senha123', CURRENT_TIMESTAMP);

-- Inserções para a tabela Despesa
INSERT INTO Despesa (nome, descricao, status, valor, dataCriacao, dataVencimento) 
VALUES ('Compra de Mercado', 'Compras do mês', 1, 200.00, '2023-12-17 00:00:00', '2024-01-17 00:00:00');
