package com.ada.systemlab.systemlabV1.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estudio;

    private String nombre;
    private String tipo_muestra;
    private String equipo_laboratorio;
    private int precio_estudio;

    public int getId_estudio() {
        return id_estudio;
    }

    public void setId_estudio(int id_estudio) {
        this.id_estudio = id_estudio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_muestra() {
        return tipo_muestra;
    }

    public void setTipo_muestra(String tipo_muestra) {
        this.tipo_muestra = tipo_muestra;
    }

    public String getEquipo_laboratorio() {
        return equipo_laboratorio;
    }

    public void setEquipo_laboratorio(String equipo_laboratorio) {
        this.equipo_laboratorio = equipo_laboratorio;
    }

    public int getPrecio_estudio() {
        return precio_estudio;
    }

    public void setPrecio_estudio(int precio_estudio) {
        this.precio_estudio = precio_estudio;
    }
}
