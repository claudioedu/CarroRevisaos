package br.edu.faculdadedelta.carrorevisao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.edu.faculdadedelta.carrorevisao.R;
import br.edu.faculdadedelta.carrorevisao.modelo.Carro;

public class CarroAdapter extends BaseAdapter {
    private List<Carro> listaCarro;
    private Context context;

    public CarroAdapter(List<Carro> listaCarro, Context context) {
        this.listaCarro = listaCarro;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaCarro.size();
    }

    @Override
    public Object getItem(int i) {
        return listaCarro.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

       Carro carro = (Carro) getItem(i);

        View viewRetorno = view.inflate(context, R.layout.layout_item_lista, null);

        TextView tvCor = viewRetorno.findViewById(R.id.tvCor);
        tvCor.setText("Cor: " + carro.getCor());

        TextView tvMarca= viewRetorno.findViewById(R.id.tvMarca);
        tvMarca.setText("Marca: " + carro.getMarca());

        TextView tvModelo = viewRetorno.findViewById(R.id.tvModelo);
        tvModelo.setText("Modelo: " + carro.getModelo());


        TextView tvDataFabricacao = viewRetorno.findViewById(R.id.tvDataFabricacao);

        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");

        tvDataFabricacao.setText("Data: " + sf.format(carro.getDataFabricacao()));




        return viewRetorno;
    }
}


