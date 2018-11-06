import javax.swing.*;

public class Janela {

	private JFrame window = new JFrame();
	private JPanel mainPanel = (JPanel)window.getContentPane();

	/*
	* Cria um JFrame com a largura e o comprimento especificado
	* @param largura     largura do JFrame
	* @param comprimento comprimento do JFrame
	*/
	public void criarJanela(int largura, int comprimento){
		window.setSize(largura,comprimento);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	/*
	* Torna o JFrame desta classe visível
	*/
	public void tornarVisivel(){
		window.setVisible(true);
	}

	/*
	* Adiciona um botão em um painel do JFrame
	* @param texto Texto do conteúdo do botão
	* @param painel Painel ser adiciona o botao
	*/

	public void adicionarBotao(String texto, JPanel painel){
		JButton botao = new JButton(texto);
		painel.add(botao);
	}


	/*
	* Cria um painel e adiciona este ao JFrame
	*/

	public void criarPainel(){
		JPanel painel = new JPanel();
		window.getContentPane().add(painel);
	}

}