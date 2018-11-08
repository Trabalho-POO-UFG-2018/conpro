package model;

import model.Endereco;
import java.util.ArrayList;

public class Loja {

	private String razaoSocial;
	public Endereco endereco;
	ArrayList<Produto> listaProdutos = new ArrayList();

	//construtor
	public Loja(String razaoSocial, Endereco endereco){
		this.razaoSocial = razaoSocial;
		this.endereco = endereco;
	}	
		
	//setters e getters
	public void setRazaoSocial(String razaoSocial){
		this.razaoSocial = razaoSocial;
	}
	public String getRazaoSocial(){
		return this.razaoSocial;
	}

}
