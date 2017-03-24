function Z = projectData(X, U, K)

#Projects the data to a new matrix
Z = zeros(size(X, 1), K);
Z = X * U(:, 1:K);

end
