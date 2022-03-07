# Algebra (oder Datentyp)

Bei Algebren bei denen nur eine Objektklasse vorkommt, spricht man von einer *universalen Algebra*, sonst von *mehrsortigen* oder *heterogenen Algebra*.

**Beispiel:** Verwalte eine Menge ganzer Zahlen, so dass Zahlen eingefügt und gelöscht werden können und der Test auf Enthaltensein durchgeführt werden kann.

Um eine Algebra zu beschrieben muss festgelegt werden, wie die Objektmengen und Operationen heißen, wieviele und was für Objekte die Operationen als Argumente benötigen und welche Art von Objekt sie als Ergebnis liefern.
Dies ist ein rein syntaktischer Aspekt, er wird durch eine *Signatur* festgelegt, die man für unser Beispiel etwa so aufschreiben kann:

**sorts**    *intset, int, bool*
**ops**        *empty*                                     ->  *intset*
	        *insert:*        *intset $\times$ int*          ->  *intset*
			*delete:*       *intset* $\times$ *int*          ->  *intset*
			contains:    *intset* $\times$ *int*         ->  *bool*
			*isempty:*     *intset*                  ->  bool

```ad-info
Man beachte, dass die Signatur weiter nichts über die *Semantik*, also die bedeutung all dieser Bezeichnungen aussagt. Wir haben natürlich eine Vorstellung davon, was z.B. das Wort bool bedeutet; die Signatur lässt das aber völlig offen.
```

Es muss also zusätzlich die Semantik festgelegt werden. Im Prinzip ist dazu jeder Sorte eine *Trägermenge* zuzuordnen und jedem Operationssymbol eine *Funktion* mit entsprechenden Argument- und Wertebereichen.

Für diese Zuordnungen gibt es zwei Vorgensweisen,
Die erste, *Spezifikation als Algebra*, gibt Trägermengen und Funktionen direkt an, unter Verwendung der in der Mathematik üblichen Notationen.
Für unser Beispiel siet das so aus:

**sorts**    *intset, int, bool*
**ops**        *empty*                                     ->  *intset*
	        *insert:*        *intset $\times$ int*          ->  *intset*
			*delete:*       *intset* $\times$ *int*          ->  *intset*
			contains:    *intset* $\times$ *int*         ->  *bool*
			*isempty:*     *intset*                  ->  bool
**sets**        *intset =* $F(\mathbb{Z}) = \{M \subset \mathbb{Z}~|~M~endlich\}$
**functions**
                *empty*                                    = $\varnothing$
			*insert(M,i)*                              = $M \cup \{i\}$
			*delete(M,i)*                             = $M \setminus \{i\}$
			*contains(M,i)*                         = $$
			