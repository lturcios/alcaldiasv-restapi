INSERT INTO instituciones (nombre, estado, telefono, direccion) VALUES
('Alcaldía Municipal de San Miguel', 'Activo', '2661-0515', '2A Avenida Norte, San Miguel'),
('Alcaldía Municipal de Cojutepeque', 'Activo', '2379-3900', '6A Avenida Sur, Cojutepeque'),
('Alcaldía Municipal de Zaragoza', 'Activo', '2349-0900', '2A Calle Poniente y Avenida España Sur, Zaragoza');


INSERT INTO usuarios (email, nombre, password, institucion_id_fk) VALUES
('admin@sanmiguel.com', 'administrador de San Miguel', '123456', 1),
('admin@cojutepeque.com', 'administrador de Cojutepeque', '123456', 2),
('admin@zaragoza.com', 'administrador de Zaragoza', '123456', 3);

INSERT INTO municipios (id, municipio_departamento) VALUES
(101, 'San Salvador, San Salvador'),
(102, 'Ciudad Delgado, San Salvador'),
(103, 'Mejicanos, San Salvador'),
(104, 'Soyapango, San Salvador'),
(105, 'Cuscatancingo, San Salvador'),
(106, 'San Marcos, San Salvador'),
(107, 'Ilopango, San Salvador'),
(108, 'Nejapa, San Salvador'),
(109, 'Apopa, San Salvador'),
(110, 'San Martin, San Salvador'),
(111, 'Panchimalco, San Salvador'),
(112, 'Aguilares, San Salvador'),
(113, 'Tonacatepeque, San Salvador'),
(114, 'Santo Tomas, San Salvador'),
(115, 'Santiago Texacuangos, San Salvador'),
(116, 'El Paisnal, San Salvador'),
(117, 'Guazapa, San Salvador'),
(118, 'Ayutuxtepeque, San Salvador'),
(119, 'Rosario De Mora, San Salvador'),
(201, 'Santa Ana, Santa Ana '),
(202, 'Chalchuapa, Santa Ana '),
(203, 'Metapan, Santa Ana '),
(204, 'Coatepeque, Santa Ana '),
(205, 'El Congo, Santa Ana '),
(206, 'Texistepeque, Santa Ana '),
(207, 'Candelaria De La Frontera, Santa Ana '),
(208, 'San Sebastian Salitrillo, Santa Ana '),
(209, 'Santa Rosa Guachipilin, Santa Ana '),
(210, 'Santiago De La Frontera, Santa Ana '),
(211, 'El Porvenir, Santa Ana '),
(212, 'Masahuat, Santa Ana '),
(213, 'San Antonio Pajonal, Santa Ana '),
(301, 'San Miguel, San Miguel'),
(302, 'Chinameca, San Miguel'),
(303, 'El Transito, San Miguel'),
(304, 'Ciudad Barrios, San Miguel'),
(305, 'Chirilagua, San Miguel'),
(306, 'Sesori, San Miguel'),
(307, 'San Rafael Oriente, San Miguel'),
(308, 'Moncagua, San Miguel'),
(309, 'Lolotique, San Miguel'),
(310, 'San Jorge, San Miguel'),
(311, 'Chapeltique, San Miguel'),
(312, 'San Gerardo, San Miguel'),
(313, 'Carolina, San Miguel'),
(314, 'Quelepa, San Miguel'),
(315, 'San Luis De La Reina, San Miguel'),
(316, 'Nuevo Eden De San Juan, San Miguel'),
(317, 'Nueva Guadalupe, San Miguel'),
(318, 'Uluazapa, San Miguel'),
(319, 'Comacaran, San Miguel'),
(320, 'San Antonio Del Mosco, San Miguel'),
(401, 'Santa Tecla, La Libertad'),
(402, 'Quezaltepeque, La Libertad'),
(403, 'Ciudad Arce, La Libertad'),
(404, 'San Juan Opico, La Libertad'),
(405, 'Colon, La Libertad'),
(406, 'La Libertad, La Libertad'),
(407, 'Antiguo Cuscatlan, La Libertad'),
(408, 'Comasagua, La Libertad'),
(409, 'San Pablo Tacachico, La Libertad'),
(410, 'Jayaque, La Libertad'),
(411, 'Huizucar, La Libertad'),
(412, 'Tepecoyo, La Libertad'),
(413, 'Teotepeque, La Libertad'),
(414, 'Chiltiupan, La Libertad'),
(415, 'Nuevo Cuscatlan, La Libertad'),
(416, 'Tamanique, La Libertad'),
(417, 'Sacacoyo, La Libertad'),
(418, 'San Jose Villanueva, La Libertad'),
(419, 'Zaragoza, La Libertad'),
(420, 'Talnique, La Libertad'),
(421, 'San Matias, La Libertad'),
(422, 'Jicalapa, La Libertad'),
(501, 'Usulutan, Usulutan'),
(502, 'Jiquilisco, Usulutan'),
(503, 'Berlin, Usulutan'),
(504, 'Santiago De Maria, Usulutan'),
(505, 'Jucuapa, Usulutan'),
(506, 'Santa Elena, Usulutan'),
(507, 'Jucuaran, Usulutan'),
(508, 'San Agustin, Usulutan'),
(509, 'Ozatlan, Usulutan'),
(510, 'Estanzuelas, Usulutan'),
(511, 'Mercedes Umaña, Usulutan'),
(512, 'Alegria, Usulutan'),
(513, 'Concepcion Batres, Usulutan'),
(514, 'San Francisco Javier, Usulutan'),
(515, 'Puerto El Triunfo, Usulutan'),
(516, 'Tecapan, Usulutan'),
(517, 'San Dionisio, Usulutan'),
(518, 'Ereguayquin, Usulutan'),
(519, 'Santa Maria, Usulutan'),
(520, 'Nueva Granada, Usulutan'),
(521, 'El Triunfo, Usulutan'),
(522, 'San Buenaventura, Usulutan'),
(523, 'California, Usulutan'),
(601, 'Sonsonate, Sonsonate'),
(602, 'Izalco, Sonsonate'),
(603, 'Acajutla, Sonsonate'),
(604, 'Armenia, Sonsonate'),
(605, 'Nahuizalco, Sonsonate'),
(606, 'Juayua, Sonsonate'),
(607, 'San Julian, Sonsonate'),
(608, 'Sonzacate, Sonsonate'),
(609, 'San Antonio Del Monte, Sonsonate'),
(610, 'Nahuilingo, Sonsonate'),
(611, 'Cuisnahuat, Sonsonate'),
(612, 'Santa Catarina Masahuat, Sonsonate'),
(613, 'Caluco, Sonsonate'),
(614, 'Santa Isabel Ishuatan, Sonsonate'),
(615, 'Salcoatitan, Sonsonate'),
(616, 'Santo Domingo De Guzman, Sonsonate'),
(701, 'La Union, La Union'),
(702, 'Santa Rosa De Lima, La Union'),
(703, 'Pasaquina, La Union'),
(704, 'San Alejo, La Union'),
(705, 'Anamoros, La Union'),
(706, 'El Carmen, La Union'),
(707, 'Conchagua, La Union'),
(708, 'El Sauce, La Union'),
(709, 'Lislique, La Union'),
(710, 'Yucuaiquin, La Union'),
(711, 'Nueva Esparta, La Union'),
(712, 'Poloros, La Union'),
(713, 'Bolivar, La Union'),
(714, 'Concepcion De Oriente, La Union'),
(715, 'Intipuca, La Union'),
(716, 'San Jose Las Fuentes, La Union'),
(717, 'Yayantique, La Union'),
(718, 'Meanguera Del Golfo, La Union'),
(801, 'Zacatecoluca, La Paz'),
(802, 'Santiago Nonualco, La Paz'),
(803, 'San Juan Nonualco, La Paz'),
(804, 'San Pedro Masahuat, La Paz'),
(805, 'Olocuilta, La Paz'),
(806, 'San Pedro Nonualco, La Paz'),
(807, 'San Francisco Chinameca, La Paz'),
(808, 'San Juan Talpa, La Paz'),
(809, 'El Rosario, La Paz'),
(810, 'San Rafael Obrajuelo, La Paz'),
(811, 'Santa Maria Ostuma, La Paz'),
(812, 'San Luis Talpa, La Paz'),
(813, 'San Antonio Masahuat, La Paz'),
(814, 'San Miguel Tepezontes, La Paz'),
(815, 'San Juan Tepezontes, La Paz'),
(816, 'Tapalhuaca, La Paz'),
(817, 'Cuyultitan, La Paz'),
(818, 'Paraiso De Osorio, La Paz'),
(819, 'San Emigdio, La Paz'),
(820, 'Jerusalen, La Paz'),
(821, 'Mercedes La Ceiba, La Paz'),
(822, 'San Luis La Herradura, La Paz'),
(901, 'Chalatenango, Chalatenango'),
(902, 'Nueva Concepcion, Chalatenango'),
(903, 'La Palma, Chalatenango'),
(904, 'Tejutla, Chalatenango'),
(905, 'La Reina, Chalatenango'),
(906, 'Arcatao, Chalatenango'),
(907, 'San Ignacio, Chalatenango'),
(908, 'Dulce Nombre De Maria, Chalatenango'),
(909, 'Citala, Chalatenango'),
(910, 'Agua Caliente, Chalatenango'),
(911, 'Concepcion Quezaltepeque, Chalatenango'),
(912, 'Nueva Trinidad, Chalatenango'),
(913, 'Las Vueltas, Chalatenango'),
(914, 'Comalapa, Chalatenango'),
(915, 'San Rafael, Chalatenango'),
(916, 'Las Flores, Chalatenango'),
(917, 'Ojos De Agua, Chalatenango'),
(918, 'Nombre De Jesus, Chalatenango'),
(919, 'Potonico, Chalatenango'),
(920, 'San Francisco Morazan, Chalatenango'),
(921, 'Santa Rita, Chalatenango'),
(922, 'La Laguna, Chalatenango'),
(923, 'San Isidro Labrador, Chalatenango'),
(924, 'San Antonio De La Cruz, Chalatenango'),
(925, 'El Paraiso, Chalatenango'),
(926, 'San Miguel De Mercedes, Chalatenango'),
(927, 'San Luis Del Carmen, Chalatenango'),
(928, 'San Jose Cancasque, Chalatenango'),
(929, 'San Antonio Los Ranchos, Chalatenango'),
(930, 'El Carrizal, Chalatenango'),
(931, 'San Fernando, Chalatenango'),
(932, 'Azacualpa, Chalatenango'),
(933, 'San Francisco Lempa, Chalatenango'),
(1001, 'Cojutepeque, Cuscatlan'),
(1002, 'Suchitoto, Cuscatlan'),
(1003, 'San Pedro Perulapan, Cuscatlan'),
(1004, 'San Jose Guayabal, Cuscatlan'),
(1005, 'Tenancingo, Cuscatlan'),
(1006, 'San Rafael Cedros, Cuscatlan'),
(1007, 'Candelaria, Cuscatlan'),
(1008, 'El Carmen, Cuscatlan'),
(1009, 'Monte San Juan, Cuscatlan'),
(1010, 'San Cristobal, Cuscatlan'),
(1011, 'Santa Cruz Michapa, Cuscatlan'),
(1012, 'San Bartolome Perulapia, Cuscatlan'),
(1013, 'San Ramon, Cuscatlan'),
(1014, 'El Rosario, Cuscatlan'),
(1015, 'Oratorio De Concepcion, Cuscatlan'),
(1016, 'Santa Cruz Analquito, Cuscatlan'),
(1101, 'Ahuachapan, Ahuachapan'),
(1102, 'Atiquizaya, Ahuachapan'),
(1103, 'San Francisco Menendez, Ahuachapan'),
(1104, 'Tacuba, Ahuachapan'),
(1105, 'Concepcion De Ataco, Ahuachapan'),
(1106, 'Jujutla, Ahuachapan'),
(1107, 'Guaymango, Ahuachapan'),
(1108, 'Apaneca, Ahuachapan'),
(1109, 'San Pedro Puxtla, Ahuachapan'),
(1110, 'San Lorenzo, Ahuachapan'),
(1111, 'Turin, Ahuachapan'),
(1112, 'El Refugio, Ahuachapan'),
(1201, 'San Francisco Gotera, Morazan'),
(1202, 'Jocoro, Morazan'),
(1203, 'Corinto, Morazan'),
(1204, 'Sociedad, Morazan'),
(1205, 'Cacaopera, Morazan'),
(1206, 'Guatajiagua, Morazan'),
(1207, 'El Divisadero, Morazan'),
(1208, 'Jocoaitique, Morazan'),
(1209, 'Osicala, Morazan'),
(1210, 'Chilanga, Morazan'),
(1211, 'Meanguera, Morazan'),
(1212, 'Torola, Morazan'),
(1213, 'San Simon, Morazan'),
(1214, 'Delicias De Concepcion, Morazan'),
(1215, 'Joateca, Morazan'),
(1216, 'Arambala, Morazan'),
(1217, 'Lolotiquillo, Morazan'),
(1218, 'Yamabal, Morazan'),
(1219, 'Yoloaiquin, Morazan'),
(1220, 'San Carlos, Morazan'),
(1221, 'El Rosario, Morazan'),
(1222, 'Perquin, Morazan'),
(1223, 'Sensembra, Morazan'),
(1224, 'Gualococti, Morazan'),
(1225, 'San Fernando, Morazan'),
(1226, 'San Isidro, Morazan'),
(1301, 'San Vicente, San Vicente'),
(1302, 'Tecoluca, San Vicente'),
(1303, 'San Sebastian, San Vicente'),
(1304, 'Apastepeque, San Vicente'),
(1305, 'San Esteban Catarina, San Vicente'),
(1306, 'San Ildefonso, San Vicente'),
(1307, 'Santa Clara, San Vicente'),
(1308, 'San Lorenzo, San Vicente'),
(1309, 'Verapaz, San Vicente'),
(1310, 'Guadalupe, San Vicente'),
(1311, 'Santo Domingo, San Vicente'),
(1312, 'San Cayetano Istepeque, San Vicente'),
(1313, 'Tepetitan, San Vicente'),
(1401, 'Sensuntepeque, Cabañas'),
(1402, 'Ilobasco, Cabañas'),
(1403, 'Victoria, Cabañas'),
(1404, 'San Isidro, Cabañas'),
(1405, 'Jutiapa, Cabañas'),
(1406, 'Tejutepeque, Cabañas'),
(1407, 'Dolores, Cabañas'),
(1408, 'Cinquera, Cabañas'),
(1409, 'Guacotecti, Cabañas'),
(1501, 'Residentes En El Exterior, Res. Exterior');


INSERT  INTO tarifas (codigo_presup, precio_unitario, vigencia, descripcion, referencia, institucion_id_fk) VALUES
(12115999, 0.5, '2016/06/01', 'Vendedor Ambulante', null, 1),
(12115999, 0.5, '2016/06/01', 'Vendedor Ambulante', null, 2),
(12115999, 0.5, '2016/06/01', 'Vendedor Ambulante', null, 3);




