/*
* TODO
* Tratar a entrada do CNPJ no método de cadastrar nova loja
*/

package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import model.*;

final class CadastroNovaLoja extends JFrame{
    //Instância do Singleton
    private static CadastroNovaLoja instancia;
    
    //Construtor
    private CadastroNovaLoja(){
        initComponents();
    }
    
    public static CadastroNovaLoja getInstance(){
        if(instancia == null){
            instancia = new CadastroNovaLoja();
        }
        
        return instancia;
    }
    
    
    //Variáveis do JFrame
    private javax.swing.JTextField bairro_TextField;
    private javax.swing.JButton cadastrar_nova_loja;
    private javax.swing.JTextField cidade_TextField;
    private javax.swing.JTextField cnpj_TextField;
    private javax.swing.JTextField estado_TextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField razao_social_TextField;
    private javax.swing.JTextField rua_TextField;
    
    
    //Inicia os componentes
    private void initComponents() {

        rua_TextField = new javax.swing.JTextField();
        rua_TextField.setName("rua");
        
        razao_social_TextField = new javax.swing.JTextField();
        razao_social_TextField.setName("razão social");

        bairro_TextField = new javax.swing.JTextField();
        bairro_TextField.setName("bairro");

        estado_TextField = new javax.swing.JTextField();
		estado_TextField.setName("estado");        
        
        cidade_TextField = new javax.swing.JTextField();
        cidade_TextField.setName("cidade");

        cnpj_TextField = new javax.swing.JTextField();
        cnpj_TextField.setName("cnpj");

        cadastrar_nova_loja = new javax.swing.JButton();
        cadastrar_nova_loja.setBorder(new RoundedBorder(20));
        
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        
        

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                Login.getInstance().setVisible(true);
            }
        });
        setTitle("Cadastrar nova loja");
        setMaximumSize(new java.awt.Dimension(554, 395));
        
        cadastrar_nova_loja.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                try{
                    cadastrar_nova_loja_ActionPerformed(evt);
                }catch(InvalidTextException e){
                    System.out.println(e);
                } catch (CNPJException ex) {
                    System.out.println(ex);
                }
            }
        });
        
        rua_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rua_TextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Informe a razão social:");

        razao_social_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                razao_social_TextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Informações relacionadas ao endereço:");

        jLabel3.setText("Rua:");

        jLabel4.setText("Bairro:");

        bairro_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bairro_TextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Cidade:");

        estado_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estado_TextFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado:");

        cidade_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidade_TextFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Informe o CNPJ da loja:");

        cnpj_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnpj_TextFieldActionPerformed(evt);
            }
        });

        cadastrar_nova_loja.setText("Cadastrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cnpj_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(rua_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(bairro_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(estado_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(cidade_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(razao_social_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(cadastrar_nova_loja, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(razao_social_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cnpj_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rua_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bairro_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cidade_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estado_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrar_nova_loja, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
    
    
    //Eventos
    private void rua_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
    }                                             

    private void razao_social_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void bairro_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void estado_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void cidade_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void cnpj_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }
    
    private void cadastrar_nova_loja_ActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException,CNPJException{
        Endereco end;
        Loja loja;
        String razao_social = getTextField(razao_social_TextField);
        String cnpj = getTextField(cnpj_TextField);
       	String rua = getTextField(rua_TextField);
      	String bairro = getTextField(bairro_TextField);
      	String cidade = getTextField(cidade_TextField);
      	String estado = getTextField(estado_TextField);

      	try{
            Loja.validarCNPJ(cnpj);
      	}catch(CNPJException e){
            System.out.println(e.getMessage());
      	}
      	end = new Endereco(rua,bairro,cidade,estado);
      	loja = new Loja(razao_social,cnpj,end);
    }
    
    private String getTextField(JTextField textField) throws InvalidTextException{
        if(textField.getText().length() == 0){
            throw new InvalidTextException("O nome da " + textField.getName() + " não pode ser vazio");
        }
        
        return textField.getText();
    }
}
