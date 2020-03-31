package br.fortal.android.exemplomvp.view;

import br.fortal.android.exemplomvp.model.Pessoa;

public interface MainMVP {

    interface View {
        void mostrarMensagem(Pessoa pessoa);
        void mostrarNomes(Pessoa pessoa);
        void onSuccess(String mensagem);
        void onError(String mensagem);
        void onFailure(String mensagem);
    }

    interface Presenter {
        void botaoClicado(int id);
    }

}