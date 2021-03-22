var X1;
var X2;

subject to R1: 0 <= X1 <= 100;
subject to R2: 0 <= X2 <= 100;
subject to R3: 50*X1 + 35*X2 <= 6000;
subject to R4: 20*X1 + 15*X2 >= 2000;

maximize L: 20*X1 + 15*X2;