option solver gurobi;

var x1 >= 0; # número de pratos de Bife utilizados
var x2 >= 0; # número de pratos de Frango utilizados
var x3 >= 0; # número de pratos de Peixe utilizados
var x4 >= 0; # número de pratos de Hamburger utilizados
var x5 >= 0; # número de pratos de Macarrão utilizados
var x6 >= 0; # número de pratos de Empada utilizados
var x7 >= 0; # número de pratos de Esparguete utilizados
var x8 >= 0; # número de pratos de Peru utilizados

minimize C: 319*x1 + 259*x2 + 229*x3 + 289*x4 + 189*x5 + 199*x6 + 199*x7 + 249*x8;

s.t. R1: x1*60 + x2*8 + x3*8 + x4*40 + x5*15 + x6*70 + x7*25 + x8*60 >= 700;
s.t. R2: x1*20 + x2*0 + x3*10 + x4*40 + x5*35 + x6*30 + x7*50 + x8*20 >= 700;
s.t. R3: x1*10 + x2*20 + x3*15 + x4*35 + x5*15 + x6*15 + x7*25 + x8*15 >= 700;
s.t. R4: x1*15 + x2*20 + x3*10 + x4*10 + x5*15 + x6*15 + x7*15 + x8*10 >= 700;

# C = 8820