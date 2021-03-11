var BIFE;
var FRAN;
var PEIX;
var HAMB;
var MACA;
var EMPA;
var ESPA;
var PERU;

subject to R1: 60*BIFE + 8*FRAN + 8*PEIX + 40*HAMB + 15*MACA + 70*EMPA + 25*ESPA + 60*PERU >= 700;
subject to R2: 20*BIFE + 0*FRAN + 10*PEIX + 40*HAMB + 35*MACA + 30*EMPA + 50*ESPA + 20*PERU >= 700;
subject to R3: 10*BIFE + 20*FRAN + 15*PEIX + 35*HAMB + 15*MACA + 15*EMPA + 25*ESPA + 15*PERU >= 700;
subject to R4: 15*BIFE + 20*FRAN + 10*PEIX + 10*HAMB + 15*MACA + 15*EMPA + 15*ESPA + 10*PERU >= 700;
subject to R5: BIFE >= 0;
subject to R6: FRAN >= 0;
subject to R7: PEIX >= 0;
subject to R8: HAMB >= 0;
subject to R9: MACA >= 0;
subject to R10: EMPA >= 0;
subject to R11: ESPA >= 0;
subject to R12: PERU >= 0;

minimize P: 319*BIFE + 259*FRAN + 229*PEIX + 289*HAMB + 189*MACA + 199*EMPA + 199*ESPA + 249*PERU;