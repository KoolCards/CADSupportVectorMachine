function [X_norm, mu, sigma] = featureNormalize(X)

#Normalizes the data to reduce the excess weightage of one variable
mu = mean(X);
X_norm = bsxfun(@minus, X, mu);
sigma = std(X_norm);
X_norm = bsxfun(@rdivide, X_norm, sigma);

end
