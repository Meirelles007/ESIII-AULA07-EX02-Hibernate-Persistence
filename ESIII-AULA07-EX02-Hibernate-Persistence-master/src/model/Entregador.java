package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "entregador")
public class Entregador extends Funcionario {

	@Column(name = "num_cnh", length = 13)
	@NotNull
	private String numCnh;

	@Column(name = "categoria_cnh", length = 2)
	@NotNull
	private String categoriaCnh;
	
	public String getNumCnh() {
		return numCnh;
	}
	public void setNumCnh(String numCnh) {
		this.numCnh = numCnh;
	}
	public String getCategoriaCnh() {
		return categoriaCnh;
	}
	public void setCategoriaCnh(String categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}

	@Override
	public String toString() {
		return "Entregador [numCnh=" + numCnh + ", categoriaCnh=" + categoriaCnh + "]";
	}
}
