package br.com.queroumtrampo.dao;

import java.util.List;

import br.com.queroumtrampo.model.Servico;

public class ServicoDAO extends GenericDAO<Servico> {

	private static final long serialVersionUID = 6239602715783256116L;

	public ServicoDAO() {
		super(Servico.class);
	}

	public void insert(Servico servico) {
		beginTransaction();
		super.save(servico);
		commitAndCloseTransaction();
	}

	public Servico find(int entityID) {
		beginTransaction();
		Servico servico = super.find(entityID);
		closeTransaction();

		return servico;
	}

	public Servico update(Servico servico) {
		beginTransaction();
		Servico servicoNew = super.update(servico);
		commitAndCloseTransaction();

		return servicoNew;
	}

	public void delete(Servico servico) {
		beginTransaction();
		super.delete(servico.getId(), Servico.class);
		commitAndCloseTransaction();
	}

	public List<Servico> findAll() {
		beginTransaction();
		List<Servico> servicos = super.findAll();
		closeTransaction();

		return servicos;
	}
}
