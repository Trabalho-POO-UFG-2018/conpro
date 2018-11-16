package view;

import connection.Cadastrar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Produto;

public class ClienteConsulta extends JFrame{
    //Variáveis do JFrame
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pesquisaTextField;
    private javax.swing.JButton searchButton;
    
    //Instancia Singleton
    private static ClienteConsulta instancia;
    
    //Singleton
    private ClienteConsulta(){
        initComponents();
    }
    
    public static ClienteConsulta getInstance(){
        if(instancia == null)
            instancia = new ClienteConsulta();
        return instancia;
    }
    
    //Eventos
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) throws InvalidTextException, SQLException {                                             
        try{
            ControladorDeJanelas.clearRows(jTable1);
            String query;
            ArrayList<Produto> produtos = new ArrayList<>();
            query = ControladorDeJanelas.getTextField(pesquisaTextField);
            produtos = Cadastrar.obterProdutos(query);
            if(produtos.size() <= 0){
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!", "Lamentamos", JOptionPane.WARNING_MESSAGE);
            }else{
                ControladorDeJanelas.fillTable(jTable1, produtos);
            }
        }catch(InvalidTextException e){
            new GUIException(e.getMessage());
        }    
    }                                            

    private void pesquisaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    }
    
    //Inicia os componentes
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pesquisaTextField = new javax.swing.JTextField();
        pesquisaTextField.setName("pesquisa");
        searchButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        
        setTitle("Consulta");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent we){
                TelaInicial.getInstance().setVisible(true);
                instancia.setVisible(false);
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
                pesquisaTextFieldActionPerformed(evt);
            }
        });

        searchButton.setText("Procurar");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    searchButtonActionPerformed(evt);
                } catch (InvalidTextException ex) {
                    Logger.getLogger(ClienteConsulta.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteConsulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        jLabel1.setText("Digite o nome do produto que deseja buscar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pesquisaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(62, 62, 62)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }
    
}
