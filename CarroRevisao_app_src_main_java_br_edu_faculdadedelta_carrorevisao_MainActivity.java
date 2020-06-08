package br.edu.faculdadedelta.carrorevisao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.edu.faculdadedelta.carrorevisao.dao.CarroDAO;
import br.edu.faculdadedelta.carrorevisao.helper.PrincipalHelper;
import br.edu.faculdadedelta.carrorevisao.modelo.Carro;

public class MainActivity extends AppCompatActivity {

    private Button btnSalvar;
    private Button btnLimpar;
    private Button btnListar;

    private PrincipalHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new PrincipalHelper(this);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.limparCampos();
            }
        });

        btnListar = findViewById(R.id.btnListar);
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listar();
            }
        });

        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

        Intent intent = getIntent();
        if(intent != null){
         Carro carroSelecionado = (Carro) intent.getSerializableExtra("carroSelecionado");
            if(carroSelecionado != null){
                helper.popularFormulario(carroSelecionado);
            }
        }
    }

    private void listar() {
        Intent intent = new Intent(getBaseContext(), ListaActivity.class);
        startActivity(intent);
    }

    private void salvar(){
        String msgRetorno = helper.validarCampos();

        if(msgRetorno.equals("")){
            Carro carro = helper.popularModelo();
           CarroDAO dao = new CarroDAO();
            if(carro.getId() == null){
                dao.incluir(carro);
                Toast.makeText(getBaseContext(), "Incluido com sucesso!", Toast.LENGTH_LONG).show();
            }else{
                dao.alterar(carro);
                Toast.makeText(getBaseContext(), "Alterado com sucesso!", Toast.LENGTH_LONG).show();
            }
            helper.limparCampos();
        }else{
            Toast.makeText(getBaseContext(), msgRetorno, Toast.LENGTH_LONG).show();
        }
    }
}
