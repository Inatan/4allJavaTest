package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.ProdutoVO;
import persistencia.ConexaoBanco;

/**
 * ProdutoDAO possui todas as operações com o banco de dados relacionados ao produto
 * @author Inatan
 */
public class ProdutoDAO {
    /**
     * Cadastro do produto no banco de dados
     * @param pVO objeto a ser inserido no banco de dados
     * @throws SQLException - falha com o banco de dados
     */
    
    public void cadastarProduto(ProdutoVO pVO) throws SQLException {
        // conexão com o banco de dados
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql; // query
            
        // inserção de um novo produto
        sql = "insert into produto(nome,preco,imagem)"
                    + "values('"+pVO.getNome()+ "'," + pVO.getPreço() + ",'"
                    + pVO.getEndereçoImagem() + "')";
            stat.execute(sql); // execução da query

        } catch (Exception e) {  
            throw new SQLException("Erro ao inserir o Produto.");
        } finally {
            // fecha conexão
            con.close();
            stat.close();
        }//fecha finally
    }//fecha metodo cadastrar

    /**
     * Realiza busca de todos os produtos no banco de dados
     * @return uma lista de todos o produtos do banco de dados
     * @throws SQLException  - caso de erro com o banco de dados
     */
    public ArrayList<ProdutoVO> buscarProduto() throws SQLException {
        // conexão com o banco de dados
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();

        try {
            String sql = "select * from produto"; //query de select
            ResultSet rs = stat.executeQuery(sql); // execução da query
            ArrayList<ProdutoVO> prod = new ArrayList<>();

            while (rs.next()) {
                // leituro dos produtos
                ProdutoVO pVO = new ProdutoVO(rs.getInt("id"),
                        rs.getString("nome"), (float)rs.getDouble("preco"),
                        rs.getString("imagem"));
                prod.add(pVO);//Adição dos produtos em uma lista de produto
            }//fecha while
            //retorna Arraylist de produtos
            return prod;
        } catch (SQLException e) {                                             
            throw new SQLDataException("Erro ao buscar Produtos" + e.getMessage());
        } finally {
            // fecha conexão com o banco de dados
            con.close();
            stat.close();
        }//fecha finally
    }//fecha metodo buscar
    
    /**
     * Realiza a alteração com o banco de dados
     * @param p valor que será alterado no banco
     * @throws SQLException - caso a aconteça erro com o banco de dados
     */
    public void alterarProduto(ProdutoVO p) throws SQLException{
        //conexão com o banco de dados
        Connection con = ConexaoBanco.getConexao();
        Statement stat = con.createStatement();
        
        try {
            String sql;// query sql de update
            sql = "update produto set "
                    + "nome = '" +p.getNome()+"', "
                    + "preco = " +p.getPreço() +", "
                    + "imagem = '" + p.getEndereçoImagem()+"' "
                    + "where id = " + p.getId();
            
            stat.executeUpdate(sql); // execução da query
        } catch (SQLException se) {
            throw new SQLException("Erro ao alterar! " + se.getMessage());
        }finally{
            //Fecha a conexão com o banco de dados
            con.close();
            stat.close();
        }//fecha finally
    }//fecha alterar
}


