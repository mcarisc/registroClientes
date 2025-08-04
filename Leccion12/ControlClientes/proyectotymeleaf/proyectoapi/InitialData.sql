--1. Iniciar cliente MySQL dentro del contenedor
-->mysql -u root -p
--2. Usar la base de datos
-->USE test;
-- 3. Ver las bases de datos disponibles
-->SHOW DATABASES;
--4. Ver las tablas creadas
-->SHOW TABLES;
--5. Ver estructura de una tabla
--DESCRIBE nombre_tabla;
--6. Consultar la tabla usuario
-->SELECT * FROM usuario;


INSERT INTO usuario (username, password)
VALUES ('admin', '$2a$10$188F2hxmSnz4Xb7NccHde.aYqhR/ZZzWoRC4OF5e0g.dlIbfA9gVG');

INSERT INTO usuario (username, password)
VALUES ('user', '$2a$10$188F2hxmSnz4Xb7NccHde.aYqhR/ZZzWoRC4OF5e0g.dlIbfA9gVG');

INSERT INTO usuario (username, password)
VALUES ('gcaris', '$2a$10$188F2hxmSnz4Xb7NccHde.aYqhR/ZZzWoRC4OF5e0g.dlIbfA9gVG');

INSERT INTO usuario (username, password)
VALUES ('test', '$2a$10$188F2hxmSnz4Xb7NccHde.aYqhR/ZZzWoRC4OF5e0g.dlIbfA9gVG');

INSERT INTO rol (nombre, id_usuario)
VALUES ('ROLE_ADMIN', 1);

INSERT INTO rol (nombre, id_usuario)
VALUES ('ROLE_USER', 2);

INSERT INTO rol (nombre, id_usuario)
VALUES ('ROLE_ADMIN', 3);

INSERT INTO rol (nombre, id_usuario)
VALUES ('ROLE_USER', 3);

INSERT INTO rol (nombre, id_usuario)
VALUES ('ROLE_USER', 4);

