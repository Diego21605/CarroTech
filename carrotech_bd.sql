-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-09-2021 a las 22:27:06
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `carrotech_bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tcliente`
--

CREATE TABLE `tcliente` (
  `nClienteID` int(10) NOT NULL,
  `cPrimerNombre` varchar(20) NOT NULL,
  `cSegundoNombre` varchar(20) DEFAULT NULL,
  `cPrimerApellido` varchar(20) NOT NULL,
  `cSegundoApellido` varchar(20) NOT NULL,
  `nIdentificacion` int(15) NOT NULL,
  `cCorreo` varchar(100) NOT NULL,
  `nTelefono` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tcliente`
--

INSERT INTO `tcliente` (`nClienteID`, `cPrimerNombre`, `cSegundoNombre`, `cPrimerApellido`, `cSegundoApellido`, `nIdentificacion`, `cCorreo`, `nTelefono`) VALUES
(3, 'wqeqweq', 'eqewq', 'eqeqe', 'qewqeq', 4324, 'dadsa', 4234),
(4, 'diego', 'andres', 'fernandez', 'arteaga', 42343, 'diego@gmail.com', 3168797);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tfactura`
--

CREATE TABLE `tfactura` (
  `nFacturaID` int(11) NOT NULL,
  `cModoPago` varchar(20) NOT NULL,
  `nValorPagar` int(10) NOT NULL,
  `nDeposito` int(10) NOT NULL,
  `nCodigo` int(10) NOT NULL,
  `dFecha` date NOT NULL,
  `dFechaEntradaVehiculo` date NOT NULL,
  `dFechaSalidaVehiculo` date NOT NULL,
  `nClienteID` int(11) NOT NULL,
  `nVehiculoID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tusuario`
--

CREATE TABLE `tusuario` (
  `nUsuarioID` int(10) NOT NULL,
  `cPrimerNombre` varchar(20) NOT NULL,
  `cSegundoNombre` varchar(20) DEFAULT NULL,
  `cPrimerApellido` varchar(20) NOT NULL,
  `cSegundoApellido` varchar(20) NOT NULL,
  `nIdentificacion` int(15) NOT NULL,
  `cDireccion` varchar(20) NOT NULL,
  `cCorreo` varchar(20) NOT NULL,
  `cTipoUsuario` varchar(1) NOT NULL,
  `nTelefono` int(10) NOT NULL,
  `cUsuario` text NOT NULL,
  `cPass` char(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tusuario`
--

INSERT INTO `tusuario` (`nUsuarioID`, `cPrimerNombre`, `cSegundoNombre`, `cPrimerApellido`, `cSegundoApellido`, `nIdentificacion`, `cDireccion`, `cCorreo`, `cTipoUsuario`, `nTelefono`, `cUsuario`, `cPass`) VALUES
(5, 'Diego', 'Andres', 'Fernandez', 'Arteaga', 1000729591, 'calle', 'diegofe21605@gmail.c', 'A', 123456, 'diego2', '12345'),
(6, 'Javier', NULL, 'Rebolledo', 'Correa', 12345, 'calle', 'javier@algo.com', 'B', 987456, 'javier', '12345'),
(7, 'John', NULL, 'Chacon', 'Larios', 741258, 'calle', 'john@algo.com', 'C', 852369, 'john', '12345'),
(14, 'Diego', 'Andres', 'Fernandez', 'Arteaga', 123456, 'calle', 'diego@gmail.com', 'A', 456123, 'diego', '12345');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tvehiculo`
--

CREATE TABLE `tvehiculo` (
  `nVehiculoID` int(10) NOT NULL,
  `cMarca` varchar(20) NOT NULL,
  `cModelo` varchar(20) NOT NULL,
  `cColor` text NOT NULL,
  `cPlaca` varchar(10) NOT NULL,
  `cTipoVehiculo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tvehiculo`
--

INSERT INTO `tvehiculo` (`nVehiculoID`, `cMarca`, `cModelo`, `cColor`, `cPlaca`, `cTipoVehiculo`) VALUES
(1, 'Ford', '2022', 'Negro', 'CJB235', 'A'),
(2, 'Ford', '2020', 'Azul', 'DOF287', 'C'),
(3, 'Ford', '2022', 'Rojo', 'CJB236', 'A'),
(4, 'Renault', '2002', 'Negro', 'DIE200', 'C');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tcliente`
--
ALTER TABLE `tcliente`
  ADD PRIMARY KEY (`nClienteID`);

--
-- Indices de la tabla `tfactura`
--
ALTER TABLE `tfactura`
  ADD PRIMARY KEY (`nFacturaID`),
  ADD UNIQUE KEY `nCodigo` (`nCodigo`),
  ADD KEY `nClienteID` (`nClienteID`),
  ADD KEY `nVehiculoID` (`nVehiculoID`);

--
-- Indices de la tabla `tusuario`
--
ALTER TABLE `tusuario`
  ADD PRIMARY KEY (`nUsuarioID`);

--
-- Indices de la tabla `tvehiculo`
--
ALTER TABLE `tvehiculo`
  ADD PRIMARY KEY (`nVehiculoID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tcliente`
--
ALTER TABLE `tcliente`
  MODIFY `nClienteID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tfactura`
--
ALTER TABLE `tfactura`
  MODIFY `nFacturaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tusuario`
--
ALTER TABLE `tusuario`
  MODIFY `nUsuarioID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `tvehiculo`
--
ALTER TABLE `tvehiculo`
  MODIFY `nVehiculoID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tfactura`
--
ALTER TABLE `tfactura`
  ADD CONSTRAINT `tfactura_ibfk_1` FOREIGN KEY (`nClienteID`) REFERENCES `tcliente` (`nClienteID`),
  ADD CONSTRAINT `tfactura_ibfk_2` FOREIGN KEY (`nVehiculoID`) REFERENCES `tvehiculo` (`nVehiculoID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
