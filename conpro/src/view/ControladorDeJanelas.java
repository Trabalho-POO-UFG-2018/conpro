package view;


import java.io.IOException;
import javax.swing.UIManager;

public class ControladorDeJanelas{
    public static void main(String[] args) throws IOException,Exception {
        
        
    
        TelaInicial inicio = TelaInicial.getInstance();
        inicio.setVisible(true);
    }
}
