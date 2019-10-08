package com.fernando9825.alcaldiasvrestapi.models.dao;

import com.fernando9825.alcaldiasvrestapi.models.entity.Contribuyente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContribuyenteDao extends JpaRepository<Contribuyente, String> {

}
