function plotData(X,y,columnNum)

figure; 
hold on;

posFirst = find(y == 1); 
posSecond = find(y == 2);
posThird = find(y == 3);
posFourth = find(y == 4);
neg = find(y == 0);

plot(X(posFirst, 1),(X(posFirst,columnNum)), 'k+','LineWidth', 2,'MarkerSize', 12); 
plot(X(neg, 1),(X(neg,columnNum)),'ko', 'MarkerFaceColor', 'y', 'MarkerSize', 12);
plot(X(posSecond, 1),(X(posSecond,columnNum)), 'k+','LineWidth', 2,'MarkerSize', 12); 
plot(X(posThird, 1),(X(posThird,columnNum)), 'k+','LineWidth', 2,'MarkerSize', 12); 
plot(X(posFourth, 1),(X(posFourth,columnNum)), 'k+','LineWidth', 2,'MarkerSize', 12); 


hold off;

end