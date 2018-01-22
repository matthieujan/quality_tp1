package evenements;

public class EvtUsagerDestination extends Evt 
{
	public int dest =0;
	public String name ="";
    public EvtUsagerDestination(String nom, int et) { dest =et; name =nom; }

    public String toString() { return "# Usager["+name+"]: \t\t# entre la destination "+dest+"\n"; }
}