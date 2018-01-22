package evenements;

public class EvtUsagerEntree extends Evt 
{
	public String name ="";
    public EvtUsagerEntree(String nom) { name =nom; }

    public String toString() { return "# Usager["+name+"]: \t\t# entre dans l'ascenseur\n"; }
}