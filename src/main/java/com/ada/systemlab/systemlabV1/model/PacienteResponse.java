package com.ada.systemlab.systemlabV1.model;

public class PacienteResponse {
    private Paciente paciente;
    private String message;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
