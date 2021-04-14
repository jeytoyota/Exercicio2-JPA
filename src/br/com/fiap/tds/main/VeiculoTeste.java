package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.VeiculoDao;
import br.com.fiap.tds.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Veiculo;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.impl.VeiculoDaoImpl;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class VeiculoTeste {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		GenericDao<Veiculo, Integer> dao = new GenericDaoImpl<Veiculo, Integer>(em) {};
		
		Veiculo veiculo = new Veiculo("FFC", "VERDE", 2015);
		
		// cadastrar
		try {
			dao.create(veiculo);
			dao.commit();
			System.out.println("Ve�culo cadastrado");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		
		// Pesquisar
		try {
			veiculo = dao.search(1);
			System.out.println(veiculo.getPlaca() + " "+ veiculo.getCor()+ " " + veiculo.getAno());
		}catch(EntityNotFoundException e) {
			System.out.println("Ve�culo n�o encontrado");
		}
		
		//atualizar
		veiculo = new Veiculo("BBO", "Preto", 2018);
		try {
			dao.update(veiculo);
			dao.commit();
			System.out.println("Ve�culo atualizado");
		}catch(CommitException e){
			System.out.println(e.getMessage());
		}
		
		//deletar
		try {
			dao.delete(2);
			dao.commit();
		}catch(CommitException | EntityNotFoundException e) {
			System.out.println("N�o foi poss�vel deletar");
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}

}
