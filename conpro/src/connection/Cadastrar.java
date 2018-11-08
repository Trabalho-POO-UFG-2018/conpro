package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Loja;

public class Cadastrar {
    
    public void create(Loja novaLoja) {        
	Connection con = ConnectionDB.getConnection();
        System.out.printf("Consegui obter conexao");
	PreparedStatement stmt = null;
		
	try {
            stmt = con.prepareStatement("insert into loja (razao_social, rua, bairro, cidade, estado) values (?, ?, ?, ?, ?)");
            /*
            stmt.setString(1, "1");
            stmt.setString(2, "1");
            stmt.setString(3, "1");
            stmt.setString(4, "1");
            stmt.setString(5, "1");
            */
            stmt.setString(1, novaLoja.getRazaoSocial());
            stmt.setString(2, novaLoja.endereco.getRua());
            stmt.setString(3, novaLoja.endereco.getBairro());
            stmt.setString(4, novaLoja.endereco.getCidade());
            stmt.setString(5, novaLoja.endereco.getEstado());
            stmt.executeUpdate();
            System.out.println("Um Sucesso");
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
    }    
}
