package br.com.fiap.tds.main;


import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.MotoristaDao;
import br.com.fiap.tds.entity.Genero;
import br.com.fiap.tds.entity.Motorista;
import br.com.fiap.tds.entity.Veiculo;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.impl.GenericDaoImpl;
import br.com.fiap.tds.impl.MotoristaDaoImpl;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class MotoristaTeste {
	
	public static void main(String[] args) {
		
EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		GenericDao<Motorista, Integer> dao = new GenericDaoImpl<Motorista, Integer>(em) {};	
		
		
		
		Calendar c = Calendar.getInstance();
		c.set( 2010, 10, 05);
		Motorista moto = new Motorista(22222,"Maria",c,Genero.MASCULINO);
		
		//cadastrar
		try {
			dao.create(moto);
			dao.commit();
			System.out.println("Motorista cadastrado!");
		}catch(CommitException e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		//pesquisar
		try {
			moto = dao.search(1111111);
			System.out.println("Motorista:" + " " + moto.getCarteira() + " " + moto.getMotorista()+ " " + moto.getNascimento());
		}catch(EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//atualizar
		moto = new Motorista(333333,"Maria",c,Genero.FEMENINO);
		try {
			dao.update(moto);
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
