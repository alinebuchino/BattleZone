-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 12-Abr-2021 às 00:26
-- Versão do servidor: 10.4.16-MariaDB
-- versão do PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `battlezone`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `codigo_pro` varchar(11) NOT NULL,
  `tipo_pro` varchar(100) NOT NULL,
  `nome_pro` varchar(100) NOT NULL,
  `valor_pro` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`codigo_pro`, `tipo_pro`, `nome_pro`, `valor_pro`) VALUES
('PRO0001', 'INFORMATICA', 'XBOX', '1500.00'),
('PRO0002', 'PAPELARIA', 'CADERNO', '30.00'),
('PRO0003', 'ELETRONICA', 'ARDUINO', '280.00'),
('PRO0004', 'ASSISTENCIA', 'FORMATACAO PC ', '80.00'),
('PRO0005', 'ESCRITORIO', 'CONSULTORIA FINANCEIRA', '125.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `codigo_us` varchar(15) NOT NULL,
  `nome_us` varchar(100) NOT NULL,
  `sexo_us` varchar(20) NOT NULL,
  `tipo_us` varchar(30) NOT NULL,
  `senha` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`codigo_us`, `nome_us`, `sexo_us`, `tipo_us`, `senha`) VALUES
('USU0001', 'ALINE', 'FEMININO', 'ADMINISTRADOR', '123'),
('USU0002', 'PANDA', 'MASCULINO', 'FUNCIONARIO', '1234');

-- --------------------------------------------------------

--
-- Estrutura da tabela `venda`
--

CREATE TABLE `venda` (
  `numero_ven` varchar(30) NOT NULL,
  `total_ven` decimal(10,2) NOT NULL,
  `data_ven` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `venda`
--

INSERT INTO `venda` (`numero_ven`, `total_ven`, `data_ven`) VALUES
('00000001', '60.00', '11/02/2021'),
('00000002', '3000.00', '10/02/2021'),
('00000003', '90.00', '10/02/2021'),
('00000004', '5060.00', '11/02/2021'),
('00000005', '2210.00', '12/02/2021'),
('00000007', '1560.00', '12/02/2021'),
('00000008', '285.00', '17/03/2021');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`codigo_pro`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigo_us`);

--
-- Índices para tabela `venda`
--
ALTER TABLE `venda`
  ADD PRIMARY KEY (`numero_ven`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
