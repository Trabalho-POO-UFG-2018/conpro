package view;

import connection.Cadastrar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Endereco;
import model.Loja;

public class AlterarLoja extends JFrame{
    //Variáveis do JFrame
    private javax.swing.JButton changeButton;
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField newCity;
    private javax.swing.JTextField newNeighbour;
    private javax.swing.JPasswordField newPassword;
    private javax.swing.JTextField newState;
    private javax.swing.JTextField newStreet;
    
    //Instancia
    private static AlterarLoja instancia;

    //Singleton
    private AlterarLoja(){
        initComponents();
    }
    
    public static AlterarLoja getInstance(){
        if(instancia == null)
            instancia = new AlterarLoja();
        return instancia;
    }
    
    //Eventos
    private void newPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                            
    }                                           

    private void confirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {                                                
    }                                               

    private void newStreetActionPerformed(java.awt.event.ActionEvent evt) {                                          
    }                                         

    private void newNeighbourActionPerformed(java.awt.event.ActionEvent evt) {                                             
    }                                            

    private void newCityActionPerformed(java.awt.event.ActionEvent evt) {                                        
    }                                       

    private void newStateActionPerformed(java.awt.event.ActionEvent evt) {                                         
    }                                        

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException {                                             
        Loja loja = Cadastrar.obterLoja(Login.getCNPJ());
        Endereco end;
        boolean flag = false;
        
        String novaSenha;
        String confirmSenha;
        String novaRua;
        String novoBairro;
        String novaCidade;
        String novoEstado;
        
        try{
            novaSenha = ControladorDeJanelas.getTextField(newPassword);
            confirmSenha = ControladorDeJanelas.getTextField(confirmPassword);
            novoBairro = ControladorDeJanelas.getTextField(newNeighbour);
            novaCidade = ControladorDeJanelas.getTextField(newCity);
            novoEstado = ControladorDeJanelas.getTextField(newState);
            novaRua = ControladorDeJanelas.getTextField(newStreet);
            
            end = new Endereco(novaRua, novoBairro, novaCidade, novoEstado);
            
            novaSenha = String.valueOf(novaSenha.hashCode());
            confirmSenha = String.valueOf(confirmSenha.hashCode());
            
            if(novaSenha.compareTo(confirmSenha) == 0){
                loja.setEndereco(end);
                loja.setSenha(novaSenha);

                Cadastrar.alterarLoja(loja);

                flag = true;
            }else{
                JOptionPane.showMessageDialog(null, "A senha digitada não corresponde com a confirmação", 
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
        }catch(InvalidTextException e){
            new GUIException(e.getMessage());
        }
        
        if(flag){
            JOptionPane.showMessageDialog(null, "Dados da loja alterados com sucesso", 
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
            instancia.setVisible(false);
            Plataforma.getInstance().setVisible(true);
            
            newPassword.setText("");
            confirmPassword.setText("");
            newStreet.setText("");
            newNeighbour.setText("");
            newCity.setText("");
            newState.setText("");
        }
    }
    
    //Inicia os componentes                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        
        newPassword = new javax.swing.JPasswordField();
        newPassword.setName("nova senha");
        
        confirmPassword = new javax.swing.JPasswordField();
        confirmPassword.setName("confirme a senha");
        
        newNeighbour = new javax.swing.JTextField();
        newNeighbour.setName("novo bairro");
        
        newStreet = new javax.swing.JTextField();
        newStreet.setName("nova rua");
        
        newState = new javax.swing.JTextField();
        newState.setName("novo estado");
        
        newCity = new javax.swing.JTextField();
        newCity.setName("nova cidade");
        
        changeButton = new javax.swing.JButton();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                Alterar.getInstance().setVisible(true);
            }
        });
        setTitle("Alterar Loja");

        newPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordActionPerformed(evt);
            }
        });

        jLabel1.setText("Rua:");

        jLabel2.setText("Confirme a senha:");

        confirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordActionPerformed(evt);
            }
        });

        jLabel3.setText("Nova senha:");

        newNeighbour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newNeighbourActionPerformed(evt);
            }
        });

        jLabel4.setText("Bairro:");

        newStreet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStreetActionPerformed(evt);
            }
        });

        jLabel5.setText("Cidade:");

        jLabel6.setText("Estado:");

        newState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStateActionPerformed(evt);
            }
        });

        newCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCityActionPerformed(evt);
            }
        });

        changeButton.setText("Alterar");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    changeButtonActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    Logger.getLogger(AlterarLoja.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(newPassword)
                            .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(newStreet)
                        .addComponent(newNeighbour)
                        .addComponent(newCity)
                        .addComponent(newState, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newNeighbour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(changeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }
}
