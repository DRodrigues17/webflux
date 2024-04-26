CREATE TABLE anime (
    id serial PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

INSERT INTO anime (nome) VALUES
    ('berserk'),
    ('neo genesis evangelion'),
    ('vagabond'),
    ('bleach'),
    ('akira'),
    ('vinland saga');
