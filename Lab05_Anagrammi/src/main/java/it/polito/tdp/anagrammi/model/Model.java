package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.polito.tdp.anagrammi.dao.DizionarioDAO;

public class Model {
	
	private Set<String> dizionario;
	private DizionarioDAO dao;
	private int n;
	private List<String> corretti;
	private List<String> errati;
	
	public Model() {
		this.dizionario = new HashSet<>();
		this.dao = new DizionarioDAO();
		this.dao.caricaDizionario(this.dizionario);
	}
	
	public Set<String> getDizionario(){
		return this.dizionario;
	}
	
	public void cercaAnagrammi(String parola) {
		this.n = parola.length();
		this.corretti = new ArrayList<>();
		this.errati = new ArrayList<>();
		List<Character> disponibili = new ArrayList<>();
		for(int i=0; i<n; i++) {
			disponibili.add(parola.charAt(i));
		}
		
		cerca("", 0, disponibili);
		
	}
	
	private void cerca(String parziale, int livello, List<Character> disponibili) {
		if(livello==n) {
			//System.out.println(parziale);
			if(dizionario.contains(parziale) && !corretti.contains(parziale)) {
				corretti.add(parziale);
			}else if(!dizionario.contains(parziale) && !errati.contains(parziale)) {
				errati.add(parziale);
			}
			return;
		}
		
		for(Character c : disponibili) {
			String tentativo = parziale + c;
			List<Character> rimasti = new ArrayList<>(disponibili);
			rimasti.remove(c);
			cerca(tentativo, livello+1, rimasti);
			rimasti.add(c);
			tentativo = parziale;
		}
		
	}
	
	public List<String> getCorretti(){
		return corretti;
	}
	
	public List<String> getErrati(){
		return errati;
	}

}
