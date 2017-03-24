function observedMatrix = sortData(observed_X, observed_y)

  #Creates the chi-square table
  m = size(observed_X,1);
  tempYYstore = 0;
  tempYXstore = 0;
  tempXXstore = 0;
  tempXYstore = 0;
  for i=1:m
    if (observed_X(i) == 0)
      if (observed_y(i) == 0)
        tempXXstore = tempXXstore + 1;
      else
         tempXYstore = tempXYstore + 1;
      endif
    else 
      if (observed_y(i) == 0)
        tempYXstore = tempYXstore + 1;
      else
        tempYYstore = tempYYstore + 1;
      endif 
    endif
   endfor
   observedMatrix(1,1) = tempXXstore;
   observedMatrix(1,2) = tempXYstore;
   observedMatrix(2,1) = tempYXstore;
   observedMatrix(2,2) = tempYYstore;
end