clear; close all; clc
data = load('sampleTrainingData.txt');

pause;
observed_heartAttack = data(:,7);
observed_sex = data(:,2);
observedMatrixSex = sortData(observed_sex, observed_heartAttack)
sexChiValue = computeChiValue(observedMatrixSex)
fprintf('\n');

pause;
observed_BP = data(:,3);
newObserved_BP = sortBoundary(observed_BP, 120);
observedMatrixBP = sortData(newObserved_BP, observed_heartAttack)
BPChiValue = computeChiValue(observedMatrixBP)
fprintf('\n');

pause;
observed_EKG = data(:,5);
observedMatrixEKG = sortData(observed_EKG, observed_heartAttack)
EKGChiValue  = computeChiValue(observedMatrixEKG)
fprintf('\n');