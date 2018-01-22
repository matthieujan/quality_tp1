package evenements;

public class EvtAscenseurEtage extends Evt 
{
	public int etage =0;
    public EvtAscenseurEtage(int et) { etage =et; }

    public String toString() { return "+ Ascenseur:	\t+ etage: "+etage+"\n"; }
}