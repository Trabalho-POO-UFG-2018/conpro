public class Loja {

	private String razaoSocial;
	private Endereco endereco;
	ArrayList<Produto> listaProdutos = new ArrayList();

	//construtor
	public Loja(String razaoSocial, Endereco endereco){
		this.razaoSocial = razaoSocial;
		this.endereco = endereco
	}	
		
	//setters e getters
	public void setRazaoSocial(String razaoSocial){
		this.razaoSocial = razaoSocial
	}
	public String getRazaoSocial(){
		return this.razaoSocial;
	}

}
