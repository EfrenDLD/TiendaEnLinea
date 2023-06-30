package Pojo;

public class Usuario {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String edad;
    private String direccion;
    private String telefono;
    private String ine;

    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String edad, String direccion, String telefono, String ine) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ine = ine;
    }

    public Usuario(){

    }
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIne() {
        return ine;
    }
}
