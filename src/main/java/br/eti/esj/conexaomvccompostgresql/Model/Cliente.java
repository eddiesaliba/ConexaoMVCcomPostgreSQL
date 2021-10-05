package Model;

public class Cliente {
	private int codigo;
	private String nome;
	private String cpf;
	private String identidade;
	
	public Cliente(){
		
	}

	public Cliente(int c, String n, String cpf, String i){
		codigo = c;
		nome = n;
		this.cpf = cpf;
		identidade = i;		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getIdentidade() {
		return identidade;
	}

	public void setIdentidade(String identidade) {
		this.identidade = identidade;
	}
}
