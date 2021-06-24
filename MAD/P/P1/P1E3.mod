option solver gurobi;

var c >= 0, <= 42; # comprimento
var l >= 0;        # largura
var a >= 0;        # altura

maximize p: c*l*a;

s.t. R1: c + l <= 72;
s.t. R2: a <= l;
s.t. R3: l <= c;

# p* = nonlinear