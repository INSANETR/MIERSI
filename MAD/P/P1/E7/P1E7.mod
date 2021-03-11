var A;
var B;
var C;

subject to R1: 0.1*A + 0.2*B + 0.4*C >= 30;
subject to R2: 0.45*A + 0.25*B + 0.3*C >= 40;
subject to R3: A >= 0;
subject to R4: B >= 0;
subject to R5: C >= 0;

minimize P: 15*A + 10*B + 20*C;