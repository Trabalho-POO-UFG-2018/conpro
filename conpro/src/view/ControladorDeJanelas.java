package view;


import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.UIManager;

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
}
