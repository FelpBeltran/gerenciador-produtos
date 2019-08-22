/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equipe7.gerenciador.controller;

import com.equipe7.gerenciador.DAO.ProdutoDAO;
import com.equipe7.gerenciador.controller.helper.MenuPrincipalHelper;
import com.equipe7.gerenciador.model.Produto;
import com.equipe7.gerenciador.view.MenuPrincipal;
import java.util.List;


/**
 *
 * @author Felipe
 */
public class MenuPrincipalController {
    private final MenuPrincipal view;
    private MenuPrincipalHelper helper;
    public MenuPrincipalController(MenuPrincipal view) {
        this.view = view;
        this.helper = new MenuPrincipalHelper(view);
    }
    
    public void addProduto(){
        //Produto produto = helper.obterModelo();
        //ProdutoDAO add = new ProdutoDAO();
        //add.
        Produto produto =helper.obterModelo();
        
        ProdutoDAO prod = new ProdutoDAO();
        
        this.view.exibeMensagem(prod.cadastrarProduto(produto) ? "Produto adicionado com sucesso!": "falha ao cadastrar");
        helper.limparTela();
    }
    public List<Produto> getProdutosList(){
        ProdutoDAO produtodao = new ProdutoDAO();
        return produtodao.listarProdutos();
    }
    
    public void removeProduto(int pid){
        Produto produto =helper.obterModelo();
        
        ProdutoDAO prod = new ProdutoDAO();
        this.view.exibeMensagem( prod.excluirProduto(pid)?"Produto excluído com sucesso!":"falha ao remover produto");
    }
  
    public Produto findProduto(){
        Produto produto =helper.obterModelo();
        helper.setarModelo(produto);
        ProdutoDAO prod = new ProdutoDAO();
        return produto;
    }
}
