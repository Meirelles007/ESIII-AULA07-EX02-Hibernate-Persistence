package view;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.SessionFactory;

import model.Atendente;
import model.Atendimento;
import model.Cliente;
import persistence.AtendenteDao;
import persistence.AtendimentoDao;
import persistence.ClienteDao;
import util.HibernateUtil;

public class Principal {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		
		Cliente cli = new Cliente();
		cli.setCpf("12345678911");
		cli.setNome("Fulano");
		cli.setEmail("fulano@internet.com");
		cli.setCelular("11911115555");
		cli.setPronomeTratamento("Sr.");
		
//		ClienteDao cDao = new ClienteDao(sf);
//		cDao.insere(cli);
		
		Atendente at = new Atendente();
		at.setId(2);
		at.setNome("Petr Cech");
		at.setSalario(7500.00f);
		at.setTelefone("11888884444");
		at.setDataNascimento(LocalDate.of(1986, 6, 27));
		at.setEmail("petr@empresa.com");
		at.setHoraEntrada(9);
		at.setHoraSaida(18);
		
//		AtendenteDao atDao = new AtendenteDao(sf);
//		atDao.insere(at);
		
		Atendimento atendimento = new Atendimento();
		atendimento.setAtendente(at);
		atendimento.setCliente(cli);
		atendimento.setDataHora(LocalDateTime.parse("2022-06-04T23:23:23"));
		
		
		AtendimentoDao atendimentoDao = new AtendimentoDao(sf);
		atendimento = atendimentoDao.selectOne(atendimento);
		
//		atendimentoDao.insere(atendimento);
		
	}

}
