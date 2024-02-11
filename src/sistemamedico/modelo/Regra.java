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
public class Regra {
    private Facto conclusao;
    private List<Facto> sintomas;

    public Regra() {
    }
    
    public Facto getConclusao() {
        return conclusao;
    }

    public void setConclusao(Facto conclusao) {
        this.conclusao = conclusao;
    }

    public List<Facto> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Facto> sintomas) {
        this.sintomas = sintomas;
    }
}
