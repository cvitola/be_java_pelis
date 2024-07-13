package com.example.demo.model;

public class Usuario {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String fechaNacimiento;
    private String pais;
    private Boolean terminos;
    
    public Usuario() {
    }
    //a fin de borrar.-
    public Usuario(String email){
        this.email = email;
    }
    
    public Usuario(String nombre, String apellido, String email, String password, String fechaNacimiento, String pais,
            Boolean terminos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.terminos = terminos;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public Boolean getTerminos() {
        return terminos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setTerminos(Boolean terminos) {
        this.terminos = terminos;
    }


    
}
