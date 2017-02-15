function [Z_free, Z_affected] = organize(Z)
  [m n] = size(Z);
  affected_counter = 1;
  free_counter = 1;
  for i=1:m
    if (Z(i,3) > 0)
      Z_affected(affected_counter,1:2) = Z(i,1:2);
      affected_counter = affected_counter + 1;
    else
      Z_free(free_counter, 1:2) = Z(i,1:2);
      free_counter = free_counter + 1;
     end
   end