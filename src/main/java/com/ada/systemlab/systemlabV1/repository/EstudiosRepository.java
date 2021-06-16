package com.ada.systemlab.systemlabV1.repository;

import com.ada.systemlab.systemlabV1.model.Estudios;
import com.ada.systemlab.systemlabV1.model.Paciente;
import com.ada.systemlab.systemlabV1.model.Protocolo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;

public interface EstudiosRepository extends CrudRepository <Estudios, Integer> {

    @Query (value = "select e.* from Protocolo as p,estudios as e where" +
            " p.id_estudios = e.id_estudio and p.fecha_ingreso = :fecha_ingreso and e.nombre like %:nombre%", nativeQuery = true)
    Collection<Estudios> getEstudioporFechaIngreso (@Param("nombre") String nombre, @Param("fecha_ingreso") String fecha_ingreso);


}
    //@Query ("from Paciente where obra_social like %:obra_social%")
    //Collection<Paciente> getPacienteObraSocialLike (@Param("obra_social") String obra_social);