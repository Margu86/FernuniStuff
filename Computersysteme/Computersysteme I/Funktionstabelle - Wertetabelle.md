# Funktionstabelle / Wertetabelle
```ad-info
Die Eingangsvariablen ordnen wir in der Tabelle absteigend an, um sie (z.B. für das Quine McClusky Verfahren) direkt als Binärzahl lesen zu können (und damit recht einfach in eine Dualzahl umwandeln können).

Dabei handelt es sich nicht um eine fest definierte Vorgabe.
```

## Vollständig

| $x_3$ | $x_2$ | $x_1$ | $f(x_1,x_2,x_3)$ |
|-------|-------|-------|------------------|
| 0     | 0     | 0     | 0                |
| 0     | 0     | 1     | 1                |
| 0     | 1     | 0     | 1                |
| 0     | 1     | 1     | 1                |
| 1     | 0     | 0     | 0                |
| 1     | 0     | 1     | 0                |
| 1     | 1     | 0     | 0                |
| 1     | 1     | 1     | 1                |


## Unvollständig

| $x_3$ | $x_2$ | $x_1$ | $f(x_1,x_2,x_3)$ |
|-------|-------|-------|------------------|
| 0     | 0     | 0     | 0                |
| 0     | 0     | 1     | 1                |
| 0     | 1     | 0     | 1                |
| 0     | 1     | 1     | 1                |
| 1     | 0     | 0     | 0                |
| 1     | 0     | 1     | X                |
| 1     | 1     | 0     | X                |
| 1     | 1     | 1     | X                |

die X in der Tabelle entsprechen dem "*dont care*" Ausdruck und können mit 0 oder 1 besetzt sein.