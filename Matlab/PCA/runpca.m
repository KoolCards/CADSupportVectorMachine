function [U, S] = runpca(X)

%Initializes useful variables for calculations
[m, n] = size(X);

%Initializes vectors U and V which will store the eigenvectors
U = zeros(n);
S = zeros(n);

%Calculate the covariance of the data
Sigma = (1/m) * X' * X;

%Finds the principle components of data
[U, S, V] = svd(Sigma);

end
