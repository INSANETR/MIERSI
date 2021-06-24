option solver gurobi;

var xf >= 0, <= 6000; # quantidade de fitas produzida (toneladas)
var xb >= 0, <= 4000; # quantidade de bobinas produzidas (toneladas)

maximize p: 25*xf + 30*xb;

s.t. R1: xf/200 + xb/140 <= 40;

# p* = 192000 