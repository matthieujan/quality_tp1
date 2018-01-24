
import org.junit.*;
import static org.junit.Assert.*;
import evenements.*;


/**
 * Driver qui permet d'executer les tests unitaires sur le simulateur d'ascenseur.
 */
public class TestGlobal extends Simulateur 
{

	public static junit.framework.Test suite() 
	{
		return new junit.framework.JUnit4TestAdapter(TestGlobal.class);
	}


	public boolean REUSSITE =true;

 	/** Test unitaire sur l'ascenseur. */
	@Test 
	public void testGlobalTousPreambules() 
	{
		System.out.println("\n-> Test Global: tester les 4 conditions globales sur tous les preambules \n");

		// Creer les portes (de 0 a 2 pour les etages 1 a 3)
		for (int i=0;i<Constantes.ETAGES;i++)
		{
		    portes[i] =new Porte(i+1,this); // (etage, simulateur)
		    portes[i].start();
		}
	
		
		//Bouclez ici!
		{
			int depart0 =2, dest0 =3;
			int depart1 =3, dest1 =1;
			int etageAsc =1;

			System.out.println("Input: Usager0("+depart0+","+dest0+") Usager1("+depart1+","+dest1+") Asc("+etageAsc+")");
			
			// Creer les usagers (max 2 usagers, pas de delai)
			(new Usager("0",depart0,dest0,0, this)).start(); // (nom, etage, dest, delai, simulateur)
			(new Usager("1",depart1,dest1,0, this)).start();
			
			// Creer l'ascenseur  
			ascenseur = new Ascenseur(etageAsc, this); // (etage, simulateur)
			ascenseur.start();
		
			// Attendre fin de la simulation ou une faute...
			while (usager_term <Constantes.USAGERS && REUSSITE)
				pause(50);

			ascenseur.stop();

			
			// Verifier que les conditions globales sont toujours respect�es
			assertTrue( " Trace : \n" + evenements, REUSSITE );


			// Reinitialisation
			pause(Constantes.DELAIPORTE); // Court delai avant de demarrer prochain test
			evenements.clear();
			usager_term =0;
			etageArret =-1;
			for (int i=0;i<Constantes.ETAGES;i++)
			{
				appels[i] =Direction.NONE;
				destinations[i] =false;
			}

		} // Recommencez avec un nouveau preambule...

		
	}

	

    /*******************************
     * Comportement global 1
     * Lorsque l'ascenseur est en mouvement, aucune porte n'est ouverte
     *******************************/
    private boolean TestGlobal1()
    {
		// Vecteur pour noter quelle porte est ouverte
		boolean portesOuverte[] = new boolean[Constantes.ETAGES];

		// Variable pour verifier s'il y a eu un changement d'etage
		int etageCourant =-1;
	
	
		// Analyse de la sequence d'evenements 
		for (int i=0; i<evenements.size(); i++)
		{
		    // Initialiser la variable etageCourant
		    if (etageCourant ==-1)
				if (evenements.get(i) instanceof EvtAscenseurArret)
					etageCourant =((EvtAscenseurArret) evenements.get(i)).etage;
				else if (evenements.get(i) instanceof EvtAscenseurEtage)
					etageCourant =((EvtAscenseurEtage) evenements.get(i)).etage;


		    // Une porte s'ouvre 
		    if(evenements.get(i) instanceof EvtPorteOuverture) {
		    	int etage =((EvtPorteOuverture) evenements.get(i)).etage;
		    	portesOuverte[etage-1] =true;
		    }
	
		    // Une porte se ferme
		    if(evenements.get(i) instanceof EvtPorteFermeture) {
		    	int etage =((EvtPorteFermeture) evenements.get(i)).etage;
		    	portesOuverte[etage-1] =true;
		    }
	
		    // L'ascenseur se deplace
		    if(evenements.get(i) instanceof EvtAscenseurEtage) {

				// Verifier s'il y a un changement d'etage
				if (etageCourant !=((EvtAscenseurEtage) evenements.get(i)).etage)
					// Si une porte est ouverte, il y a une erreur!
					for(int j=0; j<Constantes.ETAGES; j++)
				    	if(portesOuverte[j]) 
						{
							System.out.println("\n Faute TestGlobal1, evenement ["+i+"]: " 
									+ evenements.get(i)
									+ " -> La porte ["+(j+1)+"] est ouverte. ");
							return false;
				    	}

				etageCourant =((EvtAscenseurEtage) evenements.get(i)).etage;
		    }

		    // Les autres evenements sont ignores
		}
	
		// Aucune erreur de trouvee 
		return true;
    }
    
    
    /** Signal d'arrive d'un usager, et fin de l'application... */
    public void sig_usagerTermine()
    {
		usager_term ++;
		
		if (usager_term == Constantes.USAGERS)
		{
		    System.out.println("Fin de la simulation");
		}
    }

    /** Traitement des evenements */
    public void ajouter_evenement(Evt evt)
    {
		// Ajouter l'evenement 
		evenements.add(evt);
		System.out.print(".");

		// A chaque fois q'un evenement est ajoute, on verifie les conditions globales!
		if (REUSSITE)
			REUSSITE =TestGlobal1();

		// Global2, Global3, Global4
    }

	private void pause(long delai)
	{
	    try { Thread.sleep(delai); }
	    catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }					
	}

}