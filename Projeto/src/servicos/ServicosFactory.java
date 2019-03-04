package servicos;

/**
 * Factory que além de produto permite mais objetos a serem trabalhados
 * @author Inatan
 */
public class ServicosFactory {
    private static ProdutoServicos produtoServicos = new ProdutoServicos();
    
    public static ProdutoServicos getProdutoServicos() {
        return produtoServicos;          
    }//fecha produto serviços
}
