/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamedico.modelo;

/**
 *
 * @author Nano
 */
public class Facto
{
    private String atributo;
    private String valor;
    private String facto_certeza;

    public Facto() {
    }

    public Facto(String atributo, String valor, String facto_certeza) {
        this.atributo = atributo;
        this.valor = valor;
        this.facto_certeza = facto_certeza;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFacto_certeza() {
        return facto_certeza;
    }

    public void setFacto_certeza(String facto_certeza) {
        this.facto_certeza = facto_certeza;
    }
}
