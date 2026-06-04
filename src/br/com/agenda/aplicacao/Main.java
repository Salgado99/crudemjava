package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {

		ContatoDAO contatoDAO = new ContatoDAO();

		Contato contato = new Contato();
		contato.setNome("Samuel Salgado");
		contato.setIdade(27);
		contato.setDataCadastro(new Date());

		contatoDAO.save(contato);

		for (Contato c : contatoDAO.getContatos()) {
			System.out.println("Contato " + c.getId());
			System.out.println("Contato " + c.getNome());
			System.out.println("Contato " + c.getIdade());
			System.out.println("Contato " + c.getDataCadastro());
		}

	}

}
