package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class AnagrammiModel {
	
	private DizionarioDAO dizionarioDao;
	
	public AnagrammiModel() {
		this.dizionarioDao = new DizionarioDAO();
	}
	
	//Restituisce true se la parola è presente nel dizionario, false altrimenti
	public boolean isCorrect(String s) {
		return dizionarioDao.isCorrect(s);
	}
	

	public Set<String> calcolaAnagrammi(String parola) {
		// TODO Auto-generated method stub
		Set<String> anagrammi = new HashSet<String>();
		
		//parziale è una stringa vuota da riempire con i caratteri scritti dall'utente
		String parziale="";
		
		calcola(parziale, parola, 0, anagrammi);
		
		return anagrammi;
	}
	
	public void calcola(String parziale, String parola, int livello, Set<String> anagrammi) { //RECURSIVE
		
		//Livello=numero lettere inserite in parziale (quindi se parziale è uguale a 3 significa che sono state aggiunte già 3 lettere)
		
		//A - Condizione di terminazione
		//Come prima cosa controllo la lunghezza della stringa parziale, perchè se è lunga tanto quanto la parola inserita dall'utente
		//allora significa che la soluzione parziale  è una soluzione completa e quindi deve essere aggiunta al Set anagrammi
		if(livello==parola.length()) { 
			
			anagrammi.add(parziale);
			
			return;
		}
		
		//B - Genera nuova soluzione parziale
		for(int i = 0; i<parola.length(); i++) {
			
//			C - Filtro sulla chiamata ricorsiva
//			Qua vado a controllare se la lettera che sto per aggiungere può essere aggiunta
//			Per farlo uso il metodo contaCaratteri, con cui confronto quante volte ricorre la lettera i-esima
//			nella parola che sto costruendo (parziale) e nella parola scritta dall'utente (parola)
//			ContaCaratteri ritorna un int che mi dice quante volte compare una certa lettera

			if ( (contaCaratteri(parziale, parola.charAt(i))) < (contaCaratteri(parola, parola.charAt(i))) ){
				
				//Se nella parola in costruzione compare meno volte rispetto alla parola scritta dall'utente
				//allora aggiungo il carattere alla soluzione parziale e richiamo calcola
				parziale += parola.charAt(i);
				
				//Richiama sè  stesso aumentando di 1 il livello
				calcola(parziale, parola, livello+1, anagrammi);
				
				//D - Backtracking=con la funzione substring tolgo l'ultimo carattere messo e quindi tengo dal char(0) a quello (length-1)
				parziale = parziale.substring(0, parziale.length()-1);
			}	
		}
		
	}
	
	
	//Questo metodo serve per controllare se la lettera che sto aggiungendo alla soluzione parziale può essere aggiunta o no
	//Gli passo come parametro la stringa in cui cercare e il carattere di cui vogliamo sapere il numero di volte che pu comparire
	public int contaCaratteri(String stringa, char c ) {
		//Inizializzo
		int contatore = 0 ;
		//Ciclo la stringa
		for (int i=0; i<stringa.length(); i++) {
			//Se al posto i-esimo della stringa trovo il carattere ricercato, allora incremento il contatore
			if (stringa.charAt(i)==c) {
				contatore++;
			}
		}
		//Alla fine ritorno il contatore
		return contatore;
	}//Questo metodo è fondamentale per il filtro dell'if

	
	
	

}
