# Sweep-Line
Die Seep-Line bewegt sich kontinuirlich von links nach rechts durch die Ebene.
Interessante Punkte sind alle linken und rechten "Enden" von Segmenten
Diese Events werden mittels zwei Datenstrukturen abgespeichert:
1. Sweepline-Status-Struktur: Enthält alle Objekte, die aktuell die Sweepline schneiden
	1. Bedeutet, die SlSS ist anfänglich leer und mit jedem Schritt können Elemente hinzugefügt und/oder entfernt werden
2. Sweep-Event-Struktur: Enthält alle noch zu bearbeitenden "Haltepunkte der Sweepline"
	1. Hier stehen also alle "Haltepunkte" der X-Achse, also jeder Punkt an dem entwas geschieht wie z.B. **Hinzufügen** und **Entfernen** eines Elements (in die Sweepline-Status-Struktur) oder auch einen **Schnittpunkt**
