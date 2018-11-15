package view;


import connection.Cadastrar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import model.Loja;
import model.Produto;

public class AdicionarProduto extends JFrame{
    //Instância
    private static AdicionarProduto instancia;
    
    //Variáveis
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nomeProdutoTextField;
    private javax.swing.JTextField precoTextField;
    private javax.swing.JSlider quantidadeSlider;
    private javax.swing.JLabel valorSlider;
    private javax.swing.JButton cadastrarNovoProdutoButton;
    
    //Construtor
    private AdicionarProduto(){
        initComponents();
    }
    
    //Singleton
    public static AdicionarProduto getInstance(){
        if(instancia == null){
            instancia = new AdicionarProduto();
        }
        return instancia;
    }
    
    //Eventos
    private void nomeProdutoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        
    }                                                    

    private void precoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
    }
    
    private void cadastrarNovoProdutoButtonActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException{                                                           
        Produto p;
        String nome = "";
        int quantidade = 0;
        double preco = 0;
        
        boolean flag = false;
        
        try{
            nome = ControladorDeJanelas.getTextField(nomeProdutoTextField);
            quantidade = quantidadeSlider.getValue();
            preco = ControladorDeJanelas.getPriceTextField(precoTextField);
            flag = true;
        }catch(InvalidTextException e){
            new GUIException(e.getMessage());
        }
        if(flag){
            p = new Produto(nome,quantidade,preco);
            Loja loja = Cadastrar.obterLoja(Login.getCNPJ());
            Cadastrar.cadastrarProduto(loja, p);
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    //Inicia os componentes
    private void initComponents() {
        
        ChangeListener listener;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomeProdutoTextField = new javax.swing.JTextField();
        nomeProdutoTextField.setName("nome do produto");
        
        jLabel3 = new javax.swing.JLabel();
        quantidadeSlider = new javax.swing.JSlider();
        valorSlider = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        
        precoTextField = new javax.swing.JFormattedTextField();
        precoTextField.setName("preco");
        
        cadastrarNovoProdutoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                Plataforma.getInstance().setVisible(true);
            }
        });
        setTitle("Novo produto");

        jLabel1.setText("Nome do produto:");
        
        listener = new ChangeListener(){
            public void stateChanged(ChangeEvent event)
            {
               // update text field when the slider value changes
               JSlider source = (JSlider) event.getSource();
               valorSlider.setText("" + source.getValue());
            }
         };

        nomeProdutoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeProdutoTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Quantidade:");

        quantidadeSlider.setValueIsAdjusting(true);
        quantidadeSlider.addChangeListener(listener);
        
        valorSlider.setText("50");

        jLabel5.setText("Preço:");

        precoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoTextFieldActionPerformed(evt);
            }
        });

        cadastrarNovoProdutoButton.setText("Cadastrar");
        cadastrarNovoProdutoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cadastrarNovoProdutoButtonActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    System.out.println(ex);
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addComponent(nomeProdutoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(66, 66, 66)
                .addComponent(valorSlider))
            .addComponent(quantidadeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel5)
            .addComponent(precoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(cadastrarNovoProdutoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(nomeProdutoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(valorSlider))
                .addGap(6, 6, 6)
                .addComponent(quantidadeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(precoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cadastrarNovoProdutoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }
}
