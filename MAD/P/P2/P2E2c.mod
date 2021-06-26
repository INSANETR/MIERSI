option solver gurobi;

var x1 >= 0; # numero de galoes de milho
var x2 >= 0; # numero de galoes de trigo

maximize z: 3*x1 + 4*x2;

s.t. R1: x1/10 + x2/25 <= 7;
s.t. R2: 4*(x1/10) + 10*(x2/25) <= 40;
s.t. R3: x1 >= 30;

# z* = 370