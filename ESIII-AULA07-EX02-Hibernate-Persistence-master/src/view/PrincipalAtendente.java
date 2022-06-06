package view;

import java.time.LocalDate;

import org.hibernate.SessionFactory;

import model.Atendente;
import persistence.AtendenteDao;
import util.HibernateUtil;

public class PrincipalAtendente {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Atendente at = new Atendente();
		at.setId(2);
		at.setNome("Petr Cech");
		at.setSalario(7500.00f);
		at.setTelefone("11888884444");
		at.setDataNascimento(LocalDate.of(1986, 6, 27));
		at.setEmail("petr@empresa.com");
		at.setHoraEntrada(9);
		at.setHoraSaida(18);
		
		AtendenteDao atDao = new AtendenteDao(sf);
		atDao.insere(at);
	}

}
