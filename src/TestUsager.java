
import org.junit.*;
import static org.junit.Assert.*;


/**
 * Driver qui permet d'executer les tests unitaires sur le simulateur d'ascenseur.
 */
public class TestUsager extends Simulateur 
{

	public static junit.framework.Test suite() 
	{
		return new junit.framework.JUnit4TestAdapter(TestUsager.class);
	}

    
	
}
