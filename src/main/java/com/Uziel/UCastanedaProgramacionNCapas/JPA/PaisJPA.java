package com.Uziel.UCastanedaProgramacionNCapas.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAIS")
public class PaisJPA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idpais")
    private int IdPais;
    
    @Column(name = "nombre")
    private String Nombre;
    
    public PaisJPA(){
        
    }
    
    public PaisJPA(int IdPais, String Nombre){
        this.IdPais = IdPais;
        this.Nombre = Nombre;
    }
    
    public void setIdPais(int IdPais){
        this.IdPais = IdPais;
    }
    
    public int getIdPais(){
        return IdPais;
    }
    
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    
    public String getNombre(){
        return Nombre;
    }

}
