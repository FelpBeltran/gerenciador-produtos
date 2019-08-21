/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equipe7.gerenciador.controller;

import com.equipe7.gerenciador.controller.helper.MenuPrincipalHelper;
import view.MenuPrincipal;

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
        
        this.view.exibeMensagem("Produto adicionado com sucesso! ");
    }
      
}
