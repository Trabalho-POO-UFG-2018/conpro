package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.border.Border;
import javax.swing.*;


public final class TelaInicial extends JFrame{
    
    private static TelaInicial instancia;
    private Login telaLogin;
    
    
    private TelaInicial(){
        initComponents();
    }
    
    //Singleton
    public static TelaInicial getInstance(){
        if(instancia == null)
            instancia = new TelaInicial();
        return instancia;    
    }
    
    //Inicia a janela conforme foi configurada
    private void initComponents(){

        loja = new javax.swing.JButton();
        cliente = new javax.swing.JButton();
        
        
        //Controla o fechamento da janela
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        setTitle("Inicio");
        setMinimumSize(new Dimension(500,500));

        loja.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        loja.setText("Sou empreendor");
        loja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lojaActionPerformed(evt);
            }
        });
        loja.setBorder(new RoundedBorder(20));
        

        cliente.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        cliente.setText("Sou cliente");
        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });
        cliente.setBorder(new RoundedBorder(20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(loja, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addGap(145, 145, 145))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(165, 165, 165)
                    .addComponent(cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addGap(145, 145, 145)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(loja, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(106, 106, 106))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(cliente, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                    .addGap(269, 269, 269)))
        );
       
        pack();
    }
    
    //Eventos
    private void lojaActionPerformed(java.awt.event.ActionEvent evt) {                                     
        telaLogin = Login.getInstance();
        telaLogin.setVisible(true);
        this.setVisible(false);
    }
    
    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
    }
    
    //Variáveis do JFrame;
    private javax.swing.JButton cliente;
    private javax.swing.JButton loja;
    
    //Outro métodos
    
    
   
}
