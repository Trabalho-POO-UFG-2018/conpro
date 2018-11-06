import java.util.ArrayList;

public class Classe implements java.io.Serializable{
	ArrayList<Integer> numeros = new ArrayList<>();

	Classe(int number){
		numeros.add(number);
		numeros.add(43);
		numeros.add(23);
		numeros.add(543);
		numeros.add(465);
		numeros.add(41);
	
	}

	public String toString(){
		return "Este foi o numero que eu coloquei: " + this.numeros.get(4);
	}
}