option solver gurobi;

var xa >= 0, <= 100000;
var xv >= 0, <= 100000;
var xp >= 0, <= 120000;

maximize p: 500*(400*xa + 500*xv + 300*xp) + 200*(500*xa + 200*xv + 800*xp);

# p* = 9.62e+10