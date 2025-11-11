package Labo1;

import java.util.Random;
import java.util.Scanner;



public class LePendu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] dico= {"java","proforma","ordinateur","utile","victoire"};
		char [] mot;
		char [] motcache;
		char lettre;
		boolean trouve;
		boolean motTrouve = false;
		int choixmot;
		int tour;
		int i;
		int choix;
		Random r=new Random();

		
		do {
		tour=1;
		int cpt = 0;
		choixmot=r.nextInt(5);
		mot= dico[choixmot].toCharArray();
		motcache=new char[mot.length];
		for (i=0;i<mot.length;i++) {
			motcache[i]='_';
		}

		System.out.println("jeu du pendu");

		while(cpt<6 && !motTrouve) {
			System.out.println("essai n° "+tour);
			Util.LesMéthodes.pendu(cpt);
			Util.UtilTab.affiche(motcache);


			lettre=Util.UtilSaisie.saisieChar("entre une lettre");


			trouve=false;
			for ( i=0;i<mot.length;i++) {
				if (mot[i]==lettre){
					motcache[i]=lettre;
					trouve=true;


				}
			}
			if(!trouve) {
				cpt++;
			
			}else {
				System.out.println("Bien joué !");
			}
			motTrouve = String.valueOf(mot).equals(String.valueOf(motcache));
			
			tour++;

		} 

		if(motTrouve) {
				 System.out.println("Bravo ! Tu as trouvé le mot : " + String.valueOf(mot));
        } else {
            Util.LesMéthodes.pendu(cpt);
            System.out.println("Dommage... Le mot était : " + dico[choixmot]);
        }
		
		System.out.println("veux-tu recommencer ? \n1. OUI \n2. NON");
		choix=new Scanner(System.in).nextInt();
		}while(choix==1);
		
		if(choix==2)
			System.out.println("au revoir");
	}
	
}
