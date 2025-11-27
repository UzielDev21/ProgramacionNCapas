package com.Uziel.UCastanedaProgramacionNCapas.ML;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {

    private int IdUsuario; //Propiedad

    @NotNull(message = "El campo no puede ser Nulo")
    @NotBlank(message = "El campo debe contener informacion")
    @Size(min = 5, max = 18)
    @Pattern(regexp = "[a-zA-Z0-9_ñ@$#-]+$", message = "El campo debe de tener _, Numeros y Letras")
    private String UserName;

    @NotNull(message = "El Campo no puede quedar vacio")
    @NotBlank(message = "El Campo debe contener informacion")
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[A-Za-zñáéíóúÁÉÍÓÚ]+(\\s[A-Za-zñáéíóúÁÉÍÓÚ]+)*$", message = "Solo se pueden ingresar Letras")
    private String Nombre;

    @NotNull(message = "El campo no puede quedar vacio")
    @NotBlank(message = "El Campo debe contener información con Letras")
    @Size(min = 3, max = 17)
    @Pattern(regexp = "^[A-Za-zñáéíóúÁÉÍÓÚ]+(\\s[A-Za-zñáéíóúÁÉÍÓÚ]+)*$", message = "Solo se pueden ingresar Letras")
    private String ApellidoPaterno;

    @NotBlank(message = "El Campo debe contener información con Letras")
    @Size(min = 3, max = 17)
    @Pattern(regexp = "^[A-Za-zñáéíóúÁÉÍÓÚ]+(\\s[A-Za-zñáéíóúÁÉÍÓÚ]+)*$", message = "Solo se pueden ingresar Letras")
    private String ApellidoMaterno;

    @NotNull(message = "El campo no puede quedar vacio")
    @NotBlank(message = "El campo Debe de contener información")
    @Email(message = "Ingresa un correo valido")
    private String Email;

    @NotNull(message = "El campo no puede quedar vacio")
    @NotBlank(message = "Ingresa información a la casilla")
    @Size(min = 8, max = 16, message = "La contraseña minimo de 8 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{8,16}$", message = "La contraseña debe de Tener al Menos una Letra mayuscula y un Numero")
    private String Password;

    @NotNull(message = "El campo no puede quedar vacio")
    @Past(message = "Solo puedes ingresar fechas anteriores a la actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date FechaNacimiento;

    @NotNull(message = " ")
    @NotBlank(message = "Debes de Seleccionar una Opcion")
    private String Sexo;

    @NotNull(message = " ")
    @NotBlank(message = "El campo no debe de estar vacio")
    @Pattern(regexp = "\\+*([0-9]{2,3})*\\s*[0-9]{10}$", message = "El campo Solo acepta numeros y +")
    private String Telefono;

    @NotBlank(message = "El campo no debe de estar vacio")
    @Pattern(regexp = "\\+*([0-9]{2,3})*\\s*[0-9]{10}$", message = "El campo Solo acepta numeros y +")
    private String Celular;

    @NotNull(message = " ")
    @NotBlank(message = "El campo no puede quedar vacio")
    @Pattern(regexp = "\\b[A-Z][AEIOU][A-Z]{2}[0-9]{2}(?:0[1-9]|1[0-2])(?:[1-2][0-9]|0[1-9]|3[0-1])[HM][A-Z]{2}[B-DF-HJ-NP-TV-Z]{3}(?:[0-9]|[A-Z])[0-9]\\b", message = "ingresa una CURP valida")
    private String Curp;

    private String Imagen;
    
    private int Status;

    private String extension;

    public Rol Rol; //Propiedad de navegación

    public List<Direccion> Direcciones;

    public Usuario() {

    }

    public Usuario(String UserName, String Nombre, String ApellidoPaterno, String ApellidoMaterno, String Email, String Password, Date FechaNacimiento, String Sexo, String Telefono, String Celular, String Curp, String Imagen) {
        this.UserName = UserName;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Email = Email;
        this.Password = Password;
        this.FechaNacimiento = FechaNacimiento;
        this.Sexo = Sexo;
        this.Celular = Celular;
        this.Curp = Curp;
        this.Imagen = Imagen;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getEmail() {
        return Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCurp(String Curp) {
        this.Curp = Curp;
    }

    public String getCurp() {
        return Curp;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    public String getImagen() {
        return Imagen;
    }

    public Rol getRol() {
        return Rol;
    }

    public void setRol(Rol Rol) {
        this.Rol = Rol;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
    
    public List<Direccion> getDirecciones() {
        return Direcciones;
    }

    public void setDirecciones(List<Direccion> Direcciones) {
        this.Direcciones = Direcciones;
    }

}
