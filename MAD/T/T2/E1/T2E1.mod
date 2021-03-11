var M;
var C;

subject to L1: 2*M + C <= 100;
subject to L2: M + C <= 80;
subject to L3: 0 <= M <= 40;
subject to L5: C >= 0;

maximize L: 3*M + 2*C;