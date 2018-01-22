package evenements;

public class EvtAscenseurArret extends Evt 
{
	public int etage =0;
    public EvtAscenseurArret(int et) { etage =et; }

    public String toString() { return "+ Ascenseur:	\t+ arret a l'etage "+etage+"\n"; }
}