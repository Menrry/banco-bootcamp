import java.util.ArrayList;
import java.util.List;


public class Banco {

	private String nome;
	private List<Conta> contas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}
	
	public void adicionarConta(Conta conta){
		if (this.contas==null){
			this.contas = new ArrayList<>(); 
		}
		this.contas.add(conta);
	}

}