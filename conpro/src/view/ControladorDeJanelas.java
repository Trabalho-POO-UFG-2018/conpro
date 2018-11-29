package view;


import view.Exceptions.InvalidTextException;
import controller.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Loja;
import model.Produto;

public class ControladorDeJanelas{
    /**
    * Método principal que abre a janela inicial
    * @param args argumentos iniciais (não usados)
    * @return void
    */
    public static void main(String[] args) throws IOException,Exception {
        
        
        TelaInicial inicio = TelaInicial.getInstance();
        inicio.setVisible(true);
        
        
    }
    
    /**
    * Obtem o texto contido em um TextField de um JFrame
    * @param  textField Caixa de texto de onde a String será extraída
    * @return String - Retorna a String contida no TextField
    */
    public static String getTextField(JTextField textField) throws InvalidTextException{
        if(textField.getText().length() == 0){
            throw new InvalidTextException("O campo:  " + textField.getName() + " não pode ser vazio");
        }
        
        return textField.getText();
    }
    
    /**
    * Obtem e verifica o preco contido nos TextFields separados para preço
    * @param textField Caixa de texto de onde será extraído e verificado o preço
    * @return Double - O preco contido no TextField (se válido).
    * @throws InvalidTextException caso o preco contido no text field seja inválido
    */
    public static Double getPriceTextField(JTextField textField) throws InvalidTextException{
        ArrayList<Character> notNumbers = new ArrayList<>();
        
        if(textField.getText().length() == 0){
            getTextField(textField);
        }else{
            //Adiciona todos os caracteres que não são numeros em uma lista
            for(int i = 0; i < textField.getText().length(); i++){
                if(!Character.isDigit(textField.getText().charAt(i))){
                    notNumbers.add(textField.getText().charAt(i));
                }
                if(notNumbers.size() > 1){
                    throw new InvalidTextException("O preço digitado não possui um formato válido\n"
                            + "Por favor, digite um preço com o formato: 9999.99");
                }else if (notNumbers.size() == 1){
                    if(notNumbers.get(0) != '.')
                        throw new InvalidTextException("O preço digitado não possui um formato válido\n"
                            + "Por favor, digite um preço com o formato: 9999.99");    
                }
            }
        }
        
            
        
        return Double.parseDouble(textField.getText());
    }
    
    /**
    * Preenche a tabela de uma pesquisa geral com os produtos contidos em um ArrayList
    * @param table Tabela que será preenchida.
    * @param produtos Produtos que serão colocados na tabela table.
    * @throws SQLException
    */
    public static void fillTableGeral(JTable table, ArrayList<Produto> produtos) throws SQLException{
        Loja l;
        ArrayList<Integer> id_loja = LojaDAO.obterIdLoja(produtos.get(0));
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        //Insere na tabela
        for(int i = 0; i < produtos.size();i++){
            System.out.println(id_loja);
            l = LojaDAO.obterLoja(id_loja.get(i));
            dtm.addRow(new Object[]{produtos.get(i).getNome(),produtos.get(i).getQuantidade()
                , produtos.get(i).getPreco(),l.getRazaoSocial()});
    
        }
    }
    
    /**
    * Preenche a tabela de um empreendedor com os produtos contidos em um ArrayList
    * @param table Tabela que será preenchida.
    * @param produtos Produtos que serão colocados na tabela table.
    * @throws SQLException
    */
    public static void fillTableEmpreendedor(JTable table, ArrayList<Produto> produtos) throws SQLException{
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        //Insere na tabela
        for(int i = 0; i < produtos.size();i++){
            dtm.addRow(new Object[]{produtos.get(i).getNome(),produtos.get(i).getQuantidade()
                , produtos.get(i).getPreco()});
    
        }
    }
    
    
    /**
    * Preenche a tabela de uma consulta específica com os produtos contidos em um ArrayList
    * @param table Tabela que será preenchida.
    * @param produtos Produtos que serão colocados na tabela table.
    * @throws SQLException
    */
    public static void fillTableEspecifica(JTable table, ArrayList<Produto> produtos){
        clearRows(table);
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        
        for(int i = 0; i < produtos.size();i++){
            Produto produto_atual = produtos.get(i);
            dtm.addRow(new Object[]{produto_atual.getNome(),produto_atual.getQuantidade(),produto_atual.getPreco(),produto_atual.getLoja().getRazaoSocial()});
        }
    }
    
    
    /**
    * Limpa as linhas de uma tabela
    * @param table Tabela cuja as linhas serão excluídas.
    */
    public static void clearRows(JTable table){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        //Limpa a tabela antes de outra pesquisa
        int rows = dtm.getRowCount(); 
        for(int i = rows - 1; i >=0; i--){
           dtm.removeRow(i); 
        }
    }
    
    /**
    * Obtem o nome de um produto em uma linha que está selecionada em uma tabela
    * @param table Tabela a ser analisada.
    * @return String - O nome de um produto.
    */
    public static String getSelectedText(JTable table){
        int linha = table.getSelectedRow();
        int coluna = 0;
        
        if(linha != -1){
            return (String) table.getValueAt(linha, coluna);
        }else{
            return null;
        }
        
    }
}
