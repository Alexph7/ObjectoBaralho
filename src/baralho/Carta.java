/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baralho;

/**
 *
 * @author ph757
 */
public class Carta {

    private String simbolo;
    private String numero;

    public Carta(String simbolo, String numero) {
        this.simbolo = simbolo;
        this.numero = numero;
    }

    public String toString() {
        return simbolo + " de " + numero;
    }

}
