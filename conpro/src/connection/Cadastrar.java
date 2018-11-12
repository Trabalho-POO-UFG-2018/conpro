package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.*;

public class Cadastrar {
    public void createLoja(Loja novaLoja) {        
    	Connection con = ConnectionDB.getConnection();
    	PreparedStatement stmt = null;
		Endereco novoEndereco = novaLoja.getEndereco();
	try {
            stmt = con.prepareStatement("insert into lojas (razao_social, cnpj, senha, rua, bairro, cidade, estado) values (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, novaLoja.getRazaoSocial());
            stmt.setString(2, novaLoja.getCnpj());
            stmt.setString(3, novaLoja.getSenha());
            stmt.setString(4, novoEndereco.getRua());
            stmt.setString(5, novoEndereco.getBairro());
            stmt.setString(6, novoEndereco.getCidade());
            stmt.setString(7, novoEndereco.getEstado());
            stmt.executeUpdate();
            System.out.println("Um Sucesso");
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
    }
    
    public void inserirProduto(Loja loja, Produto novoProduto){
    	Connection con = ConnectionDB.getConnection();
    	PreparedStatement stmt = null;
	
    	
    }
    public boolean checkLogin(String cnpj, String senha) {        
		Connection con = ConnectionDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
	        boolean check = false;
	        try{
	            stmt = con.prepareStatement("select * from lojas where cnpj = ? and senha = ?");
	            stmt.setString(1, cnpj);
	            stmt.setString(2, senha);
	            rs = stmt.executeQuery();
	            
	            if(rs.next()){
	                check = true;
	            }
	        } catch (SQLException ex) {
	            System.out.print("ERRO");
	        }
	           return check;
	}    
}
