var A;
var C;
var L;

subject to R1: C + L <= 72;
subject to R2: 0 <= A <= L;
subject to R3: 0 <= C <= 42;
subject to R4: 0 <= L <= C;

maximize V: A*C*L;