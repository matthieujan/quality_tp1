
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
	

	
}
