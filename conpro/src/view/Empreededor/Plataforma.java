package view.Empreededor;

import controller.LojaDAO;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Empreededor.AdicionarProduto;
import view.Empreededor.Alterar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import model.Loja;
import view.ControladorDeJanelas;
import view.Exceptions.InvalidTextException;

public final class Plataforma extends JFrame{
    //Instância do Singleton
    private static Plataforma instance;
    
    //Variáveis do JFrame
    private javax.swing.JButton adicionarProduto;
    private javax.swing.JButton alterar;
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
    private void alterarActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException, SQLException {                                               
//        Loja l = LojaDAO.obterLoja(Login.getCNPJ());
//        l.preencherProdutos();
//        ControladorDeJanelas.fillTableEmpreendedor(ConsultaProdutos.getInstance().getJTable(),l.getProdutos());
        AlterarLoja.getInstance().setVisible(true);
        instance.setVisible(false);
    }                                              

    private void adicionarProdutoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        AdicionarProduto.getInstance().setVisible(true);
        Plataforma.getInstance().setVisible(false);
    }                                                

    private void consultarProdutoActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException, SQLException {                                                 
        Loja l = LojaDAO.obterLoja(Login.getCNPJ());
        try{
            ControladorDeJanelas.clearRows(ConsultaProdutos.getInstance().getJTable());
            l.preencherProdutos();
            ControladorDeJanelas.fillTableEmpreendedor(ConsultaProdutos.getInstance().getJTable(),l.getProdutos());
            ConsultaProdutos.getInstance().setVisible(true);
        }catch(SQLException e){
            e.printStackTrace();
        }
        instance.setVisible(false);
    }
    
    //Inicialização dos componentes
    private void initComponents() {
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        

        nomeLojaJLabel = new javax.swing.JLabel();
        adicionarProduto = new javax.swing.JButton();
        alterar = new javax.swing.JButton();
        consultarProduto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                Login.getInstance().setVisible(true);
                instance.setVisible(false);
            }
        });
        setTitle("Plataforma");
        
        nomeLojaJLabel.setText("");
        nomeLojaJLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        
        
        adicionarProduto.setText("Adicionar Produto");
        adicionarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarProdutoActionPerformed(evt);
            }
        });

        alterar.setText("Alterar dados da loja");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    alterarActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    Logger.getLogger(Plataforma.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Plataforma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        consultarProduto.setText("Consultar Produto");
        consultarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    consultarProdutoActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    Logger.getLogger(Plataforma.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Plataforma.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(consultarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(adicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nomeLojaJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nomeLojaJLabel)
                .addGap(58, 58, 58)
                .addComponent(alterar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        instance.setTitle(nomeDaLoja);
    }
}
