package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Giro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGiroDao extends JpaRepository<Giro, Long> {
}
