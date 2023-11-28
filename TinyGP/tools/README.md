# Narzędzia do TinyGP stworzone w Pyhton
- [generator](#Generator-instrukcja-obsługi)
- [simplifier](#simplifier-instrukcja-obsługi)
- [wisualizator](#visualizer-instrukcja-obsługi)

## Generator instrukcja obsługi:
Generator jest tylko klasą opakowującą instrukcje.

### Klasa GenArgs:
Aby wygenerowa dane naley najpier stworzyć obiekt klasy `GenArgs`.  
Przyjmuje on w konstruktoe takie argumenty:
- `f` - funkcja, która będzie wykorzystana do generowania programów
- `args_num: int` - liczba argumentów funkcji
- `args_range: (float, float)` - zakres argumentów funkcji (zakres dziedziny)
- `inst_num: int` - ilość liczb w dyskretnej dziedzinie funkcji
- `rand_num: int` - liczba losowych liczb, które będą wykorzystane w TinyGP
- `rand_range: (float, float)`  - zakres losowanych liczb

```py
args = GenArgs(lambda x: x**2, 1, [-1, 1], 100, 100, [-5, 5])
```

### Metoda generate:
Metoda generate generuje dane funkcji i wpisuje je do pliku.
```py
Generator.generate(args, 'data.txt')
```

### Generacja funkcji do TinyGP:
Na samym dole pliku `generator.py` znajduje się kod generujący wszystkie funkcje potrzebne do realizacji _Zadania 1_.

---

## Simplifier instrukcja obsługi:

### Stworzenie obiektu klasy Simplifier:
Nic nie trzeba podawać w konstruktorze.
```py
simplifier = Simplifier()
```

### Metoda simplify:
W metodzie `simplify` podajemy formę tekstową programu.  
```py
txt = '((1 - 2) * (3 + 4)) + sin((X1 / 5))'
simplified = simplifier.simplify(txt)
```
Metoda zarówno zwraca uproszczony program jak i zapisuje go w polu klasy - `self.new_program`.

### Pola klasy Simplifier:
- `original_program` - oryginalny program przekazany do funkcji `simplify`
- `new_program` - nowy, uproszczony program

### Statystyki:
Statystyki z działania programu można pobrać z tekstowej reprezentacji obiektu klasy:
```py
stats = str(simplifier)
```
Zawiera następujące informacje:
- oryginalna długość programu
- długość uproszczonego programu
- redukcja - stosunek długości starego i nowego programu
- liczba zredukowanych formuł

#### Statystyki przykładowego programu:
```
orgiginal program size: 35
final program size: 16
size reduction: 19 (54.29%)
total number of simplified formulas: 3
```

### Wykorzystanie klasy Simplify do bliczania wartości funkcji dla danych argumentów
Taka funkcjonalnoś została zaimplementowana w klasie [visualizer](#visualizer-instrukcja-obsługi).

1. Wczytanie programu
```py
program = # pobieranie danych z konkretnego pliku
```

2. Nowy obiekt i wstępne uproszczenie
```py
simplifier = Simplifier()
raw_function = simplifier.simplify(program)
```

3. Funkcja przyjmująca dowolną liczbę argumentów i zwracająca wyliczoną wartość programu dla nich  
   Jeśli w wyrażeniu (`expression`) pozostały zmienne `X` wyrzucany jest błąd informujący o zbyt małej ilości argumentów.
```py
def evaluate_expression(*args):
    """Evaluates a function for given arguments.

    Returns:
        float: result of the function for given arguments.
    """

    expression = raw_function
    for i, arg in enumerate(args):
        expression = expression.replace(f'X{i+1}', str(arg))
    if 'X' in expression:
        raise ValueError('not suficient argument number, there are unbounded variables left in expression')
    
    return eval(simplifier.simplify(expression))
```

#### Funkcja zwracająca callable stworzony z programu
Łącząc te trzy kroki razem możemy otrzymać funkcję `prepare_function`, która zwraca typ callable dzięki czemu możemy wygodnie korzystać z programu zwróconego przez TinyGP poprzez zwykłą zmienną w python:
```py
def prepare_function(program):
    simplifier = Simplifier()
    raw_function = simplifier.simplify(program)
    
    def evaluate_expression(*args):
        expression = raw_function
        for i, arg in enumerate(args):
            expression = expression.replace(f'X{i+1}', str(arg))

        if 'X' in expression:
            raise ValueError('not suficient argument number, there are unbounded variables left in expression')

        return eval(simplifier.simplify(expression))

    return evaluate_expression
```

Korzystanie z kodu jest już bardzo proste:
```py
txt = '(2 + (X1 * 4))'

function = prepare_function(txt)

result = function(3)
print(result) # >>> 14
```

---

## Visualizer instrukcja obsługi:
Klasa `Visualizer` posiada dwie metody:
- `visualize_function` - rysuje wykres funkcji
- `visualize_progress` - rysuje wykres postępu algorytmu

### Stworzenie obiektu klasy Visualizer:
W konstruktorze podajemy:
- `path: str` - ścieżka do pliku z danymi
- `function: str` - nazwa folderu z daną funkcją

Klasa zakłąda taką strukturę plików:
```txt
data
  f1
    f1_0
      dat
        _data.xt
        ari_fun.dat - plik z wygenerowanymi funkcjami arytmetycznymi
        ari_sts.csv - plik ze statystykami postępu rozwoju funkcji arytmetycznej
        tri_fun.dat - plik z wygenerowanymi funkcjami trygonometrycznymi
        tri_sts.csv - plik ze statystykami postępu rozwoju funkcji trygonometrycznej
      TUTAJ GENEROWANE BĘDĄ WYKRESY
    f1_1
      ...
```

#### Zmiana ścieżek do plików
W konstruktorze zaimplementowany jest słownik z domyślnymi ścieżkami do plików.
jeśli chcemy mieć inne ścieżki należy je zmienić bezpośrednio w kodzie konstruktora.

### Metoda visualize_function:
Metoda `visualize_function` rysuje wykres funkcji dla danych argumentów z pliku `_data.txt`.

Program wykrywa które pliki z funkcjami są dostępne i rysuje wykresy dla nich. Jeśli obecne są oba, tworzy dodatkowy wykres porównujący oba typy funkcji.

```py
visualizer = Visualizer('data', 'f1_0')
visualizer.visualize_function()
```

### Metoda visualize_progress:
Metoda `visualize_progress` rysuje wykres postępu algorytmu dla danych funkcji.

Podobnie jak w przypadku `visualize_function` program wykrywa które pliki są dostępne i rysuje wykresy dla nich.

```py
visualizer = Visualizer('data', 'f1_0')
visualizer.visualize_progress()
```