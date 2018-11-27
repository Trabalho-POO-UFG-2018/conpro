
package view.Empreededor;

import controller.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Loja;
import view.ControladorDeJanelas;
import view.Exceptions.GUIException;
import view.Exceptions.InvalidTextException;
import view.TelaInicial;

public class Login extends JFrame{
    
    //Instancia
    private static Login instancia;
    
    //Variáveis do JFrame
    private static javax.swing.JTextField cnpjLogin;
    private javax.swing.JButton criarNovaConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton login;
    private static javax.swing.JPasswordField senhaLogin;
    private javax.swing.JButton excluirLojaButton;
    
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
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        setResizable(false);

        login = new javax.swing.JButton();
        criarNovaConta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        excluirLojaButton = new javax.swing.JButton();
        excluirLojaButton.setText("Excluir loja");
        
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

        criarNovaConta.setText("Não tenho conta");
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
        
        excluirLojaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    excluirLojaButtonActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(cnpjLogin)
                            .addComponent(senhaLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(criarNovaConta, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(excluirLojaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cnpjLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(criarNovaConta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(excluirLojaButton)
                .addContainerGap(27, Short.MAX_VALUE))
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
            senhaDigitada = String.valueOf(ControladorDeJanelas.getTextField(senhaLogin).hashCode());
            isLoged = LoginDAO.checkLogin(cnpjDigitado, senhaDigitada);
        }catch(InvalidTextException e){
            new GUIException(e.getMessage());
        }
        
        //Caso obtenha sucesso em se logar, fecha a janela de login e abre a da plataforma
        if(isLoged){
            //Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Você se logou com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            //"Fechamento" da janela de login
            instancia.setVisible(false);
            instancia.senhaLogin.setText("");
            
            //Obtem a loja que foi logada
            loja = LojaDAO.obterLoja(cnpjDigitado);
            
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
    
    private void excluirLojaButtonActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException {                                         
        int sucess = 0;
        try{
            String cnpj = getCNPJ();
            String senha = String.valueOf(ControladorDeJanelas.getTextField(senhaLogin).hashCode());
            Loja loja = LojaDAO.obterLoja(getCNPJ());
            //Verifica se o cnpj e a senha informada é válida
            if(LoginDAO.checkLogin(cnpj, senha)){
                //Pergunta se o empreendedor quer realmente excluir a loja
                int a = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar a loja " +
                        loja.getRazaoSocial() + " ?", "Apagar loja ?",JOptionPane.YES_NO_OPTION);
                if(a == 0){
                    sucess = LojaDAO.deletarLoja(loja);
                }
                
                if(sucess == 1){
                    JOptionPane.showMessageDialog(null, "Loja excluída com sucesso", "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao excluir a loja", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Senha ou usuário inválidos", "Erro",
                            JOptionPane.ERROR_MESSAGE);
            }
        }catch(InvalidTextException e){
            new GUIException(e.getMessage());
        }
    }                                        
    
    //Outros métodos
    public static String getCNPJ() throws InvalidTextException{
        return ControladorDeJanelas.getTextField(cnpjLogin);
    }
    
    public static void clearPasswordField(){
        senhaLogin.setText("");
    }
    
}
