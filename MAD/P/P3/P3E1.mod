var X1;
var X2;

subject to R1: X1 + 2*X2 <= 350;
subject to R2: 2*X1 + X1 <= 400;
subject to R3: X1 >= 0;
subject to R4: X2 >= 0;

maximize L: 2*X1 + 2.5*X2;