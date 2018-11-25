/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Cliente;

import view.Cliente.ClienteConsultaEspecifica;
import view.Cliente.ClienteConsultaGeral;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import view.TelaInicial;

/**
 *
 * @author matheus
 */
public class PonteCliente extends JFrame{
    //Instancia Singleton
    private static PonteCliente instancia;
    
    //Singleton
    private PonteCliente(){
        initComponents();
    }
    
    public static PonteCliente getInstance(){
        if(instancia == null)
            instancia = new PonteCliente();
        return instancia;
    }
    
    //Variáveis JFrame
    private javax.swing.JButton consultaGeral;
    private javax.swing.JButton consultaEspecifica;
    
    
    //Eventos
    private void consultaGeralActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ClienteConsultaGeral.getInstance().setVisible(true);
        instancia.setVisible(false);
    }                                        

    private void consultaEspecificaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        ClienteConsultaEspecifica.getInstance().setVisible(true);
        instancia.setVisible(false);
    }     
    
    //Inicia os componentes                     
    private void initComponents() {

        consultaGeral = new javax.swing.JButton();
        consultaEspecifica = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                TelaInicial.getInstance().setVisible(true);
            }
        });
        setTitle("Qual tipo de busca?");

        consultaGeral.setText("Consulta geral");
        consultaGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaGeralActionPerformed(evt);
            }
        });

        consultaEspecifica.setText("Consulta Específica");
        consultaEspecifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaEspecificaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(consultaEspecifica, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(consultaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(consultaEspecifica, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        pack();
    }
}
