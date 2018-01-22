import evenements.*;


/** 
 * Classe qui decrit l'etat et le comportement d'un usager virtuel qui 
 * utilise un ascenseur.
 * */
public class Usager extends Thread 
{
	/** Nom textuel de l'usager. */
	private String name;
	/** Etage sur lequel l'usager se situe au debut de la simulation. */
    private int etage;
    /** Etage sur lequel l'usager veut se diriger. */
    private int dest;
    /** Direction verticale que l'usager veut se diriger. */
    private Direction dir;
    /** Temps de distraction en millisecondes. */
    private long delai;
    /** L'instance du simulateur qui gere le syteme. */	
    private Simulateur sim;

    static private boolean DEBUG =Constantes.DEBUG;

    /** Constructeur. */
    public Usager(String name, int etage, int dest, Simulateur sim)
    {
		this.name =name;
		this.etage =etage;
		this.dest =dest;
		this.dir = Direction.NONE;
		this.dir = dest > etage ? Direction.UP : Direction.DOWN;
		this.delai =0;
		this.sim =sim;
    }
    /** Constructeur supplementaire qui specifie un temps de distraction pour l'usager. */
    public Usager(String name, int etage, int dest, long distraction, Simulateur sim)
    {
		this.name =name;
		this.etage =etage;
		this.dest =dest;
		this.dir = Direction.NONE;
		this.dir = dest > etage ? Direction.UP : Direction.DOWN;
		this.delai =distraction;
		this.sim =sim;
    }
    /** Constructeur supplementaire qui specifie une direction et un temps de distraction pour l'usager. */
    public Usager(String name, int etage, int dest, Direction direction, long distraction, Simulateur sim)
    {
		this.name =name;
		this.etage =etage;
		this.dest =dest;
		this.dir = direction;
		this.delai =distraction;
		this.sim =sim;
    }

    @Override
    public String toString()
    {
    	return "Usager[" +
    			"nom="	+ name +
    			", etage=" + etage +
    			", dest=" + dest +
    			", dir=" + dir + 
    			"]";
    }

    public void run()
    {
		// [1] Tant que la porte n'est pas ouverte et la direction incorrecte 
    	while(!sim.check_porteOuverteCetEtage(etage) || !sim.check_directionAscenseur(dir))
    	{
    		// 1.1 Boucle d'attente ou d'appel...
			while(!sim.check_porteOuverteCetEtage(etage) || !sim.check_directionAscenseur(dir))
			{
			    // Si aucun appel n'est signale, l'usager effectue l'appel 
			    if (sim.appels[etage-1]==Direction.NONE)
			    {
			    	sim.ajouter_evenement(new EvtUsagerAppel(name,etage,dir));
			    	sim.appels[etage-1]=dir;
			    }		    

			    try { Thread.sleep(100); } // Courte pause pour allouer le controle aux autres threads...
			    catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }
			}
	
		    // 1.2 Dans certain l'usager est distrait (attente supplementaire) 
		    if(sim.non_determinisme() && delai > 0)
			    try 
		    	{
					sim.ajouter_evenement(new EvtUsagerDistrait(name));
					Thread.sleep(delai);
			    }
			    catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }	
		
    	} // 1.3 Si la porte est toujours ouverte, l'usager entre enfin! 
		
		
		// L'usager entre dans l'ascenseur 
		sim.ajouter_evenement(new EvtUsagerEntree(name));
	
		// [2] L'usager signale sa destination 
		sim.ajouter_evenement(new EvtUsagerDestination(name,dest));
		sim.destinations[dest-1]=true;
	
		// [3] L'usager attend que la porte s'ouvre a destination et il descend 
		while (!sim.check_porteOuverteCetEtage(dest))
		    try { Thread.sleep(100); } // Courte pause pour allouer le controle aux autres threads...
		    catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }
	
		// [4] L'usager est arrive a destination 
		sim.ajouter_evenement(new EvtUsagerSortie(name));
	
		// L'usager a termine 
		sim.sig_usagerTermine();
    }
}
