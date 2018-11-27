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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.Loja;
import model.Produto;
import view.ControladorDeJanelas;
import view.Exceptions.InvalidTextException;

public class ConsultaProdutos extends JFrame{
    //Instancia
    private static ConsultaProdutos instancia;

    //Singleton
    private ConsultaProdutos(){
        initComponents();
    }
    
    public static ConsultaProdutos getInstance(){
        if(instancia == null)
            instancia = new ConsultaProdutos();
        return instancia;
    }
    
    //Eventos
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException, SQLException {                                         
        Loja loja = LojaDAO.obterLoja(Login.getCNPJ());
        String nome_produto = ControladorDeJanelas.getSelectedText(jTable1);
        
        if(nome_produto != null){
            
            ProdutoDAO.deletarProduto(loja.getId(), ProdutoDAO.codigoProduto(nome_produto));

            loja.preencherProdutos();

            ControladorDeJanelas.clearRows(jTable1);
            ControladorDeJanelas.fillTableEmpreendedor(jTable1, loja.getProdutos());
        }else{
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado\n Por favor selecione um produto", "Erro", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    private void alterarProdutoButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        if(ControladorDeJanelas.getSelectedText(jTable1) == null){
            JOptionPane.showMessageDialog(null, "Nenhum produto selecionado\n Por favor selecione um produto", "Erro", 
                    JOptionPane.INFORMATION_MESSAGE);
        }else{
            AlterarProduto.getInstance().setVisible(true);
            instancia.setVisible(false);
        }
        
    }
    
    //Inicia os componentes do JFrame                         
    private void initComponents() {
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        
        setResizable(false);

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        deleteButton = new JButton();
        
        deleteButton.setText("Deletar Produto");
        
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                deleteButtonActionPerformed(evt);
            } catch (InvalidTextException ex) {
                Logger.getLogger(ConsultaProdutos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultaProdutos.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        });
        
        alterarProdutoButton = new JButton();

        alterarProdutoButton.setText("Alterar Produto");
        alterarProdutoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarProdutoButtonActionPerformed(evt);
            }
        });
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                Plataforma.getInstance().setVisible(true);
                instancia.setVisible(false);
            }
        });
        
        setTitle("Produtos cadastrados");
        jLabel1.setText("Seus produtos:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome:", "Quantidade:", "Preco:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(alterarProdutoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alterarProdutoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        pack();

    }
    
    //Variáveis do JFrame
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton alterarProdutoButton;
    //Métodos
    
    public JTable getJTable(){
        return jTable1;
    }
}
    

