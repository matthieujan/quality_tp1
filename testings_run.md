# Tp2 - Ascenseur::run()
## Méthode Tous les noeuds
### Listing des noeuds
3 - 6 - 7 - 10 - 14 - 18 - 19 - 24 - 27 - 28 - 30 - 34 - 38 - 39 - 40 - 41 - 43 - 46 - 47 - 48 - 49 - 52
40 - 41 - 48 - 49
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
demiTourHaut = [3.6.7.10.14.18.19.24.27.28.30.34.38.39.43.46.47.52]
##### Résultat attendu
etage == 3
dir == Direction.DOWN
##### Condition de réussite
assertEquals(3,etage);
assertEquals(Direction.DOWN,dir)
##### Test exécuté avec succès ou non
##### Code
##### Trace d'execution du test

#### Test 1.2
##### Description du cas de test
On verifie que, si l'ascenseur est arreté au 1er étage après avoir été appellé, et qu'il est rappellé ensuite au rez de chaussé, il arrive au rez de chaussé et change automatiquement sa direction vers `Direction.UP` (car il ne peut plus descendre)
##### Nom du cas de test
testRun__demiTourBas()
##### Données de test
etage = 2
dir = Direction.NONE
sim.appel[1] = Direction.UP
sim.appel[0] = Direction.UP

##### Chemin couvert
demiTourHaut = [3.6.7.10.14.18.19.24.27.28.30.34.38.40.41.43.46.48.49.52]
##### Résultat attendu
etage == 1
dir == Direction.UP
##### Condition de réussite
assertEquals(1,etage);
assertEquals(Direction.UP,dir)
##### Test exécuté avec succès ou non
##### Code
##### Trace d'execution du test

### Couverture
Noeuds couverts / Noeuds totaux = 22/22 = 1


## Tous les arcs
### Listing des arcs
### Cas de tests
#### Test X
##### Description du cas de test
##### Nom du cas de test
##### Données de test
##### Chemin couvert
##### Résultat attendu
##### Condition de réussite
##### Test exécuté avec succès ou non
##### Code

##### Trace d'execution du test
### Couverture

## Méthode PLCS
### Noeuds spéciaux
Entrée :
Sortie :
If a false :
Loop end :
### Sauts
Vers terminal :
Vers if a false :
Vers loop end :
### PLCS
#### Partant de 
#### Partant de 
#### Partant de 
### Couverture PLCS
