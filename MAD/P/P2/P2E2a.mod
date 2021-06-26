option solver gurobi;

var x1 >= 0; # numero de acres de milho
var x2 >= 0; # numero de acres de trigo

maximize z: 30*x1 + 100*x2;

s.t. R1: x1 + x2 <= 7;
s.t. R2: 4*x1 + 10*x2 <= 40; 
s.t. R3: 10*x1 >= 30;

# z* = 370