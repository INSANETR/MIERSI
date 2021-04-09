### SETS ###

set types;
set planets;
set months;
set pLines;

### PARAMETERS ###

param mercuryPrices {months, types} >= 0;
param venusPrices   {months, types} >= 0;
param marsPrices    {months, types} >= 0;
param pLinesMax     {pLines, types} >= 0;

### VARIABLES ###

var mercuryShipped {months, types} >= 0 integer;
var venusShipped   {months, types} >= 0 integer;
var marsShipped    {months, types} >= 0 integer;

### CONSTRAINTS ###

subject to mercuryLimit  {month in months}: 0 <= (sum {type in types} mercuryShipped[month, type]) <= 1000;
subject to venusLimit    {month in months}: 0 <= (sum {type in types} venusShipped[month, type]) <= 1000;
subject to marsLimit     {month in months}: 0 <= (sum {type in types} marsShipped[month, type]) <= 1000;
subject to pLinesLimit   {month in months, pLine in pLines}: 0 <= sum {type in types} (mercuryShipped[month, type] + venusShipped[month, type] + marsShipped[month, type])/pLinesMax[pLine, type] <= 1;

### OBJECTIVE ###

maximize revenue: (sum {month in months} (sum {type in types} (mercuryShipped[month, type]*mercuryPrices[month, type] + venusShipped[month, type]*venusPrices[month, type] + marsShipped[month, type]*marsPrices[month, type]))); 

end;
