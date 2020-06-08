package br.edu.faculdadedelta.carrorevisao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.edu.faculdadedelta.carrorevisao.adapter.CarroAdapter;
import br.edu.faculdadedelta.carrorevisao.dao.CarroDAO;
import br.edu.faculdadedelta.carrorevisao.modelo.Carro;

public class ListaActivity extends AppCompatActivity {
    private ListView lvLista;
    private CarroDAO dao = new CarroDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lvLista = findViewById(R.id.lvLista);

        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Carro carroSelecionado = (Carro) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("carroSelecionado", carroSelecionado);
                startActivity(intent);
            }
        });

        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Carro carroSelecionado = (Carro) adapterView.getItemAtPosition(i);
                dao.excluir(carroSelecionado);
                carregarLista();
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }

    private void carregarLista() {
       CarroAdapter adapter = new CarroAdapter(dao.listar(), getBaseContext());
        lvLista.setAdapter(adapter);
    }

    public void novo(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}
