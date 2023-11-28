# Refaktoryzacja TinyGP - 2

## Cel
W przeciwieństwie do [poprzedniej refaktoryzacji](../refactored%201/README.md) nie braliśmy pod uwagę tak bardzo optymalizacji. Zależało nam bardziej na tym, aby kod był czytelny i łatwy do zrozumienia.

## Zmiany
Największą zmianą był podział kodu na klasy:

- `TinyGP` - główna klasa, która odpowiada za uruchomienie algorytmu
- `Program` - klasa, która odpowiada za przechowywanie indywidualnego programu i tworzenie nowych programów podczas mutacji i krzyżowania
- `Function` - klasa, która odpowiada za przechowywanie funkcji i jej danych z pliku `_data.txt` zakłada identyczną strukturę plików jak [visualizer](../visualizer/README.md)
- `OutInterface` - klasa, która odpowiada za wypisywanie danych na ekran lub do pliku


