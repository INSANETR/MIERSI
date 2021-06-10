# option solver gurobi;

var x {i in 1 .. 3, j in 1 .. 3} >= 0; # barris de petróleo i usado para produzir gasolina j
var a {i in 1 .. 3} >= 0;              # euros gastos diariamente a publicitar a gasolina i

maximize P: 
sum{i in 1 .. 3} (70*x[i, 1] + 60*x[i, 2] + 50*x[i, 3]) 
- sum{j in 1 .. 3} (45*x[1, j] + 35*x[2, j] + 25*x[3, j]) 
- sum{i in 1 .. 3} (a[i]) 
- sum{i in 1 .. 3, j in 1 .. 3} (4*x[i, j]);

s.t. R1:  sum{i in 1 .. 3} x[i, 1] - 10*a[1] = 3000;
s.t. R2:  sum{i in 1 .. 3} x[i, 2] - 10*a[2] = 2000;
s.t. R3:  sum{i in 1 .. 3} x[i, 3] - 10*a[3] = 1000;
s.t. R4   {i in 1 .. 3}: sum{j in 1 .. 3} x[i, j] <= 5000;
s.t. R5:  sum{i in 1 .. 3, j in 1 .. 3} x[i, j] <= 14000;
s.t. R6:  2*x[1, 1] - 4*x[2, 1] - 2*x[3, 1] >= 0;
s.t. R7:  4*x[1, 2] - 2*x[2, 2] >= 0;
s.t. R8:  6*x[1, 3] - 2*x[3, 3] >= 0;
s.t. R9:  -0.005*x[1, 1] + 0.01*x[2, 1] + 0.02*x[3, 1] <= 0;
s.t. R10: -0.015*x[1, 2] + 0.01*x[3, 2] <= 0;
s.t. R11: -0.005*x[1, 3] + 0.01*x[2, 3] + 0.02*x[3, 3] <= 0;

# P = 287750