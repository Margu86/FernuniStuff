# Automatenmodelle für Schaltwerke
Ein *Automat* ist ein Modell für ein diskretes, zeitveränderliches System. Automaten können formal durch ein 6-Tupel beschrieben werden:

$<I,S,O,s_0,f,g>$

Darin bezeichnen:
- $I$ die Menge der möglichen EIngabezeichen (Eingabealphabet)
- $S$ die Menge der Zustände
- $O$ die Menge der ,öglichen Ausgabezeichen (Ausgabealphabet)
- $s_0$ den Startzustand
- $g$ die Übergangsfunktion
- $f$ die Ausgangsfunktion

Sind die Mengen $I$, $S$ und $O$ endlich, spricht man von einem *endlichen* Automaten (Finite State Maschine, FSM)

Für jedes Paar aus einem Zustand und einem Eingabezeichen liefert die Übergangsfunktion $g$ einen eindeutig bestimmten Folgezustand:

$g : S \times I \to S$

Durch die Funktion $f$ werden die Ausgabezeichen bestimmt. Für diese gibt es *zwei* verschiedene Definitionen. Die erste Möglichkeit leitet die Ausgabezeichen lediglich aus dem augenblicklichen Zustand ab:

$f : S \to O$

Bei dieser Variante handelt es sich um einen *zustandsbasierten* endlichen Automaten, welcher auch als *[[#Moore-Automat]]* bezeichnet wird.

Eine weitere Möglichkeit $f$ zu definieren besteht darin, zusätzlich das aktuelle Eingabezeichen einzubeziehen. Diese Variante bezeichnet man als *übergangsbasierten* endlichen Automaten oder *[[#Mealy-Automat]]*. In diesem Fall gilt:

$f : S \times I \to O$

Bestehen die Elemente von $I$, $S$ und $O$ aus binären Zeichenketten, so stellen  $f$ und $g$ Boole'sche Funktionen dar. Diese können daher durch Schaltnetze implementiert werden. Flipflops bzw. Register, mit geeignetem Zeitverhalten, können zur Speicherung der Zustände genutzt werden.

Betshet der Eingabevektor $X$ eines Schaltwerks aus $m$ Elementen ($X = (x_{m-1},....x_1,X_0)$), so ergibt sich dieMenge $I$ der Eingabezeichen aus dem [kartesischen Produkt](https://de.wikipedia.org/wiki/Kartesisches_Produkt) der einzelnen Signalmengen. Im Fall binärer Eingaben gilt daher:

$I = \{0,1\}^m$

Ganz ähnlich erhalten wir die beiden anderen Mengen für ein Schaltwerk mit einem $k$ Bit langen Zustandsvektor bzw. -register $Z = (z_{k-1},....,z_0)$ und einem $n$-dimensionalen Ausgangsvektor $Y = (y_{n-1},....,y_0)$. Im Fall binärer Signale gilt:

$S = \{0,1\}^k$
$O = \{0,1\}^n$

#### Vollständigkeit
Ein Automat heißt *vollständig*, wenn für jeden Zustand und alle möglichen Eingaben Zustandsübergänge (Kanten) spezifiziert sind. Eine Kante kann auch durch eine ODER-Verknüpfung zweier oder mehrerer möglicher Eingaben markiert sein.
#### Wiederspruchsfei
Ein Automat heißt *wiederspruchsfrei*, wenn führ jeden Zustand und alle möglichen Eingaben jeweils ein eindeutiger Folgezustand bestimmt ist, d.h. wenn $g$ tatsächlich eine Funktion ist[¹]. Für den Zustandsgraphen bedeutet dies, dass es für jede mögliche Eingabe nur eine einzige auslaufende Kante aus einem Knoten (Zustand) gibt.



## Moore-Automat
```ad-info
Ein [[#Moore-Automat]] ist etwas **langsamer** als ein [[#Mealy-Automat]].
```


## Mealy-Automat

```ad-info
Ein [[#Mealy-Automat]] ist etwas **schneller** als ein [[#Moore-Automat]].
```
