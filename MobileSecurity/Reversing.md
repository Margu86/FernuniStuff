# Reversing bei Android
## Vorgehensweise beim Reversing von Android-Applikationen
1. Beschaffung der zu untersuchenden Applikation
2. Entpacken der APK-Datei
3. Auslesen des Android-Manifests
4. Übersetzen des Dalvik-Bytecodes in Java-Bytecode
5. Umwandeln des Java-Bytecodes in herkömmlichen Java-Code oder sogenannten Zwischendarstellungssprachen wie Jimple oder smali
6. Analyse des so generierten Codes

### Beschaffung der Anwendung
- Installierte App via `adb pull` vom Telefon holen
- APK von externer Seite herunterladen

### Analysieren und Entpacken der APK-Datei
- Einzelne Dateien können mit `aapt` (Android Asset Packaging Tool) via Kommandozeile betrachtet werden
  -Analyse des Manifests auf verdächtige oder fehlende Berechtigungen
  - Ausgabe der Einsprungpunkte (Activities, Receiver) des Pakets
- Unzippen mit `unzip` oder beliebigem Zip-Tool

### Werkzeuge zum Analysieren der Applikation
Es ist sinnvoll, mehrere Tools zu verwenden, da sie unterschiedliche Stärken und Schwächen haben die sich gegenseitig ausgleichen können.

#### dex2jar
Übersetzt Dalvik-Bytecode zurück in Java-Bytecode.
Nicht mehr ganz aktuell, hat teilweise Probleme bei der Übersetzung.

#### enjarify
Aktueller als dex2jar, unterstützt Unicode und ist robuster als dex2jar.

#### baksmali
Übersetzt Dalvik-Bytecode in `smali`, eine Mischung aus Pseudocode und Java, relativ nah am Bytecode. Kann auch smali wieder zurück zu Dalvik übersetzen.

#### JD-GUI
Übersetzt Java-Bytecode in Java

#### JADx-GUI
Kann direkt Android-Apps zu Java-Code dekompilieren, allerdings in früher Entwicklungsphase.

#### Androguard
Interaktive REPL-Umgebung auf Python-Basis für die Kommandozeile um APKs zu analysieren und zu dekompilieren.

#### Codeinspect
Werkzeug auf Eclipse-Basis um Android-Apps zu analysieren. Übersetzt in Zwischensprache `jimple` ("Java but simple"). Bietet IDE-Funktionen (Debugging, Refactoring, Suche, Hierarchien).
Kann auch zur Laufzeitanalyse verwendet werden.


# Reversing bei iOS

## Vorgehensweise beim Reversing von iOS-Applikationen
1. Beschaffen der zu untersuchenden App
2. Analyse des Codes

## Laborumgebung
1. Gerät muss jailbroken sein, Analyserechner wird benötigt
2. Cydia installieren
3. OpenSSH aus Cydia installieren (dadruch ist eine Kommunikation mit dem Analyserechner möglich)
4. SSH-verbindung mit `libmobiledevice` und `iproxy` für stabilere Verbindung über USB tunneln
5. Mit dem Gerät können dann Tools wie `cycript` oder `dumpdecrypted` auf dem Gerät installiert werden

## Tools

### Cydia
Alternativer Marktplatz für jailbroken iOS-Geräte. Basiert auf `apt` und ermöglicht die Installation von Apps außerhalb des offiziellen Marktplatzes.

### SSH/SCP
Von Cydia aus installierbar.

**SSH:** Verbindung zum Gerät
**SCP:** Datenaustausch mit dem Gerät

Danach unbedingt Passwörter für `root` und `mobile` mit `passwd` ändern, da diese für alle Installationen identisch sind.

### libumobiledevice
Tunnelt Debugger-Verbindung über USB, da SSH meist nicht ausreichend stabil ist.

### class-dump
Extrahiert C-Header (*.h) aus den Class-Dateien des Mach-O-Binaries, diese können danach sehr einfach gelesen werden. Funktioniert nur bei unverschlüsselten oder eigenentwickelten Dateien.

### dumpdecrypted
Apps vom Marktplatz sind durch Apple verschlüsselt, dadurch können sie nicht mit `class-dump` extrahiert werden. Mit `dumpdecrypt` ist dies möglich.

### lipo
Kann Architekturen aus Apps auslesen und verändern. Interessant für Apps, die eine bestimmte Architektur nicht unterstützen.

### Cycript
Interaktive Konsole, die man an den aktuell laufenden Prozess oder App anhängen kann und diese dann manipulieren oder mit ihnen interagieren kann.

## Beschaffen der zu untersuchenden Applikation
1. Mit SSH auf das Gerät verbinden
2. Auffinden der App selbst
3. Auffinden des Dokumentenverzeichnisses der App
4. Entschlüsseln der App
5. Übertragen der entschlüsselten App auf den Analyserechner

## Auffinden der App selbst
Unter `/var/mobile/Containers/Bundle/Application/<unique_id>`.
Herausfinden lann man die ID einer laufenden App z.B. mit `ps`.

## Auffinden des Dokumentenverzeichnisses der App
Kann mittels `cycript -p Appname` herausgefunden werden, z.B. `/var/mobile/Containers/Data/Application/<unique_id>/Documents/`.
Hat eventuell keine Schreibrechte, in diesem Fall kann man auch `/var/root` verwenden.

## Entschlüsseln der App
`dumpdecrypted.dylib` in Dokumnentenverzeichnis kopieren und `dumpdecrypted` ausführen, danach hat man eine `<App>.decrypted` Datei.

## Übertragen der entschlüsselten App auf den Analyserechner
Mit `scp`.

## Werkzeuge zum Analysieren der App
Schwieriger als bei Android, da Objective-C erstmal nach Assembler zurückübersetzt wird.

### Hopper
Relatiiv günstiges Tool zum Reversing von x86/x64-Intel-Mac, Windows- und iOS-ARM Executables nach Assembler.
Kann in Pseudocode übersetzen.

### IDA Pro
Deutlich teurer, aber Industriestandard.