# Rapport TP3
## Code Tests Globaux
### Test Global1
```
/*******************************
     * Comportement global 1
     * Lorsque l'ascenseur est en mouvement, aucune porte n'est ouverte
     *******************************/
    private boolean TestGlobal1()
    {
		// Vecteur pour noter quelle porte est ouverte
		boolean portesOuverte[] = new boolean[Constantes.ETAGES];

		// Variable pour verifier s'il y a eu un changement d'etage
		int etageCourant =-1;


		// Analyse de la sequence d'evenements
		for (int i=0; i<evenements.size(); i++)
		{
		    // Initialiser la variable etageCourant
		    if (etageCourant ==-1)
				if (evenements.get(i) instanceof EvtAscenseurArret)
					etageCourant =((EvtAscenseurArret) evenements.get(i)).etage;
				else if (evenements.get(i) instanceof EvtAscenseurEtage)
					etageCourant =((EvtAscenseurEtage) evenements.get(i)).etage;


		    // Une porte s'ouvre
		    if(evenements.get(i) instanceof EvtPorteOuverture) {
		    	int etage =((EvtPorteOuverture) evenements.get(i)).etage;
		    	portesOuverte[etage-1] =true;
		    }

		    // Une porte se ferme
		    if(evenements.get(i) instanceof EvtPorteFermeture) {
		    	int etage =((EvtPorteFermeture) evenements.get(i)).etage;
		    	portesOuverte[etage-1] =false;
		    }

		    // L'ascenseur se deplace
		    if(evenements.get(i) instanceof EvtAscenseurEtage) {

				// Verifier s'il y a un changement d'etage
				if (etageCourant !=((EvtAscenseurEtage) evenements.get(i)).etage)
					// Si une porte est ouverte, il y a une erreur!
					for(int j=0; j<Constantes.ETAGES; j++)
				    	if(portesOuverte[j])
						{
							System.out.println("\n Faute TestGlobal1, evenement ["+i+"]: "
									+ evenements.get(i)
									+ " -> La porte ["+(j+1)+"] est ouverte. ");
							return false;
				    	}

				etageCourant =((EvtAscenseurEtage) evenements.get(i)).etage;
		    }

		    // Les autres evenements sont ignores
		}

		// Aucune erreur de trouvee
		return true;
    }
    
    ```
### Test Global2

```
    /*******************************
     * Comportement global 2
     * Il est toujours vrai qu'un usager qui demande l'ascenseur y entrera fatalement
     *******************************/
    private boolean TestGlobal2(){
        // Analyse de la sequence d'evenements
        HashMap<String,Integer> usagersSource = new HashMap();
        HashMap<String,Boolean> usagersDistrait = new HashMap();

        int etageCourant = -1;

		for (int i=0; i<evenements.size(); i++)
		{
            // Gestion des appels
            if(evenements.get(i) instanceof EvtUsagerAppel) {
                String name = ((EvtUsagerAppel) evenements.get(i)).name;
                int etage = ((EvtUsagerAppel) evenements.get(i)).etage;
                usagersSource.put(name,etage);
            }

            // Gestion des entrées
            if(evenements.get(i) instanceof EvtUsagerEntree) {
                String name = ((EvtUsagerEntree) evenements.get(i)).name;
                usagersSource.remove(name);
            }

            // Gestion des entrées
            if(evenements.get(i) instanceof EvtAscenseurEtage) {
                etageCourant = ((EvtAscenseurEtage) evenements.get(i)).etage;
            }

            // Gestion des distraction
            if(evenements.get(i) instanceof EvtUsagerDistrait) {
                String name = ((EvtUsagerDistrait) evenements.get(i)).name;
                usagersDistrait.put(name,true);
            }

            //Si a la fin de l'arret l'usager esgt toujours en train d'attendre, erreur
            //Sauf si celui ci est distrait
            if(evenements.get(i) instanceof EvtAscenseurFinArret) {
                for(Map.Entry<String, Integer> entry : usagersSource.entrySet()){
                        String name = entry.getKey();
                        if(usagersSource.get(name) == etageCourant){
                            if(usagersDistrait.containsKey(name) && usagersDistrait.get(name)){
                                usagersDistrait.remove(name);
                            }else{
                                return false;
                            }
                        }
                }
            }

		    // Les autres evenements sont ignores
		}

		// Aucune erreur de trouvee
		return true;
    }
    ```

### Test Global3

```
    /*******************************
     * Comportement global 3
     * Il n'y a jamais plus d'une porte ouverte à la fois
     *******************************/
    private boolean TestGlobal3()
    {
		// Vecteur pour noter quelle porte est ouverte
		boolean portesOuverte[] = new boolean[Constantes.ETAGES];

		// Analyse de la sequence d'evenements
		for (int i=0; i<evenements.size(); i++)
		{
		    // Une porte s'ouvre
		    if(evenements.get(i) instanceof EvtPorteOuverture) {
		    	int etage =((EvtPorteOuverture) evenements.get(i)).etage;
		    	portesOuverte[etage-1] =true;
		    }
		    // Une porte se ferme
		    if(evenements.get(i) instanceof EvtPorteFermeture) {
		    	int etage =((EvtPorteFermeture) evenements.get(i)).etage;
		    	portesOuverte[etage-1] =false;
		    }
            //Verifier qu'il n'y a pas plus d'une porte ouverte à la fois
            int portesOuvertes = 0;
            for(int j= 0; j<portesOuverte.length;j++){
                if(portesOuverte[j]) portesOuvertes++;
            }

            if(portesOuvertes>1){
                return false;
            }
		    // Les autres evenements sont ignores
		}

		// Aucune erreur de trouvee
		return true;
    }
```

### Test Global4
```
    /*******************************
     * Comportement global 4
     * La distance parcourue par un usager est toujours égale à [source-destination]
     *******************************/
    private boolean TestGlobal4(){
        // Analyse de la sequence d'evenements
        HashMap<String,Integer> usagersInside = new HashMap();
        HashMap<String,Integer> usagersSource = new HashMap();
        HashMap<String,Integer> usagersDest = new HashMap();
        // Variable pour verifier s'il y a eu un changement d'etage
		int etageCourant =-1;
		for (int i=0; i<evenements.size(); i++)
		{

            // Initialiser la variable etageCourant
		    if (etageCourant ==-1)
				if (evenements.get(i) instanceof EvtAscenseurArret)
					etageCourant =((EvtAscenseurArret) evenements.get(i)).etage;
				else if (evenements.get(i) instanceof EvtAscenseurEtage)
					etageCourant =((EvtAscenseurEtage) evenements.get(i)).etage;

            //Gestion des entrées dans l'ascenseur
		    if(evenements.get(i) instanceof EvtUsagerEntree) {
                String name = ((EvtUsagerEntree) evenements.get(i)).name;
                usagersInside.put(name,0);
            }

            //Gestion des sorties de l'ascenseur
            if(evenements.get(i) instanceof EvtUsagerSortie) {
                String name = ((EvtUsagerSortie) evenements.get(i)).name;
                int deplExpected = usagersSource.get(name)-usagersDest.get(name);
                if(deplExpected<0)deplExpected*=-1;
                if(usagersInside.get(name)!=deplExpected){
                    return false;
                }
                usagersInside.remove(name);
            }

            // Gestion des appels
            if(evenements.get(i) instanceof EvtUsagerAppel) {
                String name = ((EvtUsagerAppel) evenements.get(i)).name;
                int etage = ((EvtUsagerAppel) evenements.get(i)).etage;
                usagersSource.put(name,etage);
            }

            // Gestion des destinations
            if(evenements.get(i) instanceof EvtUsagerDestination) {
                String name = ((EvtUsagerDestination) evenements.get(i)).name;
                int etage = ((EvtUsagerDestination) evenements.get(i)).dest;
                usagersDest.put(name,etage);
            }

            // L'ascenseur se deplace
		    if(evenements.get(i) instanceof EvtAscenseurEtage) {
				// Verifier s'il y a un changement d'etage
                int deplacement = etageCourant-((EvtAscenseurEtage)evenements.get(i)).etage;
                if (deplacement != 0){
                    if(deplacement < 0) deplacement*=-1;

                    for(Map.Entry<String, Integer> entry : usagersInside.entrySet()){
                        String name = entry.getKey();
                        usagersInside.put(name,usagersInside.get(name)+deplacement);
                    }
                }

				etageCourant =((EvtAscenseurEtage) evenements.get(i)).etage;
		    }

		    // Les autres evenements sont ignores
		}

		// Aucune erreur de trouvee
		return true;
    }
    ```

## Trace test sans distraction
```JUnit version 4.1
.
-> Test Global: tester les 4 conditions globales sur tous les preambules 

Input: Usager0(2,3) Usager1(3,1) Asc(1)
TestGlobal1 : 
..........................Fin de la simulation
.Input: Usager0(2,3) Usager1(3,1) Asc(1)
TestGlobal2 : 
..........................Fin de la simulation
.Input: Usager0(2,3) Usager1(3,1) Asc(1)
TestGlobal3 : 
..........................Fin de la simulation
.Input: Usager0(2,3) Usager1(3,1) Asc(1)
TestGlobal4 : 
..........................Fin de la simulation
.
Time: 14.849

OK (1 test)```

## Trace test avec distraction
```JUnit version 4.1
.
-> Test Global: tester les 4 conditions globales sur tous les preambules 

Input: Usager0(2,3) Usager1(3,1) Asc(1)
TestGlobal1 : 
..........................................Fin de la simulation
.Input: Usager0(2,3) Usager1(3,1) Asc(1)
TestGlobal2 : 
............................................................................Fin de la simulation
.Input: Usager0(2,3) Usager1(3,1) Asc(1)
TestGlobal3 : 
..............................................................................................................................................................Fin de la simulation
.Input: Usager0(2,3) Usager1(3,1) Asc(1)
TestGlobal4 : 
..............................................................................................................Fin de la simulation
.
Time: 48.338

OK (1 test)```
