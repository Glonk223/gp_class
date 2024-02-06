import numpy as np
import itertools

args_min = -9999
args_max = 9999
inst_num = 5

one_dimension = np.linspace(args_min, args_max, inst_num)
fun_args = itertools.product(one_dimension, repeat=2)

def f(a, b): return a*b

with open('./OurGP/data/zad1.2.E/data.txt', 'w') as file:
    for fun_arg in fun_args:
        fun_args_str = " ".join(map(lambda x: f"{x:.3f}", fun_arg))
        fun_val = f(*fun_arg)
        file.write(f"{fun_args_str} : {fun_val:.3f}\n")