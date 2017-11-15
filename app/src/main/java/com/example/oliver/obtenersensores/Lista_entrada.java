package com.example.oliver.obtenersensores;

/**
 * Created by oliver on 13/11/17.
 */

public class Lista_entrada {

    private String nombre;
    private String fabricante;
    private String version;

    public Lista_entrada(String nombre, String fabricante, String version) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.version = version;
    }
    public String getNombre() {
        return nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getVersion() {
        return version;
    }
}
