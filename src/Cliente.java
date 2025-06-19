
import java.util.ArrayList; // Adicionar import para ArrayList
import java.util.List; // Adicionar import para List


public class Cliente {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    private List<Conta> contasDoCliente;

  //Associação Cliente-Contas: Um cliente pode ter várias contas, mas a classe 
  //Cliente agora pode listar todas as contas de um determinado cliente.  
    public void adicionarConta(Conta conta) {
    if (this.contasDoCliente == null) {
        this.contasDoCliente = new ArrayList<>();
    }
    this.contasDoCliente.add(conta);
}


}
