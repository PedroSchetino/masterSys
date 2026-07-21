/*
INSERT INTO modalidades (nome)
VALUES ('Musculação'),
       ('Funcional'),
       ('Jiu-Jitsu'),
       ('Muay Thai'),
       ('Pilates');

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 120.00
FROM modalidades
WHERE nome = 'Musculação';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Trimestral', 330.00
FROM modalidades
WHERE nome = 'Musculação';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 150.00
FROM modalidades
WHERE nome = 'Funcional';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 180.00
FROM modalidades
WHERE nome = 'Jiu-Jitsu';

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Branca'
FROM modalidades
WHERE nome = 'Jiu-Jitsu';

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Azul'
FROM modalidades
WHERE nome = 'Jiu-Jitsu';

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Roxa'
FROM modalidades
WHERE nome = 'Jiu-Jitsu';
 */

-- Inserções na tabela modalidades (garantindo não duplicar)
INSERT INTO modalidades (nome)
SELECT 'Musculação' WHERE NOT EXISTS (SELECT 1 FROM modalidades WHERE nome = 'Musculação');

INSERT INTO modalidades (nome)
SELECT 'Funcional' WHERE NOT EXISTS (SELECT 1 FROM modalidades WHERE nome = 'Funcional');

INSERT INTO modalidades (nome)
SELECT 'Jiu-Jitsu' WHERE NOT EXISTS (SELECT 1 FROM modalidades WHERE nome = 'Jiu-Jitsu');

INSERT INTO modalidades (nome)
SELECT 'Muay Thai' WHERE NOT EXISTS (SELECT 1 FROM modalidades WHERE nome = 'Muay Thai');

INSERT INTO modalidades (nome)
SELECT 'Pilates' WHERE NOT EXISTS (SELECT 1 FROM modalidades WHERE nome = 'Pilates');

-- Inserções na tabela planos (Com ON CONFLICT para ignorar duplicatas no PostgreSQL)
INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 120.00
FROM modalidades
WHERE nome = 'Musculação' ON CONFLICT (modalidade_id, nome) DO NOTHING;

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Trimestral', 330.00
FROM modalidades
WHERE nome = 'Musculação' ON CONFLICT (modalidade_id, nome) DO NOTHING;

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 150.00
FROM modalidades
WHERE nome = 'Funcional' ON CONFLICT (modalidade_id, nome) DO NOTHING;

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 180.00
FROM modalidades
WHERE nome = 'Jiu-Jitsu' ON CONFLICT (modalidade_id, nome) DO NOTHING;

-- Inserções na tabela graduacoes
INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Branca'
FROM modalidades
WHERE nome = 'Jiu-Jitsu' ON CONFLICT DO NOTHING;

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Azul'
FROM modalidades
WHERE nome = 'Jiu-Jitsu' ON CONFLICT DO NOTHING;

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Roxa'
FROM modalidades
WHERE nome = 'Jiu-Jitsu' ON CONFLICT DO NOTHING;