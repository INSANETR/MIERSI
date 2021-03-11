var X;
var Y;

subject to R1: 5*X + 6*Y <= 600;
subject to R2: X + 2*Y <= 160;
subject to R3: X >= 0;
subject to R4: Y >= 0;

maximize L: 32*X + 8*Y + X*Y - X^2/2 - Y^2;