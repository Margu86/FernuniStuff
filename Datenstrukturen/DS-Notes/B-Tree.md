# B-Bäume
## Definition
Ein B-Baum der Ordnung *m* ist ein Vielweg-Suchbaum mit folgenden Eigenschaften:
* Die Anzahl der Schlüssel in jedem Knoten mit Ausnahme der Wurzel liegt zwischen *m* und *2m*. Die Wurzel enthält mindestens einen und maximal *2m* Schlüssel.
* Alle Pfadlängen von der Wurzel zu einem Blatt sind gleich.
* Jeder innere Knoten mit *s* Schlüsseln hat genau *s+1* Kinder (das heißt, es gibt keine leeren Teilbäume).

## Einfügen und Löschen

### overflow (s > 2m)
#### splitt

### underflow (s < m) des Knoten p
hat p einen Nachbarn p' mit s > m Schlüsseln, dann
#### balance

ansonsten gilt, da p nicht die Wurzel sein kann, muss p einen Nachbarn mit m Schlüsseln haben; sei p' so ein Nachbar mit m Schlüsseln;
#### merge
