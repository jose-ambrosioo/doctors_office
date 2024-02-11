/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamedico.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jpl7.Query;
import org.jpl7.Term;
import sistemamedico.modelo.Pergunta;

/**
 *
 * @author Nano
 */
public class PerguntaDAO
{
    public static List<Pergunta> getPerguntas()
    {
        List<Pergunta> perguntas = new ArrayList<>();

        String t4 = "consult('base_conhecimento.pl')";
        Query q4 = new Query(t4);

        q4.hasSolution();

        String t2 = "pergunta(Atributo, Valor, Pergunta, Lista_De_Respostas)";
        Query q2 = new Query(t2);
        q2.hasMoreSolutions();

        do
        {
            Map<String, Term> mapa = q2.nextSolution();

            String atributo = mapa.get("Atributo").toString();
            String valor = mapa.get("Valor").toString();
            String pergunta = mapa.get("Pergunta").toString().replace("_", " ").replace("'", "");
            String[] listaDeResposta = mapa.get("Lista_De_Respostas").toString().replace("'", "").split(";");

            perguntas.add(new Pergunta(atributo, valor, pergunta, RespostaDAO.getRespostas(listaDeResposta)));

        }
        while (q2.hasMoreSolutions());

        return perguntas;
    }

}
