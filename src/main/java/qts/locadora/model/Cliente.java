package qts.locadora.model;

public class Cliente {
	private String nome;

	public Cliente(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nome: " + nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Cliente cli = (Cliente) obj;
		return nome.equals(cli.nome);
	}
}
