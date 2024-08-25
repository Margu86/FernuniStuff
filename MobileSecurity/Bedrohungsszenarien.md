Mobile Geräte sind heute oft für mobiles Arbeiten im Einsatz, durch Nutzung vieler verschiedener Apps sind verschiedene Bedrohungen möglich.

**Webbasiert:** Ausnutzung von Lücken in Browsern und eingebetteten Funktionen wie Videplayer etc.

**Applikationsbasiert:** Apps aus "offiziellen" Märkten wir Goole Play werden mit Sicherheitschecks abgesichert, bei alternativen Märkten fehlt diese Prüfung meist.

# Bedrohungstypen
**Malware:** Ermöglicht den Zugang zum Gerät und ermöglich dadurch Datendiebstahl, Fernsteuerung etc.

**Spyware:** Ermöglicht das Abgreifen sensibler Daten. Installation über physischen Zugriff zum Gerät, über Sicherheitslücken oder auch per Social Engineering.

**Grayware:** Wird vom Nutzer selbst installiert. Hat oft reale Funktionen, aber Sammelt Informationen (Adressbuch, Browser-Historie). Auch oft als Adware oder PUA (Potentially Unwanted Application) bezeichnet.

 ---

**Mögliche Malwaretypen:**

Versand von Premium SMS, Nutzerortung, Datendiebstahl, Botnetze, Root-Exploits, Adware/PUA, Online-Banking Trojaner, Kommerzielle Malware, Cryptolocker/Ransomware

---

# OWASP Mobile Top 10 (2014)

## Weak Server Side Controls
Im Backend.
Fehlerhafte Authentifizierung, Session-Handling, Parameterprüfung.
Müssen oft im Backend, und nicht von der Anwendung selbst behoben werden.

## Insecure Data Storage
Kompromitierung von SQL-Datenbanken, Metadaten, Logdaten, ungesicherte Daten auf SD-Karten.
Insbesondere wenn Geräte manipuliert oder infiziert sind.

## Insufficient Transport Layer Protection
Abgreifen von Daten beim Transport durch verschiedene Netze (WiFi, Mobilfunnk).
Wird durch TLS verhindert, muss aber richtig implementiert sein.

## Unintended Data Leakage
Versehentliche Datenfreigabe über Caching, Clipboard oder Logdateien.

## Poor Authentication und Authorization
Schlechte Überprüfung von Daten, insbesondere wenn sie leicht fälschbar sind (IMEI, GPS).
Oder Authentifizierung mit einem PIN, aber keine keine Verschlüsselung mit diesem PIN.

## Broken Cryptography
Hardcodierte Schlüssel, die leicht auslesbar sind.

## Client Side Injection
Der Anwendung werden manipuliert Daten übergeben, um durch Fehlverhalten Rechte zu erlangen.
Fehlende Eingabevalidierung.

## Security Decisions via Untrusted Inputs
Manipulation versteckter Parameter, z.B. bei Bachendaufrufen via Web oder IPC (Inter-Prozess Communication).

## Improper Session Handling
Tokens mit geringer Entropie, fehlende Devalidierung, zu lange Gültigkeit.
Fehlender Schutz der Token.

## Lack of Binary Protection
Verschlüsselung / Verschleierung des Codes selbst.
Schutz vor Reverse-Engineering.


|  #  |              OWASP-2014                 |         OWASP-2016        |               OWASP-2024              |
|-----|-----------------------------------------|---------------------------|---------------------------------------|
| M1  | Weak Server Side Controls               | Improper Platform Usage   | Improper Credential Usage             |
| M2  | Insecure Data Storage                   | Insecure Data Storage     | Inadequate Supply Chain Security      |
| M3  | Insufficient Transport Layer Protection | Insecure Communication    | Insecure Authentication/Authorization |
| M4  | Unintended Data Leakage                 | Insecure Authentication   | Insufficient Input/Output Validation  |
| M5  | Poor Authorization and Authentication   | Insufficient Cryptography | Insecure Communication                |
| M6  | Broken Cryptography                     | Insecure Authorization    | Inadequate Privacy Controls           |
| M7  | Client Side Injection                   | Client Code Quality       | Insufficient Binary Protections       |
| M8  | Security Decisions Via Untrusted Inputs | Code Tampering            | Security Misconfiguration             |
| M9  | Improper Session Handling               | Reverse Engineering       | Insecure Data Storage                 |
| M10 | Lack of Binary Protections              | Extraneous Functionality  | Insufficient Cryptography             |

Bei der Liste von 2016 zu 2024 hat sich folgendes geändert:
- M1, M2, M4 und M6 wurden neu aufgenommen
- M3 wurde durch Zusammenführen von M4 und M6 erzeugt
- M5 ist von M3 herabgerutscht
- M7 wurde duch Zusammenführen von M7 und M9 erzeugt
- M8 ist M10 mit neuem Wortlaut
- M9 ist von M2 herabgerutscht
- M10 ist von M5 herabgerutscht