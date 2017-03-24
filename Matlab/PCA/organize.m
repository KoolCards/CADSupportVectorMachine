function [Z_free, Z_affected] = organize(Z)

  #Creates two datasets based on the diagnosis
  [m n] = size(Z);
  affected_counter = 1;
  free_counter = 1;
  for i=1:m
    if (Z(i,4) > 0)
      Z_affected(affected_counter,1:3) = Z(i,1:3);
      affected_counter = affected_counter + 1;
    else
      Z_free(free_counter, 1:3) = Z(i,1:3);
      free_counter = free_counter + 1;
     end
   end