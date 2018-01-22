# Tp2 - Ascenseur::run()
## Méthode Tous les noeuds
### Listing des noeuds
3 - 6 - 7 - 10 - 14 - 18 - 19 - 24 - 27 - 28 - 30 - 34 - 38 - 39 - 40 - 41 - 43 - 46 - 47 - 48 - 49 - 52 - 54
### Cas de tests
#### Test 1.1
##### Description du cas de test
On verifie que, si l'ascenseur est arreté à l'avant dernier étage après avoir été appellé, et qu'il est rappellé ensuite au dernier étage, il arrive au dernier étage et change automatiquement sa direction vers `Direction.DOWN` (car il ne peut plus monter)
##### Nom du cas de test
testRun__demiTourHaut()
##### Données de test
etage = 2
dir = Direction.NONE
sim.appel[1] = Direction.UP
sim.appel[2] = Direction.DOWN

##### Chemin couvert
demiTourHaut = [3.6.7.10.14.18.19.18.24.27.28.30.34.38.39.43.46.47.52]
##### Résultat attendu
etage == 3
dir == Direction.DOWN
##### Condition de réussite
assertTrue(check_directionAscenseur(Direction.DOWN))
assertTrue(check_arretCetEtage(3))
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testRun_demiTourHaut()
	{
		System.out.println("\n-> Test 1.1: run - demi tour haut\n");
		ascenseur =new Ascenseur(2,this);
		//Lancement de la méthode run
		ascenseur.start();
		ascenseur.dir = Direction.NONE;
		appels[1] =Direction.UP;
		appels[2] =Direction.DOWN;
		System.out.println("(a) L'"+ascenseur+" est au 2 eme etage");



		try { Thread.sleep(Constantes.DELAIDISTRACTION); }
		catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }

		etageArret=-1;
		try { Thread.sleep(Constantes.DELAIDISTRACTION); }
		catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }


		// Valider le comportement :
		assertTrue(check_directionAscenseur(Direction.DOWN));
		System.out.println("(b) La direction choisie est bien DOWN");

		assertTrue(check_arretCetEtage(3));
		System.out.println("(c) L'ascenseur s'est bien arrété à l'étage 3");
	}
```
##### Trace d'execution du test
```
-> Test 1.1: run - demi tour haut

(a) L'Ascenseur[etage=2, dir=NONE] est au 2 eme etage
1.	+ Ascenseur:		+ arret a l'etage 2
2.	+ Ascenseur: 		+ fin de l'arret
 >> appelAuDessus(2) =true
3.	+ Ascenseur:		+ direction: UP
4.	+ Ascenseur:		+ etage: 3
5.	+ Ascenseur:		+ arret a l'etage 3
(b) La direction choisie est bien DOWN
(c) L'ascenseur s'est bien arrété à l'étage 3
```

#### Test 1.2
##### Description du cas de test
On verifie que, si l'ascenseur arrive au 1er étage après avoir été appellé ET que l'ascenseur avait pour destination le 1er étage, et qu'il est rappellé ensuite au rez de chaussé, il arrive au rez de chaussé et change automatiquement sa direction vers `Direction.UP` (car il ne peut plus descendre)
##### Nom du cas de test
testRun__demiTourBas()
##### Données de test
etage = 2
dir = Direction.UP
sim.destination[1] = true
sim.appel[1] = Direction.DOWN
sim.appel[0] = Direction.UP

##### Chemin couvert
demiTourHaut = [3.6.7.10.14.18.19.18.24.27.30.34.38.40.41.43.46.48.49.52]
##### Résultat attendu
etage == 1
dir == Direction.UP
##### Condition de réussite
assertTrue(check_directionAscenseur(Direction.UP));
assertTrue(check_arretCetEtage(1));
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testRun_demiTourBas()
	{
		System.out.println("\n-> Test 1.2: run - demi tour bas\n");
		ascenseur =new Ascenseur(2,this);
		//Lancement de la méthode run
		ascenseur.start();
		ascenseur.dir = Direction.UP;
		this.destinations[1] = true;
		appels[1] =Direction.DOWN;
		appels[0] =Direction.UP;
		System.out.println("(a) L'"+ascenseur+" est au 2 eme etage");



		try { Thread.sleep(Constantes.DELAIDISTRACTION); }
		catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }

		etageArret=-1;
		try { Thread.sleep(Constantes.DELAIDISTRACTION); }
		catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }


		// Valider le comportement :
		assertTrue(check_directionAscenseur(Direction.UP));
		System.out.println("(b) La direction choisie est bien UP");

		assertTrue(check_arretCetEtage(1));
		System.out.println("(c) L'ascenseur s'est bien arrété à l'étage 1");
	}
```
##### Trace d'execution du test
```
-> Test 1.2: run - demi tour bas

(a) L'Ascenseur[etage=2, dir=UP] est au 2 eme etage
1.	+ Ascenseur:		+ arret a l'etage 2
2.	+ Ascenseur: 		+ fin de l'arret
 >> appelAuDessus(2) =false
 >> destAuDessus(2) =false
 >> appelEnDessous(2) =true
3.	+ Ascenseur:		+ direction: DOWN
4.	+ Ascenseur:		+ etage: 1
5.	+ Ascenseur:		+ arret a l'etage 1
(b) La direction choisie est bien UP
(c) L'ascenseur s'est bien arrété à l'étage 1
```

### Couverture
Noeuds couverts / Noeuds totaux = 22/23


## Tous les arcs
### Listing des arcs
(3,6),(6,7),(6,10),(10,14),(14,18),(18,19),(19,18),(18,24),(24,27),(27,28),(27,30),(10,34),(28,30),(30,34),(34,38),(38,39),(38,40),(40,41),(40,43),(39,43),(41,43),(43,46),(46,47),(46,48),(48,49),(47,52),(48,52),(49,52),(52,3),(3,54)
### Cas de tests
#### Test 2.1 (1.1)
##### Description du cas de test
On verifie que, si l'ascenseur est arreté à l'avant dernier étage après avoir été appellé, et qu'il est rappellé ensuite au dernier étage, il arrive au dernier étage et change automatiquement sa direction vers `Direction.DOWN` (car il ne peut plus monter)
##### Nom du cas de test
testRun__demiTourHaut()
##### Données de test
etage = 2
dir = Direction.NONE
sim.appel[1] = Direction.UP
sim.appel[2] = Direction.DOWN

##### Chemin couvert
demiTourHaut = [3.6.7.10.14.18.24.27.28.30.34.38.39.43.46.47.52]
##### Deroulement du test
Voir Test 1.1

#### Test 2.2 (1.2)
##### Description du cas de test
On verifie que, si l'ascenseur arrive au 1er étage après avoir été appellé ET que l'ascenseur avait pour destination le 1er étage, et qu'il est rappellé ensuite au rez de chaussé, il arrive au rez de chaussé et change automatiquement sa direction vers `Direction.UP` (car il ne peut plus descendre)
##### Nom du cas de test
testRun__demiTourBas()
##### Données de test
etage = 2
dir = Direction.UP
sim.destination[1] = true
sim.appel[1] = Direction.DOWN
sim.appel[0] = Direction.UP

##### Chemin couvert
demiTourHaut = [3.6.10.14.18.19.18.24.27.30.34.38.40.41.43.46.48.49.52]
##### Déroulement du test
Voir Test 1.2

#### Test 2.3
##### Description du cas de test
On verifie que si l'ascenseur n'a rien a faire et qu'il n'est pas tout en bas ou tout en haut, il ne fait rien
##### Nom du cas de test
testRun_standByMiddle()
##### Données de test
dir = Direction.NONE
etage = 2
##### Chemin couvert
standByMiddle = [3.6.10.34.38.40.43.46.48.52]
##### Résultat attendu
etage=2
dir = Direction.NONE
##### Condition de réussite
assertEquals(2,etage);
assertEquals(Direction.NONE,dir)
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testRun_standByMiddle()
	{
		System.out.println("\n-> Test 2.3: run - stand by middle\n");
		ascenseur =new Ascenseur(2,this);
		//Lancement de la méthode run
		ascenseur.start();
		ascenseur.dir = Direction.NONE;
		System.out.println("(a) L'"+ascenseur+" est au 2 eme etage");



		try { Thread.sleep(Constantes.DELAIDISTRACTION); }
		catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }

		etageArret=-1;
		try { Thread.sleep(Constantes.DELAIDISTRACTION); }
		catch(InterruptedException e) { System.out.print("Erreur dans Thread.sleep\n"); }


		// Valider le comportement :
		assertTrue(check_directionAscenseur(Direction.DOWN));
		System.out.println("(b) La direction choisie est bien DOWN");

		assertTrue(check_arretCetEtage(3));
		System.out.println("(c) L'ascenseur s'est bien arrété à l'étage 3");
	}
```
##### Trace d'execution du test
La fonction Run étant une boucle infini, l'ascenseur attend à l'étage 2 à l'infini
```
-> Test 2.3: run - stand by middle

(a) L'Ascenseur[etage=2, dir=NONE] est au 2 eme etage
 >> appelAuDessus(2) =false
 >> destAuDessus(2) =false
 >> appelEnDessous(2) =false
 >> destEnDessous(2) =false
1.	+ Ascenseur:		+ direction: NONE
2.	+ Ascenseur:		+ etage: 2
 >> appelAuDessus(2) =false
 >> destAuDessus(2) =false
 >> appelEnDessous(2) =false
 >> destEnDessous(2) =false
3.	+ Ascenseur:		+ direction: NONE
4.	+ Ascenseur:		+ etage: 2
 >> appelAuDessus(2) =false
 >> destAuDessus(2) =false
 >> appelEnDessous(2) =false
 >> destEnDessous(2) =false

 ...
```

### Couverture
Arc couverts / Arc totaux  = 30 / 31

## Méthode PLCS
### Noeuds spéciaux
Entrée : 3
Sortie :54
If a false : 10, 24, 30, 34, 40, 43, 48, 52, 54
Loop end : 52
### Sauts
Vers terminal :
Vers if a false : (6,10),(7,10),(18,24),(27,30),(28,30),(10,34),(30,34),(38,40),(40,43),(41,43),(39,43),(46,48),(48,52),(49,52),(47,52)
Vers loop end : (Redite, car loop end egalement if a false)
### PLCS
#### Partant de 3
Vers 10 -> [3.6.10] -> Couvert par Test 2.3
Vers 10 -> [3.6.7.10] -> Couvert par Test 1.1
Vers 54 -> [3.54] -> Infaisable (while true)
#### Partant de 10
Vers 24 -> [10.14.18.24] -> Couvert par Test 1.2
Vers 24 -> [10.14.18.19.18.24] -> Couvert par Test 1.1
Vers 34 -> [10.34] -> Couvert par Test 2.3
#### Partant de 24
Vers 30 -> [24.27.30] -> Couvert par Test 1.2
Vers 30 -> [24.27.28.30] -> Couvert par Test 1.1
#### Partant de 30
Vers 34 -> [30.34] -> Couvert par Test 1.1
#### Partant de 34
Vers 40 -> [34.38.40] -> Couvert par Test 1.2
Vers 43 -> [34.38.39.43] -> Couvert par Test 1.1
#### Partant de 40
Vers 43 -> [40.43] -> Couvert par Test 2.3
Vers 43 -> [40.41.43] -> Couvert par Test 1.2
#### Partant de 43
Vers 48 -> [43.46.48] -> Couvert par Test 1.2
Vers 52 -> [43.46.47.52] -> Couvert par Test 1.1
#### Partant de 48
Vers 52 -> [48.52] -> Couvert par Test 2.3
Vers 52 -> [48.49.52] -> Couvert par Test 1.2
#### Partant de 52
Vers 3 -> [52.3] -> Tous (Repetition de la boucle)
### Couverture PLCS
PLCS couvert / PLC Totaux= 17 / 18

## Méthode def-use
### Preparation
#### Tableau de flot de données (pour var : etage)
| Noeud     | définition   | c-utilisation   | p-utilisation   |
| --------- | :----------: | :-------------: | --------------: |
| 01        | etage        |                 |                 |
| 06        |              |                 | etage           |
| 07        |              | etage           |                 |
| 10        |              |                 | etage           |
| 14        |              | etage           |                 |
| 27        |              |                 | etage           |
| 28        |              | etage           |                 |
| 30        |              | etage           |                 |
| 39        | etage        | etage           |                 |
| 41        | etage        | etage           |                 |
| 46        |              |                 | etage           |
| 48        |              |                 | etage           |

#### Tableau de pair def-use (pour var : etage)
- Pas compris comment le réaliser
