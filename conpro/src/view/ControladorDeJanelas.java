package view;


import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTextField;

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
}
