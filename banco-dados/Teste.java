import java.io.*;

public class Teste{
	public static void main(String[] args) throws IOException,Exception{
		FileOutputStream file = new FileOutputStream("teste.txt");
		ObjectOutputStream teste = new ObjectOutputStream(file);

		FileInputStream leitura = new FileInputStream("teste.txt");
		ObjectInputStream arqLeitura = new ObjectInputStream(leitura);

		teste.writeObject(new Classe(3));

		System.out.println(arqLeitura.readObject());

		arqLeitura.close();
		teste.close();
	}
}