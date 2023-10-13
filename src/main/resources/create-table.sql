CREATE TABLE pelicula (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    sinopsis TEXT,
    enListaPorVer BOOLEAN
);

CREATE TABLE serie (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    sinopsis TEXT,
    enListaPorVer BOOLEAN
);

CREATE TABLE temporada (
    id INTEGER PRIMARY KEY REFERENCES serie(id),
    numTempo INTEGER,
    viendoActualmente BOOLEAN
);

CREATE TABLE episodio (
    id SERIAL PRIMARY KEY,
    numTempo INTEGER,
    numEpisodio INTEGER,
    titulo VARCHAR(255) NOT NULL,
    viendoActualmente BOOLEAN,
    serie_id INTEGER REFERENCES temporada(id)
);

CREATE TABLE genero (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descrip TEXT
);

CREATE TABLE visualizacion (
    id SERIAL PRIMARY KEY,
    vistoCuando DATE,
    tiempoVisto INTEGER,
    pelicula_id INTEGER REFERENCES pelicula(id),
    serie_id INTEGER REFERENCES serie(id)
);


CREATE TABLE ubicacion (
    vid INTEGER PRIMARY KEY REFERENCES visualizacion(id),
    ciudad VARCHAR(255),
    lugar VARCHAR(255)
);

CREATE TABLE celebridad (
    cID SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

CREATE TABLE rating (
    id SERIAL PRIMARY KEY,
    calificacion DECIMAL(3,2),
    resena TEXT,
    pelicula_id INTEGER REFERENCES pelicula(id),
    serie_id INTEGER REFERENCES serie(id)
);


CREATE TABLE participa (
    id SERIAL PRIMARY KEY,
    cID INTEGER REFERENCES celebridad(cID),
    rol VARCHAR(255),
    pelicula_id INTEGER REFERENCES pelicula(id),
    serie_id INTEGER REFERENCES serie(id)
);
