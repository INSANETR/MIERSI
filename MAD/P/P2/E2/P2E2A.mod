var X1;
var X2;

subject to R1: 10*X2 + 4*X1 <= 40;
subject to R2: X1 + X2 <= 7;
subject to R3: 10*X1 >= 30;
subject to R4: X1 >= 0;
subject to R5: X2 >= 0;

maximize L: 4*25*X2 + 3*10*X1;