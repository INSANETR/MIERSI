var F;
var B;

subject to RA: F/200 + B/140 <= 40;

subject to RB: 0 <= F <= 6000;

subject to RC: 0 <= B <= 4000;

maximize L: 25*F + 30*B;