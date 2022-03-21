# ASM-Diagramme

Ein ASM-Diagramm kann drei Arten von *Boxen* enthalten:
1. [[#Zustandsbox]]en
2. [[#Entscheidungsbox]]en
3. [[#Bedingte Ausgangsbox]]en

```ad-note
title: Merke!
Bei [[Automatenmodelle für Schaltwerke#Moore-Automat]] / Moore-Schaltwerken gibt es keine bedingten Ausgangsboxen, da sie zustandsorientiert arbeiten.
```
## Zustandsbox
![[ASM_Zustandsbox.png]]
In einer Zustandsbox können einem oder mehreren Registern Werte zugewiesen werden. Die Zuweisungen werden in der RTL-Notation angegeben.
In Zustandsboxen wird die AKtion festgelegt, die beim Erreichen dieses Zustands im Operationswerk ausgeführt werden soll.
In jedem ASM-Diagramm gibt es einen Zustand $Z_0$, der nach dem Einschalten der Betriebsspannung eingenommen wird.

## Entscheidungsbox
![[ASM_Entscheidungsbox.png]]
Entscheidungsboxen testen Registerinhalte oder Eingänge auf besondere Bedingungen. 
Die abgefragte Bedingung steuert den Kontrollfluss und legt damit die Ausgangspfade aus einem ASM-Block fest. Durch Entscheidungsboxen werden die Folgezustände festgelegt, die das Steuerwerk als nächstes einnehmen soll.
Eine Entscheidungsbox hat nur zwei Ausgänge, da die abgefragte Bedingung nur wahr (1) oder falsch (0) sein kann.

## Bedingte Ausgangsbox
![[ASM_Bedingte-Ausgangsbox.png]]
Diese Komponente gibt es nur bei ASM-Diagrammen für [[Automatenmodelle für Schaltwerke#Moore-Automat]] / Mealy-Schaltwerke.
Wie bei einer [[#Zustandsbox]] können in der bedingten Ausgangsbox Variablen oder Ausgängen Werte zugewiesen werden.
Jedoch werden nur diejenigen Ausgangsboxen ausgeführt, die auf dem genommenen Pfad liegen.
Die Zuweisungen der aktivierten bedingten Ausgangsboxen werden zeitgleich zu den Zuweisungen in der vorgelagerten Zustandsbox ausgeführt.