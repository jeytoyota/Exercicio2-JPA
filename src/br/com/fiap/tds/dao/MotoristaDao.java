package br.com.fiap.tds.dao;

import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

public interface MotoristaDao<Entidade, Chave> extends GenericDao<Entidade, Chave> {
	
	void create(Entidade entidade);
	
	Entidade search(Chave id) throws EntityNotFoundException;
	
	void delete(Chave id) throws EntityNotFoundException;
	
	void update(Entidade entidade);
	
	void commit() throws CommitException;

}
