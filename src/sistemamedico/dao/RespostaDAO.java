/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamedico.dao;

import java.text.DecimalFormat;
import sistemamedico.modelo.Constantes;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jpl7.Query;
import org.jpl7.Term;
import sistemamedico.modelo.Facto;
import sistemamedico.modelo.Regra;
import sistemamedico.modelo.Resposta;

/**
 *
 * @author Nano
 */
public class RespostaDAO
{

    public static void getRespostas()
    {
        String atributo = "diagnostico";

        String t4 = "consult('motor_inferencia.pl')";
        Query q4 = new Query(t4);
        q4.hasSolution();

        String t5 = "prepararCondicoes.";
        Query q5 = new Query(t5);
        q5.hasMoreSolutions();

        for (Facto sintoma : Constantes.sintomas)
        {
            String t7 = "assert(facto(av(" + sintoma.getAtributo() + ", " + sintoma.getValor() + "), " + sintoma.getFacto_certeza() + ")).";
            Query q7 = new Query(t7);
            q7.hasSolution();

            System.out.println(t7);
        }

        String t8 = "iniciarProcessoInferencia.";
        Query q8 = new Query(t8);
        q8.hasMoreSolutions();

        String t2 = "facto(av(" + atributo + ", Valor), CF).";
        Query q2 = new Query(t2);
        q2.hasMoreSolutions();

        do
        {
          if(q2.isOpen())
          {
            Map<String, Term> mapa = q2.nextSolution();
            if (mapa != null)
            {
                String valor = mapa.get("Valor").toString();
                String facto_certeza = mapa.get("CF").toString();

                Constantes.setResultados(new Facto(atributo, valor, facto_certeza));
            }
          }
        }
        while (q2.hasMoreSolutions());
    }

    public static Resposta getRespostas(String[] respostas)
    {
        return new Resposta(respostas[0], respostas[1], respostas[2], respostas[3], respostas[4]);
    }

    public static String formatarResposta(List<Facto> respostas)
    {
        String str = new String();

        for (Facto facto : respostas)
        {
             
            str += "\n " + facto.getValor() + " - " + new DecimalFormat("0.##").format(Double.parseDouble(facto.getFacto_certeza())) + " % ";
        }

        return str;
    }

    public static void getExplicacao()
    {

        String t2 = "regra(_, lhs(Sintomas), rhs(av(diagnostico, ValorDoDiagnostico),_)).";
        Query q2 = new Query(t2);
        q2.hasMoreSolutions();

        do
        {
            Map<String, Term> mapa = q2.nextSolution();

            String sintomasBS = mapa.get("Sintomas").toString();

            sintomasBS = sintomasBS.replace("'[|]'(", "");
            sintomasBS = sintomasBS.replace("), '[]'))))))", "");
            sintomasBS = sintomasBS.replace("av(", "");
            sintomasBS = sintomasBS.replace(")", "");
            sintomasBS = sintomasBS.replace("sintoma,", "");
            sintomasBS = sintomasBS.replace(" ", "");

            String[] sin = sintomasBS.split(",");

            String valorDiagnostico = mapa.get("ValorDoDiagnostico").toString();

            Facto conclusao = null;
            for (Facto resposta : Constantes.resultados)
            {
                if (resposta.getValor().equalsIgnoreCase(valorDiagnostico))
                {
                    conclusao = resposta;
                }
            }

            List<Facto> sintomasDoDiagnostico = new ArrayList<>();
            for (String s1 : sin)
            {
                for (Facto s2 : Constantes.sintomas)
                {
                    if (s1.equals(s2.getValor()))
                    {
                        sintomasDoDiagnostico.add(s2);
                    }
                }
            }

            Regra regra = new Regra();
            regra.setConclusao(conclusao);
            regra.setSintomas(sintomasDoDiagnostico);

            Constantes.setExplicacao(regra);

        }
        while (q2.hasMoreSolutions());
    }
    
    public static String formatarExplicacao(List<Regra> explicacao)
    {
        String str = new String();        
        for(Regra regra : explicacao)
        {
            if(regra.getConclusao() != null)
            {
                str += "\n Diagnosticou-se  " + regra.getConclusao().getValor() + " com " + new DecimalFormat("0.##").format(Double.parseDouble(regra.getConclusao().getFacto_certeza())) +"%  pois: \n";
                for(Facto sintoma : regra.getSintomas())
                {
                    str += "\t" + Constantes.descricao(Double.parseDouble(sintoma.getFacto_certeza())) + " - " + sintoma.getValor() + "\n";
                }
            }
        }
        return str;
    }  

    public static void inserirNovaregra(List<String> sintomas, String valor_diagnostico)
    {
       String t4 = "consult('motor_inferencia.pl')";
       Query q4 = new Query(t4);
       q4.hasSolution();
        
       String regra = new String();
       
       regra += "regra(_,lhs([";
       for(int i = 0; i < sintomas.size(); i++)
       {
           regra += "av(sintoma, ";
           regra += sintomas.get(i) + ") ";
           
           if((i+1)  != sintomas.size())
           {
               regra += ",";
           }
       }
       regra += "] ), rhs( av( diagnostico , "+valor_diagnostico+" ), 100)). ";
       
       System.out.println(regra);           

       String t7 = "inserir_facto('"+regra+"').";
       Query q7 = new Query(t7);
       q7.hasSolution();       
    }

    public static void inserirNovoSintoma(String nomeSintoma)
    {
       String t4 = "consult('motor_inferencia.pl')";
       Query q4 = new Query(t4);
       q4.hasSolution();
        
       String descricaoPergunta = "Tens "+nomeSintoma+" ?";
       
      String facto = "pergunta(sintoma, "+nomeSintoma+", \""+descricaoPergunta+"\", \"Sim; Talvez Sim; Nao Sei; Talvez Nao; Nao\").";
      
       System.out.println(facto);           

       String t7 = "inserir_facto('"+facto+"').";       
       Query q7 = new Query(t7);
       q7.hasSolution();       
    }    
    
    public static List<String> getNomesTodasPatologias()
    {
        List<String> nomes = new ArrayList<>();
        
        String t4 = "consult('motor_inferencia.pl')";
        Query q4 = new Query(t4);
        q4.hasSolution();
        
        String t2 = "regra(_, _, rhs(av(diagnostico, ValorDoDiagnostico),_)).";
        Query q2 = new Query(t2);
        q2.hasMoreSolutions();

        do
        {
            Map<String, Term> mapa = q2.nextSolution();

            if(mapa != null)
                nomes.add(mapa.get("ValorDoDiagnostico").toString());
            
        }while (q2.hasMoreSolutions());
        
        return nomes;
    } 
}
