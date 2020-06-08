package br.edu.faculdadedelta.carrorevisao.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.faculdadedelta.carrorevisao.modelo.Carro;

public class CarroDAO {
    private static List<Carro> listaCarro = new ArrayList<>();
    private static Long idGerador = 1L;

    public void incluir(Carro carro) {
        carro.setId(idGerador++);
        listaCarro.add(carro);
    }

    public void excluir(Carro carro) {
        listaCarro.remove(carro);
    }

    public List<Carro> listar() {
        return listaCarro;
    }

    public void alterar(Carro carro) {
        for ( Carro carroAux: listaCarro) {
            long idCarro = carro.getId();
            long idCarroAux = carroAux.getId();
            if (idCarro == idCarroAux) {
                listaCarro.remove(carroAux);
                listaCarro.add(carro);
                break;
            }
        }
    }
}



