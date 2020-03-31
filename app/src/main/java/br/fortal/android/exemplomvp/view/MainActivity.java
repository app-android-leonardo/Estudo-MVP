package br.fortal.android.exemplomvp.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import br.fortal.android.exemplomvp.R;
import br.fortal.android.exemplomvp.model.Pessoa;
import br.fortal.android.exemplomvp.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainMVP.View {
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        Button buttonToast1 = findViewById(R.id.button_toast1);
        Button buttonToast2 = findViewById(R.id.button_toast2);

        buttonToast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.botaoClicado(R.id.button_toast1);
                List<String> nomes = presenter.getNomes();
                Toast.makeText(getApplicationContext(), nomes.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        buttonToast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.botaoClicado(R.id.button_toast2);
                presenter.call();
            }
        });
    }

    @Override
    public void mostrarMensagem(Pessoa pessoa) {
        Toast.makeText(getApplicationContext(), pessoa.getNome(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void mostrarNomes(Pessoa pessoa) {
        Toast.makeText(getApplicationContext(), pessoa.getNomes().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(String mensagem) {
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String mensagem) {
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String mensagem) {
        Toast.makeText(getApplicationContext(), mensagem, Toast.LENGTH_SHORT).show();
    }

}