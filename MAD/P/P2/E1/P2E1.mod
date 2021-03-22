var P;
var D;

subject to R1: (8/9)*P + D <= 40;
subject to R2: (8/10)*P + (1/2)*D <= 40;
subject to R3: P >= D + 1;
subject to R4: P >= 0;
subject to R5: D >= 0;

maximize L: 250*P + 150*D;