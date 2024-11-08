CREATE TABLE produtos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255),
    descricao TEXT,
    localizacao VARCHAR(255),
    resumo TEXT,
    itens_inclusos TEXT[],      
    dicas TEXT[],               
    observacoes TEXT[],  -- Tipo array para armazenar faixas de preço
    url_video VARCHAR(255),
    numero_diarias INT,
    hospedagem_inclusa BOOLEAN, -- Booleano
    roteiro TEXT,
    data_disponiveis DATE[],    -- Tipo array para armazenar datas
    limite_vagas INT
);

CREATE TABLE produto_faixas_preco (
    id SERIAL PRIMARY KEY,
    produto_id INTEGER REFERENCES produtos(id) ON DELETE CASCADE,
    faixa TEXT NOT NULL,
    preco TEXT NOT NULL
);