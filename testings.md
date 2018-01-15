# Tp2
## Méthode Tous les noeuds
### Listing des noeuds
3 - 5 - 7 - 8 - 9 - 10 - 12 - 14 - 15 - 16 - 17 -20
### Cas de tests
On prend pour nos jeux de tests, les variables dir, etage, appels[], destination[]

#### Test 1
##### Description du cas de test
Nous testons si l'ascenseur conserve sa direction vers le haut `Direction.UP` dans la situation où il est à l'étage 1 et il y a un appel provenant du 3ème étage pour aller en bas
##### Nom du cas de test
testChoisirDirection_poursuiteMontee()
##### Données de test
DT1 = {
    1. ascenseur = new Ascenseur(1,this)
    2. appels[3] = Destination.DOWN;
    }
##### Chemin couvert
poursuite_Montee = [3.5.7.8.20]
##### Résultat attendu
Direction.UP
##### Condition de réussite
assertEquals(Direction.UP,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
##### Code
##### Trace d'execution du test

DT2 = {dir=Direction.UP , etage=2 , appels = [Direction.UP,null,null],
destinations = [false,false,false]} -> [3.5.7.9.10.20]

DT3 = {dir=Direction.DOWN , etage=2 , appels = [Direction.UP,null,null],
destinations = [false,false,false]} -> [3.5.12.14.15.20]

DT4 = {dir=Direction.DOWN , etage=2 , appels = [null,null,Direction.DOWN],
destinations = [false,false,false]} -> [3.5.12.14.16.17.20]

### Couverture
100%

## Tous les arcs
### Listing des arcs
(3,5),(5,7),(7,8),(8,20),(7,9),(9,10),(10,20),(9,20),(5,12),(12,20),(12,14),(14,15),(15,20),(14,16),(16,17),(16,20),(17,20)
### Cas de tests
On prend pour nos jeux de tests, les variables dir, etage, appels[], destination[]

DT1 = {dir=Direction.UP , etage=1 , appels = [null,null,Destination.DOWN],
destinations = [false,false,false]} -> [3.5.7.8.20]

DT2 = {dir=Direction.UP , etage=2 , appels = [Direction.UP,null,null],
destinations = [false,false,false]} -> [3.5.7.9.10.20]

DT3 = {dir=Direction.UP , etage=2 , appels = [null,null,null],
destinations = [false,false,false]} -> [3.5.7.9.20]

DT4 = {dir=null , etage=2 , appels = [Direction.UP,null,null],
destinations = [false,false,false]} -> [3.5.12.20]

DT5 = {dir=Direction.DOWN , etage=2 , appels = [Direction.UP,null,null],
destinations = [false,false,false]} -> [3.5.12.14.15.20]

DT6 = {dir=Direction.DOWN , etage=2 , appels = [null,null,Direction.DOWN],
destinations = [false,false,false]} -> [3.5.12.14.16.17.20]

DT7 = {dir=Direction.DOWN , etage=2 , appels = [null,null,Direction.DOWN],
destinations = [false,false,false]} -> [3.5.12.14.16.20]

### Couverture
100%

## Méthode PLCS
### Noeuds spéciaux
Entrée : 3
Sortie : 20
If a false : 12,9,16
### Sauts
Vers terminal : (8,20),(10,20),(9,20),(12,20),(15,20),(17,20),(16,20)
Vers if a false : (5,12),(7,9),(14,16)
### PLCS
#### Partant de 3
Vers 20 -> [3.5.7.8.20]
Vers 12 -> [3.5.12]
Vers 9 -> [3.5.7.9]
#### Partant de 12
Vers 20 -> [12.20]
Vers 20 -> [12.14.15.20]
Vers 16 -> [12.14.16]
#### Partant de 9
Vers 20 -> [9.10.20]
Vers 20 -> [9.20]
#### Partant de 16
Vers 20 -> [16.17.20]
Vers 20 -> [16.20]
### Couverture PLCS


