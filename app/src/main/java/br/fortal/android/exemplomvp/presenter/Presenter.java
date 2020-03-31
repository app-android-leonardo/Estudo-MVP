package br.fortal.android.exemplomvp.presenter;

import java.util.ArrayList;
import java.util.List;

import br.fortal.android.exemplomvp.view.MainMVP;
import br.fortal.android.exemplomvp.R;
import br.fortal.android.exemplomvp.model.Pessoa;

public class Presenter implements MainMVP.Presenter {
    private MainMVP.View view;

    public Presenter (MainMVP.View view){
        this.view = view;
    }

    @Override
    public void botaoClicado(int id) {
        Pessoa p1 = new Pessoa("Leonardo");
        Pessoa p2 = new Pessoa("Roberta");

        switch (id){
            case R.id.button_toast1:
                view.mostrarMensagem(p1);
                view.mostrarNomes(p1);
                break;
            case R.id.button_toast2:
                view.mostrarMensagem(p2);
                break;
        }
    }

    public List<String> getNomes(){
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("1");
        nomes.add("2");
        nomes.add("3");
        nomes.add("4");
        return nomes;
    }

}