package dao;

/**
 * Factory de DAO que a tem produtos, mas pode ter futuramente outras classes
 * @author Inatan
 */
public class DAOFactory {
    private static final ProdutoDAO pDAO = new ProdutoDAO();
    public static ProdutoDAO getProdutoDAO() {
        return pDAO;
    }
}
