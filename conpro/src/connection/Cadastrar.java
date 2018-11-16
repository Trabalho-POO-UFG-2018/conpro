package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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
            //Adicionado por Matheus
            while(!rs.isLast()){
                rs.next();
            }
            produto.setCodigo(rs.getInt("id")); //set codigo produto
            stmt = null;

            //System.out.printf("ID LOJA: %d && ID PRODUTO : %d\n", loja.getId(), produto.getCodigo());

            //inserindo na tabela relacional loja-produto
            stmt = con.prepareStatement("insert into lojas_produtos (nome_produto, id_loja, id_produto, qtde, preco) values (?, ?, ?, ?, ?)");
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, loja.getId());
            stmt.setInt(3, produto.getCodigo());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setDouble(5, produto.getPreco());
            //Adicionado por Matheus
            stmt.execute();

        }catch (SQLException e) {
            e.getMessage();
        }

		
    	
    }
    public static void alterarLoja(Loja loja){
        Connection con = ConnectionDB.getConnection();
	PreparedStatement stmt = null;
        Endereco endereco = loja.getEndereco();
        try {
            stmt = con.prepareStatement("update lojas set razao_social = ?, cnpj = ?, senha = ?, rua = ?, bairro = ?, cidade = ?, estado = ? where id = ?");
            stmt.setString(1, loja.getRazaoSocial());
            stmt.setString(2, loja.getCnpj());
            stmt.setString(3, loja.getSenha());
            stmt.setString(4, endereco.getRua());
            stmt.setString(5, endereco.getBairro());
            stmt.setString(6, endereco.getCidade());
            stmt.setString(7, endereco.getEstado());
            stmt.setInt(8, loja.getId());
            stmt.executeUpdate();
      
       } catch (SQLException ex) {
            Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public static Loja obterLoja(int id){
    	
    	Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Loja novaLoja = null;
        Endereco novoEndereco;

        try {
                stmt = con.prepareStatement("select * from lojas where id = ?");
                stmt.setInt(1, id);
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
    //Feito por Matheus
    public static ArrayList<Produto> obterProdutos(String nome){
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt;
        ResultSet rs;
        Produto p;
        ArrayList<Produto> produtos = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM lojas_produtos WHERE nome_produto = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            
            //Percorre a lista de produtos do BD para adicionar em um array list
            while(!rs.isLast()){
                rs.next();
                p = new Produto(rs.getString("nome_produto")
                                ,rs.getInt("qtde"),rs.getDouble("preco"));
                p.setCodigo(rs.getInt("id_produto"));
                produtos.add(p);
            }
        }catch(SQLException e){
            e.getMessage();
        }
        
        return produtos;
    }
    
    public static int obterIdLoja(Produto p) throws SQLException{
        Connection con = ConnectionDB.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int id_loja = 0;
        
        try{
            stmt = con.prepareStatement("SELECT id_loja FROM lojas_produtos WHERE id_produto = ?");
            stmt.setInt(1, p.getCodigo());
            rs = stmt.executeQuery();
            rs.next();
            id_loja = rs.getInt("id_loja");
        }catch(SQLException e){
            e.getMessage();
        }    
        
        return id_loja;
    }
    
    
}
