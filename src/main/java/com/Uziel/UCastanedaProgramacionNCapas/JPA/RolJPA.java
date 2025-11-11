package com.Uziel.UCastanedaProgramacionNCapas.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROLES")
public class RolJPA {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "idrol")
    private int IdRol;
    
    @Column(name = "rol")
    private String NombreRol;
    
    @Column(name = "descripcion")
    private String Descripcion;
    
    public RolJPA(){
        
    }
    
    public RolJPA(int IdRol, String NombreRol, String Descripcion){
        this.IdRol = IdRol;
        this.NombreRol = NombreRol;
        this.Descripcion = Descripcion;
    }
    
    public void setIdRol(int IdRol){
        this.IdRol = IdRol;
    }
    
    public int getIdRol(){
        return IdRol;
    }
    
    public void setNombreRol(String NombreRol){
        this.NombreRol = NombreRol;
    }
    
    public String getNombreRol(){
        return NombreRol;
    }
    
    public void setDescripcion(String Descripcion){
        this.Descripcion = Descripcion;
    }
    
    public String getDescripcion(){
        return Descripcion;
    }
}
