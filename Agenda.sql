-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 14/06/2012 às 23h02min
-- Versão do Servidor: 5.5.16
-- Versão do PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `agenda`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_contatos`
--

CREATE TABLE IF NOT EXISTS `tb_contatos` (
  `id_contato` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Tb_Usuario_Id_Usuario` int(10) unsigned NOT NULL,
  `Tp_Contato_id_tp_contato` int(20) unsigned NOT NULL,
  `Tb_Endereco_id_endereco` int(10) unsigned NOT NULL,
  `is_ativo` tinyint(1) DEFAULT NULL,
  `dt_cadastro` varchar(20) DEFAULT NULL,
  `Nome` varchar(100) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Telefone_Fixo` varchar(20) DEFAULT NULL,
  `Telefone_Celular` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_contato`),
  KEY `Tb_Contatos_FKIndex2` (`Tb_Endereco_id_endereco`),
  KEY `Tb_Contatos_FKIndex3` (`Tp_Contato_id_tp_contato`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `tb_contatos`
--

INSERT INTO `tb_contatos` (`id_contato`, `Tb_Usuario_Id_Usuario`, `Tp_Contato_id_tp_contato`, `Tb_Endereco_id_endereco`, `is_ativo`, `dt_cadastro`, `Nome`, `Email`, `Telefone_Fixo`, `Telefone_Celular`) VALUES
(1, 16, 1, 4, 0, '2012-06-14', 'Paulo Ferreira', 'mrpauloii@gmail.com', '(61)9958-6419', '(61)9958-6419'),
(2, 15, 1, 4, 0, '2012-06-14', 'Wagtom', 'naotem', '(66)6666-6666', '(66)6666-6666');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_endereco`
--

CREATE TABLE IF NOT EXISTS `tb_endereco` (
  `id_endereco` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cep` varchar(20) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `cidade` varchar(40) DEFAULT NULL,
  `estado` varchar(40) DEFAULT NULL,
  `pais` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `tb_endereco`
--

INSERT INTO `tb_endereco` (`id_endereco`, `cep`, `endereco`, `cidade`, `estado`, `pais`) VALUES
(4, '72000-000', 'QNL 03 Bloco b Apt 315', 'Taguatinga', 'DF', 'Brasil'),
(5, '72222-222', 'Setor O', 'Ceilandia', 'DF', 'Brasil');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_login`
--

CREATE TABLE IF NOT EXISTS `tb_login` (
  `Id_login` int(11) NOT NULL AUTO_INCREMENT,
  `Tb_Usuario_Id_Usuario` int(10) unsigned NOT NULL,
  `login` varchar(20) NOT NULL,
  `Tb_Perfil_id_perfil` int(20) unsigned NOT NULL,
  `senha` varchar(20) NOT NULL,
  `dt_cadastro` date NOT NULL,
  PRIMARY KEY (`Id_login`),
  KEY `Tb_Login_FKIndex1` (`Tb_Perfil_id_perfil`),
  KEY `Tb_Login_FKIndex2` (`Tb_Usuario_Id_Usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `tb_login`
--

INSERT INTO `tb_login` (`Id_login`, `Tb_Usuario_Id_Usuario`, `login`, `Tb_Perfil_id_perfil`, `senha`, `dt_cadastro`) VALUES
(1, 1, 'paulo', 1, 'paulo', '2012-06-14'),
(2, 15, '11', 1, '11', '2012-06-14');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_perfil`
--

CREATE TABLE IF NOT EXISTS `tb_perfil` (
  `id_perfil` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `perfil` varchar(50) NOT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `tb_perfil`
--

INSERT INTO `tb_perfil` (`id_perfil`, `perfil`, `descricao`) VALUES
(1, 'Administrador', NULL),
(2, 'Outros', NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tb_usuario`
--

CREATE TABLE IF NOT EXISTS `tb_usuario` (
  `Id_Usuario` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cpf` varchar(15) NOT NULL,
  `Tb_Endereco_id_endereco` int(10) unsigned NOT NULL,
  `nome` varchar(60) NOT NULL,
  `telefone` int(10) unsigned NOT NULL,
  `rg` int(10) unsigned NOT NULL,
  `estado_civil` varchar(20) NOT NULL,
  `is_ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`Id_Usuario`),
  UNIQUE KEY `Unico_CPF` (`cpf`),
  KEY `Tb_Usuario_FKIndex2` (`Tb_Endereco_id_endereco`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Extraindo dados da tabela `tb_usuario`
--

INSERT INTO `tb_usuario` (`Id_Usuario`, `cpf`, `Tb_Endereco_id_endereco`, `nome`, `telefone`, `rg`, `estado_civil`, `is_ativo`) VALUES
(13, '02904685154', 1, 'Luís Filipe Gomes de Carvalho', 34347675, 1321444, 'Solteiro(a)', 0),
(15, '000.000.000-00', 4, 'Paulo', 11111111, 2222222, 'Separado(a)', 0),
(16, '722.222.222-22', 5, 'Jessia Maria', 33644444, 2222222, 'Solteiro(a)', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tp_contato`
--

CREATE TABLE IF NOT EXISTS `tp_contato` (
  `id_tp_contato` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `tp_contato` varchar(200) DEFAULT NULL,
  `descricao` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_tp_contato`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `tp_contato`
--

INSERT INTO `tp_contato` (`id_tp_contato`, `tp_contato`, `descricao`) VALUES
(1, 'Amigos', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
