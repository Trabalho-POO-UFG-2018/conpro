package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import model.*;
import connection.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class CadastroNovaLoja extends JFrame{
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
    private javax.swing.JTextField bairroTextField;
    private javax.swing.JButton cadastrarNovaLoja;
    private javax.swing.JTextField cidadeTextField;
    private javax.swing.JTextField cnpjTextField;
    private javax.swing.JTextField estadoTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField razaoSocialTextField;
    private javax.swing.JTextField ruaTextField;
    private javax.swing.JPasswordField senhaTextField;
    
    
    //Inicia os componentes
    private void initComponents() {
        
        
        cnpjTextField = new javax.swing.JTextField();
        cnpjTextField.setName("cnpj");
        
        razaoSocialTextField = new javax.swing.JTextField();
        razaoSocialTextField.setName("razão social");
        
        senhaTextField = new javax.swing.JPasswordField();
        senhaTextField.setName("senha");
        
        ruaTextField = new javax.swing.JTextField();
        ruaTextField.setName("rua");
        
        bairroTextField = new javax.swing.JTextField();
        bairroTextField.setName("bairro");
        
        cidadeTextField = new javax.swing.JTextField();
        cidadeTextField.setName("cidade");
        
        estadoTextField = new javax.swing.JTextField();
        estadoTextField.setName("estado");
        
        
        cadastrarNovaLoja = new javax.swing.JButton();
        cadastrarNovaLoja.setBorder(new RoundedBorder(20));

        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                cnpjTextField.setText("");
                senhaTextField.setText("");
                ruaTextField.setText("");
                bairroTextField.setText("");
                estadoTextField.setText("");
                cidadeTextField.setText("");
                razaoSocialTextField.setText("");
                Login.getInstance().setVisible(true);
            }
        });
        setTitle("Cadastrar nova loja");
        
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("Digite o cnpj da empresa (somente números):");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("Informe a sua senha:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Informações sobre o endereço:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Rua:");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Bairro:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel6.setText("Cidade:");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Estado:");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setText("Informe a razão social:");

        cnpjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt){
                try{
                    cnpjTextFieldActionPerformed(evt);
                }catch(InvalidTextException e){
                    System.out.println(e.getMessage());
                } catch (CNPJException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        razaoSocialTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    razaoSocialTextFieldActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    System.out.println(ex.getMessage());
                } catch (CNPJException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        senhaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    senhaTextFieldActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    System.out.println(ex.getMessage());
                } catch (CNPJException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        ruaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    ruaTextFieldActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    System.out.println(ex.getMessage());
                } catch (CNPJException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        bairroTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    bairroTextFieldActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    System.out.println(ex.getMessage());
                } catch (CNPJException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        cidadeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cidadeTextFieldActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    System.out.println(ex.getMessage());
                } catch (CNPJException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        estadoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    estadoTextFieldActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    System.out.println(ex.getMessage());
                } catch (CNPJException ex) {
                
                }
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel9.setText("Cadastro");

        cadastrarNovaLoja.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        cadastrarNovaLoja.setText("Cadastrar");
        cadastrarNovaLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                    cadastrarNovaLojaActionPerformed(evt);
                }catch(InvalidTextException e){
                    System.out.println(e);
                } catch (CNPJException ex) {
                    System.out.println(ex);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(jLabel8)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(razaoSocialTextField)
                                .addComponent(cnpjTextField)
                                .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ruaTextField)
                                        .addComponent(bairroTextField)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel7))
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(cidadeTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(estadoTextField))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jLabel9))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(cadastrarNovaLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(razaoSocialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(cnpjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(5, 5, 5)
                .addComponent(ruaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bairroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(estadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrarNovaLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }
    
    
    //Eventos
    private void senhaTextFieldActionPerformed(java.awt.event.ActionEvent evt)throws InvalidTextException,CNPJException {                                               
        cadastrarNovaLojaActionPerformed(evt);
    }                                              

    private void razaoSocialTextFieldActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException,CNPJException{                                                     
        cadastrarNovaLojaActionPerformed(evt);
    }                                                    

    private void cnpjTextFieldActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException,CNPJException {                                              
        cadastrarNovaLojaActionPerformed(evt);
    }                                             

    private void ruaTextFieldActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException,CNPJException{                                             
        cadastrarNovaLojaActionPerformed(evt);
    }                                            

    private void bairroTextFieldActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException,CNPJException {                                                
        cadastrarNovaLojaActionPerformed(evt);
    }                                               
    
    private void cidadeTextFieldActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException,CNPJException {                                                
        cadastrarNovaLojaActionPerformed(evt);
    }                                               

    private void estadoTextFieldActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException,CNPJException {                                                
        cadastrarNovaLojaActionPerformed(evt);
    }                                               

    /**
    * Cadastra uma nova loja inserido esta no banco de dados
    * @param evt Evento que será acionado
    * @throws InvalidTextException e CNPJ Exception
    */
    private void cadastrarNovaLojaActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException,CNPJException{                                                  
        Endereco end;
        Loja loja;
        boolean flag = false;
        try{
            String razao_social = ControladorDeJanelas.getTextField(razaoSocialTextField);
            String cnpj = ControladorDeJanelas.getTextField(cnpjTextField);
            String rua = ControladorDeJanelas.getTextField(ruaTextField);
            String bairro = ControladorDeJanelas.getTextField(bairroTextField);
            String cidade = ControladorDeJanelas.getTextField(cidadeTextField);
            String estado = ControladorDeJanelas.getTextField(estadoTextField);
            String senha = ControladorDeJanelas.getTextField(senhaTextField);
            
            Loja.validarCNPJ(cnpj);
            
            end = new Endereco(rua,bairro,cidade,estado);
            loja = new Loja(razao_social,cnpj,senha,end);
            
            Cadastrar.createLoja(loja);
            flag = true;
      	}catch(CNPJException e){
            new GUIException(e.getMessage());
      	}catch(InvalidTextException e){
            new GUIException(e.getMessage());
        }
      	if(flag)
            JOptionPane.showMessageDialog(null, "Loja criada com sucesso!\nVocê já pode logar em sua conta", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            instancia.setVisible(false);
            Login.getInstance().setVisible(true);
    }
   
    /**
    * Pega os textos que estão presentes nos "Texts Fields"
    * @param textField TextField que será analisado a fim de retornar o texto presente nele
    * @return Retorna o texto presente no textfield analisado 
    */
    
}
