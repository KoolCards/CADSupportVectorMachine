data = load('OtherTraining.txt');
X = data(:,[1,4,5,6]);
[X_norm, mu, sigma] = featureNormalize(X);
[U, S] = runpca(X_norm);
size(U)
K = 3;
Z = projectData(X_norm, U, K);
Z(:,4) = data(:,7);
save logRegTrainingData.mat Z;
[Z_free, Z_affected] = organize(Z);
save Zfree.mat Z_free;
save Zaffected.mat Z_affected;