package view;


import connection.Cadastrar;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Loja;
import model.Produto;

public class ControladorDeJanelas{
    public static void main(String[] args) throws IOException,Exception {
        
        
        TelaInicial inicio = TelaInicial.getInstance();
        inicio.setVisible(true);
        
    }
    
    public static String getTextField(JTextField textField) throws InvalidTextException{
        if(textField.getText().length() == 0){
            throw new InvalidTextException("O campo:  " + textField.getName() + " não pode ser vazio");
        }
        
        return textField.getText();
    }
    
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
    
    public static void fillTable(JTable table, ArrayList<Produto> produtos) throws SQLException{
        Loja l;
        int id_loja;
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        //Insere na tabela
        for(int i = 0; i < produtos.size();i++){
            id_loja = Cadastrar.obterIdLoja(produtos.get(i));
            System.out.println(id_loja);
            l = Cadastrar.obterLoja(id_loja);
            dtm.addRow(new Object[]{produtos.get(i).getNome(),produtos.get(i).getQuantidade()
                , produtos.get(i).getPreco(),l.getRazaoSocial()});
    
        }
    }
    
    public static void clearRows(JTable table){
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        //Limpa a tabela antes de outra pesquisa
        int rows = dtm.getRowCount(); 
        for(int i = rows - 1; i >=0; i--){
           dtm.removeRow(i); 
        }
    }
}
