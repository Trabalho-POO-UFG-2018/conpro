package view;

import javax.swing.JFrame;
import javax.swing.JLabel;

public final class Plataforma extends JFrame{
    //Instância do Singleton
    private static Plataforma instance;
    
    //Variáveis do JFrame
    private javax.swing.JButton adicionarProduto;
    private javax.swing.JButton alterarProduto;
    private javax.swing.JButton consultarProduto;
    private javax.swing.JLabel nomeLojaJLabel;
    
    //Construtor
    private Plataforma(){
        initComponents();
    }
    
    //Singleton
    public static Plataforma getInstance(){
        if(instance == null)
            instance = new Plataforma();
        
        return instance;    
    }
    
    
    //Eventos
    private void alterarProdutoActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void adicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void consultarProdutoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }
    
    //Inicialização dos componentes
    private void initComponents() {

        nomeLojaJLabel = new javax.swing.JLabel();
        adicionarProduto = new javax.swing.JButton();
        alterarProduto = new javax.swing.JButton();
        consultarProduto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plataforma");

        nomeLojaJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        nomeLojaJLabel.setText("");

        adicionarProduto.setText("Adicionar Produto");
        adicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarProdutoActionPerformed(evt);
            }
        });

        alterarProduto.setText("Alterar Produto");
        alterarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarProdutoActionPerformed(evt);
            }
        });

        consultarProduto.setText("Consultar Produto");
        consultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alterarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(nomeLojaJLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomeLojaJLabel)
                .addGap(58, 58, 58)
                .addComponent(alterarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(adicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(consultarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }
    
    
    //Setter
    public void setTextNomeLoja(String nomeDaLoja) {
        this.nomeLojaJLabel.setText(nomeDaLoja);
    }
}
