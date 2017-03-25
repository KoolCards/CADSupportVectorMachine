clear; close all; clc
data = load('trainingData.txt');

%Calculates chi-square value of age
observed_heartAttack = data(:,8);
observed_age = data(:,1);
newObserved_age = sortBoundary(observed_age, mean(observed_age));
observedMatrixAge = sortData(newObserved_age, observed_heartAttack)
AgeChiValue = computeChiValue(observedMatrixAge)
fprintf('\n');
pause;

%Calculates chi-square value of sex
observed_sex = data(:,2);
observedMatrixSex = sortData(observed_sex, observed_heartAttack)
sexChiValue = computeChiValue(observedMatrixSex)
fprintf('\n');
pause;

%Calculates chi-square value of blood pressure
observed_BP = data(:,3);
newObserved_BP = sortBoundary(observed_BP, mean(observed_BP));
observedMatrixBP = sortData(newObserved_BP, observed_heartAttack)
BPChiValue = computeChiValue(observedMatrixBP)
fprintf('\n');
pause;

%Calculates chi-square value of cholesterol
observed_Chol = data(:,4);
newObserved_Chol = sortBoundary(observed_Chol, mean(observed_Chol));
observedMatrixChol = sortData(newObserved_Chol, observed_heartAttack)
CholChiValue = computeChiValue(observedMatrixChol)
fprintf('\n');
pause;

%Calculates chi-square value of ECG
observed_EKG = data(:,5);
observedMatrixEKG = sortData(observed_EKG, observed_heartAttack)
EKGChiValue  = computeChiValue(observedMatrixEKG)
fprintf('\n');
pause;

%Calculates chi-square value of heart rate
observed_Thal = data(:,6);
newObserved_Thal = sortBoundary(observed_Thal, mean(observed_Thal));
observedMatrixThal = sortData(newObserved_Thal, observed_heartAttack)
CholChiValue = computeChiValue(observedMatrixThal)
fprintf('\n');
pause;

%Calculates chi-square value of ST segment slope
observed_ST = data(:,7);
newObserved_ST = sortBoundary(observed_ST, 2);
observedMatrixST = sortData(newObserved_ST, observed_heartAttack)
STChiValue = computeChiValue(observedMatrixST)
fprintf('\n');