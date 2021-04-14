package br.com.fiap.tds.dao;

import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;

public interface GenericDao<Entidade, Chave> {
	
	void create(Entidade entidade);
	
	Entidade search(Chave id) throws EntityNotFoundException;
	
	void update(Entidade entidade);
	
	void delete(Chave id) throws EntityNotFoundException;
	
	void commit() throws CommitException;

}
