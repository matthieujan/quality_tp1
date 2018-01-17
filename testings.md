# Tp2
## Méthode Tous les noeuds
### Listing des noeuds
3 - 5 - 7 - 8 - 9 - 10 - 12 - 14 - 15 - 16 - 17 -20
### Cas de tests
On prend pour nos jeux de tests, les variables dir, etage, appels[], destination[]

#### Test 1.1
##### Description du cas de test
Nous testons si l'ascenseur conserve sa direction vers le haut `Direction.UP` dans la situation où il est à l'étage 1 et il y a un appel provenant du 3ème étage pour aller en bas
##### Nom du cas de test
testChoisirDirection_poursuiteMontee()
##### Données de test
DT1 = {
    1. ascenseur = new Ascenseur(1,this)
    2. appels[2] = Destination.DOWN;
    3. dir=Direction.UP
    }
##### Chemin couvert
poursuiteMontee = [3.5.7.8.20]
##### Résultat attendu
Direction.UP
##### Condition de réussite
assertEquals(Direction.UP,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testChoisirDirection_poursuiteMontee()
	{
		System.out.println("\n Test 1.1 : choisir Direction - poursuiteMontée\n");

		this.ascenseur = new Ascenseur(1, this);
    this.ascenseur.dir = Direction.UP;
		appels[2] = Direction.DOWN;

		System.out.println("(a) L'"+this.ascenseur+" est au premier étage");

		//Valider le comportement :
		assertEquals(Direction.UP, this.ascenseur.choisirDirection());

		System.out.println("(b) La direction choisie est bien UP");
	}
```
##### Trace d'execution du test
```
Test 1.1 : choisir Direction - poursuiteMontée

(a) L'Ascenseur[etage=1, dir=UP] est au premier étage
 >> appelAuDessus(1) =true
(b) La direction choisie est bien UP
```
#### Test 1.2
##### Description du cas de test
Nous testons si l'ascenseur change sa `Direction.UP` vers `Direction.DOWN` dans la situation où il est à l'étage 2 et il y a un appel provenant du 1er étage pour aller en haut
##### Nom du cas de test
testChoisirDirection_changementDeDirectionVersBas()
##### Données de test
DT2 = {
    1. ascenseur = new Ascenseur(2,this)
    2. appels[0] = Destination.UP;
    3. dir=Direction.UP
    }
##### Chemin couvert
changementDeDirectionVersBas = [3.5.7.9.10.20]
##### Résultat attendu
Direction.DOWN
##### Condition de réussite
assertEquals(Direction.DOWN,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testChoisirDirection_changementDeDirectionVersBas()
	{
		System.out.println("\n Test 1.2 : choisir Direction - changement de direction vers le bas\n");

		this.ascenseur = new Ascenseur(2, this);
    this.ascenseur.dir = Direction.UP;
		appels[0] = Direction.UP;

		System.out.println("(a) L'"+this.ascenseur+" est au deuxième étage");

		//Valider le comportement :
		assertEquals(Direction.DOWN, this.ascenseur.choisirDirection());

		System.out.println("(b) La direction choisie est bien DOWN");
	}
```
##### Trace d'execution du test
```
Test 1.2 : choisir Direction - changement de direction vers le bas

(a) L'Ascenseur[etage=2, dir=UP] est au deuxième étage
>> appelAuDessus(2) =false
>> destAuDessus(2) =false
>> appelEnDessous(2) =true
(b) La direction choisie est bien DOWN
```

#### Test 1.3
##### Description du cas de test
Nous testons si l'ascenseur conserve sa direction vers le bas `Direction.DOWN` dans la situation où il est à l'étage 2 et il y a un appel provenant du 1er étage pour aller en haut
##### Nom du cas de test
testChoisirDirection_poursuiteDescente()
##### Données de test
DT3 = {
    1. ascenseur = new Ascenseur(2,this)
    2. appels[0] = Destination.UP;
    3. dir=Direction.DOWN
    }
##### Chemin couvert
poursuiteDescente = [3.5.12.14.15.20]
##### Résultat attendu
Direction.DOWN
##### Condition de réussite
assertEquals(Direction.DOWN,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testChoisirDirection_poursuiteDescente()
	{
		System.out.println("\n Test 1.3 : choisir Direction - poursuite de la descente\n");

		this.ascenseur = new Ascenseur(2, this);
		this.ascenseur.dir = Direction.DOWN;
		appels[0] = Direction.UP;

		System.out.println("(a) L'"+this.ascenseur+" est au deuxième étage");

		//Valider le comportement :
		assertEquals(Direction.DOWN, this.ascenseur.choisirDirection());

		System.out.println("(b) La direction choisie est bien DOWN");
	}
```
##### Trace d'execution du test
```
Test 1.3 : choisir Direction - poursuite de la descente

(a) L'Ascenseur[etage=2, dir=DOWN] est au deuxième étage
 >> appelEnDessous(2) =true
(b) La direction choisie est bien DOWN
```

#### Test 1.4
##### Description du cas de test
Nous testons si l'ascenseur change sa `Direction.DOWN` vers `Direction.UP` dans la situation où il est à l'étage 2 et il y a un appel provenant du 3ème étage pour aller en bas
##### Nom du cas de test
testChoisirDirection_changementDeDirectionVersHaut()
##### Données de test
DT4 = {
    1. ascenseur = new Ascenseur(2,this)
    2. appels[2] = Destination.DOWN;
    3. dir=Direction.DOWN
    }
##### Chemin couvert
changementDeDirectionVersHaut = [3.5.7.12.14.16.17.20]
##### Résultat attendu
Direction.UP
##### Condition de réussite
assertEquals(Direction.UP,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testChoisirDirection_changementDeDirectionVersHaut()
	{
		System.out.println("\n Test 1.4 : choisir Direction - changement de direction vers le haut\n");

		this.ascenseur = new Ascenseur(2, this);
		this.ascenseur.dir = Direction.DOWN;
		appels[2] = Direction.DOWN;

		System.out.println("(a) L'"+this.ascenseur+" est au deuxième étage");

		//Valider le comportement :
		assertEquals(Direction.UP, this.ascenseur.choisirDirection());

		System.out.println("(b) La direction choisie est bien UP");
	}
```
##### Trace d'execution du test
```
Test 1.4 : choisir Direction - changement de direction vers le haut

(a) L'Ascenseur[etage=2, dir=DOWN] est au deuxième étage
>> appelEnDessous(2) =false
>> destEnDessous(2) =false
>> appelAuDessus(2) =true
(b) La direction choisie est bien UP
```

### Couverture
Noeuds couverts / Noeuds totaux = 12 / 12 = 1

## Tous les arcs
### Listing des arcs
(3,5),(5,7),(7,8),(8,20),(7,9),(9,10),(10,20),(9,20),(5,12),(12,20),(12,14),(14,15),(15,20),(14,16),(16,17),(16,20),(17,20)
### Cas de tests
On prend pour nos jeux de tests, les variables dir, etage, appels[], destination[]

#### Test 2.1 (1.1)
##### Description du cas de test
Nous testons si l'ascenseur conserve sa direction vers le haut `Direction.UP` dans la situation où il est à l'étage 1 et il y a un appel provenant du 3ème étage pour aller en bas
##### Nom du cas de test
testChoisirDirection_poursuiteMontee()
##### Données de test
DT1 = {
    1. ascenseur = new Ascenseur(1,this)
    2. appels[2] = Destination.DOWN;
    3. dir=Direction.UP
    }
##### Chemin couvert
poursuiteMontee = [3.5.7.8.20]
##### Résultat attendu
Direction.UP
##### Condition de réussite
assertEquals(Direction.UP,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testChoisirDirection_poursuiteMontee()
	{
		System.out.println("\n Test 1.1 : choisir Direction - poursuiteMontée\n");

		this.ascenseur = new Ascenseur(1, this);
    this.ascenseur.dir = Direction.UP;
		appels[2] = Direction.DOWN;

		System.out.println("(a) L'"+this.ascenseur+" est au premier étage");

		//Valider le comportement :
		assertEquals(Direction.UP, this.ascenseur.choisirDirection());

		System.out.println("(b) La direction choisie est bien UP");
	}
```

##### Trace d'execution du test
```
Test 1.1 : choisir Direction - poursuiteMontée

(a) L'Ascenseur[etage=1, dir=UP] est au premier étage
 >> appelAuDessus(1) =true
(b) La direction choisie est bien UP
```

#### Test 2.2 (1.3)
##### Description du cas de test
Nous testons si l'ascenseur conserve sa direction vers le bas `Direction.DOWN` dans la situation où il est à l'étage 2 et il y a un appel provenant du 1er étage pour aller en haut
##### Nom du cas de test
testChoisirDirection_poursuiteDescente()
##### Données de test
DT2 = {
    1. ascenseur = new Ascenseur(2,this)
    2. appels[0] = Destination.UP;
    3. dir=Direction.DOWN
    }
##### Chemin couvert
poursuiteDescente = [3.5.12.14.15.20]
##### Résultat attendu
Direction.DOWN
##### Condition de réussite
assertEquals(Direction.DOWN,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testChoisirDirection_poursuiteDescente()
	{
		System.out.println("\n Test 1.3 : choisir Direction - poursuite de la descente\n");

		this.ascenseur = new Ascenseur(2, this);
		this.ascenseur.dir = Direction.DOWN;
		appels[0] = Direction.UP;

		System.out.println("(a) L'"+this.ascenseur+" est au deuxième étage");

		//Valider le comportement :
		assertEquals(Direction.DOWN, this.ascenseur.choisirDirection());

		System.out.println("(b) La direction choisie est bien DOWN");
	}
```
##### Trace d'execution du test
```
Test 1.3 : choisir Direction - poursuite de la descente

(a) L'Ascenseur[etage=2, dir=DOWN] est au deuxième étage
 >> appelEnDessous(2) =true
(b) La direction choisie est bien DOWN
```

#### Test 2.3 (1.2)
##### Description du cas de test
Nous testons si l'ascenseur change sa `Direction.UP` vers `Direction.DOWN` dans la situation où il est à l'étage 2 et il y a un appel provenant du 1er étage pour aller en haut
##### Nom du cas de test
testChoisirDirection_changementDeDirectionVersBas()
##### Données de test
DT3 = {
    1. ascenseur = new Ascenseur(2,this)
    2. appels[0] = Destination.UP;
    3. dir=Direction.UP
    }
##### Chemin couvert
changementDeDirectionVersBas = [3.5.7.9.10.20]
##### Résultat attendu
Direction.DOWN
##### Condition de réussite
assertEquals(Direction.DOWN,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testChoisirDirection_changementDeDirectionVersBas()
	{
		System.out.println("\n Test 1.2 : choisir Direction - changement de direction vers le bas\n");

		this.ascenseur = new Ascenseur(2, this);
		this.ascenseur.dir = Direction.UP;
		appels[0] = Direction.UP;

		System.out.println("(a) L'"+this.ascenseur+" est au deuxième étage");

		//Valider le comportement :
		assertEquals(Direction.DOWN, this.ascenseur.choisirDirection());

		System.out.println("(b) La direction choisie est bien DOWN");
	}
```

##### Trace d'execution du test
```
Test 1.2 : choisir Direction - changement de direction vers le bas

(a) L'Ascenseur[etage=2, dir=UP] est au deuxième étage
 >> appelAuDessus(2) =false
 >> destAuDessus(2) =false
 >> appelEnDessous(2) =true
(b) La direction choisie est bien DOWN
```

#### Test 2.4 (1.4)
##### Description du cas de test
Nous testons si l'ascenseur change sa `Direction.DOWN` vers `Direction.UP` dans la situation où il est à l'étage 2 et il y a un appel provenant du 3ème étage pour aller en bas
##### Nom du cas de test
testChoisirDirection_changementDeDirectionVersHaut()
##### Données de test
DT4 = {
    1. ascenseur = new Ascenseur(2,this)
    2. appels[2] = Destination.DOWN;
    3. dir=Direction.DOWN
    }
##### Chemin couvert
changementDeDirectionVersHaut = [3.5.7.12.14.16.17.20]
##### Résultat attendu
Direction.UP
##### Condition de réussite
assertEquals(Direction.UP,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testChoisirDirection_changementDeDirectionVersHaut()
	{
		System.out.println("\n Test 1.4 : choisir Direction - changement de direction vers le haut\n");

		this.ascenseur = new Ascenseur(2, this);
		this.ascenseur.dir = Direction.DOWN;
		appels[2] = Direction.DOWN;

		System.out.println("(a) L'"+this.ascenseur+" est au deuxième étage");

		//Valider le comportement :
		assertEquals(Direction.UP, this.ascenseur.choisirDirection());

		System.out.println("(b) La direction choisie est bien UP");
	}
```

##### Trace d'execution du test
```
Test 1.4 : choisir Direction - changement de direction vers le haut

(a) L'Ascenseur[etage=2, dir=DOWN] est au deuxième étage
>> appelEnDessous(2) =false
>> destEnDessous(2) =false
>> appelAuDessus(2) =true
(b) La direction choisie est bien UP
```

#### Test 2.5
##### Description du cas de test
Nous testons si l'ascenseur change sa `Direction.DOWN` vers `Direction.NONE` dans la situation où il est à l'étage 2 et qu'il n'y a ni appel ni destination
##### Nom du cas de test
testChoisirDirection__miseEnAttenteApresDescente()
##### Données de test
DT5 = {
    1. ascenseur = new Ascenseur(2,this)
    2. dir=Direction.DOWN
    }
##### Chemin couvert
changementDeDirectionVersHaut = [3.5.12.14.16.20]
##### Résultat attendu
Direction.NONE
##### Condition de réussite
assertEquals(Direction.NONE,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
##### Code
```
@Test
	public void testChoisirDirection_miseEnAttenteApresDescente()
	{
		System.out.println("\n Test 2.5 : choisir Direction - mise en attente après descente\n");

		this.ascenseur = new Ascenseur(2, this);
		this.ascenseur.dir = Direction.DOWN;

		System.out.println("(a) L'"+this.ascenseur+" est au deuxième étage");

		//Valider le comportement :
		assertEquals(Direction.NONE, this.ascenseur.choisirDirection());

		System.out.println("(b) La direction choisie est bien NONE");
	}
```
##### Trace d'execution du test
```
Test 2.5 : choisir Direction - mise en attente après descente

(a) L'Ascenseur[etage=2, dir=DOWN] est au deuxième étage
 >> appelEnDessous(2) =false
 >> destEnDessous(2) =false
 >> appelAuDessus(2) =false
 >> destAuDessus(2) =false
(b) La direction choisie est bien NONE
```

#### Test 2.6
##### Description du cas de test
Nous testons si l'ascenseur change sa `Direction.UP` vers `Direction.NONE` dans la situation où il est à l'étage 2 et qu'il n'y a ni appel ni destination
##### Nom du cas de test
testChoisirDirection_miseEnAttenteApresMontee()
##### Données de test
DT6 = {
    1. ascenseur = new Ascenseur(2,this)
    2. dir=Direction.UP
    }
##### Chemin couvert
miseEnAttenteApresMontee = [3.5.7.9.20]
##### Résultat attendu
Direction.NONE
##### Condition de réussite
assertEquals(Direction.NONE,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
Oui
##### Code
```
@Test
	public void testChoisirDirection_miseEnAttenteApresMontee()
	{
		System.out.println("\n Test 2.6 : choisir Direction - mise en attente après montée\n");

		this.ascenseur = new Ascenseur(2, this);
		this.ascenseur.dir = Direction.UP;

		System.out.println("(a) L'"+this.ascenseur+" est au deuxième étage");

		//Valider le comportement :
		assertEquals(Direction.NONE, this.ascenseur.choisirDirection());

		System.out.println("(b) La direction choisie est bien NONE");
	}
```
##### Trace d'execution du test
```
Test 2.6 : choisir Direction - mise en attente après montée

(a) L'Ascenseur[etage=2, dir=UP] est au deuxième étage
 >> appelAuDessus(2) =false
 >> destAuDessus(2) =false
 >> appelEnDessous(2) =false
 >> destEnDessous(2) =false
(b) La direction choisie est bien NONE
```

#### Test 2.7
##### Description du cas de test
Nous testons si l'ascenseur se met en standby `Direction.NONE`dans la situation ou il est à l'étage 2, qu'il n'y a pas d'appel et que sa direction est `null`
##### Nom du cas de test
testChoisirDirection__miseEnAttenteDirNull()
##### Données de test
DT7 = {
    1. ascenseur = new Ascenseur(2,this)
    2. dir=null
    }
##### Chemin couvert
miseEnAttenteDirNull = [3.5.12.20]
##### Résultat attendu
Direction.NONE
##### Condition de réussite
assertEquals(Direction.NONE,ascenseur.choisirDirection())
##### Test exécuté avec succès ou non
##### Code
```
@Test
	public void testChoisirDirection_miseEnAttenteDirNull()
	{
		System.out.println("\n Test 2.7 : choisir Direction - mise en attente direction null\n");

		this.ascenseur = new Ascenseur(2, this);
		this.ascenseur.dir = null;

		System.out.println("(a) L'"+this.ascenseur+" est au deuxième étage");

		//Valider le comportement :
		assertEquals(Direction.NONE, this.ascenseur.choisirDirection());

		System.out.println("(b) La direction choisie est bien NONE");
	}
```
##### Trace d'execution du test
```
Test 2.7 : choisir Direction - mise en attente direction null

(a) L'Ascenseur[etage=2, dir=null] est au deuxième étage
(b) La direction choisie est bien NONE
```

### Couverture
Arc couvert / Arc totaux = 17 / 17 = 1

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
### Couverture PLCS
Vers 20 -> [9.10.20]
Vers 20 -> [9.20]
#### Partant de 16
Vers 20 -> [16.17.20]
Vers 20 -> [16.20]
