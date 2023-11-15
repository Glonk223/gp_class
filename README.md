# gp_class
Repository for Genetic Programming class

## Simplifier instrukcja obsługi:

### Stworzenie obiektu klasy Simplifier:
Nic nie trzeba podawać w konstruktorze.
```py
simplifier = Simplifier()
```

### Metoda simplify:
W metodzie `simplify` podajemy formę tekstową programu.  
```py
txt = '(2 + 2)'
simplified = simplifier.simplify(txt)
```
Metoda zarówno zwraca uproszczony program jak i zapisuje go w polu klasy - `self.new_program`.

### Pola klasy Simplifier:
- `original_program` - oryginalny program przekazany do funkcji `simplify`
- `new_program` - nowy, uproszczony program

### Statystyki:
Statystyki z działania programu można pobrzć z tekstowej reprezentacji obiektu klasy:
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
orgiginal program size: 10974
final program size: 5693
size reduction: 5281 (48.12%)
total number of simplified formulas: 195
```

### Wykorzystanie klasy Simplify do bliczania wartości funkcji dla danych argumentów
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
def evaluate_expression(args):
    """Evaluates a function for given arguments.

    Returns:
        float: result of the function for given arguments.
    """

    expression = raw_function
    for i, arg in enumerate(args):
        expression = expression.replace(f'X{i}', str(arg))
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
    
    def evaluate_expression(args):
        expression = raw_function
        for i, arg in enumerate(args):
            expression = expression.replace(f'X{i}', str(arg))

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
