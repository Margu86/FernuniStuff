# Gesetze der Booleschen Algebra

1. Es existiert eine Menge $B =\{a,b,...,n\}$ 
	$\land$ und $\lor$ sind eindeuteige Verknüpfungen:

$\land~\colon B \times B \to B$
$\lor~\colon B \times B \to B$

2. Für $a, b, c \in B$ gelten folgende Gesetze:
	1. Kommutativgesetze
	$a \land b = b \land a~(K\land)$
	$a \lor b = b \lor a~(K \lor)$
	2. Assoziativgesetze
	$(a \land b ) \land c = a \land (b \land c )~(A\land)$
	$(a \lor b ) \lor c = a \lor (b \lor c )~(A\lor)$
	3. Absorptionsgesetze
	$a \land (a \lor v) = a ~ (Ab \land)$
	$a \lor (a \land v) = a ~ (Ab \lor)$
	4. Distributivgesetze
	$a \land (b \lor c) = (a \land b) \lor (a \land c) ~ (D\land)$
	$a \lor (b \land c) = (a \lor b) \land (a \lor c) ~ (D\lor)$
	5. Neutrale Elemente
	Es gibt in B verschiedene Elemente $e$ und $n \in B$, so dass für alle $a \in B$ gilt:
	$a \land e = a ~ (N\land)$
	$a \lor e = a ~ (N\lor)$
	6. Komplementäres Element
	Zu jedem $a \in B$ existiert genau ein Element $\overline{a} \in B$ mit den Eigenschaften
	$a \land \overline{a} = n ~ (N \land)$
	$a \lor n = a ~ (N \lor)$
	7. Dualitätsprinzip
	Ist $A$ eine Aussage der Booleschen Algebra, so auch $\overline{A}$, die man durch Vertauschen vom $\land$ gegen $\lor$ und $n$ gegen $e$ erhält.
	8. De Morgansche Regel:
		$\overline{a \land b} = \overline{a} \lor \overline{b}$
		$\overline{a \lor b} = \overline{a} \land \overline{b}$
		