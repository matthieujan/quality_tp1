package evenements;

public class EvtPorteFermeture extends Evt 
{
	public int etage =0;
    public EvtPorteFermeture(int et) { etage =et; }

    public String toString() { return "* Porte etage "+etage+":\t* fermeture\n"; }
}