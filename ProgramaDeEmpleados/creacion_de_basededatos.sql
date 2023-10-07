DROP DATABASE if exists db_programadeclientes;
CREATE DATABASE IF NOT EXISTS tabla_usuarios;
USE prueba_proyecto;
CREATE TABLE tabla_usuarios (
  usuario VARCHAR(15) NOT NULL,
  contraseña BLOB NULL DEFAULT NULL,
  numero_telefono VARCHAR(10) NULL DEFAULT NULL,
  correo_electronico VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY(usuario)
  );
  
INSERT INTO tabla_usuarios VALUES('admin','1234','9211225443','admin@uv.mx');
INSERT INTO tabla_usuarios VALUES('jvergara','1234','9215584663','jvergara@uv.mx');
INSERT INTO tabla_usuarios VALUES('jmendoza','1234','2292458245','jmendoza@uv.mx');
INSERT INTO tabla_usuarios VALUES('alejandromndz','1234','2295155654','admin@uv.mx');

