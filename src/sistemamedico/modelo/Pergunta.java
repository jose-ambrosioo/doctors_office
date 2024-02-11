/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamedico.modelo;

import java.util.List;

/**
 *
 * @author Nano
 */
public class Pergunta
{
    private String atributo;
    private String valor;
    private String descricaoPergunta;
    private Resposta respostas;

    public Pergunta() {
    }

    public Pergunta(String atributo, String valor, String descricaoPergunta, Resposta respostas) {
        this.atributo = atributo;
        this.valor = valor;
        this.descricaoPergunta = descricaoPergunta;
        this.respostas = respostas;
    }
    
    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getDescricaoPergunta() {
        return descricaoPergunta;
    }

    public void setDescricaoPergunta(String descricaoPergunta) {
        this.descricaoPergunta = descricaoPergunta;
    }

    public Resposta getRespostas()
    {
        return respostas;
    }

    public void setRespostas(Resposta respostas)
    {
        this.respostas = respostas;
    }
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
