package it.polito.tdp.anagrammi.DAO;

public class TestDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DizionarioDAO dao = new DizionarioDAO();
		
		boolean flag=dao.isCorrect("ciao");
		System.out.println("La parola � "+flag);
		
		flag=dao.isCorrect("iaoc");
		System.out.println("La parola � "+flag);
	
		
		//Il metodo isCorrect funziona bene
	}

}
