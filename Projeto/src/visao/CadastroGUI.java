package visao;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.CellEditor;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import modelo.ModeloTabela;
import modelo.ProdutoVO;
import servicos.ProdutoServicos;
import servicos.ServicosFactory;

/**
 * Tela que contem a tabela de todos os produtos
 *
 * @author Inatan
 */
public class CadastroGUI extends javax.swing.JFrame {

    //
    private final boolean flagNovoProdutoGUI = false;

    //padrões de alguta e largura para imagem na tabela
    private final int LARGURA_IMAGEM = 150;
    private final int TAMANHO_IMAGEM = 120;

    // localização dos valores na tabela 
    private final int NUMERO_COLUNAS = 3;
    private final int INDICE_NOME = 1;
    private final int INDICE_PREÇO = 2;
    private final int INDICE_IMAGEM = 0;

    // expressão regular para valor decimal positivo com duas casas
    private final String PADRÃO_DECIMAL = "[0-9]+|(([0-9]+)(\\.|,)([0-9]*))";
    // Todos os produtos adicionados na tabela
    private ArrayList<ProdutoVO> produtos;

    /**
     * Evento de alteração na tabela
     */
    private TableModelListener modeloEdição = new TableModelListener() {
        /**
         * Esse evento tem como objetivo atualizar a tabela e o banco de dados
         * caso um elemento seja editado. Apenas nome e preço podem ser editados
         * e ambos os valores tem critérios apra que a edição seja aceita, caso
         * contrário mensagens de erro serão apresentadas
         *
         * @param e
         */
        public void tableChanged(TableModelEvent e) {
            int linha = e.getFirstRow(); // linha onde está o valor
            int coluna = e.getColumn(); // coluna de onde está o valor
            // valor do nome editado
            String novoNome = (String) jtableProduto.getModel().getValueAt(linha, INDICE_NOME);
            // valor do preço editado
            String novoPreço = (String) jtableProduto.getModel().getValueAt(linha, INDICE_PREÇO);
            String mensagemErro = "";
            // esse evento só executa somente se o evente é uma atualização da tabela
            if (TableModelEvent.UPDATE == e.getType()) {
                if (coluna == INDICE_NOME) { // caso o valor editado seja o nome
                    if (novoNome.length() == 0) // nome não pode ser nulo
                    {
                        mensagemErro += "O nome do produto da linha " + (linha + 1)
                                + " está vazio";
                    } else {
                        // atualiza o nome do produto
                        produtos.get(linha).setNome(novoNome);
                    }
                } else // caso o valor editado seja o preço
                if (novoPreço.length() == 0) // preço não pode ser nulo
                {
                    mensagemErro += "O preço do produto da linha " + (linha + 1)
                            + " está vazio";
                } // preço deve ser expresso em valor númerico positivo
                else if (!Pattern.matches(PADRÃO_DECIMAL, novoPreço)) {
                    mensagemErro += "O preço produto da linha " + (linha + 1)
                            + " está em um formato não decimal";
                } else {
                    // atualiza o nome do produto
                    produtos.get(linha).setPreço(Float.parseFloat(novoPreço));
                }
                // caso não exista erros é realizada a alteração no banco de dados
                if (mensagemErro == "") {
                    Alterar(linha);
                } else { // casa exista erros todos são expressos em uma caixa de texto
                    JOptionPane.showMessageDialog(
                            rootPane,
                            mensagemErro,
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
            try { // a tabela é preenchida novamente
                preencherTabela();
            } catch (SQLException ex) {
                Logger.getLogger(CadastroGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    /**
     * Creates new form CadastroGUI
     */
    public CadastroGUI() throws SQLException {
        initComponents();
        preencherTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        btnNovoProduto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Produtos");

        btnNovoProduto.setText("Novo Produto");
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });

        jtableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Imagem", "Nome", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ObjectProperty.create(), jtableProduto, org.jdesktop.beansbinding.BeanProperty.create("elements"));
        bindingGroup.addBinding(binding);
        binding.bind();
        jScrollPane1.setViewportView(jtableProduto);
        if (jtableProduto.getColumnModel().getColumnCount() > 0) {
            jtableProduto.getColumnModel().getColumn(0).setResizable(false);
            jtableProduto.getColumnModel().getColumn(1).setResizable(false);
            jtableProduto.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNovoProduto))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnNovoProduto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**
     * Abre a tela de cadastro de um produto novo, é utilizado um Dialog modal
     * para abrir a tela de produto novo.
     *
     * @param evt - evento de clique
     */
    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        NovoProdutoGUI npg = new NovoProdutoGUI();
        JDialog d = new JDialog(npg, "Novo Produto", true);
        d.setModal(true); // forma modal
        d.getContentPane().add(npg.getContentPane()); // pega o conteudo da tela
        d.pack();
        d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // modo de fechar
        d.setLocationRelativeTo(npg); // localização
        d.setResizable(false);
        d.setVisible(true);
        
        try {
            preencherTabela(); // após isso a tabela é preenchida novamente em
            // caso de atualização
        } catch (SQLException ex) {
            Logger.getLogger(CadastroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadastroGUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CadastroGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * Consulta todo o banco de dados e atualiza a tabela com os produtos
     * presentes
     *
     * @throws SQLException
     */
    private void preencherTabela() throws SQLException {
        try {
            ProdutoServicos ps = ServicosFactory.getProdutoServicos();

            /*ArrayList<VO> vazio
             para receber o ArrayList com os dados */
            produtos = new ArrayList<>();
            // formato para 2 casas decimais
            DecimalFormat formatoDecimal = new DecimalFormat("#.00");
            produtos = ps.buscarProduto(); // consulta no banco de dados
            String[] cabeçalhos = {"Imagem", "Nome", "Preço"}; // colunas da tabela
            Object[][] linhas = new Object[produtos.size()][NUMERO_COLUNAS]; // valores
            ModeloTabela modelo = new ModeloTabela(cabeçalhos, linhas); // modelo definido

            // é passado os valores de cada elemento dos produtos para a tabela
            // é inserida a imagem do produto
            // preço é alterado para duas casas decimaais
            for (int i = 0; i < produtos.size(); i++) {
                linhas[i][INDICE_NOME] = produtos.get(i).getNome();  //nome
                linhas[i][INDICE_PREÇO] = formatoDecimal.format(produtos.get(i).getPreço());
                if (produtos.get(i).getEndereçoImagem() != null) {
                    // imagem sendo adicionada com o tamanho e largura pré definidos
                    ImageIcon image = new ImageIcon(new ImageIcon(produtos.get(i)
                            .getEndereçoImagem()).getImage()
                            .getScaledInstance(LARGURA_IMAGEM, TAMANHO_IMAGEM, Image.SCALE_SMOOTH));
                    linhas[i][INDICE_IMAGEM] = image;
                } else {
                    linhas[i][INDICE_IMAGEM] = null; // caso a imagem não exista
                }
            }//fecha for
            /* Adicionando o modelo de tabela 
             com os dados na tabela */
            DefaultTableCellRenderer alinhamentoCentro = new DefaultTableCellRenderer();
            // detalhe para alinhar todos os elementos nos centros da coluna
            alinhamentoCentro.setHorizontalAlignment(JLabel.CENTER);
            modelo.addTableModelListener(modeloEdição);
            jtableProduto.setModel(modelo);
            jtableProduto.setRowHeight(TAMANHO_IMAGEM); // tamanho da linha
            // tamanho da imagem dentro da tabela
            jtableProduto.getColumnModel().getColumn(INDICE_IMAGEM).setPreferredWidth(LARGURA_IMAGEM);
            // Preço é centralizado para ficar visualmente mais agradável
            jtableProduto.getColumnModel().getColumn(INDICE_PREÇO).setCellRenderer(alinhamentoCentro);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro! " + e.getMessage());
        }//fecha catch
    }//fecha preencher Tabela

    private void Alterar(int linha) {
        ProdutoServicos ps = ServicosFactory.getProdutoServicos();
        try {
            ps.alterarProduto(produtos.get(linha)); // execução com o banco de 
            // dados dos valores de produtos atualizados
            JOptionPane.showMessageDialog(rootPane,
                    "Alterada com Sucesso! ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro!" + e.getMessage());
        }//fecha catch
    }//fecha confirar Alteracao


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableProduto;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
