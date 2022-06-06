package persistence;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Atendente;
import model.Atendimento;
import model.Cliente;

public class AtendimentoDao implements IAtendimentoDao {

	private SessionFactory sf;

	public AtendimentoDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insere(Atendimento atend) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(atend);
		transaction.commit();
	}

	@Override
	@SuppressWarnings("unchecked")
	public Atendimento selectOne(Atendimento atend) {
		Atendimento atendimento = new Atendimento();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT * FROM atendimento ");
		buffer.append("INNER JOIN cliente ON cliente.cpf_cliente = atendimento.cpf_cliente ");
		buffer.append("INNER JOIN atendente ON atendente.id = atendimento.id_atendente ");
		buffer.append("WHERE ");
		buffer.append("atendimento.data_hora_atendimento = " + atend.getDataHora().toString() + " AND ");
		buffer.append("atendimento.id_atendente = " + atend.getAtendente().getId() + " AND ");
		buffer.append("atendimento.cpf_cliente = " + atend.getCliente().getCpf());

		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> resultado = query.getResultList();

		for (Object[] obj : resultado) {
			Cliente cliente = new Cliente();
			Atendente atendente = new Atendente();
			atendimento.setDataHora(LocalDateTime.parse(obj[0].toString()));
			cliente.setCpf(obj[3].toString());
			cliente.setCelular(obj[4].toString());
			cliente.setEmail(obj[5].toString());
			cliente.setNome(obj[6].toString());
			cliente.setPronomeTratamento(obj[7].toString());

			atendente.setEmail(obj[8].toString());
			atendente.setHoraEntrada(Integer.parseInt(obj[9].toString()));
			atendente.setHoraSaida(Integer.parseInt(obj[10].toString()));

			atendimento.setAtendente(atendente);
			atendimento.setCliente(cliente);
		}

		return atendimento;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Atendimento> selectOneCliente(Atendimento atend) {
		List<Atendimento> atendimentoClientes = new ArrayList<Atendimento>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT * FROM atendimento ");
		buffer.append("INNER JOIN cliente ON cliente.cpf_cliente = atendimento.cpf_cliente ");
		buffer.append("INNER JOIN atendente ON atendente.id = atendimento.id_atendente ");
		buffer.append("WHERE ");
		buffer.append("atendimento.cpf_cliente = " + atend.getCliente().getCpf());
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Atendimento atendimento = new Atendimento();
			Atendente atendente = new Atendente();
			Cliente cliente = new Cliente();
			atendimento.setDataHora(LocalDateTime.parse(obj[0].toString()));
			cliente.setCpf(obj[3].toString());
			cliente.setCelular(obj[4].toString());
			cliente.setEmail(obj[5].toString());
			cliente.setNome(obj[6].toString());
			cliente.setPronomeTratamento(obj[7].toString());

			atendente.setEmail(obj[8].toString());
			atendente.setHoraEntrada(Integer.parseInt(obj[9].toString()));
			atendente.setHoraSaida(Integer.parseInt(obj[10].toString()));

			atendimento.setAtendente(atendente);
			atendimento.setCliente(cliente);
			atendimentoClientes.add(atendimento);
		}

		return atendimentoClientes;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Atendimento> selectOneAtendente(Atendimento atend) {
		List<Atendimento> atendimentoAtendente = new ArrayList<Atendimento>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT * FROM atendimento ");
		buffer.append("INNER JOIN cliente ON cliente.cpf_cliente = atendimento.cpf_cliente ");
		buffer.append("INNER JOIN atendente ON atendente.id = atendimento.id_atendente ");
		buffer.append("WHERE ");
		buffer.append("atendimento.id_atendente = " + atend.getAtendente().getId() + " AND ");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Atendimento atendimento = new Atendimento();
			Atendente atendente = new Atendente();
			Cliente cliente = new Cliente();
			atendimento.setDataHora(LocalDateTime.parse(obj[0].toString()));
			cliente.setCpf(obj[3].toString());
			cliente.setCelular(obj[4].toString());
			cliente.setEmail(obj[5].toString());
			cliente.setNome(obj[6].toString());
			cliente.setPronomeTratamento(obj[7].toString());

			atendente.setEmail(obj[8].toString());
			atendente.setHoraEntrada(Integer.parseInt(obj[9].toString()));
			atendente.setHoraSaida(Integer.parseInt(obj[10].toString()));

			atendimento.setAtendente(atendente);
			atendimento.setCliente(cliente);
			atendimentoAtendente.add(atendimento);
		}

		return atendimentoAtendente;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Atendimento> selectAll() {
		List<Atendimento> atendimentos = new ArrayList<Atendimento>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT * FROM atendimento ");
		buffer.append("INNER JOIN cliente ON cliente.cpf_cliente = atendimento.cpf_cliente ");
		buffer.append("INNER JOIN atendente ON atendente.id = atendimento.id_atendente ");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Atendimento atendimento = new Atendimento();
			Atendente atendente = new Atendente();
			Cliente cliente = new Cliente();
			atendimento.setDataHora(LocalDateTime.parse(obj[0].toString()));
			cliente.setCpf(obj[3].toString());
			cliente.setCelular(obj[4].toString());
			cliente.setEmail(obj[5].toString());
			cliente.setNome(obj[6].toString());
			cliente.setPronomeTratamento(obj[7].toString());

			atendente.setEmail(obj[8].toString());
			atendente.setHoraEntrada(Integer.parseInt(obj[9].toString()));
			atendente.setHoraSaida(Integer.parseInt(obj[10].toString()));

			atendimento.setAtendente(atendente);
			atendimento.setCliente(cliente);
			atendimentos.add(atendimento);
		}

		return atendimentos;
	}
}
