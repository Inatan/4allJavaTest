package servicos;

import dao.DAOFactory;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ProdutoVO;


/**
 * Serviços entre o VO do produto e o seu DAO
 * @author Inatan
 */
public class ProdutoServicos {
    // interface que realiza cadastro do banco de dados
    public void cadastarProduto(ProdutoVO pVO) throws SQLException {
        ProdutoDAO pDAO = DAOFactory.getProdutoDAO();
        pDAO.cadastarProduto(pVO);
    }//fecha cadastrar

    // interface que realiza a busca no banco de dados
    public ArrayList<ProdutoVO> buscarProduto() throws SQLException {
        ProdutoDAO pDAO = DAOFactory.getProdutoDAO();
        return pDAO.buscarProduto();

    }//fecha buscar   
    
    //interface que realiza a alterçao para o banco de dados
    public void alterarProduto(ProdutoVO prod) throws SQLException {
        ProdutoDAO pDAO = DAOFactory.getProdutoDAO();
            pDAO.alterarProduto(prod);
    }//fecha metodo
}
