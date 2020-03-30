package br.fortal.android.exemplomvp.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getNomes(){
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("ABC");
        nomes.add("DFG");
        nomes.add("HIJ");
        nomes.add("KLM");
        return nomes;
    }
}
