package modelo;

/**
 * Classe que contem o modelo do produto
 * @author Inatan
 */
public class ProdutoVO {

    
    private int id; // id do banco para controlar atualizações
    private String nome;
    private float preço;
    private String endereçoImagem; // a imagem é salva em uma pasta e o banco de 
    // dados só guarda o endereço dessa imagem para abri-la em tempo de execução

    //construtor
    public ProdutoVO() {
    }

    //construtor
    public ProdutoVO(int id, String nome, float preço, String endereçoImagem) {
        this.id=id;
        this.nome = nome;
        this.preço = preço;
        this.endereçoImagem = endereçoImagem;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public float getPreço() {
        return preço;
    }

    public String getEndereçoImagem() {
        return endereçoImagem;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreço(float preço) {
        this.preço = preço;
    }

        
    
    
    
}
