/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import modelo.ProdutoVO;
import servicos.ProdutoServicos;

/**
 * Tela de cadastro de produtos novos
 * @author Inatan
 */
public class NovoProdutoGUI extends javax.swing.JFrame {
    // padrões do imagem para a tela
    final private int TAMANHO_IMAGEM = 168;
    final private int LARGURA_IMAGEM = 333;
    // caso a imagem não seja colocada
    final private String MSG_ERRO = "Sem imagem";
    // regex que avalia se é valor decimal.
    final private String PADRÃO_DECIMAL = "[0-9]+|(([0-9]+)(\\.|,)([0-9]*))";

    /**
     * Creates new form EdiçãoGUI
     */
    public NovoProdutoGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtPreço = new javax.swing.JTextField();
        jlImagem = new javax.swing.JLabel();
        jtImagem = new javax.swing.JTextField();
        btnArquivo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nome do produto: ");

        jLabel2.setText("Preço: ");

        jlImagem.setToolTipText("");

        jtImagem.setEnabled(false);

        btnArquivo.setText("Arquivo");
        btnArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArquivoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtPreço, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnArquivo))
                            .addComponent(jlImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(btnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtPreço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnArquivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnConfirmar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        /**
     * Escolhe a imagem e coloca na tela de cadastro
     * @param evt
     */
    private void btnArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArquivoActionPerformed
        JFileChooser arquivoEscolhido = new JFileChooser(); 
        arquivoEscolhido.showOpenDialog(null); //seletor de arquivo
        //Se a escolha do arquivo foi cancelada nada acontece
        if (arquivoEscolhido.getSelectedFile() != null) {
            File arquivoImagem = arquivoEscolhido.getSelectedFile(); //arquivo
            String caminhoImagem = arquivoImagem.getAbsolutePath(); //caminho
            String mensagemErro = "";
            //filtro para avaliar se os arquivos são imagens
            if (!(caminhoImagem.toLowerCase().endsWith(".jpg"))
                    && !(caminhoImagem.toLowerCase().endsWith(".png"))
                    && !(caminhoImagem.toLowerCase().endsWith(".gif"))
                    && !(caminhoImagem.toLowerCase().endsWith(".tif"))) {
                JOptionPane.showMessageDialog(
                        rootPane,
                        "Formato de imagem inválido\n",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                // define caminho da imagem
                jtImagem.setText(caminhoImagem);
                // define imagem com largura e tamanho
                ImageIcon imagem = new ImageIcon(new ImageIcon(caminhoImagem, "Imagem do produto").getImage()
                        .getScaledInstance(LARGURA_IMAGEM, TAMANHO_IMAGEM, Image.SCALE_SMOOTH));
                if (imagem != null) {
                    //insere o ícone
                    jlImagem.setIcon(imagem);
                    jlImagem.setText("");
                } else {
                    // mantem tudo nulo
                    jlImagem.setText("");
                    jlImagem.setIcon(null);
                    JOptionPane.showMessageDialog(
                            rootPane,
                            "Erro ao abrir a imagem\n",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnArquivoActionPerformed
    /**
     * Botão que realiza o cadastro
     *
     * @param evt - evento e clicar com mouse
     */
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, 
                "Você tem certeza que deseja cadastrar esse produto?", 
                "Cadastro", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            cadastrar();
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed
    /**
     * Fecha janela e retora a tela de cadastros
     * @param evt 
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(NovoProdutoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoProdutoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoProdutoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoProdutoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoProdutoGUI().setVisible(true);
            }
        });
    }

    /**
     * Esse método serve para facilitar o cadastro quando uma nova imagem é
     * adicionada, o endereço é salvo em uma pasta específica, com o objetivo de
     * centralizar as imagens em um mesmo endereço para o banco de dados.
     *
     * @param origem, caminho do arquivo a ser copiado
     * @param destino, caminho do arquivo de cópia
     */
    private void copiarArquivo(String origem, String destino) {
        FileInputStream fluxoEntrada;
        FileOutputStream fluxoSaída;
        try {
            // criação dos arquivos
            File arquivoEntrada = new File(origem);
            File arquivoSaída = new File(destino);

            fluxoEntrada = new FileInputStream(arquivoEntrada);
            fluxoSaída = new FileOutputStream(arquivoSaída);

            byte[] buffer = new byte[1024];

            int tamanho;
            // cópia do arquivo sendo realizada
            while ((tamanho = fluxoEntrada.read(buffer)) > 0) {
                fluxoSaída.write(buffer, 0, tamanho);
            }
            // fecha os fluxos de dados
            fluxoEntrada.close();
            fluxoSaída.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Cadastra um novo produto no banco de dados
     */
    private void cadastrar() {

        String mensagemErro = "";
        // se o nome não é vazio.
        if (jtNome.getText().length() == 0) {
            mensagemErro += "O campo de nome está vazio\n";
        }
        // se o preço não foi digitado
        if (jtPreço.getText().length() == 0) {
            mensagemErro += "O campo de preço está vazio\n";
        } // uso de Regex para identificar se foi digitado realmente
        // um valor de preço
        else if (!Pattern.matches(PADRÃO_DECIMAL, jtPreço.getText())) {
            mensagemErro += "O campo de preço não está expresso em valor"
                    + " númerico positivo\n";
        }
        // se a imagems não foi adicionada
        if (jtImagem.getText().length() == 0) {
            mensagemErro += "A imagem não foi selecionada\n";
        }
        //caso não exista erros o cadasto é efetivamente iniciado
        if (mensagemErro == "") {
            String caminho = jtImagem.getText();
            // partes é utilizado para retirar o valor da extensão do arquivo
            String[] partes = caminho.split("\\.");
            // a partir disso o novoCaminho onde se encontrará a imagem será salvo
            String novoCaminho = "imagens/" + jtNome.getText().replace(' ', '_')
                    .toLowerCase() + "." + partes[partes.length - 1];
            copiarArquivo(jtImagem.getText(), novoCaminho); // a imagem é copiada
            // com um novo nome e novo caminho, para facilitar a sua gerencia
            // junto com o banco
            
            // O replace serve para permitir que seja colocado um valor correspondente
            ProdutoVO pVO = new ProdutoVO(0, jtNome.getText(),
                    Float.parseFloat(jtPreço.getText().replace(',', '.')), novoCaminho);

            //enviando produto pVO para o banco
            try {
                // serviço que faz interface entre o modelo e o banco de dados
                ProdutoServicos ps = servicos.ServicosFactory.getProdutoServicos();
                // é realizado o cadastro em nível do banco de dados
                ps.cadastarProduto(pVO);

                JOptionPane.showMessageDialog(
                        rootPane,
                        "Produto cadastrado com sucesso!");
                this.setVisible(false);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(
                        rootPane,
                        "Erro! " + e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }//fecha catch
        } else {
            JOptionPane.showMessageDialog(
                    rootPane,
                    mensagemErro,
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        } // fecha else

    }//fecha método cadastrar

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArquivo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jlImagem;
    private javax.swing.JTextField jtImagem;
    private javax.swing.JTextField jtNome;
    private javax.swing.JTextField jtPreço;
    // End of variables declaration//GEN-END:variables
}
