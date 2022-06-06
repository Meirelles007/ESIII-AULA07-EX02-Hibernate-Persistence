package model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "funcionario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Funcionario {

	@Id
	@Column(name = "id")
	@NotNull
	private int id;

	@Column(name = "nome", length = 100)
	@NotNull
	private String nome;
	
	@Column(name = "data_nascimento")
	@NotNull
	private LocalDate dataNascimento;

	@Column(name = "salario")
	@NotNull
	private float salario;
	
	@Column(name = "telefone", length = 11)
	@NotNull
	private String telefone;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", salario="
				+ salario + ", telefone=" + telefone + "]";
	}
}

/*
AempresaXYZquerinformatizarseusdadosetem,
preliminarmente,quecadastrarseusfuncion�rios.
Todosrecebemumaidentifica��ointerna,
edevemcadastrarseunome,datadenascimento,seusal�rio,
apenasumtelefonedecontato(celular).
Quandoofuncion�rioforumatendente,
�precisosaberseuhor�riodeentrada,
seuhor�riodesa�daeseue-mailinstitucional.
Quandoofuncion�rioforentregador,
�importantesaberon�meroeacategoriadaCNH.
*/