# Refaktoryzacja TinyGP - 1

## Cel
Celem refaktoryzacji było uproszczenie kodu i zwiększenie jego czytelności przy zachowaniu takiej samej logiki oraz optymalizacji.

## Zmiany
Kod został podzielony na klasy:
- `TinyGP` - główna klasa, która odpowiada za uruchomienie algorytmu
- `EvolutionGP` - klasa, która odpowiada za ewolucję populacji
- `OutputGP` - klasa, która odpowiada za wypisywanie danych na ekran lub do pliku
