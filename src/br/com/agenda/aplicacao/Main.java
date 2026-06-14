package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {

		ContatoDAO contatoDAO = new ContatoDAO();

		Contato contato = new Contato();
		contatoDAO.deleteByID(1);

	}

}
