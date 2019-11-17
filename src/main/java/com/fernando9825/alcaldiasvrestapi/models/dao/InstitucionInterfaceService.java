package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Institucion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitucionInterfaceService extends JpaRepository<Institucion, Short> {
}
