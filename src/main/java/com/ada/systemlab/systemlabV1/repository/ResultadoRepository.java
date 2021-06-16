package com.ada.systemlab.systemlabV1.repository;

import com.ada.systemlab.systemlabV1.model.Protocolo;
import com.ada.systemlab.systemlabV1.model.Resultado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ResultadoRepository extends CrudRepository <Resultado, Integer> {


}
