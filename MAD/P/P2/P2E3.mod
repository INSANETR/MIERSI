option solver gurobi;

var xd >= 0, <= 100; # quantidade de discos produzidos
var xl >= 0, <= 100; # quantidade de leitores produzidos

maximize z: 20*xd + 15*xl;

s.t. R1: 50*xd + 35*xl <= 6000;
s.t. R2: 20*xd + 15*xl >= 2000;

# z* = 2500