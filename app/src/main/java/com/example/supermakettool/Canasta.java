package com.example.supermakettool;



public class Canasta {

    private String cod,descripcion,detalle;
    private double precio;
    private String img;

    public Canasta(String cod, String descripcion, String detalle, double precio, String img) {
        this.cod = cod;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.img = img;
    }

    public Canasta(String cod, String descripcion, String detalle) {
        this.cod = cod;
        this.descripcion = descripcion;
        this.detalle = detalle;
    }

    public Canasta(String descripcion, String detalle, double precio, String img) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.img = img;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    @Override
    public String toString() {
        return "Canasta{" +
                "cod='" + cod + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", detalle='" + detalle + '\'' +
                ", precio=" + precio +
                ", img='" + img + '\'' +
                '}';
    }
}
