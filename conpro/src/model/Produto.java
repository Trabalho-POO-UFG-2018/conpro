package model;

public class Produto {
    private int codigo;
    private String nome;
    private int quantidade;
    private double preco;
    private Loja loja;

    
	
    //construtor
    public Produto(String nome, int quantidade, double preco){
            this.nome = nome;
            this.quantidade = quantidade;
            this.preco = preco;
    }

    //setters e getters
    
    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }
    
    public void setCodigo(int codigo){
            this.codigo = codigo;
    }

    public int getCodigo(){
            return this.codigo;
    }

    public void setNome(String nome){
            this.nome = nome;
    }

    public String getNome(){
            return this.nome;
    }

    public void setQuantidade(int quantidade){
            this.quantidade = quantidade;
    }

    public int getQuantidade(){
            return this.quantidade;
    }

    public void setPreco(double preco){
            this.preco = preco;
    }

    public double getPreco(){
            return this.preco;
    }
    public String toString(){
            return "Codigo:" + this.codigo + " Nome:"+ this.nome + " Quantidade:"+ this.quantidade + " Preco:" + this.preco;
    }
}
