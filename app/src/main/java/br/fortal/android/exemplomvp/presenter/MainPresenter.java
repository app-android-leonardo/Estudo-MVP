package br.fortal.android.exemplomvp.presenter;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.fortal.android.exemplomvp.api.ApiClient;
import br.fortal.android.exemplomvp.api.ApiInterface;
import br.fortal.android.exemplomvp.model.GitHubModel;
import br.fortal.android.exemplomvp.view.MainMVP;
import br.fortal.android.exemplomvp.R;
import br.fortal.android.exemplomvp.model.Pessoa;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainMVP.Presenter {
    private MainMVP.View view;
    private Context context;

    public MainPresenter(MainMVP.View view){
        this.view = view;
        this.context = (Context) view;
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

    public void call(){
        ApiInterface service = ApiClient.getApiClient().create(ApiInterface.class);
        Call<GitHubModel> call = service.user();
        call.enqueue(new Callback<GitHubModel>() {
            @Override
            public void onResponse(@NonNull Call<GitHubModel> call, @NonNull Response<GitHubModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    GitHubModel body = response.body();
                    String userUrl = body.userUrl;
                    //Toast.makeText(context, userUrl, Toast.LENGTH_SHORT).show();
                    view.onSuccess(userUrl);
                } else {
                    //Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                    view.onError(response.message());
                }
            }

            @Override
            public void onFailure(@NonNull Call<GitHubModel> call, @NonNull Throwable t) {
                //Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
                view.onFailure(t.getMessage());
            }
        });
    }

}