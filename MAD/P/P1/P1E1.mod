option solver gurobi;

var a >= 0; # número de toneladas fornecidas pela fábrica A
var b >= 0; # número de toneladas fornecidas pela fábrica B

maximize P: 4*a + 3.5*b; 

s.t. R1: a + b <= 5;
s.t. R2: a <= 3;

# P = 19