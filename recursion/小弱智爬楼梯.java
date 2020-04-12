//3 2 1 -> n


//recursion

if (n < 0) return 0;
if (n == 0) return 1;

return solve(n-1)+solve(n-2)+solve(n-3);



//iteration

x1 = 1
x2 = 2
x3 = 4
for(int i = 4; i < n; i++){
  x1_1 = x1;
  x1 = x2;
  x2 = x3;
  x3 = x1_1 + x1 + x2;

}

return x3;
