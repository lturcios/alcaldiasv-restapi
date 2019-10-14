# INSTITUCIONES
INSERT INTO instituciones (institucion_id, institucion_direccion, institucion_estado, institucion_nombre, institucion_telefono) VALUES (null, '2A Avenida Norte, San Miguel', 'Activo', 'San Miguel', '2661-0515');

# SECTORES
INSERT INTO sectores (sector_id, institucion_id, sector_nombre) VALUES (null, 1, 'Mercado de Mariscos');
INSERT INTO sectores (sector_id, institucion_id, sector_nombre) VALUES (null, 1, 'Mercado de Verduras');
INSERT INTO sectores (sector_id, institucion_id, sector_nombre) VALUES (null, 1, 'Zapaterias');

# INSERT INTO puestos (puesto_id, puesto_estado, puesto_modulo, contrib_id, sector_sector_id) VALUES (null, 'ARRENDADO', '1-A', '1', '1');

# INSTITUCION_PUESTOS
# INSERT INTO institucion_puestos (institucion_institucion_id, puestos_puesto_id) VALUES (1, 1);
# INSERT INTO institucion_puestos (institucion_institucion_id, puestos_puesto_id) VALUES (1, 2);
# INSERT INTO institucion_puestos (institucion_institucion_id, puestos_puesto_id) VALUES (1, 3);


# USUARIOS DEL SISTEMA
INSERT INTO usuarios (username, email, password, institucion_institucion_id) VALUES ('admin', 'admin@admin', '1234', 1);
INSERT INTO usuarios (username, email, password, institucion_institucion_id) VALUES ('luis', 'luis@luis', '12345', 1);

# MUNICIPIOS
INSERT INTO municipios (municipio_id, municipio_departamento) VALUES (0101, 'San Salvador, San Salvador');
INSERT INTO municipios (municipio_id, municipio_departamento) VALUES (0201, 'Santa Ana, Santa Ana');
INSERT INTO municipios (municipio_id, municipio_departamento) VALUES (0301, 'San Miguel, San Miguel');

# CONTRIBUYENTES
INSERT INTO contribuyentes (contrib_id, codigo_cta, nombres, apellidos, dui, telefono_principal, telefono_secundario, nit, direccion, municipio_id, institucion_id) VALUES (null, 'LT/001', 'Luis', 'Turcios', '02756131-0', '6007-4974', '6152-6344', '1206-280879-111-6', 'Colonia Urbesa, Polígono D, pasaje B #17', 0301, 1);
INSERT INTO contribuyentes (contrib_id, codigo_cta, nombres, apellidos, dui, telefono_principal, telefono_secundario, nit, direccion, municipio_id, institucion_id) VALUES (null, 'FV/002', 'Fernando Roman', 'Ventura Alvarado', '05579685-2', '7530-6697', null, '1206-240799-111-7', 'Barrio San Francisco, 14 C. Pnte.', 0301, 1);

# PUESTOS
INSERT INTO puestos (puesto_id, puesto_estado, puesto_modulo, sector_sector_id, contrib_id, institucion_id) VALUES (null, 'ARRENDADO', '1-A', 1, 1, 1);
INSERT INTO puestos (puesto_id, puesto_estado, puesto_modulo, sector_sector_id, contrib_id, institucion_id) VALUES (null, 'DISPONIBLE', '2-A', 2, 1, 1);
INSERT INTO puestos (puesto_id, puesto_estado, puesto_modulo, sector_sector_id, contrib_id, institucion_id) VALUES (null, 'ARRENDADO', '1-B', 3, null, 1);
INSERT INTO puestos (puesto_id, puesto_estado, puesto_modulo, sector_sector_id, contrib_id, institucion_id) VALUES (null, 'NECESITA REPARACIÓN', '2-B', 3, 2, 1);


# GIROS
INSERT INTO giros (giro_id, giro_nombre) VALUES (null, 'VERDURAS');
INSERT INTO giros (giro_id, giro_nombre) VALUES (null, 'LACTEOS');
INSERT INTO giros (giro_id, giro_nombre) VALUES (null, 'PLASTICOS');
INSERT INTO giros (giro_id, giro_nombre) VALUES (null, 'CRISTALERIA');

# INSTITUCION - GIROS
# INSERT INTO institucion_giros (institucion_institucion_id, giros_giro_id) VALUES (1, 1);
# INSERT INTO institucion_giros (institucion_institucion_id, giros_giro_id) VALUES (1, 2);
# INSERT INTO institucion_giros (institucion_institucion_id, giros_giro_id) VALUES (1, 3);
# INSERT INTO institucion_giros (institucion_institucion_id, giros_giro_id) VALUES (1, 4);

# TARIFAS
INSERT INTO tarifas (tarifa_id, descripcion, precio_unitario, referencia, vigencia) VALUES (null, 'Puesto acera', 0.20, 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Porro eum totam cum laboriosam aut nam veniam ut vero delectus hic nemo assumenda laudantium, omnis praesentium et est architecto. Officia, facilis.', '2010/01/01');
INSERT INTO tarifas (tarifa_id, descripcion, precio_unitario, referencia, vigencia) VALUES (null, 'Puesto calle', 0.22, 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Porro eum totam cum laboriosam aut nam veniam ut vero delectus hic nemo assumenda laudantium, omnis praesentium et est architecto. Officia, facilis.', '2010/01/01');
INSERT INTO tarifas (tarifa_id, descripcion, precio_unitario, referencia, vigencia) VALUES (null, 'Puesto acera', 0.25, 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Porro eum totam cum laboriosam aut nam veniam ut vero delectus hic nemo assumenda laudantium, omnis praesentium et est architecto. Officia, facilis.', '2016/06/01');

# ASIGNACIONES
INSERT INTO asignaciones (asignacion_id, area_calificacion, fecha_egreso, fecha_ingreso, medida_compensa, medida_fondo, medida_frente, observaciones, ultimo_pago, contribuyente_contrib_id, giro_giro_id, institucion_institucion_id, sector_sector_id, tarifa_tarifa_id) VALUES (null, 8.5, null, '2019/01/01', 0.5, 3, 3, 'Lorem ipsum dolor, sit amet consectetur adipisicing elit. Porro eum totam cum laboriosam aut nam veniam ut vero delectus hic nemo assumenda laudantium, omnis praesentium et est architecto. Officia, facilis.', '2019/09/15', 1, 1, 1, 1, 1);