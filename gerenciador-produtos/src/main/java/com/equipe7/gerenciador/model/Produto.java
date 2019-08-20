package com.equipe7.gerenciador.model;

import java.util.Date;

public class Produto {

    private int id;

    private String nome;

    private String descricao;

    private float preco_Compra;

    private float preco_Venda;

    private int quantidade;

    private boolean disponivel;

    private Date dt_Cadastro;

    private Categoria categoriaProduto;

    public Produto() {
    }

    public Produto(int id, String nome, String descricao, float preco_Compra, float preco_Venda, int quantidade, boolean disponivel, Date dt_Cadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco_Compra = preco_Compra;
        this.preco_Venda = preco_Venda;
        this.quantidade = quantidade;
        this.disponivel = disponivel;
        this.dt_Cadastro = dt_Cadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco_Compra() {
        return preco_Compra;
    }

    public void setPreco_Compra(float preco_Compra) {
        this.preco_Compra = preco_Compra;
    }

    public float getPreco_Venda() {
        return preco_Venda;
    }

    public void setPreco_Venda(float preco_Venda) {
        this.preco_Venda = preco_Venda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Date getDt_Cadastro() {
        return dt_Cadastro;
    }

    public void setDt_Cadastro(Date dt_Cadastro) {
        this.dt_Cadastro = dt_Cadastro;
    }

    public Categoria getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(Categoria categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

}
