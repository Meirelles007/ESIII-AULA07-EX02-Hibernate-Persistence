package model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "atendimento")
public class Atendimento {
	
	@Id
	@ManyToOne
	@JoinColumn(name = "cpf_cliente")
	@NotNull
	private Cliente cliente;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "id_atendente")
	@NotNull
	private Atendente atendente;
	
	@Id
	@Column(name="data_hora_atendimento")
	@NotNull
	private LocalDateTime dataHora;
	
	public final Cliente getCliente() {
		return cliente;
	}
	public final void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public final Atendente getAtendente() {
		return atendente;
	}
	public final void setAtendente(Atendente atendente) {
		this.atendente = atendente;
	}
	public final LocalDateTime getDataHora() {
		return dataHora;
	}
	public final void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public String toString() {
		return "Atendimento [cliente=" + cliente + ", atendente=" + atendente + ", dataHora=" + dataHora + "]";
	}
	
}
