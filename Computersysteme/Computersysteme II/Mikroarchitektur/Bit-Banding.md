# Bit-Banding
## Bit-Band-Alias-Bereich
Die Bit-Band-Alias-Adresse $A$ für das Bit $n$ (0-31) des Speicherworts an der Adresse X (zwischen 0x2000_0000 und 0x200f_ffff) berechnet sich wie folgt:

$A = 0x2200\_0000 + ( X - 0x2000\_0000) \cdot 32 + n \cdot 4$

