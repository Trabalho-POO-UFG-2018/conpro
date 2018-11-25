package view.Exceptions;

import javax.swing.JOptionPane;

public class GUIException {
    
    /**
    * Exibe uma tela de exceção com o texto "text"
    * @param    text Texto a ser exibo na GUI de erro
    */
    public GUIException(String text){
        JOptionPane.showMessageDialog(null, text, "Erro", JOptionPane.WARNING_MESSAGE,null);
    }
    
}
