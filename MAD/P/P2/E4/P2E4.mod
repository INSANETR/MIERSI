var A1;
var A2;
var A3;

var X11;
var X12;
var X13;

var X21;
var X22;
var X23;

var X31;
var X32;
var X33;

subject to R1: X11 + X21 + X31 - 10*A1 = 3000;
subject to R2: X12 + X22 + X32 - 10*A2 = 2000;
subject to R3: X13 + X23 + X33 - 10*A3 = 1000;
subject to R4: X11 + X12 + X13 <= 5000;
subject to R5: X21 + X22 + X23 <= 5000;
subject to R6: X31 + X32 + X33 <= 5000;
subject to R7: X11 + X12 + X13 + X21 + X22 + X23 + X31 + X32 + X33 <= 14000;
subject to R8: 2*X11 - 4*X21 - 2*X31 >= 0;
subject to R9: 4*X12 - 2*X22 >= 0;
subject to R10: 6*X13 + 2*X33 >= 0;
subject to R11: -0.005*X11 + 0.01*X21 + 0.02*X31 <= 0;
subject to R12: -0.015*X12 + 0.01*X32 <= 0;
subject to R13: -0.005*X13 + 0.01*X23 + 0.02*X33 <= 0;
subject to R14: X11 >= 0;
subject to R15: X12 >= 0;
subject to R16: X13 >= 0;
subject to R17: X21 >= 0;
subject to R18: X22 >= 0;
subject to R19: X23 >= 0;
subject to R20: X31 >= 0;
subject to R21: X32 >= 0;
subject to R22: X33 >= 0;
subject to R23: A1 >= 0;
subject to R24: A2 >= 0;
subject to R25: A3 >= 0;

maximize L: 21*X11 + 11*X12 + X13 + 31*X21 + 21*X22 + 11*X23 + 41*X31 + 31*X32 + 21*X33 - A1 - A2 - A3;