
package view;

import connection.Cadastrar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Loja;

public class Login extends JFrame{
    
    //Instancia
    private static Login instancia;
    
    //Variáveis do JFrame
    private javax.swing.JTextField cnpjLogin;
    private javax.swing.JButton criarNovaConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField senhaLogin;
    
    //Singleton
    public static Login getInstance(){
        if(instancia == null){
            instancia = new Login();
        }
        return instancia;
    }

    
    //Construtor
    private Login(){
        initComponents();
    }
    
    //Inicia os componentes da tela
    private void initComponents() {

        login = new javax.swing.JButton();
        criarNovaConta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        
        senhaLogin = new javax.swing.JPasswordField();
        senhaLogin.setName("senha");
        
        cnpjLogin = new javax.swing.JTextField();
        cnpjLogin.setName("cnpj");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                TelaInicial.getInstance().setVisible(true);
            }
        });
        
        setTitle("Login");
        setMaximumSize(new java.awt.Dimension(554, 395));

        login.setText("Entrar");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    loginActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    System.out.println(ex);
                }
            }
        });

        criarNovaConta.setText("Ainda não tenho conta");
        criarNovaConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarNovaContaActionPerformed(evt);
            }
        });

        jLabel1.setText("CNPJ:");

        jLabel2.setText("Senha:");

        senhaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    senhaLoginActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        cnpjLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cnpjLoginActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addComponent(senhaLogin)
                                .addComponent(jLabel1)
                                .addComponent(cnpjLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                            .addGap(134, 134, 134))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(109, 109, 109)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(criarNovaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cnpjLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(criarNovaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }

    //Eventos
    private void senhaLoginActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException{                                           
        loginActionPerformed(evt);
    }                                          

    private void loginActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException{                                      
        boolean isLoged = false;
        String cnpjDigitado = "";
        String senhaDigitada;
        Loja loja;
        Plataforma platform;
        
        //Tenta capturar o cnpj e senha dos textfield e validá-los
        try{
            cnpjDigitado = ControladorDeJanelas.getTextField(cnpjLogin);    
            senhaDigitada = ControladorDeJanelas.getTextField(senhaLogin);
            isLoged = Cadastrar.checkLogin(cnpjDigitado, senhaDigitada);
        }catch(InvalidTextException e){
            new GUIException(e.getMessage());
        }
        
        //Caso obtenha sucesso em se logar, fecha a janela de login e abre a da plataforma
        if(isLoged){
            //Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Você se logou com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            //"Fechamento" da janela de login
            instancia.setVisible(false);
            
            //Obtem a loja que foi logada
            loja = Cadastrar.obterLoja(cnpjDigitado);
            
            //Coloca a janela da plataforma visível
            platform = Plataforma.getInstance();
            platform.setVisible(true);
            platform.setTextNomeLoja(loja.getRazaoSocial());
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Usuário ou senha inválidos!\n Por favor, tente novamente.", "Erro",JOptionPane.ERROR_MESSAGE);
        }
    }                                     

    private void cnpjLoginActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException {                                          
        loginActionPerformed(evt);
    }                                         

    private void criarNovaContaActionPerformed(java.awt.event.ActionEvent evt) {                                               
        CadastroNovaLoja cnl = CadastroNovaLoja.getInstance();
        cnl.setVisible(true);
        this.setVisible(false);
    }
    
}
