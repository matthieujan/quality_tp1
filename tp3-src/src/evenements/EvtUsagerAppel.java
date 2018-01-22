package evenements;

public class EvtUsagerAppel extends Evt 
{
	public int etage =0;
	public Direction dir =Direction.NONE;
	public String name ="";
    public EvtUsagerAppel(String nom, int et, Direction direction) { dir =direction; etage =et; name =nom; }

    public String toString() { return "# Usager["+name+"]: \t\t# effectue l'appel "+etage+"-"+dir+"\n"; }
}