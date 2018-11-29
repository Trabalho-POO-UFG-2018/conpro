package view.Empreededor;

import controller.LojaDAO;
import controller.ProdutoDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Loja;
import model.Produto;
import view.ControladorDeJanelas;
import view.Exceptions.GUIException;
import view.Exceptions.InvalidTextException;

public class AlterarProduto extends JFrame{
    //Instancia
    private static AlterarProduto instancia;
    
    //Singleton
    private AlterarProduto(){
        initComponents();
    }
    
    public static AlterarProduto getInstance(){
        if(instancia == null){
            instancia = new AlterarProduto();
        }
        
        return instancia;
    }
    
    //Eventos
    private void newQuantidadeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
        alterarButtonActionPerformed(evt);
    }                                           

    private void newPriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                            
        alterarButtonActionPerformed(evt);
    }                                           

    private void alterarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Loja loja;
        Produto novo_produto;
        String nome_produto;
        int nova_quantidade;
        double novo_preco;
        
        
        try{
            loja = LojaDAO.obterLoja(Login.getCNPJ());
            nova_quantidade = Integer.parseInt(ControladorDeJanelas.getTextField(newQuantidadeTextField));
            novo_preco = Double.parseDouble(ControladorDeJanelas.getTextField(newPriceTextField));
            nome_produto = ControladorDeJanelas.getSelectedText(ConsultaProdutos.getInstance().getJTable());
            
            novo_produto = new Produto(nome_produto,nova_quantidade,novo_preco);
            novo_produto.setCodigo(ProdutoDAO.codigoProduto(nome_produto));
            
            ProdutoDAO.alterarProduto(loja, novo_produto);
        }catch(InvalidTextException e){
            new GUIException(e.getMessage());
            return ;
        }
        
        JOptionPane.showMessageDialog(null, "Produto alterado com sucesso", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        Loja l = null;
        try {
            l = LojaDAO.obterLoja(Login.getCNPJ());
            l.preencherProdutos();
            ControladorDeJanelas.clearRows(ConsultaProdutos.getInstance().getJTable());
            ControladorDeJanelas.fillTableEmpreendedor(ConsultaProdutos.getInstance().getJTable(), l.getProdutos());
        } catch (InvalidTextException ex) {
            Logger.getLogger(AlterarProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AlterarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ConsultaProdutos.getInstance().setVisible(true);
        instancia.setVisible(false);
    }                            
    
    
    //Variáveis do JFrame
    private javax.swing.JButton alterarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField newQuantidadeTextField;
    private javax.swing.JTextField newPriceTextField;
    
    //Inicia os componentes
    private void initComponents() {

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        
        jLabel1 = new javax.swing.JLabel();
        newQuantidadeTextField = new javax.swing.JTextField();
        newQuantidadeTextField.setName("quantidade");
        
        jLabel2 = new javax.swing.JLabel();
        newPriceTextField = new javax.swing.JTextField();
        newPriceTextField.setName("preco");
        alterarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alterar produto");
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                //Obtem a loja e preenche ela com os produtos
                Loja l = null;
                try {
                    l = LojaDAO.obterLoja(Login.getCNPJ());
                    l.preencherProdutos();
                    ControladorDeJanelas.clearRows(ConsultaProdutos.getInstance().getJTable());
                    ControladorDeJanelas.fillTableEmpreendedor(ConsultaProdutos.getInstance().getJTable(), l.getProdutos());
                } catch (InvalidTextException ex) {
                    Logger.getLogger(AlterarProduto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AlterarProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                ConsultaProdutos.getInstance().setVisible(true);
                instancia.setVisible(false);
                
                newPriceTextField.setText("");
                newQuantidadeTextField.setText("");
            }
        });

        jLabel1.setText("Digite o novo preço:");

        newQuantidadeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newQuantidadeTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Digite a nova quantidade:");

        newPriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPriceTextFieldActionPerformed(evt);
            }
        });

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(newQuantidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(alterarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newQuantidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alterarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }
}
