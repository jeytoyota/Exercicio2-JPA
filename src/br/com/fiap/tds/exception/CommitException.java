package br.com.fiap.tds.exception;

public class CommitException extends Exception {

	public CommitException() {
		super("N�o foi poss�vel dar commit");
		
	}
	
	public CommitException(String msg) {
		super(msg);
		
	}
		

}
