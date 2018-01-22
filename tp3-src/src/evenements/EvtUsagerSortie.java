package evenements;

public class EvtUsagerSortie extends Evt 
{
	public String name ="";
    public EvtUsagerSortie(String nom) { name =nom; }

    public String toString() { return "# Usager["+name+"]: \t\t# destination atteinte\n"; }
}