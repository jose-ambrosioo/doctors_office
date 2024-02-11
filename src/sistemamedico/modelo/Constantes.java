/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemamedico.modelo;

import java.util.ArrayList;
import java.util.List;
import sistemamedico.modelo.Facto;
import sistemamedico.modelo.Regra;

/**
 *
 * @author Nano
 */
public class Constantes
{

    public static double SIM = 100;
    public static double TALVEZ_SIM = 75;
    public static double NAO_SEI = 50;
    public static double TALVEZ_NAO = 25;
    public static double NAO = 0;

    public static List<Facto> sintomas = new ArrayList<>();
    public static List<Facto> resultados = new ArrayList<>();
    public static List<Regra> explicacao = new ArrayList<>();

    public static String descricao(double valor)
    {
        if (valor == 100)
        {
            return "SIM";
        }
        else if (valor == 75)
        {
            return "TALVZ SIM";
        }
        else if (valor == 50)
        {
            return "NÃO SEI";
        }
        else if (valor == 25)
        {
            return "TALVEZ NÃO";
        }
        else if (valor == 0)
        {
            return "NÃO";
        }
        return null;
    }

    public static List<Facto> getSintomas()
    {
        return sintomas;
    }

    public static void setSintomas(Facto sintomas)
    {
        Constantes.sintomas.add(sintomas);
    }

    public static List<Facto> getResultados()
    {
        return resultados;
    }

    public static void setResultados(Facto resultados)
    {
        Constantes.resultados.add(resultados);
    }

    public static List<Regra> getExplicacao()
    {
        return explicacao;
    }

    public static void setExplicacao(Regra explicacao)
    {
        Constantes.explicacao.add(explicacao);
    }

    public static void inicialiarListas()
    {
        sintomas = new ArrayList<>();
        resultados = new ArrayList<>();
        explicacao = new ArrayList<>();
    }

}
