### SETS ##

set Planets;
set Types;
set Operations;
set Months;

### PARAMETERS ###

param ShuttleCapacity;
param CharterCost;
param EarthHoldingCost;

param ForecastPrices {Planets, Types, Months} >= 0;

param ProductionLinesCapacity {Operations, Types} >= 0;

### VARIABLES ###

var ShippedUnits        {Planets, Types, Months} >= 0, <= ShuttleCapacity;
var ProducedUnits       {Types, Months}  >= 0;
var EarthStashedUnits   {Types, 0 .. 12} >= 0;
var ChartedShuttles     {Planets, Months} binary;

### CONSTRAINTS ###

subject to MaxAmountShipped {p in Planets, m in Months}: sum {t in Types} ShippedUnits[p, t, m] <= ShuttleCapacity;

subject to MaxProductionLinesOccupation {m in Months, o in Operations}: sum {t in Types} ProducedUnits[t, m] / ProductionLinesCapacity[o, t] <= 1;

subject to EarthStashedUnitsMonthZero {t in Types}: EarthStashedUnits[t, 0] = 0;
subject to MonthlyProducedUnits {t in Types, m in Months}: ProducedUnits[t, m] + EarthStashedUnits[t, m - 1] = sum {p in Planets} ShippedUnits[p, t, m] + EarthStashedUnits[t, m]; 

subject to OrderedShuttles {p in Planets, m in Months}: sum {t in Types} ShippedUnits[p, t, m] <= ShuttleCapacity*ChartedShuttles[p, m];  

### OBJECTIVE ###

maximize Revenue: 
sum {p in Planets, t in Types, m in Months} ShippedUnits[p, t, m]*ForecastPrices[p, t, m] - 
sum {t in Types, m in Months}               EarthStashedUnits[t, m]*EarthHoldingCost -
sum {p in Planets, m in Months}             ChartedShuttles[p, m]*CharterCost;

end;