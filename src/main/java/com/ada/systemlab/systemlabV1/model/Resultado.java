package com.ada.systemlab.systemlabV1.model;


import javax.persistence.*;

@Entity
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_resultado;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_paciente", referencedColumnName = "id_paciente")
    private Paciente paciente;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_estudio", referencedColumnName = "id_estudio")
    private Estudios estudio;


    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_protocolo", referencedColumnName = "id_protocolo")
    private Protocolo protocolo;


    private String valor_resultado;

    public int getId_resultado() {
        return id_resultado;
    }

    public void setId_resultado(int id_resultado) {
        this.id_resultado = id_resultado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Protocolo getProtocolo() {
        return protocolo;
    }

    public Estudios getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudios estudio) {
        this.estudio = estudio;
    }

    public void setProtocolo(Protocolo protocolo) {
        this.protocolo = protocolo;
    }

    public String getValor_resultado() {
        return valor_resultado;
    }

    public void setValor_resultado(String valor_resultado) {
        this.valor_resultado = valor_resultado;
    }
}
