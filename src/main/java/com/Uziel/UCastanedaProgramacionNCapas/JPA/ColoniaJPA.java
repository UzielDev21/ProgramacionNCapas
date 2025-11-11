package com.Uziel.UCastanedaProgramacionNCapas.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "COLONIA")
class ColoniaJPA {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcolonia")
    private int IdColonia;
    
    @Column(name = "nombre")
    private String Nombre;
    
    @Column(name = "codigopostal")
    private String CodigoPostal;
    
    @ManyToOne
    @JoinColumn(name = "idmunicipio")
    public MunicipioJPA MunicipioJPA;

//------------------------------------------------------------------SETTERS Y GETTERS------------------------------------------------------------------//
    public ColoniaJPA(){
    }
    
    public ColoniaJPA(int IdColonia, String Nombre, String CodigoPostal){
        this.IdColonia = IdColonia;
        this.Nombre = Nombre;
        this.CodigoPostal = CodigoPostal;
    }
    
    public void setIdColonia(int IdColonia){
        this.IdColonia = IdColonia;
    }
    
    public int getIdColonia(){
        return IdColonia;
    }
    
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public void setCodigoPostal(String CodigoPostal){
        this.CodigoPostal = CodigoPostal;
    }
    
    public String getCodigoPostal(){
        return CodigoPostal;
    }
    
    public void setMunicipioJPA(MunicipioJPA MunicipioJPA){
        this.MunicipioJPA = MunicipioJPA;
    }
    
    public MunicipioJPA getMunicipioJPA(){
        return MunicipioJPA;
    }
}
