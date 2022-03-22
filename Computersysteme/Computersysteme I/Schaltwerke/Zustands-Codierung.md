# Zustands-Codierung

## Hot-one-Codierung
Bei der Hot-one-Codierung gibt es pro Zustand ein Flipflop.

## Binäre Codierung
Bei der binären Codierung der Zustände werden $\lceil log_2~n \rceil$ Flipflops benötigt.
```ad-note
$\lceil x \rceil$ -> kleinste ganze Zahl größer oder gleich $x$
```
Man sieht, dass man bereits für n = 128 gegenüber der [[#Hot-one-Codierung]] eine große Einsparung erhält: 7 statt 128 Flipflops.

## Schaltwerkanalyse (Hot-one oder Binär codiert?)
Am einfachsten ist es sich eine "Schaltung" zu überlegen bei der alle Flipflops gleichzeitig 0 oder zwei Flipsflops gleichzeitig 1 annehmen. Damit wäre bereitsgezeigt, dass es sich nicht um Hot-one-Codierung handeln kann.