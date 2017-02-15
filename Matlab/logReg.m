clear; close all; clc
#Load Data
load logRegTrainingData.mat;
data = load('OtherTraining.txt');

X = Z(:,[1,2]);
y = data(:,7);
y =update(y,X);

disp(size(X,1));
pause;
disp(X);
pause;
#Visualize Data
set(gca, "fontsize", 15);
X = mapFeature(X(:,1), X(:,2));
disp(size(X));
initial_theta = zeros(size(X, 2), 1);
lambda = 1;

% Compute and display initial cost and gradient for regularized logistic
% regression
[cost, grad] = costFunctionReg(initial_theta, X, y, lambda);

fprintf('Cost at initial theta (zeros): %f\n', cost);
fprintf('\nProgram paused. Press enter to continue.\n');
pause;

initial_theta = zeros(size(X, 2), 1);

% Set regularization parameter lambda to 1 (you should vary this)
lambda = 1;

% Set Options
options = optimset('GradObj', 'on', 'MaxIter', 400);

% Optimize
[theta, J, exit_flag] = ...
	fminunc(@(t)(costFunctionReg(t, X, y, lambda)), initial_theta, options);
plotDecisionBoundary(theta, X, y);

% Put some labels 
hold on;
% Labels and Legend
xlabel('Exam 1 score')
ylabel('Exam 2 score')

% Specified in plot order
legend('Admitted', 'Not admitted')
hold off;

fprintf('\nProgram paused. Press enter to continue.\n');
pause;


% Plot Boundary
% Compute accuracy on our training set
p = predict(theta, X);

fprintf('Train Accuracy: %f\n', mean(double(p == y)) * 100);




