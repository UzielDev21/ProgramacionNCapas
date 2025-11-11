package com.Uziel.UCastanedaProgramacionNCapas.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DIRECCION")
public class DireccionJPA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddireccion", nullable = false)
    private int IdDireccion;

    @Column(name = "calle")
    private String Calle;

    @Column(name = "numerointerior")
    private String NumeroInterior;

    @Column(name = "numeroexterior")
    private String NumeroExterior;

    @ManyToOne
    @JoinColumn(name = "idcolonia")
    public ColoniaJPA ColoniaJPA;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusuario")
    public UsuarioJPA UsuarioJPA;

//------------------------------------------------------------------SETTERS Y GETTERS------------------------------------------------------------------//
    public DireccionJPA() {
    }

    public DireccionJPA(int IdDireccion, String Calle, String NumeroInterior, String NumeroExterior, int IdColonia, int IdUsuario) {
        this.IdDireccion = IdDireccion;
        this.Calle = Calle;
        this.NumeroInterior = NumeroInterior;
        this.NumeroExterior = NumeroExterior;
    }

    public void setIdDireccion(int IdDireccion) {
        this.IdDireccion = IdDireccion;
    }

    public int getIdDireccion() {
        return IdDireccion;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public String getCalle() {
        return Calle;
    }

    public void setNumeroInterior(String NumeroInterior) {
        this.NumeroInterior = NumeroInterior;
    }

    public String getNumeroInterior() {
        return NumeroInterior;
    }

    public void setNumeroExterior(String NumeroExterior) {
        this.NumeroExterior = NumeroExterior;
    }

    public String getNumeroExterior() {
        return NumeroExterior;
    }

    public void setColoniaJPA(ColoniaJPA ColoniaJPA) {
        this.ColoniaJPA = ColoniaJPA;
    }

    public ColoniaJPA getColoniaJPA() {
        return ColoniaJPA;
    }

    public void setUsuarioJPA(UsuarioJPA UsuarioJPA) {
        this.UsuarioJPA = UsuarioJPA;
    }

    public UsuarioJPA getUsuarioJPA() {
        return UsuarioJPA;
    }
}
