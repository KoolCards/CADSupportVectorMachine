#Load the data
data = load('trainingData.txt');
X = data(:,[1,2,6,7]);

#Normalizes the data to reduce the excess weightage of one variable
[X_norm, mu, sigma] = featureNormalize(X);

#Calculates the eigenvectors and stores the values to U and S
[U, S] = runpca(X_norm);

#Specifies K (the number of dimensions needed)
K = 3;
Z = projectData(X_norm, U, K);
Z(:,4) = cleanse(data(:,8));

#Save the data based on the diagnosis
[Z_free, Z_affected] = organize(Z);
save Zfree.txt Z_free;
save Zaffected.txt Z_affected;

