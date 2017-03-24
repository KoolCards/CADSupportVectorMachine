function newObserved = sortBoundary(observed_X, boundary)

  #Divides the data based on the mean of the variable
  m = size(observed_X,1);
  for i=1:m
    if (observed_X(i) >= boundary)
      newObserved(i,1) = 1;
    else
      newObserved(i,1) = 0;
    endif
  endfor
end