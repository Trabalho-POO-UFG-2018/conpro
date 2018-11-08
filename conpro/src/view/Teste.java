package view;

import connection.Cadastrar;
import java.util.Scanner;
import model.Endereco;
import model.Loja;

public class Teste {
    public static void main(String[] args){
        Loja novaLoja;
        Endereco novoEndereco;
        String razaoSocial;
        String rua, bairro, cidade, estado;
        Cadastrar cadastro = new Cadastrar();
        int flag = 1;
        //Scanner ler = new Scanner(System.in);
         Scanner ler = new Scanner(System.in);
        
         while(flag != 0){
            //Cadastro Loja
            System.out.println("Cadastrar Loja");
            System.out.print("Razao Social: ");
            razaoSocial = ler.nextLine();
            System.out.print("Rua: ");
            rua = ler.nextLine();
            System.out.print("Bairro: ");
            bairro = ler.nextLine();
            System.out.print("Cidade: ");
            cidade = ler.nextLine();
            System.out.print("Estado: ");
            estado = ler.nextLine();
            novoEndereco = new Endereco(rua, bairro, cidade, estado);
            novaLoja = new Loja(razaoSocial, novoEndereco);
            cadastro.create(novaLoja);
            System.out.print("Digite 1 - Sair || Outro numero - Cadastrar outra loja");
         }
        
    }
}
