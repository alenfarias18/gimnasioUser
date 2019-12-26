package com.example.gymfitness;

public class datosSolicitud {
    private String ip;
    private String port;
    private String usuario;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String clave;
    private String fechaNac;
    private String fechaIng;
    private String genero;

    public datosSolicitud(){
        this.ip = "192.168.0.3";
        this.port = "8080";
        this.usuario = "usuario";
        this.nombre = "nombre";
        this.apellidoPat = "apellidoPat";
        this.apellidoMat = "apellidoMat";
        this.clave = "clave";
        this.fechaNac = "fechaNacimiento";
        this.fechaIng = "fechaIngreso";
        this.genero = "genero";

    }
    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public String getClave() {
        return clave;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public String getFechaIng() {
        return fechaIng;
    }

    public String getGenero() {
        return genero;
    }


    public String getIp(){
        return ip;
    }
    public String getPort(){
        return port;
    }
}
