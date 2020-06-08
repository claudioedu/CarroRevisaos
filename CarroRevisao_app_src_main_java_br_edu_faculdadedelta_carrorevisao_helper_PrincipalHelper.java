package br.edu.faculdadedelta.carrorevisao.helper;

import android.text.TextUtils;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.faculdadedelta.carrorevisao.MainActivity;
import br.edu.faculdadedelta.carrorevisao.R;
import br.edu.faculdadedelta.carrorevisao.modelo.Carro;

public class PrincipalHelper {
    private EditText etCor;
    private EditText etModelo;
    private EditText etMarca;
    private EditText etDataFabricacao;
   ;
    private Carro carro= new Carro();


    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public PrincipalHelper(MainActivity activity){
        etCor = activity.findViewById(R.id.etCor);
        etModelo = activity.findViewById(R.id.etModelo);
        etMarca= activity.findViewById(R.id.etMarca);
        etDataFabricacao = activity.findViewById(R.id.etDataFabricacao);

        carro= new Carro();
    }

    public Carro popularModelo(){

     carro.setCor(etCor.getText().toString());
        carro.setModelo(etModelo.getText().toString());
        carro.setMarca(etMarca.getText().toString());
        ;

        try {
            carro.setDataFabricacao(sdf.parse(etDataFabricacao.getText().toString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return carro;
    }

    public void popularFormulario( Carro carro){
        etCor.setText(carro.getCor());
        etModelo.setText(carro.getModelo());
        etMarca.setText(carro.getMarca());
        etDataFabricacao.setText(sdf.format(carro.getDataFabricacao()));
        this.carro = carro;
    }

    public void limparCampos(){
        etCor.setText("");
        etModelo.setText("");
        etDataFabricacao.setText("");
        etMarca.setText("");


       carro =carro = new Carro();
    }

    public String validarCampos(){
        String msgRetorno = "";



        if(TextUtils.isEmpty(etCor.getText().toString())){
            etCor.setError(" ");
            msgRetorno = " \na cor é obrigatório!";
        }
        if(TextUtils.isEmpty(etModelo.getText().toString())){
            etModelo.setError(" ");
            msgRetorno += "\nO modelo é obrigatório!";
        }
        if(TextUtils.isEmpty(etMarca.getText().toString())){
            etMarca.setError(" ");
            msgRetorno += "\nA marca é obrigatório!";
        }

        if(TextUtils.isEmpty(etDataFabricacao.getText().toString())){
            etDataFabricacao.setError(" ");
            msgRetorno += "\nA Data de Lançamento é obrigatória!";
        }else{
            try {
                Date dataMin = sdf.parse("02/01/1900");
                Date dataConvertida = sdf.parse(etDataFabricacao.getText().toString());
                Date agora = new Date();
                if(dataConvertida.before(dataMin) || dataConvertida.after(agora)){
                    etDataFabricacao.setError(" ");
                    msgRetorno += String.format("\nA Data de Lançamento deve ser de %s a %s!", sdf.format(dataMin) ,sdf.format(agora));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return msgRetorno;
    }

}

