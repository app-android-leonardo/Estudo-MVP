package br.fortal.android.exemplomvp.api;

import br.fortal.android.exemplomvp.model.GitHubModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("user")
    Call<GitHubModel> user();

}
