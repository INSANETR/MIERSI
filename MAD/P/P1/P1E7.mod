option solver gurobi;

var x1 >= 0; # toneladas de residuos processados pela fabrica 1
var x2 >= 0; # toneladas de residuos processados pela fabrica 2
var x3 >= 0; # toneladas de residuos processados pela fabrica 3

minimize p: 15*x1 + 10*x2 + 20*x3;

s.t. R1: 0.10*x1 + 0.20*x2 + 0.40*x3 >= 30;
s.t. R2: 0.45*x1 + 0.25*x2 + 0.30*x3 >= 40;

# p* = 923077