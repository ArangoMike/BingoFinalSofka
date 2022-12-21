-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION;

-- -----------------------------------------------------
-- Schema databingo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema databingo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS databingo DEFAULT CHARACTER SET utf8 ;
USE databingo ;

-- -----------------------------------------------------
-- Table databingo.usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS databingo.usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  id_mongoU VARCHAR(45) NULL,
  PRIMARY KEY (id_usuario))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table databingo.juego
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS databingo.juego (
  id_juego INT NOT NULL AUTO_INCREMENT,
  estado_juego ENUM("iniciando", "en curso", "finalizado") NULL,
  ganador_juego VARCHAR(45) NULL,
  fecha_inicio DATETIME NULL,
  PRIMARY KEY (id_juego))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table databingo.tabla_bingo
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS databingo.tabla_bingo (
  id_tabla_bingo INT NOT NULL AUTO_INCREMENT,
  b1 INT NULL,
  b2 INT NULL,
  b3 INT NULL,
  b4 INT NULL,
  b5 INT NULL,
  i1 INT NULL,
  i2 INT NULL,
  i3 INT NULL,
  i4 INT NULL,
  i5 INT NULL,
  n1 INT NULL,
  n2 INT NULL,
  n3 VARCHAR(10) NULL,
  n4 INT NULL,
  n5 INT NULL,
  g1 INT NULL,
  g2 INT NULL,
  g3 INT NULL,
  g4 INT NULL,
  g5 INT NULL,
  o1 INT NULL,
  o2 INT NULL,
  o3 INT NULL,
  o4 INT NULL,
  o5 INT NULL,
  id_usuario INT NOT NULL,
  PRIMARY KEY (id_tabla_bingo),
  INDEX fk_tabla_bingo_usuario1_idx (id_usuario ASC) VISIBLE,
  CONSTRAINT fk_tabla_bingo_usuario1
    FOREIGN KEY (id_usuario)
    REFERENCES databingo.usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table databingo.juego_usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS databingo.juego_usuario (
  id_juego INT NOT NULL,
  id_usuario INT NOT NULL,
  id INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (id, id_juego, id_usuario),
  INDEX fk_juego_has_usuario_usuario1_idx (id_usuario ASC) VISIBLE,
  INDEX fk_juego_has_usuario_juego1_idx (id_juego ASC) VISIBLE,
  CONSTRAINT fk_juego_has_usuario_juego1
    FOREIGN KEY (id_juego)
    REFERENCES databingo.juego (id_juego)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_juego_has_usuario_usuario1
    FOREIGN KEY (id_usuario)
    REFERENCES databingo.usuario (id_usuario)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- ----------------------------------------------------
-- Table databingo.balota
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS databingo.balota (
  id_balota INT NOT NULL,
  balota VARCHAR(45) NULL,
  PRIMARY KEY (id_balota))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
