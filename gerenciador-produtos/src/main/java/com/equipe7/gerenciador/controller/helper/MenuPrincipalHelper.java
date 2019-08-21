/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equipe7.gerenciador.controller.helper;

import java.util.Date;
import produtos.Produto;
import view.MenuPrincipal;

/**
 *
 * @author Felipe
 */
public class MenuPrincipalHelper {
    private final MenuPrincipal view;
    private Date dataCadastro;

    public MenuPrincipalHelper(MenuPrincipal view) {
        this.view = view;
    }
    
    public Produto obterModelo(){
        double precovenda = Float.parseFloat(view.getTextPrecoDeVenda().getText());
        double precocompra = Float.parseFloat(view.getTextPrecoDeCompra().getText());
        String nome = view.getTextNome().getText();
        String descricao = view.getTextDescricao().getText();
        int quantidade = Integer.parseInt(view.getTextQuantidade().getText());
        //Verificar se o id precisa ser um parametro
        Produto modelo = new Produto(0, nome, descricao, precovenda, precocompra, quantidade, Boolean.FALSE, dataCadastro);
        return modelo;
    }
    public void setarModelo(Produto modelo){
        String nome = modelo.getNome();
        String descricao = modelo.getDescricao();
        double precovenda = modelo.getPrecoVenda();
        double precocompra = modelo.getPrecoCompra();
        int quantidade = modelo.getQuantidade();
        String pv = String.valueOf(precovenda);
        String pc = String.valueOf(precocompra);
        String qtd = String.valueOf(quantidade);
        
        view.getTextNome().setText(nome);
        view.getTextDescricao().setText(descricao);
        view.getTextPrecoDeVenda().setText(pv);
        view.getTextPrecoDeCompra().setText(pc);
        view.getTextQuantidade().setText(qtd);
    }
    
    public void limparTela(){
        view.getTextNome().setText("");
        view.getTextDescricao().setText("");
        view.getTextPrecoDeCompra().setText("");
        view.getTextPrecoDeVenda().setText("");
        view.getTextQuantidade().setText("");
    }
    
}
