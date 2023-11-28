import numpy as np
import itertools



data_folder = 'data_2/dat/'

class Generator:
    """Generator of test data for function f"""
    
    class GenArgs:
        """Arguments for generator"""
        def __init__(self,
                     f, #"lambda (x: float, y: float) -> float"
                     args_num: int,
                     args_range: list[int],
                     inst_num: int,
                     rand_num: int,
                     rand_range: list[int]
                    ) -> None:
            """Constructor

            Args:
                f (callable): function to generate data for
                args_num (int): number of arguments of function f
                args_range (list[int]): range of function arguments
                inst_num (int): number of instances for each function argument
                rand_num (int): number of random arguments
                rand_range (list[int]): range of random arguments
            """
            self.f = f
            self.args_num = args_num
            self.args_range = args_range
            self.inst_num = inst_num
            self.rand_num = rand_num
            self.rand_range = rand_range
        
        def __str__(self) -> str:
            return f"{self.args_num} {self.rand_num} {self.rand_range[0]} {self.rand_range[1]} {self.inst_num**self.args_num}"


    def __init__(self, args: GenArgs) -> None:
        self.args = args
    
    @staticmethod
    def generate(args: GenArgs, filename) -> None:
        """Generate data for function f"""
        args_min = args.args_range[0]
        args_max = args.args_range[1]
        
        one_dimension = np.linspace(args_min, args_max, args.inst_num)
        fun_args = itertools.product(one_dimension, repeat=args.args_num)
        
        filepath = data_folder + filename + '.dat'
        with open(filepath, 'w') as file:
            file.write(f"{args}\n")
            
            for fun_arg in fun_args:
                fun_args_str = " ".join(map(lambda x: f"{x:.3f}", fun_arg))
                fun_val = args.f(*fun_arg)
                file.write(f"{fun_args_str} {fun_val:.3f}\n")
                

def f1(x: float) -> float:
    """f(x) = 5*x^3 - 2x^2 + 3x - 17"""
    return 5 * x**3 - 2 * x**2 + 3 * x - 17

def f2(x: float) -> float:
    """f(x) = sin(x) + cos(x)"""
    return np.sin(x) + np.cos(x)

def f3(x: float) -> float:
    """f(x) = 2* ln(x+1)"""
    return 2 * np.log(x + 1)

def f4(x: float, y: float) -> float:
    """f(x,y) = x + 2*y"""
    return x + 2 * y

def f5(x: float, y: float) -> float:
    """f(x, y) = sin(x/2) + 2*cos(x)"""
    return np.sin(x/2) + 2 * np.cos(x)

def f6(x: float, y: float) -> float:
    """f(x,y) = x^2 + 3x*y - 7y + 1"""
    return x**2 + 3 * x * y - 7 * y + 1        




functions = [f1, f2, f3, f4, f5, f6]
n_args = [1, 1, 1, 2, 2, 2]
rgss = [
    [[  -10,   10], [  0, 100], [-1,   1], [-1000, 1000]],
    [[-3.14, 3.14], [  0,   7], [ 0, 100], [ -100,  100]],
    [[    0,    4], [  0,   9], [ 0,  99], [    0,  999]],
    [[    0,    1], [-10,  10], [ 0, 100], [-1000, 1000]],
    [[-3.14, 3.14], [  0,   7], [ 0, 100], [ -100,  100]],
    [[  -10,   10], [  0, 100], [-1,   1], [-1000, 1000]]
]
inst_num = [
    [100, 100, 100, 100],
    [100, 100, 100, 100],
    [100, 100, 100, 100],
    [ 20,  20,  20,  20],
    [ 20,  20,  50, 100],
    [ 20,  20,  20,  20]
]
    
instances = np.empty([6, 4], dtype=Generator.GenArgs)
for i in range(6):
    for j in range(4):
        instances[i][j] = Generator.GenArgs(functions[i],
                                            n_args[i],
                                            rgss[i][j],
                                            inst_num[i][j],
                                            100,
                                            [-5, 5],
                                            )



if __name__ == "__main__":
    # generate data for all functions
    for i in range(6):
        for j in range(4):
            Generator.generate(instances[i][j], f"f{i+1}_{j}")
            