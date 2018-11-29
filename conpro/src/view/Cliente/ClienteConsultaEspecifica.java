package view.Cliente;

import controller.LojaDAO;
import controller.ProdutoDAO;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Endereco;
import model.Loja;
import model.Produto;
import view.ControladorDeJanelas;
import view.Exceptions.GUIException;
import view.Exceptions.InvalidTextException;

public class ClienteConsultaEspecifica extends JFrame{
    //Instancia do singleton
    private static ClienteConsultaEspecifica instancia;
    
    //Variáveis do JFrame
    private javax.swing.JTextField cityTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField neighbourTextField;
    private javax.swing.JTextField pesquisaTextField;
    private javax.swing.JButton searchButton;
    
    //Singleton
    private ClienteConsultaEspecifica(){
        initComponents();
    }
    
    public static ClienteConsultaEspecifica getInstance(){
        if(instancia == null){
            instancia = new ClienteConsultaEspecifica();
        }
        return instancia;
    }
    
    //Eventos
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException {                                             
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Produto> produtos_validos = new ArrayList<>();
        String nome_produto_busca;
        String cidade;
        String bairro;
        Loja loja;
        ArrayList<Integer> lojas;
        
        ControladorDeJanelas.clearRows(jTable1);
        
        try{
            //Captura os dados dos text fields
            nome_produto_busca = ControladorDeJanelas.getTextField(pesquisaTextField);
            cidade = ControladorDeJanelas.getTextField(cityTextField);
            bairro = ControladorDeJanelas.getTextField(neighbourTextField);
            
            //Captura todos os produtos com o nome no campo do text field
            produtos = ProdutoDAO.obterProdutos(nome_produto_busca);
            
            //Obtem as lojas que possuem aquele produto
            lojas = ProdutoDAO.obterIdLojas(nome_produto_busca);
            
            //Atribui a loja a qual pertence para cada produto
            for(int i = 0; i < produtos.size();i++){
                loja = LojaDAO.obterLoja(lojas.get(i));
                produtos.get(i).setLoja(loja);
            }
            
            //Separa os produtos que são válidos
            for(int i = 0; i < produtos.size();i++){
                Produto produto_atual = produtos.get(i);
                Loja loja_atual = produto_atual.getLoja();
                Endereco endereco_atual = loja_atual.getEndereco();
                
                if((endereco_atual.getBairro().compareTo(bairro)) == 0 && 
                   (endereco_atual.getCidade().compareTo(cidade)) == 0)
                {
                    produtos_validos.add(produto_atual);
                }
            }
            
            if(produtos_validos.size() == 0){
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado", "Lamentamos", JOptionPane.INFORMATION_MESSAGE);
            }else{
                ControladorDeJanelas.fillTableEspecifica(jTable1, produtos_validos);
            }
        }catch(InvalidTextException e){
            new GUIException(e.getMessage());
        }    
    }                                            

    private void pesquisaTextFieldActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException {                                                  
        searchButtonActionPerformed(evt);
    }                                                 

    private void cityTextFieldActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException {                                              
        searchButtonActionPerformed(evt);
    }                                             

    private void neighbourTextFieldActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException {                                                   
        searchButtonActionPerformed(evt);
    }
    
    //Inicia os componentes
    private void initComponents() {
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        setTitle("Consulta por bairro");
        
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pesquisaTextField = new javax.swing.JTextField();
        pesquisaTextField.setName("pesquisa");
        
        searchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cityTextField = new javax.swing.JTextField();
        cityTextField.setName("cidade");
        
        neighbourTextField = new javax.swing.JTextField();
        neighbourTextField.setName("bairro");
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                cityTextField.setText("");
                neighbourTextField.setText("");
                pesquisaTextField.setText("");
                instancia.setVisible(false);
                PonteCliente.getInstance().setVisible(true);
                ControladorDeJanelas.clearRows(jTable1);
            }
        });
        
        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome:", "Quantidade:", "Preço:", "Loja:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        pesquisaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    pesquisaTextFieldActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    Logger.getLogger(ClienteConsultaEspecifica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        searchButton.setText("Procurar");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    searchButtonActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    Logger.getLogger(ClienteConsultaEspecifica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabel1.setText("Digite o nome do produto que deseja buscar:");

        jLabel2.setText("Em qual bairro deseja buscar ?");

        jLabel3.setText("Em qual cidade deseja buscar ?");

        cityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    cityTextFieldActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    Logger.getLogger(ClienteConsultaEspecifica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        neighbourTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    neighbourTextFieldActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    Logger.getLogger(ClienteConsultaEspecifica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(neighbourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(150, 150, 150))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(147, 147, 147))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pesquisaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                    .addGap(36, 36, 36))))
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pesquisaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(neighbourTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }                       

    
}
