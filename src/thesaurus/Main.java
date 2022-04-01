package thesaurus;

public class Main {

	public static void main(String[] args) {
		Thesaurus x = new Thesaurus();
		x.populate();
		x.print();
		
		
		x.addSynonym("happy", "extatic");
		x.print();
		
		x.addSynonym("policeman", "constable");
		x.print();
		
		x.replaceWord("happy", "A policeman's lot is not a happy one");

		x.crossReference();
		x.print();
	}


}
