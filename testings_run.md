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
assertEquals(3,etage);
assertEquals(Direction.DOWN,dir)
##### Test exécuté avec succès ou non
##### Code
##### Trace d'execution du test

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
assertEquals(1,etage);
assertEquals(Direction.UP,dir)
##### Test exécuté avec succès ou non
##### Code
##### Trace d'execution du test

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
##### Code
##### Trace d'execution du test

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
