/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

/**
 *
 * @author ben10
 */

public class Variable {
    private String tipo;
    private String id;
    private String valor;

    public Variable(String tipo, String id, String valor) {
        this.tipo = tipo;
        this.id = id;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getId() {
        return id;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return tipo + " | " + id + " | " + valor;
    }
}