  function chiValue = computeChiValue(observedMatrix)
  
  %Computes the chi-square score based on the chi-square equation
  m = size(observedMatrix,1);
  expectedValue = 0;
  absoluteSum = sum(observedMatrix(:,1)) + sum(observedMatrix(:,2));
  chiValue = 0;
  for i=1:m
    for z=1:m
      expectedValue = (sum(observedMatrix(:,i)) * sum(observedMatrix(z,:))) / (absoluteSum);
      chiValue = chiValue + ((observedMatrix(z,i) - expectedValue)^2) / expectedValue;
    endfor
  endfor
end      