package persistence;

import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Atendente;

public class AtendenteDao implements IObjDao<Atendente>{

	private SessionFactory sf;
	
	public AtendenteDao(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insere(Atendente at) {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(at);
		transaction.commit();		
	}

	@Override
	public void modifica(Atendente at) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Atendente at) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Atendente busca(Atendente at) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Atendente> lista() {
		// TODO Auto-generated method stub
		return null;
	}

}
