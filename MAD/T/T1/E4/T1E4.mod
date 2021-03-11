var F;
var B;

subject to L1: F/200 + B/140 <= 40;
subject to L2: 0 <= F <= 6000;
subject to L3: 0 <= B <= 4000;

maximize L: 25*F + 30*B; 