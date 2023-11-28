import re

import numpy as np

# na samym dole metoda main

class Simplifier:
    def __str__(self) -> str:
        """Returns a string representation of the simplifier.
        
        Shows original and simplified program size, size reduction and number of simplified formulas.
        """
        program_size_reduction = len(self.original_program) - len(self.new_program)
        percent_reduced = (program_size_reduction / len(self.original_program)) * 100

        return f"orgiginal program size: {len(self.original_program)}\n" \
               f"final program size: {len(self.new_program)}\n" \
               f"size reduction: {program_size_reduction} ({percent_reduced:.2f}%)\n" \
               f"total number of simplified formulas: {self.count}\n"
    
    
    def simplify(self, program: str) -> str:
        """Simplifies a program by replacing all simplifiable subformulas with their results.

        Args:
            program (str): program to simplify.

        Returns:
            str: simplified result.
        """
        self.original_program = program
        self.new_program = program.replace(" ", "").replace("E", "e")
        # self.new_program = self.new_program[1:-1]
        
        count = -1
        while True:
            count += 1
            simplifiable_formula = Simplifier.locate_first_simplifiable_formula(self.new_program)
            if simplifiable_formula is None: break
            
            formula, indecies = simplifiable_formula
            new_formula = str(Simplifier.calculate_formula(formula))
            self.replace_formula(new_formula, indecies)
        
        self.count = count
        # self.new_program = "(" + self.new_program + ")"
        return self.new_program
    
    def replace_formula(self, new_formula: str, indecies: (int, int)):
        """Replcaes a formula with a new one.

        Args:
            new_formula (str): new formula to replace the old one.
            indecies (int, int): indecies of the old formula in the program.
        """
        part1 = self.new_program[:indecies[0]]
        part2 = self.new_program[indecies[1] + 1:]
        
        self.new_program = part1 + new_formula + part2
    
    
    @staticmethod
    def locate_first_simplifiable_formula(program) -> tuple[str, (int, int)]:
        """Locates all simplifiable formulas in a program.
        
        Returns:
            list[str, (int, int)]: list of simplifiable formulas and their indecies in the program.
        """
        i = -1
        
        while i < len(program):
            i += 1
            parenthasis1_ix = Simplifier.locate_next_parenthasis(program, i)
            parenthasis2_ix = Simplifier.locate_next_parenthasis(program, parenthasis1_ix + 1)
            if parenthasis1_ix == -1 or parenthasis2_ix == -1: break

            formula = program[parenthasis1_ix:parenthasis2_ix + 1]
            if Simplifier.is_trigonometric_formula(formula):
                # change parenthasis1_ix to the start of sin or cos
                parenthasis1_ix += re.search(r'(sin|cos)', formula).start()
                
                # find parenthasis of next formula
                next_par1_ix = parenthasis2_ix
                next_par2_ix = Simplifier.locate_next_parenthasis(program, next_par1_ix + 1)
                if next_par2_ix == -1 or next_par2_ix == -1: break
                
                next_formula = program[next_par1_ix:next_par2_ix + 1]
                
                if Simplifier.is_simplified_formula(next_formula):
                    trigonometric_formula = program[parenthasis1_ix:next_par2_ix + 1]
                    return (trigonometric_formula, (parenthasis1_ix, next_par2_ix))
            
            elif Simplifier.is_simplifiable_formula(formula):
                return (formula, (parenthasis1_ix, parenthasis2_ix))
            
            else:
                i = parenthasis2_ix - 1
        return None
    
    @staticmethod
    def locate_next_parenthasis(program: str, start: int) -> int:
        """Locates the next parenthasis in a string.
        
        Returns:
            int: index of the next parenthasis in the string or -1 if none found.
        """
        open = program.find('(', start)
        close = program.find(')', start)
        return min(open, close) if min(open, close) != -1 else max(open, close)        
    
    
    @staticmethod
    def is_simplifiable_formula(formula: str) -> bool:
        """Checks if a formula is simplifiable.
        
        Checks if formula is closed in "( )" and if it does not contain any variables. 
        
        Returns:
            bool: True if formula is simplifiable, False otherwise.
        """
        if Simplifier.is_simplified_formula(formula): return False
        if formula[0] == "(" and formula[-1] == ")":
            return not bool(re.search(r'[a-df-zA-Z]', formula))
        return False
    
    @staticmethod
    def is_trigonometric_formula(formula: str) -> bool:
        """Checks if a formula is a sin or cos function.
        
        Returns:
            bool: True if formula is a sin or cos function, False otherwise.
        """
        return bool(re.search(r'(sin|cos)', formula))
    
    @staticmethod
    def is_simplified_formula(formula: str) -> bool:
        """Checks if a formula is simplified.
        
        Returns:
            bool: True if formula is simplified, False otherwise.
        """
        reg = r'-?\d+(\.\d*)?([eE][-+]?\d+)?$'
        if bool(re.match(reg, formula[1:-1])) or bool(re.match(reg, formula)):
            return True
        return False
    
    
    @staticmethod
    def get_tokens(formula: str) -> tuple[float, str, float]:
        """Splits a formula into tokens.
        
        Returns:
            tuple[float, str, float]: tuple of left value, function and right value.
        """
        
        tokens = re.split(r"([+\-*/])", formula[1:-1])

        # find tokens containing 'e' and marge them with 2 next tokens
        for i in range(len(tokens)):
            if 'e' in tokens[i]:
                tokens[i] = tokens[i] + tokens[i + 1] + tokens[i + 2]
                tokens[i + 1] = tokens[i + 2] = ''
        # clean empty tokens
        tokens = list(filter(str.strip, tokens))
        
        match tokens:
            case [l, f, r]:
                return (float(l), f, float(r))
            case ["-", l, f, r]:
                return (-float(l), f, float(r))
            case [l, f, "-", r]:
                return (float(l), f, -float(r))
            case ["-", l, f, "-", r]:
                return (-float(l), f, -float(r))
            case _:
                raise ValueError(f"Invalid formula found: {formula}")
    
    @staticmethod
    def get_trigonometric_tokens(formula: str) -> tuple[str, float]:
        """Splits a trigonometric formula into tokens.
        
        Returns:
            tuple[str, float]: tuple of function and value.
        """
        tokens = re.split(r'[()]', formula)
        
        match tokens:
            case 'sin', value, _:
                return ('sin', float(value))
            case 'cos', value, _:
                return ('cos', float(value))
            case _:
                raise ValueError(f"Invalid formula found: {formula}")
        
    @staticmethod
    def calculate_formula(formula: str) -> float:
        """Simplifies a formula by calculating it.
        
        If encounters zero division returns left value.
        
        Returns:
            str: simplified formula.
        """        
        if Simplifier.is_trigonometric_formula(formula):
            return Simplifier.calculate_trigonometric_formula(formula)
        
        l_val, function, r_val = Simplifier.get_tokens(formula)
        match function:
            case "+":
                return float(l_val) + float(r_val)
            case "-":
                return float(l_val) - float(r_val)
            case "*":
                return float(l_val) * float(r_val)
            case "/":
                if abs(float(r_val)) <= 0.001:
                    return float(l_val)
                return float(l_val) / float(r_val)
            case _:
                raise ValueError(f"Invalid function character found: {function}")

    @staticmethod
    def calculate_trigonometric_formula(formula: str) -> float:
        """Simplifies a formula by calculating it."""
        function, value = Simplifier.get_trigonometric_tokens(formula)
        
        match function:
            case "sin":
                return np.sin(value)
            case "cos":
                return np.cos(value)
            case _:
                raise ValueError(f"Invalid function character found: {function}")



if __name__ == "__main__":
    txt = '((1 - 2) * (3 + 4)) + sin((X1 / 5))'  # tutaj wklej program
    simplifier = Simplifier() # stworzenie obiektu klasy Simplifier
    simplifier.simplify(txt) # wywołanie metody simplify, która zwraca uproszczony program
    
    print(simplifier.original_program)
    print(simplifier.new_program) # ale też go zachowuje w klasie jako w polu self.new_program
    print()
    print(simplifier) # w str wipisuje statystyki ile udało się uprościć
    