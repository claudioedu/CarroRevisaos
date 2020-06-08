package br.edu.faculdadedelta.carrorevisao.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Carro implements Serializable {
    private Long id;
    private String  cor;
    private String modelo;
    private String marca;
    private Date dataFabricacao;

    public Carro() {
    }

    public Carro(Long id, String cor, String modelo, String marca, Date dataFabricacao) {
        this.id = id;
        this.cor = cor;
        this.modelo = modelo;
        this.marca = marca;
        this.dataFabricacao = dataFabricacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carro)) return false;
        Carro carro = (Carro) o;
        return getId().equals(carro.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
