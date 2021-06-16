package com.ada.systemlab.systemlabV1.model;

import java.util.Collection;

public class PacientesResponse {
    Collection <Paciente> paciente;
    private String message;

    public Collection<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(Collection<Paciente> paciente) {
        this.paciente = paciente;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
