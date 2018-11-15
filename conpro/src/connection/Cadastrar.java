package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.*;

public class Cadastrar{
    public static void createLoja(Loja novaLoja){        
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
    public static boolean checkLogin(String cnpj, String senha) {        
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
    public static Loja obterLoja(String cnpj){
    	
    	Connection con = ConnectionDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Loja novaLoja = null;
		Endereco novoEndereco;
		
		try {
			stmt = con.prepareStatement("select * from lojas where cnpj = ?");
			stmt.setString(1, cnpj);
			rs = stmt.executeQuery();
			rs.next();
			novoEndereco = new Endereco(rs.getString("rua"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"));
			novaLoja = new Loja(rs.getString("razao_social"), rs.getString("cnpj"), rs.getString("senha"), novoEndereco);
			novaLoja.setId(rs.getInt("id"));
			System.out.println(novaLoja.getRazaoSocial());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return novaLoja;
		
    }
    
    public static void cadastrarProduto(Loja loja, Produto produto){

    	Connection con = ConnectionDB.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			//inserindo na tabela produtos
			stmt = con.prepareStatement("insert into produtos (nome_produto) values (?)");
			stmt.setString(1, produto.getNome());
			stmt.executeUpdate();
			stmt = null;
			
			//recuperando o id
			stmt = con.prepareStatement("select id from produtos where  nome_produto = ?");
			stmt.setString(1, produto.getNome());
			rs = stmt.executeQuery();
			rs.next();
			produto.setCodigo(rs.getInt("id")); //set codigo produto
			stmt = null;
			
			//System.out.printf("ID LOJA: %d && ID PRODUTO : %d\n", loja.getId(), produto.getCodigo());
			
			//inserindo na tabela relacional loja-produto
			stmt = con.prepareStatement("insert into lojas_produtos (id_loja, id_produto, qtde, preco) values (?, ?, ?, ?)");
			stmt.setInt(1, loja.getId());
			stmt.setInt(2, produto.getCodigo());
			stmt.setInt(3, produto.getQuantidade());
			stmt.setDouble(4, produto.getPreco());
                        //Adicionado por Matheus
                        stmt.execute();
                        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
    	
    }
}
