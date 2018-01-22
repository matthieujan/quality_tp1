package evenements;

public class EvtAscenseurDirection extends Evt 
{
	public Direction dir =Direction.NONE;
    public EvtAscenseurDirection(Direction direction) { dir =direction; }

    public String toString() { return "+ Ascenseur:	\t+ direction: "+dir+"\n"; }
}