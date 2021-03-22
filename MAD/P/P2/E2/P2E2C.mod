var X1;
var X2;

subject to R1: 10*(X2/25) + 4*(X1/10) <= 40;
subject to R2: X2/25 + X1/10 <= 7;
subject to R3: X1 >= 30;
subject to R4: X1 >= 0;
subject to R5: X2 >= 0;

maximize L: 4*X2 + 3*X1;