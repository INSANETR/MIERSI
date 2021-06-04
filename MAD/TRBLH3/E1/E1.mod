option solver gurobi;

### SETS ###

set Types;
set Operations;

### PARAMETERS ###

param NumberOfWeeks;
param StashedCost;
param BacklogCost;
param SetupCost;
param M;

param ForecastSales {w in 1 .. NumberOfWeeks, Types} >= 0;

param ProductionLinesCapacity {Operations, Types} >= 0;

### VARIABLES ###

var ProducedUnits   {w in 1 .. NumberOfWeeks, Types} >= 0;
var DeliveredUnits  {w in 1 .. NumberOfWeeks, Types} >= 0;
var StashedUnits    {w in 0 .. NumberOfWeeks, Types} >= 0;
var BacklogUnits    {w in 0 .. NumberOfWeeks, Types} >= 0;
var HasSetup        {w in 1 .. NumberOfWeeks, Types} binary;

### OBJECTIVE ###

minimize TotalCost: 
sum {w in 1 .. NumberOfWeeks, t in Types} 
(
    HasSetup[w, t] * SetupCost + 
    StashedUnits[w, t] * StashedCost + 
    BacklogUnits[w, t] * BacklogCost
);

### CONSTRAINTS ###

s.t. R0 {t in Types}: sum {w in 1 .. NumberOfWeeks} ProducedUnits[w, t] = sum {w in 1 .. NumberOfWeeks} ForecastSales[w, t];

s.t. R1 {o in Operations, w in 1 .. NumberOfWeeks}: sum {t in Types} ProducedUnits[w, t] / ProductionLinesCapacity[o, t] <= 1; 

s.t. R2 {t in Types}:                          StashedUnits[0, t] = 0;
s.t. R3 {t in Types, w in 1 .. NumberOfWeeks}: ProducedUnits[w, t] + StashedUnits[w - 1, t] = DeliveredUnits[w, t] + StashedUnits[w, t];  

s.t. R4 {t in Types}:                          BacklogUnits[0, t] = 0;
s.t. R5 {t in Types}:                          BacklogUnits[52,t] = 0;
s.t. R6 {w in 1 .. NumberOfWeeks, t in Types}: BacklogUnits[w, t] = ForecastSales[w, t] + BacklogUnits[w - 1, t] - DeliveredUnits[w, t];

s.t. R7 {w in 1 .. NumberOfWeeks, t in Types}: ProducedUnits[w, t] <= M * HasSetup[w, t];

s.t. R8 {w in 1 .. NumberOfWeeks}: sum {t in Types} HasSetup[w, t] <= 2;

end;
