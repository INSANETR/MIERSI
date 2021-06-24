option solver gurobi;

var xa >= 0, <= 3; # quantidade de produto encomendado a fabrica A (toneladas)
var xb >= 0;       # quantidade de produto encomendado a fabrica B (toneladas)

maximize p: 4*xa + 3.5*xb;

s.t. R1: xa + xb <= 5;

# p* = 19