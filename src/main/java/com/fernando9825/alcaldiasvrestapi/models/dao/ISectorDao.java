package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISectorDao extends JpaRepository<Sector, Long> {
}
