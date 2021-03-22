Problem:    P2E4
Rows:       26
Columns:    12
Non-zeros:  69
Status:     OPTIMAL
Objective:  L = 287750 (MAXimum)

   No.   Row name   St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 R1           NS          3000          3000             =         -20.8 
     2 R2           NS          2000          2000             =           0.1 
     3 R3           NS          1000          1000             =         -40.8 
     4 R4           NU          5000                        5000         57.25 
     5 R5           NU          5000                        5000          20.9 
     6 R6           B           3500                        5000 
     7 R7           B          13500                       14000 
     8 R8           B           2000            -0               
     9 R9           NL             0            -0                       < eps
    10 R10          B           4000            -0               
    11 R11          NU             0                          -0          3090 
    12 R12          NU             0                          -0          3090 
    13 R13          NU             0                          -0          3090 
    14 R14          B        2222.22            -0               
    15 R15          B        2111.11            -0               
    16 R16          B        666.667            -0               
    17 R17          B        444.444            -0               
    18 R18          B        4222.22            -0               
    19 R19          B        333.333            -0               
    20 R20          B        333.333            -0               
    21 R21          B        3166.67            -0               
    22 R22          NL             0            -0                       < eps
    23 R23          NL             0            -0                        -209 
    24 R24          B            750            -0               
    25 R25          NL             0            -0                        -409 
    26 L            B         287750                             

   No. Column name  St   Activity     Lower bound   Upper bound    Marginal
------ ------------ -- ------------- ------------- ------------- -------------
     1 A1           B              0                             
     2 A2           B            750                             
     3 A3           B              0                             
     4 X11          B        2222.22                             
     5 X12          B        2111.11                             
     6 X13          B        666.667                             
     7 X21          B        444.444                             
     8 X22          B        4222.22                             
     9 X23          B        333.333                             
    10 X31          B        333.333                             
    11 X32          B        3166.67                             
    12 X33          B              0                             

Karush-Kuhn-Tucker optimality conditions:

KKT.PE: max.abs.err = 1.82e-12 on row 9
        max.rel.err = 2.84e-14 on row 23
        High quality

KKT.PB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

KKT.DE: max.abs.err = 1.42e-14 on column 6
        max.rel.err = 1.36e-16 on column 7
        High quality

KKT.DB: max.abs.err = 0.00e+00 on row 0
        max.rel.err = 0.00e+00 on row 0
        High quality

End of output
