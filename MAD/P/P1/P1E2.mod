option solver gurobi;

var x2 >= 0; # numero de videos com 2 cabecas de leitura produzidos
var x4 >= 0; # numero de videos com 4 cabecas de leitura produzidos

maximize p: 32*x2 + 8*x4 + x2*x4 - x2*x2/2 - x4*x4;

s.t. R1: 5*x2 + 6*x4 <= 600;
s.t. R2:   x2 + 2*x4 <= 160;

# p* = 1312