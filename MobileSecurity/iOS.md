# Übersicht
iOS ist in fünf Schichten aufgebaut:

## Core OS (Darwin)
Basierend auf FreeBSD mit Mach-Kern. Läuft sowohl unter PPC (Apples ältere PowerPC-Plattform), als auch unter Intel und ARM.

## Core- und Security Services
Systembibliotheken, die von iOS und Apps verwendet werden können. Interaktion mit iCloud, SQLite, XML, Netzwerk, App.Store Einkäufe, Keychain, Adressbuch etc. API-Aufrufe beginnen mit CF (`Core Foundation`).

## Media
OpenGL, AirPlay, OpenAL etc.

## Cocoa Touch
Wie Applikationsframework-Schicht bei Android. Besteht aus drei Frameworks: Foundation (Basisklassen wie Strings und Arrays), UIKit mit Appkit (UI-Entwicklung und SPrache) und Core Data (Datenspeicherung). API-Aufrufe beginnen mit NS (`NeXTStep`).

# Anwendungen
In Objective-C oder Swift geschrieben.

## Datei-Aufbau
Wird als .ipa Datei (=ZIP-Datei) verteilt und beinhaltet kompilierte Anwendung, Ressourcen und Metadaten.

**Payload/Applikation.app:** Statische Ressourcen, Bibliotheken und kompilierte Applikation (`Mach-O-Binary`)

**iTunesArtwork:** Icon für Appstore und iTunes

**iTunesMetadata.pllist:** Metadaten zur App


## Mach-O Binary
Die eigentliche Executable, Mach-Object. Ist solange verschlüsselt, bis sie auf dem Gerät ausgeführt wird. Beinhaltet oft Executables für mehrere CPI-Architekturen, wird dann `Fat Binary` genannt. Besteht aus Header, Load-Kommandos und Data.

## Header
Metadaten über die Datei, wie Format oder Architekturen.

## Load-Kommandos
Beinhaltet das Layout der Datei im Speicher (Speicherort der Symboltabelle, Infos über verschlüsselte Bereiche etc.) und verlinkte shared libraries. Jedes Data-Segement hat ein eigenes Load-Kommando.

## Data
Code- und Datenbereiche.

# Sicherheit

## Secure Boot Chain
Prozess für das Laden des eigentlichen OS.
Jede Komponente ist von Apple digital signiert und wird beim Laden von der jeweilsvorherigen Stufe überprüft.
1. Boot RO;M, in der Firmware der CPU. Beinhaltet Public-Key für Apples Root-CA. Wird implizit vertraut, da im Gerät verankert.
2. Low-Level Bootloader (LLB). Signatur kann mit PK verifiziert werden. Lokalisiert iBoot-Abbild im Flash-Speicher und prüft dessen Signatur. Schlägt dies fehl starte das Gerät im Recovery-Modus.
3. iBoot- Prüft Signatur des eigentlichen iOS-Kernelks.
4. iOS-Kernel. Lädt Betriebssystem mit allen Komponenten.

## Dataprotection Level
Verschlüsselung uns sichere Speicherung von Daten.
Via `NSFileProtection`-API. In die Generierung des Schlüssels können ein Hardware- und/oder der Passcode des Nutzers einfließen.

### NSFileProtectionNone
Daten sind so lange verschlüsselt wie das Gerät ausgeschalten ist.
Wird ausschließlich mit Hardwareschlüssel geschützt, daher kaum Schutz vor Angreifern.

### NSFileProtectionmCompleteUntilFirstUserAuthentication
Schlüssel aus Hardware und Passcode, bleibt so lange im Speicher, bis das Gerät ausgeschalten oder neu gestartet wird. Ähnlich HDD-Verschlüsselung.
Standardwert für Verschlüsselung unter iOS.

### NSFileProtectionCompleteUnlessOpen
Schlüssel wird gelöscht, sobald die Datei geschlossen wird.
Datei kann auch bei gesperrtem Bildschirm genutzt werden.

### NSFileProtectionComplete
Höchste Stufe.
Schlüssel wird gelöscht sobald der Bildschirm gesperrt wird.
Applikation kann bei gesperrten Bildschirm nicht mit so geschützten Daten arbeiten.

## Keychain
Für hochsensible Daten wie Passwörter oder Zertifikate.
Mehrere Schutzlevel für `kSecAttr`.

### kSecAttrAccessibleAlways
Einträge in Keychain immer verfügbar.

### kSecAttrAccessibleAfterFirstUnlocked
Verfügbar sobald das Gerät einmal entsperrt wurde.

### kSecAttrAccessibleWhenUnlocked
Nur verfügbar, wenn das Gerät entsperrt ist. **Standardwert**.

### kSecAttrAccessibleAlwaysThisDeviceOnly
Wie `kSecAttrAccessibleAlways` aber nur auf diesem Gerät (kein Sync oder Wiederherstellung auf einem anderen Gerät)

### kSecAttrAccessibleAfterFirstUnlockThisDeviceOnly
Wie `kSecAttrAccessibleAfterFirstUnlock`, abert nur auf diesem Gerät.

### kSecAttrAccessibleWhenUnlockedThisDeviceOnly
Wie `kSecAttrAccessibleWhenUnlocked`, aber nur auf diesem Gerät.

### kSecAttrAccessibleWhenPassCodeSetThisDeviceOnly
Nur wenn ein Passcode gesetzt wurde und der Bildschirm entsperrt ist.
Wird der Passcode entfernt, sind markierte Einträge nicht mehr entschlüsselbar.