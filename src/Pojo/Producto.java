package Pojo;

public class Producto {
    private String nombre;
    private String cantidad;
    private String precio;
    private String departamento;
    private String descripcion;
    private  boolean disponible;
    public Producto(String nombre, String cantidad, String precio, String departamento, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.departamento = departamento;
        this.descripcion = descripcion;
    }

    public Producto(String nombre, String cantidad, String precio, boolean disponible) {
    }

    public String getNombre() {
        return nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean getDisponible() {
        return disponible;
    }
}

