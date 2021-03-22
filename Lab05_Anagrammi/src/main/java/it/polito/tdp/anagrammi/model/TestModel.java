package it.polito.tdp.anagrammi.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		//System.out.println(model.getDizionario());
		model.cercaAnagrammi("posto");
		System.out.println(model.getCorretti());
		System.out.println(model.getErrati());
	}

}
