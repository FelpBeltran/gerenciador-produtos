package com.equipe7.gerenciador.DAO;

import com.equipe7.gerenciador.model.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.equipe7.gerenciador.model.Produto;
import java.sql.Date;
import java.util.List;

public class ProdutoDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String LOGIN = "YhOjH0lCdr";
    private static final String SENHA = "mtJpHsfcsD";
    private static final String URL = "jdbc:mysql://remotemysql.com:3306/YhOjH0lCdr?useTimezone=true&serverTimezone=UTC";
    private static Connection conexao;

    public static boolean cadastrarProduto(Produto prod) {
        boolean retorno = false;

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            String insertQuerry = "INSERT INTO `PRODUTO` (`NOME`, `DESCRICAO`, `PRECO_COMPRA`, `PRECO_VENDA`, `QUANTIDADE`, `DISPONIVEL`, `DT_CADASTRO`) VALUES (?,?,?,?,?,?,?)";

            PreparedStatement comando = conexao.prepareStatement(insertQuerry);

            comando.setString(1, prod.getNome());
            comando.setString(2, prod.getDescricao());
            comando.setFloat(3, prod.getPreco_Compra());
            comando.setFloat(4, prod.getPreco_Venda());
            comando.setInt(5, prod.getQuantidade());
            comando.setBoolean(6, prod.isDisponivel());
            comando.setDate(7, (Date) prod.getDt_Cadastro());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }
        }

        return retorno;
    }

    public static List<Produto> listarProdutos() {
        List<Produto> listaProdutos = new ArrayList<>();
        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            String selectQuerry = "SELECT PRODUTO.ID AS ID_PRODUTO, PRODUTO.NOME, PRODUTO.DESCRICAO, PRODUTO.PRECO_COMPRA, PRODUTO.PRECO_VENDA, PRODUTO.QUANTIDADE, PRODUTO.DISPONIVEL, PRODUTO.DT_CADASTRO, CATEGORIA.NOME AS NOME_CATEGORIA, CATEGORIA.ID as ID_CATEGORIA FROM `PRODUTO_CATEGORIA` INNER JOIN PRODUTO ON PRODUTO.ID = PRODUTO_CATEGORIA.ID_PRODUTO INNER JOIN CATEGORIA on CATEGORIA.ID = PRODUTO_CATEGORIA.ID_CATEGORIA";

            PreparedStatement comando = conexao.prepareStatement(selectQuerry);

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Produto prod = new Produto();

                prod.setId(rs.getInt("ID_PRODUTO"));
                prod.setNome(rs.getString("Nome"));
                prod.setDescricao(rs.getString("DESCRICAO"));
                prod.setPreco_Compra(rs.getFloat("PRECO_COMPRA"));
                prod.setPreco_Venda(rs.getFloat("PRECO_VENDA"));
                prod.setQuantidade(rs.getInt("QUANTIDADE"));
                prod.setDisponivel(rs.getBoolean("DISPONIVEL"));
                prod.setDt_Cadastro(rs.getDate("DT_CADASTRO"));

                Categoria c = new Categoria(rs.getInt("ID_CATEGORIA"), rs.getString("NOME_CATEGORIA"));
                prod.setCategoriaProduto(c);

                listaProdutos.add(prod);
            }

        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                return null;
            }
        }
        return listaProdutos;
    }

    public static Produto buscarProdutoPorID(int pID) {
        Produto prodBuscado = new Produto();

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            String selectQuerry = "SELECT PRODUTO.ID AS ID_PRODUTO, PRODUTO.NOME, PRODUTO.DESCRICAO, PRODUTO.PRECO_COMPRA, PRODUTO.PRECO_VENDA, PRODUTO.QUANTIDADE, PRODUTO.DISPONIVEL, PRODUTO.DT_CADASTRO, CATEGORIA.NOME AS NOME_CATEGORIA, CATEGORIA.ID as ID_CATEGORIA FROM `PRODUTO_CATEGORIA` INNER JOIN PRODUTO ON PRODUTO.ID = PRODUTO_CATEGORIA.ID_PRODUTO INNER JOIN CATEGORIA on CATEGORIA.ID = PRODUTO_CATEGORIA.ID_CATEGORIA WHERE PRODUTO.ID = ?";

            PreparedStatement comando = conexao.prepareStatement(selectQuerry);
            comando.setInt(1, pID);

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                prodBuscado.setId(rs.getInt("ID_PRODUTO"));
                prodBuscado.setNome(rs.getString("Nome"));
                prodBuscado.setDescricao(rs.getString("DESCRICAO"));
                prodBuscado.setPreco_Compra(rs.getFloat("PRECO_COMPRA"));
                prodBuscado.setPreco_Venda(rs.getFloat("PRECO_VENDA"));
                prodBuscado.setQuantidade(rs.getInt("QUANTIDADE"));
                prodBuscado.setDisponivel(rs.getBoolean("DISPONIVEL"));
                prodBuscado.setDt_Cadastro(rs.getDate("DT_CADASTRO"));

                Categoria c = new Categoria(rs.getInt("ID_CATEGORIA"), rs.getString("NOME_CATEGORIA"));
                prodBuscado.setCategoriaProduto(c);

            }
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                return null;
            }
        }

        return prodBuscado;
    }

    public static boolean editarProduto(Produto p) {
        boolean retorno = false;

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            String updateQuerry = "UPDATE `PRODUTO` SET `NOME` = ?, `DESCRICAO` = ?, `PRECO_COMPRA` = ?, `PRECO_VENDA` = ?, `QUANTIDADE` = ?, `DISPONIVEL` = ?, `DT_CADASTRO` = ? WHERE `PRODUTO`.`ID` = ?";

            PreparedStatement comando = conexao.prepareStatement(updateQuerry);

            comando.setString(1, p.getNome());
            comando.setString(2, p.getDescricao());
            comando.setFloat(3, p.getPreco_Compra());
            comando.setFloat(4, p.getPreco_Venda());
            comando.setInt(5, p.getQuantidade());
            comando.setBoolean(6, p.isDisponivel());
            comando.setDate(7, (Date) p.getDt_Cadastro());
            comando.setInt(8, p.getId());

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            retorno = false;

        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }

        }

        return retorno;
    }

    public static boolean excluirProduto(int pID) {
        boolean retorno = false;

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            String deletQuerry = "DELETE FROM `PRODUTO` WHERE `PRODUTO`.`ID` = ?";

            PreparedStatement comando = conexao.prepareStatement(deletQuerry);
            comando.setInt(1, pID);

            int linhasAfetadas = comando.executeUpdate();

            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (ClassNotFoundException | SQLException e) {
            retorno = false;
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                retorno = false;
            }

        }
        return retorno;
    }
}
