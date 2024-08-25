# Übersicht
Android ist in vier Schichten aufgebaut:

## Linux-Kernel
- Auf Basis von Linux 2.6
- Verwaltung laufender Prozesse und Powermanagement
- PID und Prozesstabelle wichtig zur Analyse von Anwendungen

## Systembibliotheken und Laufzeitumgebung
- Webkit, SSL, OpenGL, SQLite etc.
- Werden vom System und Apps genutzt
- Laufzeitumgebung (DVM/Dalvik VM, ART)
- Optimiert für mobile Geräte (wenig Rechenleistung und geringer Stromverbrauch)

## Applikationsframework
- Geräteunabhängige APIs für Apps
- Location Manager, Telephony Manager, Notifications etc.

## Anwendungen/Apps
- werden zur Laufzeit in DVM ausgeführt

## Sicherheit
- Jede App bekommt eine UID, unter der sie läuft
  - Apps mit dem gleichen Entwicklerschlüssel erhalten die gleiche UID
- Dateizugriffsberechtigung basiert auf UID (=DAC)
- Sicherheitskritische Funktionen der API prüfen zunächst Berechtigung der UID
- Abschottung über Linux-Kernel
- MAC via SELinux ab Android 4.3

# Anwendungen
Apps werden in Java geschrieben und können native Bibliotheken verwenden. Aus Java-Code wird Bytecode (unterscheidet sich von Java-Bytecode) für DVM generiert und in .dex Datei gespeichert.

## Datei-Aufbau
Alle Komponenten werden in .apk zusammengefasst (= JAR bzw. ZIP-Datei)

## Bestandteile der APK
**META-INF:** Manifest der JAR-Datei, Zertifikat, Liste aller Resourcen

**lib:** Verzeichnis mit CPU-Spezifischem Code (armeabi, x86, mips etc.)

**resources.arsc:** Vorkompilierte Ressourcen

**res:** Bibliotheken, die nicht in der arsc Datei sind

**Android-Manifest.xml:** siehe Unten

**classes.dex:** Kompilierter Java-Code


## AndroidManifest.XML
Im Android Manifest werden **drei Hauptpunkte** beschrieben:
1. **Hardwareanforderungen:** Definiert, welche Hardwarekomponenten (z.B. Kamera, GPS, Mikrofon) für die App erforderlich sind.
2. **Berechtigungen:** Listet alle Berechtigungen auf, die die App benötigt, um bestimmte Aktionen auszuführen. Zum Beispiel Zugriff auf Kontakte, Speicherplatz, Internetverbindung etc. Das ist wichtig für die Sicherheit und den Datenschutz der Nutzer.
3. **Komponenten:** Beschreibt die verschiedenen Komponenten der App, wie z.B.:
    - **Aktivitäten (Activities):** Die einzelnen Bildschirme oder Views, die der Benutzer sieht und mit denen er interagieren kann.
    - **Services:** Prozesse, die im Hintergrund ausgeführt werden und Aufgaben erledigen (z.B. Daten synchronisieren).
    - **Brodcast Receiver:** Komponenten, die auf bestimmte Ereignisse reagieren (z.B. ein eingehender Anruf).
    - **Intents:** Zur Kommunikation innerhalb oder außerhalb der App. *Data* und *Action* erforderlich, *Types* (MIME-Typ, falls Daten nicht als URI), *Categories* (genauere Beschreibung der Aktion) und *Extras* (mehr Platz für Daten) optional. Explizite Intents haben spezifische Receiver, meist innerhalb einer App. Implizite Intents werden ans System weitergegeben, dass dann die passende App heraussucht, die entsprechenden Brodcast-Receiver definiert hat.
    - **Content Provider:** Austausch persistenter Daten zwischen Apps.
    - **Shared Preferences:** Zur Speicherung kleiner, nicht sicherheitskritischer Datenmengen. Meist als XML im Verzeichnis `shared_prefs`.


## Abschottung von Anwendungen
wird vom Linux Kernel implementiert.

Da jede virtuelle Maschine und damit jede Anwendung unter einer eigenen, festen und entwicklerspezifischen Benutzerkennung (engl. user id, UID) in einem eigenen Prozess läuftkönnen über passende Zugriffsrechte (nur der Benutzer selbst darf lesen, schreiben, ausführen und andere Prozesse haben keine Berechtigungen).

- **DAC - Discretionary Access Controll:**
DAC gibt dem jeweiligen App-Owner (dem Entwickler) die Kontrolle darüber, wer auf welche Daten zugreifen kann. Er verwendet File Permissions ("Leseberechtigung", "Schreibberechtigung") um festzulegen, wer was sehen und verändern darf.

- **MAC - Mandatory Access Controll:**
MAC hingegen setzt ein hierarchisches System mit stregen Regeln ein, die vom Kernel festgelegt werden. Es gibt hier keine Freiheit für den App-Owner. Der Zugriff wird anhand von Sicherheitsklassen (wie z.B. "Top Secret", "Confidential") und Rollen geregelt.

Zusammenfassend lässt sich sagen: DAC ermöglich flexible Berechtigungen pro Anwendung, während MAC ein strikteres System mit vordefinierten Regeln für den Zugriff auf Ressourcen bietet. Android kombiniert beides zur sicheren Ausführung von Apps in einem Sandbox-Umfeld.