function y = update(y, X)
m = size(X, 1);
for i=1:m;
  if (y(i,1) > 1 );
    y(i,1) = 1;
  else
    y(i,1) = 0;
  endif
endfor;