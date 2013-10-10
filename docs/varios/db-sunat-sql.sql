SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `sunat` ;
CREATE SCHEMA IF NOT EXISTS `sunat` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci ;
USE `sunat` ;

-- -----------------------------------------------------
-- Table `sunat`.`tipoContribuyente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sunat`.`tipoContribuyente` ;

CREATE  TABLE IF NOT EXISTS `sunat`.`tipoContribuyente` (
  `idtipo_contribuyente` INT NOT NULL AUTO_INCREMENT ,
  `nombre_tipo` VARCHAR(45) NULL ,
  `descripcion` VARCHAR(45) NULL ,
  `estado` TINYINT NULL ,
  PRIMARY KEY (`idtipo_contribuyente`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sunat`.`contribuyente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sunat`.`contribuyente` ;

CREATE  TABLE IF NOT EXISTS `sunat`.`contribuyente` (
  `idcontribuyente_ruc` BIGINT NOT NULL ,
  `tipo_contribuyente` INT NULL ,
  `razon_social` VARCHAR(180) NOT NULL ,
  `nombre_comercial` VARCHAR(100) NOT NULL ,
  `direccion` VARCHAR(150) NULL ,
  `fecha_inscripcion` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  `estado` TINYINT NULL DEFAULT 1 ,
  PRIMARY KEY (`idcontribuyente_ruc`) ,
  INDEX `fk_contribuyente_tipoContribuyente_idx` (`tipo_contribuyente` ASC) ,
  CONSTRAINT `fk_contribuyente_tipoContribuyente`
    FOREIGN KEY (`tipo_contribuyente` )
    REFERENCES `sunat`.`tipoContribuyente` (`idtipo_contribuyente` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sunat`.`tributo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sunat`.`tributo` ;

CREATE  TABLE IF NOT EXISTS `sunat`.`tributo` (
  `idtributo` INT NOT NULL ,
  `nombre_tributo` VARCHAR(80) NULL ,
  `descripcion` VARCHAR(150) NULL ,
  `estado` TINYINT(1) NULL ,
  PRIMARY KEY (`idtributo`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sunat`.`pagoContribuyente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sunat`.`pagoContribuyente` ;

CREATE  TABLE IF NOT EXISTS `sunat`.`pagoContribuyente` (
  `idpago_contribuyente` INT NOT NULL ,
  `idcontribuyente` BIGINT NULL ,
  `idTributo` INT NULL ,
  `ejercicio` INT NULL ,
  `periodo` INT NULL ,
  `fechaRegistro` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`idpago_contribuyente`) ,
  INDEX `fk_pagoContribuyente_contribuyente1_idx` (`idcontribuyente` ASC) ,
  INDEX `fk_pagoContribuyente_tributo1_idx` (`idTributo` ASC) ,
  CONSTRAINT `fk_pagoContribuyente_contribuyente1`
    FOREIGN KEY (`idcontribuyente` )
    REFERENCES `sunat`.`contribuyente` (`idcontribuyente_ruc` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pagoContribuyente_tributo1`
    FOREIGN KEY (`idTributo` )
    REFERENCES `sunat`.`tributo` (`idtributo` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `sunat` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `sunat`.`tipoContribuyente`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunat`;
INSERT INTO `sunat`.`tipoContribuyente` (`idtipo_contribuyente`, `nombre_tipo`, `descripcion`, `estado`) VALUES (1, 'Persona Natural', 'Persona natural con negocio', 1);
INSERT INTO `sunat`.`tipoContribuyente` (`idtipo_contribuyente`, `nombre_tipo`, `descripcion`, `estado`) VALUES (2, 'Persona Juridica', 'Empresas', 1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `sunat`.`contribuyente`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunat`;
INSERT INTO `sunat`.`contribuyente` (`idcontribuyente_ruc`, `tipo_contribuyente`, `razon_social`, `nombre_comercial`, `direccion`, `fecha_inscripcion`, `estado`) VALUES (20516755416, 2, 'Empresa ABC', 'ABC', 'Jr. Libertad S/N', NULL, 1);
INSERT INTO `sunat`.`contribuyente` (`idcontribuyente_ruc`, `tipo_contribuyente`, `razon_social`, `nombre_comercial`, `direccion`, `fecha_inscripcion`, `estado`) VALUES (10461946827, 1, 'Armando Paredes', '', 'Jr. junin s/n', NULL, 1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `sunat`.`tributo`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunat`;
INSERT INTO `sunat`.`tributo` (`idtributo`, `nombre_tributo`, `descripcion`, `estado`) VALUES (8030, 'Fracionamiento', 'acuerdo de pago', 1);
INSERT INTO `sunat`.`tributo` (`idtributo`, `nombre_tributo`, `descripcion`, `estado`) VALUES (1011, 'Tributo XYZ', 'Impuesto xyz', 1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `sunat`.`pagoContribuyente`
-- -----------------------------------------------------
START TRANSACTION;
USE `sunat`;
INSERT INTO `sunat`.`pagoContribuyente` (`idpago_contribuyente`, `idcontribuyente`, `idTributo`, `ejercicio`, `periodo`, `fechaRegistro`) VALUES (1, 20516755416, 8030, 2013, 08, NULL);
INSERT INTO `sunat`.`pagoContribuyente` (`idpago_contribuyente`, `idcontribuyente`, `idTributo`, `ejercicio`, `periodo`, `fechaRegistro`) VALUES (2, 20516755416, 1011, 2013, 08, NULL);
INSERT INTO `sunat`.`pagoContribuyente` (`idpago_contribuyente`, `idcontribuyente`, `idTributo`, `ejercicio`, `periodo`, `fechaRegistro`) VALUES (3, 10461946827, 8030, 2013, 09, NULL);
INSERT INTO `sunat`.`pagoContribuyente` (`idpago_contribuyente`, `idcontribuyente`, `idTributo`, `ejercicio`, `periodo`, `fechaRegistro`) VALUES (4, 10461946827, 1011, 2013, 10, NULL);
INSERT INTO `sunat`.`pagoContribuyente` (`idpago_contribuyente`, `idcontribuyente`, `idTributo`, `ejercicio`, `periodo`, `fechaRegistro`) VALUES (5, 20516755416, 8030, 2013, 09, NULL);

COMMIT;
