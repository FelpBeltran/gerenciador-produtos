package produtos;

import java.util.Date;

/**
 *
 * @author mvdo
 */
public class Produto {
    
    private int id;
    private String nome;
    private String descricao;
    private Double precoVenda;
    private Double precoCompra;
    private int quantidade;
    private Boolean flag;
    private Date dataCadastro;
    
    public Produto(int id, String nome, String descricao, Double precoVenda, Double precoCompra, int quantidade, Boolean flag, Date dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
        this.quantidade = quantidade;
        this.flag = flag;
        this.dataCadastro = dataCadastro;
    }

    public Produto(int i, String nome, String descricao, String precocompra, double MIN_NORMAL, int i0, Boolean FALSE, Date dataCadastro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Produto(int i, String nome, String descricao, String precocompra, String precovenda, String quantidade, Boolean FALSE, Date dataCadastro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    


    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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



    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
  
}
