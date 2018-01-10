
import org.junit.*;
import static org.junit.Assert.*;


/**
 * Driver qui permet d'executer les tests unitaires sur le simulateur d'ascenseur.
 */
public class TestSimulateur extends Simulateur 
{

	public static junit.framework.Test suite() 
	{
		return new junit.framework.JUnit4TestAdapter(TestSimulateur.class);
	}

    
	/** Test unitaire sur la porte. */
	@Test 
	public void testPorte1() 
	{
		System.out.println("\n-> Test 1: ouverture/fermeture d'une porte au 1er l'etage\n");

		portes[0] =new Porte(1,Constantes.DELAIPORTE,this);
		portes[0].start();

		// Valider le comportement : la porte est bien fermee?
		assertFalse(portes[0].check_porteOuverte());
		assertEquals(etageArret,-1,0);
		System.out.println("(a) La "+portes[0]+" est bien fermee, et aucun signal d'arret.");


		// Simuler l'arr�t de l'ascenseur au 1er etage
		etageArret=1;

		// Attendre ouverture de la porte (1/2 delai)...
		try { Thread.sleep(Constantes.DELAIPORTE/2); }
		catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }

		// Valider le comportement : la porte est ouverte?
		assertTrue(portes[0].check_porteOuverte());
		System.out.println("(b) La "+portes[0]+" est bien ouverte.");

		// Attendre fermeture de la porte (delai complet)...
		try { Thread.sleep(Constantes.DELAIPORTE); }
		catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }

		// Valider le comportement : la porte s'est refermee?
		assertFalse(portes[0].check_porteOuverte());
		System.out.println("(c) La "+portes[0]+" s'est bien refermee.");
	}

	/** Test unitaire sur Usager */
	@Test
	public void testUsagerAttentif()
	{
		System.out.println("\n -> Test UsagerAttentif : vérification d'arrivé à destination d'un usager");
		Usager user = new Usager("Usager1",3,1,this);
		//Valider l'état de départ
		assertEquals("Usager : name=Usager1 - etage=3 - destination=1 - distraction=0",user.toString());


		portes[2] = new Porte(3,Constantes.DELAIPORTE,this);
		portes[0] = new Porte(1,Constantes.DELAIPORTE,this);

		this.ascenseur = new Ascenseur(0,this);

		//Run user
		user.start();

		this.ascenseur.etage=3; //Placé l'ascenseur à l'étage 3
		this.portes[2].porteOuverte=true;

		// Attendre l'entrée de l'usager (4s delai)...
		try { Thread.sleep(Constantes.DELAIDISTRACTION); }
		catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }


		// Attendre que l'usager selection l'étage.
		try { Thread.sleep(Constantes.DELAIDISTRACTION); }
		catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }


		this.portes[2].porteOuverte = false;
		this.ascenseur.etage=1;
		this.portes[0].porteOuverte = true;

		// Attendre que l'usager sorte.
		try { Thread.sleep(Constantes.DELAIDISTRACTION); }
		catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }

        assertEquals("Usager : name=Usager1 - etage=1 - destination=1 - distraction=0",user.toString());
	}
	

	
}
