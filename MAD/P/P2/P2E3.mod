option solver gurobi;

var x1 >= 0, <= 100; # número de discos produzidos
var x2 >= 0, <= 100; # número de leitores produzidos

maximize P: 20*x1 + 15*x2;

s.t. R1: 50*x1 + 35*x2 <= 6000;
s.t. R2: 20*x1 + 15*x2 >= 2000;

# P = 2500

# contribuição dos discos para o profit   = 100 - 50 - 30 = 20
# contribuição dos leitores para o profit = 90  - 35 - 40 = 15

# dinheiro em caixa a 1 de janeiro =
# dinheiro em caixa a 1 de dezembro
# + débito dos clientes
# - empréstimo bancário
# - renda de dezembro
# - custos de trabalho de dezembro
# = 10000 + 2000 - 1000 - 1000 - 50*x1 - 35*x2
# = 10000 - 50*x1 - 35*x2

# débitos dos clientes a 1 de janeiro =
# débitos dos clientes a 1 de dezembro
# + pagamento pelos produtos
# - débito dos clientes pago em dezembro
# = 3000 - 2000 + 100*x1 + 90*x2
# = 1000 + 100*x1 + 90*x2

# valor do inventário a 1 de janeiro =
# valor do inventário a 1 de dezembro
# - valor de inventário usado em dezembro
# + valor do inventário recebido a 1 de janeiro
# = 7000 - 30*x1 - 40*x2 + 2000
# = 9000 - 30*x1 - 40*x2

# valor dos ativos a 1 de janeiro =
# 10000 - 50*x1 - 35*x2
# + 1000 + 100*x1 + 90*x2
# + 9000 - 30*x1 - 40*x2
# = 20000 + 20*x1 + 15*x2

# valor dos passivos a 1 de janeiro =
# valor dos passivos a 1 de dezembro
# - pagamento do empréstimo
# + valor da encomenda feita a 1 de janeiro
# = 10000 - 1000 + 2000
# = 11000

