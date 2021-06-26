option solver gurobi;

var xp >= 0; # quantidade de portateis produzidos
var xd >= 0; # quantidade de desktops produzidos

maximize z: 250*xp + 150*xd;

s.t. R1: xp/9  + xd/8 <= 1;
s.t. R2: xp/10 + xd/20 <= 1;
s.t. R3: xp >= xd + 1;

# z* = 2250