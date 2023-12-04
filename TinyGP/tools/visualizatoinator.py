import numpy as np
from matplotlib import pyplot as plt
from matplotlib.lines import Line2D
from mayavi import mlab
import os

from simplifier import Simplifier


class Visualizatoinator:
    def __init__(self, path: str, function: str):
        prefix = function.split('_')[0]
        folder_path = f'{path}/{prefix}/{function}'
        self.files = {
            'src_data_file': folder_path + '/dat/_data.txt',
            
            'src_ari_fun': folder_path + '/dat/ari_fun.dat',
            'src_ari_sts': folder_path + '/dat/ari_sts.csv',
            'src_tri_fun': folder_path + '/dat/tri_fun.dat',
            'src_tri_sts': folder_path + '/dat/tri_sts.csv',

            'dst_ari_fun': folder_path + '/ari_fun.png',
            'dst_ari_sts': folder_path + '/ari_sts.png',
            'dst_tri_fun': folder_path + '/tri_fun.png',
            'dst_tri_sts': folder_path + '/tri_sts.png',
            'dst_cmp_fun': folder_path + '/cmp_fun.png',
        }
        
        self.ex_ari_fun = os.path.exists(self.files['src_ari_fun'])
        self.ex_ari_sts = os.path.exists(self.files['src_ari_sts'])
        self.ex_tri_fun = os.path.exists(self.files['src_tri_fun'])
        self.ex_tri_sts = os.path.exists(self.files['src_tri_sts'])
        
        with open(self.files['src_data_file'], 'r') as file:
            file.readline()
            self.targets = []
            """list[ tuple( list[ args ], result ))] expected function args and values"""
            for line in file:
                line = line.strip().split(' ')
                
                args = [float(x) for x in line[:-1]]
                result = float(line[-1])
                self.targets.append((args, result))
    
    
    def visualize_function(self):
        """Visualizes a function generated by TinyGP.
        
        Aligns it with the expected function from the data file."""
        exp_y = np.array([val for _, val in self.targets])
        args = np.array([args for args, _ in self.targets])
    
        if len(self.targets[0][0]) == 1:
            x = args.flatten()
            exp = {
                'fun': exp_y,
                'line': 'k-x',
                'label': 'Expected',
                'linewidth': 3,
            }
            
            def get_val(func_type):
                f = self.prepare_function(func_type)
                return self.calculate_function(f, args)
            
            if self.ex_ari_fun:
                print('\tcalculating ari 1d')
                ari_y = get_val('ari')
                ari = {
                    'fun': ari_y,
                    'line': 'r-',
                    'label': 'Aritmetic',
                    'linewidth': 2,
                }
                self.visualize_function_1d(x, [exp, ari], 'ari')
            
            if self.ex_tri_fun:
                print('\tcalculating tri 1d')
                tri_y = get_val('tri')
                tri = {
                    'fun': tri_y,
                    'line': 'c--',
                    'label': 'Trigonometric',
                    'linewidth': 2,
                }
                self.visualize_function_1d(x, [exp, tri], 'tri')
            
            if self.ex_ari_fun and self.ex_tri_fun:
                self.visualize_function_1d(x, [exp, ari, tri], 'cmp')
            
        elif len(self.targets[0][0]) == 2:
            x = args[:, 0]
            z = args[:, 1]
            
            size = int(np.sqrt(len(x)))
            if size**2 != len(x):
                raise ValueError('Something went wrong with data file')
            
            x = np.array(x).reshape((size, size))[:, 0]
            z = np.array(z).reshape((size, size))[0, :]
            x_grid, z_grid = np.meshgrid(x, z, indexing='ij')
            
            exp_y = np.array(exp_y).reshape((size, size))
            exp = {
                'fun': exp_y,
                'color': (0.3, 0.3, 0.3),
                'label': 'Expected',
            }
            
            def get_val(func_type):
                f = self.prepare_function(func_type)
                return self.calculate_function(f, x_grid, z_grid)
            
            if self.ex_ari_fun:
                print('\tcalculating ari 2d')
                ari_y = get_val('ari')
                ari = {
                    'fun': ari_y,
                    'color': (1.0, 0.0, 0.0),
                    'label': 'Aritmetic',
                }
                self.visualize_function_2d(x_grid, z_grid, [exp, ari], 'ari')
            
            if self.ex_tri_fun:
                print('\tcalculating tri 2d')
                tri_y = get_val('tri')
                tri = {
                    'fun': tri_y,
                    'color': (0.0, 0.75, 0.75),
                    'label': 'Trigonometric',
                }
                self.visualize_function_2d(x_grid, z_grid, [exp, tri], 'tri')
            
            if self.ex_ari_fun and self.ex_tri_fun:
                self.visualize_function_2d(x_grid, z_grid, [exp, ari, tri], 'cmp')
        else:
            print(f'Error: unsupported number of arguments: {len(self.targets[0][0])}')
    
    def visualize_function_1d(self,
                              x: list[float],
                              ys: list[dict],
                              func_type: str
                            ):
        plt.figure(figsize=(10, 10))
        for params in ys:
            y, line, label, linewidth = params.values()
            plt.plot(x, y, line, linewidth=linewidth, label=label)
            
        plt.legend(fontsize='xx-large')
        plt.grid()
        plt.xlabel('x')
        plt.ylabel('f(x)')
        
        dst = self.files[f'dst_{func_type}_fun']
        plt.savefig(dst)
        plt.clf()
        plt.close()
    

    def visualize_function_2d_(self, x_grid: np.array, z_grid: np.array, ys: list[dict], func_type: str):
        plt.figure(figsize=(10, 10))
        ax = plt.axes(projection='3d')

        for params in ys:
            y, color, label = params.values()
            ax.plot_wireframe(x_grid, z_grid, y, color=color, label=label, alpha=0.75)

        ax.legend(fontsize='xx-large')
        plt.xlabel('x')
        plt.ylabel('z')
        ax.set_zlabel('f(x, z)')

        dst = self.files[f'dst_{func_type}_fun']
        plt.savefig(dst)
        plt.clf()
        plt.close()
    
    def visualize_function_2d(self, x_grid: np.array, z_grid: np.array, ys: list[dict], func_type: str):
        mlab.figure(size=(800, 800), bgcolor=(1, 1, 1), fgcolor=(0, 0, 0))
        ax_ranges = [x_grid.min(), x_grid.max(),
                     z_grid.min(), z_grid.max(),
                     ys[0]['fun'].min(), ys[0]['fun'].max()]
        ax_scale = [1.0, 1.0, (ax_ranges[3] - ax_ranges[2]) / (ax_ranges[5] - ax_ranges[4])]
        ax_extent = ax_ranges * np.repeat(ax_scale, 2)

        surfs = []
        for params in ys:
            y, color, label = params.values()
            if label == 'Expected':
                surfs.append(mlab.surf(x_grid, z_grid, y, color=color, opacity=0.2))
            else:
                surfs.append(mlab.mesh(x_grid, z_grid, y, representation='wireframe', color=color))

        mlab.outline(color=(.2, .2, .2), extent=ax_extent)
        
        for surf in surfs:
            surf.actor.actor.scale = ax_scale

        # Set equal aspect ratio
        mlab.axes(color=(.2, .2, .2),
                  xlabel='x', ylabel='y', zlabel='f(x,y)',
                  ranges=ax_ranges, extent=ax_extent)
        
        mlab.view(-110, 75, 4*(ax_ranges[3] - ax_ranges[2]))

        dst = self.files[f'dst_{func_type}_fun']
        # mlab.savefig(dst)
        # mlab.clf()
        # mlab.close()
        print(f'\t\tfile: {dst}')
        mlab.show()

    
    def prepare_function(self, type):
        """Prepares a function for evaluation.

        Returns:
            callable: function that takes 1 or 2 arguments and returns a float result.
        """
        function_file = self.files[f'src_{type}_fun']
        with open(function_file, 'r') as file:
            raw_function = file.readlines()[-1].strip('Best Individual:').strip()

        simplifier = Simplifier()
        raw_function = simplifier.simplify(raw_function)

        # Helper function
        def evaluate_expression(*args):
            """Evaluates a function for given arguments.

            Returns:
                float: result of the function for given arguments.
            """
            expression = raw_function
            for i, arg in enumerate(args):
                expression = expression.replace(f'X{i+1}', str(arg))
            
            if 'X' in expression:
                raise ValueError('There are leftover variables in expression')
            
            return eval(simplifier.simplify(expression))
        
        return evaluate_expression
    
    def calculate_function(self, func: callable, *args: list[np.array]) -> np.array:
        return np.vectorize(func)(*args)
    
    
    def visualize_progress(self):
        """Visualizes the progress of the TinyGP algorithm across generations."""
        if self.ex_ari_sts:
            print('\tvisualizing ari progress')
            self._visualize_progress('ari')
        if self.ex_tri_sts:
            print('\tvisualizing tri progress')
            self._visualize_progress('tri')

    def _visualize_progress(self, func_type: str):
        stats_file = self.files[f'src_{func_type}_sts']
        data = np.genfromtxt(stats_file, delimiter=',', skip_header=1)

        x, avg_fit, best_fit, avg_size = data.transpose()

        fig, ax1 = plt.subplots(figsize=(12, 10))
        fig.subplots_adjust(right=0.75)

        ax2 = ax1.twinx()
        ax3 = ax1.twinx()

        # Offset the right spine of twin2.
        offset = 1.15
        ax3.spines.right.set_position(("axes", offset))
        
        p1, = ax1.plot(x, best_fit, label="best fit", color='C2', linewidth=3.0)
        p2, = ax2.plot(x, avg_size, label="avg size", color='C3', linewidth=1.5)
        p3, = ax3.plot(x, avg_fit,  label="avg fit",  color='C1', linewidth=0.5)

        max_fit, min_fit = np.max(best_fit), np.min(best_fit)
        avg_fit_limit = np.median(avg_fit)
        best_fit_limit = min_fit * 50 if max_fit > min_fit * 50 else max_fit
        
        # move the offset text in the y axis
        ax3.yaxis.get_offset_text().set_visible(True)
        ax3.yaxis.get_offset_text().set_position((offset, offset))

        ax1.set(ylim=(0, best_fit_limit), xlabel="Generation", ylabel="best fit")
        ax2.set(ylabel="avg size")
        ax3.set(ylim=(0, avg_fit_limit), ylabel="avg fit")

        for ax, p in zip([ax1, ax2, ax3], [p1, p2, p3]):
            ax.yaxis.label.set_color(p.get_color())
            ax.tick_params(axis='y', colors=p.get_color())

        ax1.grid()
        ax1.legend(handles=[p1, p2, p3], fontsize='xx-large')

        progress_plot = self.files[f'dst_{func_type}_sts']
        fig.savefig(progress_plot)
        plt.close(fig)



if __name__ == "__main__":
    files = [
        # 'f1_0',
        # 'f1_1',
        # 'f1_2',
        # 'f1_3',
        # 'f2_0',
        # 'f2_1',
        # 'f2_2',
        # 'f2_3',
        # 'f3_0',
        # 'f3_1',
        # 'f3_2',
        # 'f3_3',
        # 'f4_0',
        # 'f4_1',
        # 'f4_2',
        # 'f4_3',
        # 'f5_0',
        # 'f5_1',
        # 'f5_2',
        # 'f5_3',
        # 'f6_0',
        # 'f6_1',
        'f6_2',
        # 'f6_3',
        # 'f7_0',
        # 'f8_0',
    ]

    for file in files:
        print('\n\n', file)
        vis = Visualizatoinator('./data', file)
        vis.visualize_function()
        vis.visualize_progress()
    