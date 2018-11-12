package view;

import java.util.Scanner;

import connection.*;
import model.*;

public class Teste {
    public static void cadastraLoja(){
        Loja novaLoja;
        Endereco novoEndereco;
        String razaoSocial, cnpj, senha;
        String rua, bairro, cidade, estado;
        Cadastrar cadastro = new Cadastrar();
        Scanner ler = new Scanner(System.in);

        System.out.println("Cadastrar Loja");
        System.out.print("Razao Social: ");
        razaoSocial = ler.nextLine();
        System.out.print("CNPJ: ");
        cnpj = ler.nextLine();
        System.out.print("Senha: ");
        senha = ler.nextLine();
            
        System.out.print("Rua: ");
        rua = ler.nextLine();
        System.out.print("Bairro: ");
        bairro = ler.nextLine();
        System.out.print("Cidade: ");
        cidade = ler.nextLine();
        System.out.print("Estado: ");
        estado = ler.nextLine();
        novoEndereco = new Endereco(rua, bairro, cidade, estado);
        novaLoja = new Loja(razaoSocial, cnpj, senha, novoEndereco);
            
        cadastro.create(novaLoja);

    }
    
    public static void login(){
    	
        String usuario;
        String senha;
        Scanner ler = new Scanner(System.in);
        Cadastrar cadastrar = new Cadastrar();
        System.out.print("LOGIN\nUsuario: ");
        usuario = ler.nextLine();
        System.out.print("Senha: ");
        senha = ler.nextLine();
        if(cadastrar.checkLogin(usuario, senha)){
           System.out.println("Sucesso");
       } else {
           System.out.println("Falha ao realizar o Login");
       }

    }
    
    
    public static void main(String[] args){
    	int flag = 1;
    	Scanner ler = new Scanner(System.in);
    	while(flag != 0){
    		System.out.print("MENU\n");
    		System.out.print("1 - Cadastrar\n2 - Login\n0 - Sair");
    		flag = ler.nextInt();
    		if(flag == 1){
    			cadastraLoja();
    		} else if(flag == 2) {
    			login();
    			
    		}
    	}
    }
}
