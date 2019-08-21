package com.equipe7.gerenciador.DAO;

import com.equipe7.gerenciador.model.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";    
    private static final String LOGIN = "YhOjH0lCdr";                   
    private static final String SENHA = "mtJpHsfcsD";                   
    private static final String URL = "jdbc:mysql://remotemysql.com:3306/YhOjH0lCdr?useTimezone=true&serverTimezone=UTC";
    private static Connection conexao;

    public static boolean cadastrarCategoria(Categoria cat) {
        boolean retorno = false;

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            String insertQuerry = "INSERT INTO `PRODUTO_CATEGORIA` (`ID_PRODUTO`, `ID_CATEGORIA`) VALUES (?,?)";

            PreparedStatement comando = conexao.prepareStatement(insertQuerry);

            comando.setInt(1, cat.getId());
            comando.setString(2, cat.getNome());

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

    public static List<Categoria> listarCategorias() {
        List<Categoria> listaCategorias = new ArrayList<>();

        try {

            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);

            String selectQuerry = "SELECT CATEGORIA.ID, CATEGORIA.NOME FROM `CATEGORIA`";

            PreparedStatement comando = conexao.prepareStatement(selectQuerry);

            ResultSet rs = comando.executeQuery();

            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("ID"));
                cat.setNome(rs.getString("NOME"));
                listaCategorias.add(cat);
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

        return listaCategorias;
    }

}
