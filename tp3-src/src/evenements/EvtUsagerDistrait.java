package evenements;

public class EvtUsagerDistrait extends Evt 
{
	public String name ="";
    public EvtUsagerDistrait(String nom) { name =nom; }

    public String toString() { return "# Usager["+name+"]: \t\t# est distrait...\n"; }
}