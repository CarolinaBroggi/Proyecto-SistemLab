package com.ada.systemlab.systemlabV1.repository;

import com.ada.systemlab.systemlabV1.model.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;

public interface PacienteRepository extends CrudRepository <Paciente, Integer> {

    @Query ("from Paciente where obra_social like %:obra_social%")
    Collection<Paciente> getPacienteObraSocialLike (@Param("obra_social") String obra_social);

    @Query ("from Paciente where nrodocumento = :nrodocumento")
    Collection <Paciente> getPacienteDNILike (@Param("nrodocumento") Integer nrodocumento);

    }

