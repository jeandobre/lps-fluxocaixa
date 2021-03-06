﻿# Host: localhost  (Version: 5.7.9-log)
# Date: 2015-11-16 00:12:18
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "categorias"
#

CREATE TABLE `categorias` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(120) DEFAULT NULL,
  `descricao` text,
  `plano_conta_id` int(11) DEFAULT NULL,
  `tipo` enum('DEBITO','CREDITO') NOT NULL DEFAULT 'DEBITO',
  PRIMARY KEY (`Id`),
  KEY `plano_conta_id` (`plano_conta_id`),
  CONSTRAINT `categorias_ibfk_1` FOREIGN KEY (`plano_conta_id`) REFERENCES `categorias` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

#
# Structure for table "funcionarios"
#

CREATE TABLE `funcionarios` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) NOT NULL DEFAULT '',
  `matricula` varchar(20) DEFAULT NULL,
  `cargo` varchar(30) DEFAULT NULL,
  `funcao` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "centros_custo"
#

CREATE TABLE `centros_custo` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL DEFAULT '',
  `descricao` text,
  `tipo` enum('CX','CT','CC','CR','UO','FJ','FF','CJ','CF') NOT NULL DEFAULT 'CX',
  `numero_conta` varchar(6) DEFAULT NULL,
  `banco_conta` varchar(60) DEFAULT NULL,
  `numero_cartao` varchar(20) DEFAULT NULL,
  `vencimento_cartao` date DEFAULT NULL,
  `limite_cartao` float(15,2) DEFAULT '0.00',
  `tipo_unidade_setor` varchar(20) DEFAULT NULL,
  `numero_externo_setor` varchar(5) DEFAULT NULL,
  `hierarquia_setor_id` int(11) DEFAULT NULL,
  `funcionario_id` int(11) DEFAULT NULL,
  `rua` varchar(180) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `cidade` varchar(80) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `cnpj` varchar(20) DEFAULT NULL,
  `centro_custo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `hierarquia_id` (`hierarquia_setor_id`),
  KEY `funcionario_id` (`funcionario_id`),
  CONSTRAINT `centros_custo_ibfk_1` FOREIGN KEY (`hierarquia_setor_id`) REFERENCES `centros_custo` (`Id`),
  CONSTRAINT `centros_custo_ibfk_2` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionarios` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Structure for table "registros_importacao"
#

CREATE TABLE `registros_importacao` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date DEFAULT NULL,
  `sistema` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for table "movimentos"
#

CREATE TABLE `movimentos` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_id` int(11) NOT NULL DEFAULT '0',
  `data` date NOT NULL DEFAULT '0000-00-00',
  `numero_parcela` int(3) NOT NULL DEFAULT '1',
  `valor` float(15,2) NOT NULL DEFAULT '0.00',
  `observacao` text,
  `tipo` enum('TRANSFERENCIA','DESPESA','RECEITA') NOT NULL DEFAULT 'TRANSFERENCIA',
  `centro_custo_transferencia_id` int(11) DEFAULT NULL COMMENT 'usado apenas quando transferencia',
  `registro_importacao_id` int(11) DEFAULT NULL COMMENT 'usado apenas quando receita importado de outro sistema',
  `destino_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `centro_custo_transferencia_id` (`centro_custo_transferencia_id`),
  KEY `registro_importacao_id` (`registro_importacao_id`),
  KEY `categoria_id` (`categoria_id`),
  KEY `FK_9uqtwptxsxqcs3aogetlrhdy6` (`destino_id`),
  CONSTRAINT `FK_9uqtwptxsxqcs3aogetlrhdy6` FOREIGN KEY (`destino_id`) REFERENCES `centros_custo` (`Id`),
  CONSTRAINT `movimentos_ibfk_1` FOREIGN KEY (`centro_custo_transferencia_id`) REFERENCES `centros_custo` (`Id`),
  CONSTRAINT `movimentos_ibfk_2` FOREIGN KEY (`registro_importacao_id`) REFERENCES `registros_importacao` (`Id`),
  CONSTRAINT `movimentos_ibfk_3` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Structure for table "detalhe_movimentos"
#

CREATE TABLE `detalhe_movimentos` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `centro_custo_id` int(11) NOT NULL DEFAULT '0',
  `movimento_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`Id`),
  KEY `centro_custo_id` (`centro_custo_id`),
  KEY `movimento_id` (`movimento_id`),
  CONSTRAINT `detalhe_movimentos_ibfk_1` FOREIGN KEY (`centro_custo_id`) REFERENCES `centros_custo` (`Id`),
  CONSTRAINT `detalhe_movimentos_ibfk_2` FOREIGN KEY (`movimento_id`) REFERENCES `movimentos` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Structure for table "estados_caixa"
#

CREATE TABLE `estados_caixa` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` enum('REALIZADO','NAO_REALIZADO','ATRASADO') NOT NULL DEFAULT 'NAO_REALIZADO',
  `data` date DEFAULT NULL,
  `movimento_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `movimento_id` (`movimento_id`),
  CONSTRAINT `estados_caixa_ibfk_1` FOREIGN KEY (`movimento_id`) REFERENCES `movimentos` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
