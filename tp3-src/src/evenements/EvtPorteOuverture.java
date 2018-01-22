package evenements;

public class EvtPorteOuverture extends Evt 
{
	public int etage =0;
    public EvtPorteOuverture(int et) { etage =et; }

    public String toString() { return "* Porte etage "+etage+":\t* ouverture\n"; }
}
