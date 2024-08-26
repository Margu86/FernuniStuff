# Statische Analyse (Reversing)
- Analyse von Quellcode, Zerlegung von Anwendungspaketen und Suche nach bestimmten Mustern (Berechtigungen, Funktionsaufrufen)
- Anwendung muss nicht ausgeführt werden
- Kann teilweise automatisch erfolgen (Muster- oder Signaturerkennung)
- Kann je nach Umfang sehr aufwändig werden, da Muster im Voraus bekannt sein müssen
- Durch Obfuscation und Verschlüsselung erschwert

# Dynamische Analyse
- Analyse der Anwendung zur Laufzeit, in einer kontrollierten Umgebung (Sandbox)
- Durch Isolation der Anwendung wird die Umgebung vor Angriffen geschützt
- Automatisierung von Berichten durch Protokollierung der Aktionen der App möglich
- Quellcode ist durch Ausführung entschlüsselt
- Sandboxen können aber zur Laufzeit erkannt werden, Apps können sich dann "normal" verhalten
- Teilweise von äußeren Einflüssen abhängig (warten bis SMS eintrifft, bestimmte GPS Signale / Standorte etc.)
- Debugging der Anwendung möglich (Verfolgung von Variablenwerten)