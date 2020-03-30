package br.fortal.android.exemplomvp.view;

import br.fortal.android.exemplomvp.model.Pessoa;

public interface MainMVP {

    interface View {
        void mostrarMensagem(Pessoa pessoa);
        void mostrarNomes(Pessoa pessoa);
    }

    interface Presenter {
        void botaoClicado(int id);
    }

}