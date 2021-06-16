package com.ada.systemlab.systemlabV1.repository;

import com.ada.systemlab.systemlabV1.model.Estudios;
import com.ada.systemlab.systemlabV1.model.Paciente;
import com.ada.systemlab.systemlabV1.model.Protocolo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.sql.Date;

public interface ProtocoloRepository extends CrudRepository <Protocolo,Integer> {

    @Query(value = "select * from Protocolo where fecha_de_resultados =:fecha_de_resultados", nativeQuery = true)
    Iterable<Protocolo> getProtocoloPorFechaDeResultados(@Param("fecha_de_resultados") String fecha_de_resultados);

}