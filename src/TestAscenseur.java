
import org.junit.*;
import static org.junit.Assert.*;


/**
 * Driver qui permet d'executer les tests unitaires sur le simulateur d'ascenseur.
 */
public class TestAscenseur extends Simulateur 
{

	public static junit.framework.Test suite() 
	{
		return new junit.framework.JUnit4TestAdapter(TestAscenseur.class);
	}

 	/** Test unitaire sur l'ascenseur. */
	@Test 
	public void testChoisirDir_chemin1() 
	{
		System.out.println("\n-> Test 1: choisir Direction - chemin 1\n");

		ascenseur =new Ascenseur(1,this);
		appels[1] =Direction.UP;
		System.out.println("(a) L'"+ascenseur+" est au 1er etage");

		// Valider le comportement : 
		assertEquals(ascenseur.choisirDirection(), Direction.UP);

		System.out.println("(b) La direction choisie est bien UP");

	}
    
	
}
