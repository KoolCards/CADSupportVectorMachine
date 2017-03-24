function Z = cleanse(X)

#Creates a new matrix Z for computations
[m n] = size(X);
for i=1:m
  if X(i,1) == 0;
    Z(i,1) = 0;
  else
    Z(i,1) = 1;
   end
end