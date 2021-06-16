package com.ada.systemlab.systemlabV1.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Protocolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_protocolo;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    private Paciente id_paciente;

    @OneToOne (cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_estudio", referencedColumnName = "id_estudio")
    private Estudios id_estudio;

    private Date fecha_ingreso;
    private Date fecha_de_resultados;

    public int getId_protocolo() {
        return id_protocolo;
    }

    public void setId_protocolo(int id_protocolo) {
        this.id_protocolo = id_protocolo;
    }

    public Paciente getPaciente() {
        return id_paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.id_paciente = paciente;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_de_resultados() {
        return fecha_de_resultados;
    }

    public void setFecha_de_resultados(Date fecha_de_resultados) {
        this.fecha_de_resultados = fecha_de_resultados;
    }
}
