package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Puesto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPuestoDao extends JpaRepository<Puesto, Long> {
}
