package br.com.globalLabs.springWebMVC.model;

public class Produto {

    private String nome;

    private double preco;
    public Produto(final String nome, final  double preco) {
        this.nome = nome;
        this.preco=preco;
    }
        public Produto(){}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

