# Hashing
Eine *Hashfunktion* (vornehmer: Schlüsseltransformation) ist eine totale Abbildung
$h : D \to \{0,...,m-1\}$
wobei $D$ der Schlüssel-Wertebereich ist.
In einer typischen Anwendung ist $D$ etwa die Menge aller Zeichenketten der Maximallänge 20.

Eine Hashfunktion sollte folgende Eigenschaften besitzen:
1. Sie sollte *surjektiv* sein, also alle Behälter erfassen.
2. Sie sollte die zu speichernden Schlüssel möglichst *gleichmäßig* über alle Behälter verteilen.
3. Sie sollte effizient zu berechnen sein.

## Offenes vs. geschlossenes Hashing
- Kollision: Abbildung mehrerer Schlüssel auf einen Behälter
- Offenes Hashing: beliebig viele Schlüssel pro Behälter
- Geschlossenes Hashing: nur eine kleine, konstante Anzahl *b* Schlüssel pro behälter $\to$ Bei weiterem Schlüssel in Behälter: *Überlauf*

## Kollisionsstrategien
### Lineares Sondieren
- Prüfung der folgenden Behälter, bis ein freier gefunden wurde
- Sprungweite $c$ muss konstant sein, kann aber > 1 sein
- $c$ und $m$ sollten teilerfremd sein, damit alle Behälter getroffen werden
- Es können weiterhin Ketten mit Abstand $c$ entstehen

$h_i(x) = (h(x) + c \cdot i)~mod~m$

### Quadratisches Sondieren
$h_i(x) = (h(x) + i^2)~mod~m$

### Doppel-Hashing
Man wähle zwei Hashfunktionen $h$, $h'$ die voneinander *unabhängig* sind.
Damit definieren wir eine Folge von Hashfunktionen

$h_i(x) = (h(x) -i \cdot h'(x))~mod~m$, für $i \geq 0$ 

### Divisionsmethode
- Division der zu bearbeitenden Zahl $k$ durch die maximale Anzahl an Behältern $m$
- Restwert ergibt den Behälter, in dem der Wert abgelegt werden soll
- Nachteil: Aufeinanderfolgende Werte liegen in aufeinanderfolgenden Behältern

$h(k) = k~mod~m$

### Mittel-Quadrat-Methode
