CREATE TABLE IF NOT EXISTS cliente (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    data_nascimento DATE NOT NULL
);
INSERT INTO cliente (nome, email, telefone, cpf, data_nascimento) VALUES
('João Silva', 'joao.silva@email.com', '11999999999', '12345678901', '1990-05-20'),
('Maria Souza', 'maria.souza@email.com', '21988888888', '23456789012', '1985-08-15'),
('Carlos Pereira', 'carlos.pereira@email.com', '31977777777', '34567890123', '1992-03-10'),
('Ana Costa', 'ana.costa@email.com', '41966666666', '45678901234', '1995-11-25'),
('Pedro Oliveira', 'pedro.oliveira@email.com', '51955555555', '56789012345', '1988-12-30'),
('Fernanda Lima', 'fernanda.lima@email.com', '61944444444', '67890123456', '1991-07-14'),
('Bruno Rocha', 'bruno.rocha@email.com', '71933333333', '78901234567', '1993-09-05'),
('Juliana Martins', 'juliana.martins@email.com', '81922222222', '89012345678', '1996-02-28'),
('Lucas Fernandes', 'lucas.fernandes@email.com', '91911111111', '90123456789', '1987-06-18'),
('Patricia Mendes', 'patricia.mendes@email.com', '11900000000', '01234567890', '1994-04-12');