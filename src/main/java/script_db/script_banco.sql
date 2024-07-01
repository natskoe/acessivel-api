CREATE TABLE queixante (
    id_queixante bigint not null auto_increment PRIMARY KEY,
    nome VARCHAR(255),
    sobrenome VARCHAR(255),
    cpf VARCHAR(11),
    email VARCHAR(255),
    senha VARCHAR(255),
    data_nascimento date,
    cad_pcd varchar(20),
    fk_endereco_id_endereco bigint
);

CREATE TABLE endereco (
    id_endereco bigint not null auto_increment PRIMARY KEY,
    cep varchar(8),
    logradouro varchar(255),
    numero varchar(255),
    complemento varchar(255),
    bairro varchar(255),
    cidade varchar(255),
    estado varchar(255)
);

CREATE TABLE necessidade (
    id_necessidade bigint not null auto_increment PRIMARY KEY,
    titulo varchar(255),
    descricao varchar(255),
    status boolean,
    tipo varchar(255),
    cronica boolean,
    localizacao varchar(255),
    fk_queixante_id_queixante bigint
);

CREATE TABLE governo (
    data_nascimento date,
    email VARCHAR(255),
    cpf VARCHAR(11),
    nome VARCHAR(255),
    sobrenome VARCHAR(255),
    id_governo bigint not null auto_increment PRIMARY KEY,
    senha VARCHAR(255),
    matricula VARCHAR(50)
);

CREATE TABLE queixa (
    localizacao varchar(255),
    status boolean,
    titulo varchar(255),
    descricao varchar(255),
    id_queixa bigint not null auto_increment PRIMARY KEY,
    imagem_link varchar(255),
    fk_queixante_id_queixante bigint
);
 
ALTER TABLE queixante ADD CONSTRAINT FK_queixante_2
    FOREIGN KEY (fk_endereco_id_endereco)
    REFERENCES endereco (id_endereco)
    ON DELETE CASCADE;
 
ALTER TABLE necessidade ADD CONSTRAINT FK_necessidade_2
    FOREIGN KEY (fk_queixante_id_queixante)
    REFERENCES queixante (id_queixante)
    ON DELETE CASCADE;
 
ALTER TABLE queixa ADD CONSTRAINT FK_queixa_2
    FOREIGN KEY (fk_queixante_id_queixante)
    REFERENCES queixante (id_queixante)
    ON DELETE CASCADE;