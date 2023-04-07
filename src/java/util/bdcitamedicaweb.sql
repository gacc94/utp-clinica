-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-04-2023 a las 23:09:21
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdcitamedicaweb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consultorio`
--

CREATE TABLE `consultorio` (
  `ID_CONSULTORIO` varchar(50) NOT NULL,
  `NOMBRE_CONSULTORIO` varchar(50) NOT NULL,
  `ESTADO` varchar(50) NOT NULL,
  `id_medico` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `consultorio`
--

INSERT INTO `consultorio` (`ID_CONSULTORIO`, `NOMBRE_CONSULTORIO`, `ESTADO`, `id_medico`) VALUES
('C01', '101', 'Activo', 'm01'),
('C02', '102', 'Disponible', 'm02'),
('C03', '103', 'Disponible', 'm03'),
('C04', '104', 'Disponible', 'm04'),
('C05', '105', 'Disponible', 'm05'),
('C06', '106', 'Disponible', 'm06'),
('C07', '107', 'Disponible', 'm07'),
('C08', '108', 'Disponible', 'm08'),
('C09', '109', 'Disponible', 'm09'),
('C10', '110', 'Disponible', 'm10'),
('C11', '201', 'Disponible', 'm11'),
('C12', '202', 'Disponible', 'm12'),
('C13', '203', 'Disponible', 'm13'),
('C14', '204', 'Disponible', 'm14'),
('C15', '205', 'Disponible', 'm15'),
('C16', '206', 'Disponible', 'm16'),
('C17', '207', 'Disponible', 'm17'),
('C18', '208', 'Disponible', 'm18'),
('C19', '209', 'Disponible', 'm19'),
('C20', '210', 'Disponible', 'm20'),
('C21', '211', 'Disponible', 'm21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `id_especialidad` varchar(100) NOT NULL,
  `id_medico` varchar(50) DEFAULT NULL,
  `nombre_especialidad` varchar(50) DEFAULT NULL,
  `precio` decimal(11,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`id_especialidad`, `id_medico`, `nombre_especialidad`, `precio`) VALUES
('Esp01', 'm01', 'Cardiologia', '50.00'),
('Esp02', 'm02', 'CIRUGIA GENERAL', '40.00'),
('Esp03', 'm03', 'CIRUGIA TORAX Y CARDIOVASCULAR', '50.00'),
('Esp04', 'm04', 'CRED', '40.00'),
('Esp05', 'm05', 'DERMATOLOGIA', '50.00'),
('Esp06', 'm06', 'ENDOCRINOLOGIA', '40.00'),
('Esp07', 'm07', 'GASTROENTEROLOGIA', '50.00'),
('Esp08', 'm08', 'GERIATRIA', '40.00'),
('Esp09', 'm09', 'GINECOLOGIA', '50.00'),
('Esp10', 'm10', 'MEDICINA INTERNA', '40.00'),
('Esp11', 'm11', 'NEUMOLOGIA', '50.00'),
('Esp12', 'm12', 'NEUROLOGIA', '40.00'),
('Esp13', 'm13', 'NUTRICION', '50.00'),
('Esp14', 'm14', 'OFTALMOLOGIA', '40.00'),
('Esp15', 'm15', 'OTORRINOLARINGOLOGIA', '50.00'),
('Esp16', 'm16', 'PEDIATRIA', '40.00'),
('Esp17', 'm17', 'PSIQUIATRIA', '50.00'),
('Esp18', 'm18', 'REUMATOLOGIA', '40.00'),
('Esp19', 'm19', 'TERAPIA FISICA Y REHABILITACION', '50.00'),
('Esp20', 'm20', 'TRAUMATOLOGIA', '40.00'),
('Esp21', 'm21', 'UROLOGIA', '50.00'),
('Esp22', 'm01', 'CIRUGIA GENERAL', '50.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `id_medico` varchar(55) NOT NULL,
  `nombres_medico` varchar(255) DEFAULT NULL,
  `apellido_paterno_medico` varchar(255) DEFAULT NULL,
  `apellido_materno_medico` varchar(255) DEFAULT NULL,
  `idusuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`id_medico`, `nombres_medico`, `apellido_paterno_medico`, `apellido_materno_medico`, `idusuario`) VALUES
('m01', 'Naomi', 'Garmendia', 'Figueras', NULL),
('m02', 'Aroa Andres', 'Peláez', 'Huertas', NULL),
('m03', 'Amancio Alfonso', 'Río', 'Vallés', NULL),
('m04', 'Fulgencio Damon', 'Roldán', 'Perez', NULL),
('m05', 'Roque', 'Coronado', 'Palomar', NULL),
('m06', 'Román', 'Arco', 'Alvarado', NULL),
('m07', 'Cristian Ignacio', 'Rubio', 'Marquez', NULL),
('m08', 'Marcelino', 'Ferran', 'Torrijos', NULL),
('m09', 'Octavio Randall', 'Cozar', 'Cuadrado', NULL),
('m10', 'Jeremias Ernesto', 'Concha', 'Crespi', NULL),
('m11', 'Aureliano', 'Amo', 'Almagro', NULL),
('m12', 'Josefa Laura', 'Camara', 'Badia', NULL),
('m13', 'Julio Cesar', 'Salinas', 'Cinfuentes', NULL),
('m14', 'Maria Fernanda', 'Marin', 'Rueda', NULL),
('m15', 'Efrain', 'Barba', 'Sola', NULL),
('m16', 'Susana Pili', 'Cepeda', 'Collado', NULL),
('m17', 'Ruperta Constanza', 'Marin', 'Valdes', NULL),
('m18', 'Guadalupe Joan', 'Arribas', 'Enriquez', NULL),
('m19', 'Fabiana Isabela', 'Ortuño', 'Tejera', NULL),
('m20', 'Pancho Erasmo', 'Velasco', 'Anaya', NULL),
('m21', 'Jose Carlos', 'Noguera', 'Buendia', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id_paciente` varchar(100) NOT NULL,
  `dni` varchar(50) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `ape_paterno` varchar(255) DEFAULT NULL,
  `ape_materno` varchar(50) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `fec_naci` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `enfermedad` varchar(255) DEFAULT NULL,
  `medicamentos` varchar(255) DEFAULT NULL,
  `alergia` varchar(255) DEFAULT NULL,
  `fec_creacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`id_paciente`, `dni`, `nombre`, `ape_paterno`, `ape_materno`, `genero`, `fec_naci`, `email`, `direccion`, `telefono`, `imagen`, `enfermedad`, `medicamentos`, `alergia`, `fec_creacion`) VALUES
('CODPA23232323', '23232323', 'Valeria', 'Calsina', NULL, NULL, NULL, 'vcalsina@gmail.com', NULL, '987654320', NULL, NULL, NULL, NULL, '2022-12-01'),
('CODPA70030602', '70030602', 'Jonathan', 'Paniagua', NULL, NULL, NULL, 'jpani@gmail.com', NULL, '983514699', NULL, NULL, NULL, NULL, '2022-11-25'),
('CODPA70030605', '70030605', 'Luis', 'Fonsi', NULL, NULL, NULL, 'lfonsi@gmail.com', NULL, '987567456', NULL, NULL, NULL, NULL, '2022-12-15'),
('CODPA70030608', '70030608', 'Mario', 'Bros', NULL, NULL, NULL, 'mbros@gmail.com', NULL, '978678567', NULL, NULL, NULL, NULL, '2022-11-27'),
('CODPA77665544', '77665544', 'Diana', 'Pino', NULL, NULL, NULL, 'dpinosouquon@gmail.com', NULL, '876567896', NULL, NULL, NULL, NULL, '2022-11-25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `ID_PAGO` varchar(50) NOT NULL,
  `ESTADO` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pago`
--

INSERT INTO `pago` (`ID_PAGO`, `ESTADO`) VALUES
('1', 'Pendiente'),
('2', 'Pagado'),
('3', 'Cancelado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservacion`
--

CREATE TABLE `reservacion` (
  `ID_RESERVACION` int(11) NOT NULL,
  `TITULO` varchar(200) DEFAULT NULL,
  `NOTA` varchar(200) DEFAULT NULL,
  `MENSAJE` varchar(200) DEFAULT NULL,
  `FECHA_CITA` varchar(100) DEFAULT NULL,
  `HORA_CITA` varchar(100) DEFAULT NULL,
  `ID_ESPECIALIDAD` varchar(50) DEFAULT NULL,
  `SINTOMAS` varchar(200) DEFAULT NULL,
  `ENFERMEDAD` varchar(200) DEFAULT NULL,
  `IDUSUARIO` int(11) DEFAULT NULL,
  `PRECIO` decimal(11,2) DEFAULT NULL,
  `ID_PAGO` varchar(50) DEFAULT NULL,
  `ESTADO` varchar(50) DEFAULT NULL,
  `FECHA_RESERVA` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reservacion`
--

INSERT INTO `reservacion` (`ID_RESERVACION`, `TITULO`, `NOTA`, `MENSAJE`, `FECHA_CITA`, `HORA_CITA`, `ID_ESPECIALIDAD`, `SINTOMAS`, `ENFERMEDAD`, `IDUSUARIO`, `PRECIO`, `ID_PAGO`, `ESTADO`, `FECHA_RESERVA`) VALUES
(1, NULL, NULL, NULL, '11/11/2022', ' 11:40 am', 'Esp09', NULL, NULL, 14, '50.00', '2', 'Pendiente', '2022-11-25'),
(2, NULL, NULL, NULL, '10/11/2022', ' 10:54 am', 'Esp05', NULL, NULL, 14, '50.00', '2', 'Pendiente', '2022-11-26'),
(3, NULL, NULL, NULL, '10/11/2022', ' 09:06 am', 'Esp22', NULL, NULL, 16, '50.00', '2', 'Pendiente', '2022-11-27'),
(4, NULL, NULL, NULL, '11/11/2022', ' 10:42 am', 'Esp09', NULL, NULL, 14, '50.00', '2', 'Pendiente', '2022-12-01'),
(5, NULL, NULL, NULL, '10/11/2022', ' 09:54 am', 'Esp08', NULL, NULL, 17, '40.00', '2', 'Pendiente', '2022-12-01'),
(6, NULL, NULL, NULL, '10/11/2022', ' 09:54 am', 'Esp08', NULL, NULL, 17, '40.00', '2', 'Pendiente', '2022-12-01'),
(7, NULL, NULL, NULL, '19/11/2022', ' 10:42 am', 'Esp16', NULL, NULL, 14, '40.00', '2', 'Pendiente', '2022-12-08'),
(8, NULL, NULL, NULL, '10/11/2022', ' 10:42 am', 'Esp22', NULL, NULL, 18, '50.00', '2', 'Pendiente', '2022-12-15'),
(9, NULL, NULL, NULL, '26/11/2022', ' 12:00 am', 'Esp08', NULL, NULL, 18, '40.00', '2', 'Pendiente', '2022-12-15'),
(10, NULL, NULL, NULL, '25/11/2022', ' 10:18 am', 'Esp05', NULL, NULL, 14, '50.00', '2', 'Pendiente', '2023-04-01'),
(11, NULL, NULL, NULL, '19/11/2022', ' 11:50 am', 'Esp22', NULL, NULL, 14, '50.00', '2', 'Pendiente', '2023-04-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `IDROL` int(11) NOT NULL,
  `NOMBREROL` varchar(50) DEFAULT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`IDROL`, `NOMBREROL`, `DESCRIPCION`) VALUES
(1, 'Doctor', 'Medico especialista'),
(2, 'Paciente', 'Paciente'),
(3, 'Administrador', 'Ingeniero de Sistemas'),
(4, 'Enfermera', 'Asistente de médico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `IDUSUARIO` int(11) NOT NULL,
  `IDROL` int(11) DEFAULT NULL,
  `ID_PACIENTE` varchar(100) DEFAULT NULL,
  `NOMBRE` varchar(100) DEFAULT NULL,
  `APELLIDO` varchar(100) DEFAULT NULL,
  `TIPO_DOCUMENTO` varchar(20) DEFAULT NULL,
  `NUM_DOCUMENTO` varchar(30) DEFAULT NULL,
  `TELEFONO` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(50) DEFAULT NULL,
  `CONTRASENA` blob DEFAULT NULL,
  `FECHA_CREACION` date DEFAULT NULL,
  `ESTADO` varchar(20) DEFAULT NULL,
  `DIRECCION` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`IDUSUARIO`, `IDROL`, `ID_PACIENTE`, `NOMBRE`, `APELLIDO`, `TIPO_DOCUMENTO`, `NUM_DOCUMENTO`, `TELEFONO`, `EMAIL`, `CONTRASENA`, `FECHA_CREACION`, `ESTADO`, `DIRECCION`) VALUES
(14, 2, 'CODPA70030602', 'Jonathan', 'Paniagua', 'dni', '70030602', '983514699', 'jpaniagua@gmail.com', 0xd5133ff5afb948719ae0cf4e35d6c26c, '2022-11-25', 'Activo', NULL),
(15, 1, 'CODPA77665544', 'Diana', 'Pino', 'Dni', '77665544', '876567896', 'dpinosouquon@gmail.com', 0x30c61111894a2d1fc9a46694af7b0e2c, '2022-11-25', 'Activo', NULL),
(16, 2, 'CODPA70030608', 'Mario', 'Bros', 'Dni', '70030608', '978678567', 'mbros@gmail.com', 0xf6d65020d0a9e3a10b96754c8f984cf8, '2022-11-27', 'Activo', NULL),
(17, 2, 'CODPA23232323', 'Valeria', 'Calsina', 'Dni', '23232323', '987654320', 'vcalsina@gmail.com', 0x9bcde70bf8cdc4135573799dd0570f9a, '2022-12-01', 'Activo', NULL),
(18, 2, 'CODPA70030605', 'Luis', 'Fonsi', 'Dni', '70030605', '987567456', 'lfonsi@gmail.com', 0x5ccb7dc97375ef996c521bcfb59acf1f, '2022-12-15', 'Activo', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `consultorio`
--
ALTER TABLE `consultorio`
  ADD PRIMARY KEY (`ID_CONSULTORIO`),
  ADD KEY `FK_CONSULTORIO_MEDICO` (`id_medico`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`id_especialidad`),
  ADD KEY `FK_ESPECIALIDAD_MEDICO` (`id_medico`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id_medico`),
  ADD KEY `FK_MEDICO_USUARIO` (`idusuario`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id_paciente`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`ID_PAGO`);

--
-- Indices de la tabla `reservacion`
--
ALTER TABLE `reservacion`
  ADD PRIMARY KEY (`ID_RESERVACION`),
  ADD KEY `FK_RESERVA_ESPECIALIDAD` (`ID_ESPECIALIDAD`),
  ADD KEY `FK_RESERVA_USUARIO` (`IDUSUARIO`),
  ADD KEY `FK_RESERVA_PAGO` (`ID_PAGO`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`IDROL`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`IDUSUARIO`),
  ADD UNIQUE KEY `NUM_DOCUMENTO` (`NUM_DOCUMENTO`),
  ADD UNIQUE KEY `EMAIL` (`EMAIL`),
  ADD KEY `FK_USURIO_PACIENTE` (`ID_PACIENTE`),
  ADD KEY `fk_usuario_rol` (`IDROL`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reservacion`
--
ALTER TABLE `reservacion`
  MODIFY `ID_RESERVACION` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `IDROL` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `IDUSUARIO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `consultorio`
--
ALTER TABLE `consultorio`
  ADD CONSTRAINT `FK_CONSULTORIO_MEDICO` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`);

--
-- Filtros para la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD CONSTRAINT `FK_ESPECIALIDAD_MEDICO` FOREIGN KEY (`id_medico`) REFERENCES `medico` (`id_medico`);

--
-- Filtros para la tabla `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `FK_MEDICO_USUARIO` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`IDUSUARIO`);

--
-- Filtros para la tabla `reservacion`
--
ALTER TABLE `reservacion`
  ADD CONSTRAINT `FK_RESERVA_ESPECIALIDAD` FOREIGN KEY (`ID_ESPECIALIDAD`) REFERENCES `especialidad` (`id_especialidad`),
  ADD CONSTRAINT `FK_RESERVA_PAGO` FOREIGN KEY (`ID_PAGO`) REFERENCES `pago` (`ID_PAGO`),
  ADD CONSTRAINT `FK_RESERVA_USUARIO` FOREIGN KEY (`IDUSUARIO`) REFERENCES `usuario` (`IDUSUARIO`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_USURIO_PACIENTE` FOREIGN KEY (`ID_PACIENTE`) REFERENCES `paciente` (`id_paciente`),
  ADD CONSTRAINT `fk_usuario_rol` FOREIGN KEY (`IDROL`) REFERENCES `rol` (`IDROL`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
