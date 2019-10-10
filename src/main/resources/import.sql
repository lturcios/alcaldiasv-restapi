 INSERT INTO `contribuyente` (contrib_id, dui, nit, apellidos, codigo_cta, departamento, direccion, fecha_creacion, institucion_id, municipio_id, nombres, telefono_principal, telefono_secundario) VALUES (null, '12345678-9', null, 'Turcios', 123, 'San Miguel', 'En algun lugar de San Miguel', null, '1', '100', 'Luis', '75491235', null);
INSERT INTO `contribuyente` (dui, direccion, departamento, largo_local, ancho_local, nombre, impuesto) VALUES ('87654321-0', 'En algun lugar de SM', 'San Miguel', 14.5, 30.0, 'Luis Turcios', 4.0);
#INSERT INTO contribuyente (contrib_id, dui, nit, apellidos, codigo_cta, departamento, direccion, fecha_creacion, institucion_id, municipio_id, nombres, telefono_principal, telefono_secundario) VALUES ()
# usuarios del sistema
INSERT INTO user (username, email, password) VALUES ('admin', 'admin@admin', '1234');
INSERT INTO user (username, email, password) VALUES ('luis', 'luis@luis', '12345');