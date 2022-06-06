package persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Cliente;

public class ClienteDao implements IObjDao<Cliente> {

	private SessionFactory sf;
	
	public ClienteDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insere(Cliente cli) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(cli);
		transaction.commit();
	}

	@Override
	public void modifica(Cliente cli) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(cli);
		transaction.commit();
	}

	@Override
	public void remove(Cliente cli) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(cli);
		transaction.commit();
	}

	@Override
	public Cliente busca(Cliente cli) {
		EntityManager entityManager = sf.createEntityManager();
		cli = entityManager.find(Cliente.class, cli.getCpf());
		return cli;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> lista() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT cpf_cliente, nome_cliente, email_cliente, celular_cliente, ");
		buffer.append("pronome_tratamento ");
		buffer.append("FROM cliente ");
		buffer.append("ORDER BY nome_cliente");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(buffer.toString());
		List<Object[]> lista = query.getResultList();
		for (Object[] obj : lista) {
			Cliente cli = new Cliente();
			cli.setCpf(obj[0].toString());
			cli.setNome(obj[1].toString());
			cli.setEmail(obj[2].toString());
			cli.setCelular(obj[3].toString());
			cli.setPronomeTratamento(obj[4].toString());
			
			clientes.add(cli);
		}
		
		return clientes;
	}

}
