import svm
from stAnalysis import analyzeST
from graphData import graph

#Receive basic user attributes
isCorrect = False
user_age, user_heartRate, user_gender = 0,0,0
while (isCorrect != True):
    user_age = input('Enter your age: ')
    print('Your age is ' + user_age)

    user_gender = input('Enter your gender (1 for male and 0 for female): ')
    if (user_gender == '1'):
        print('Your gender is male')
    else:
        print('Your gender is female')

    user_heartRate = input('Enter your maximum heart rate while running (beats per minute): ')
    print('Your maximum heart rate is ' + user_heartRate)

    user_verify = input('Is all this information correct (0 for yes and 1 for no): ')
    if (user_verify == '0'):
        print('The information is correct')
        isCorrect = True
    else:
        print('Please re-enter your information')

#Compute or use pre-computed ST segment slope
user_choice = input('Use pre-computed ST or compute ST (Enter 0 for pre-computed and 1 for compute): ')
if (user_choice == '1'):

    #Accesses database based on input
    user_database = input('Enter the database from MIT that you would like to analyze the ST segment of: ')
    print(user_database)
    user_ST, final_sig, initial_sig = analyzeST(user_database)

    #Graphs raw and filter ECG data
    print('Plotting nonfiltered data...')
    graph(initial_sig)
    print('Plotting filtered data...')
    graph(final_sig)

    #Prints ST segment slope
    if user_ST == 1:
        print('The ST segment is upsloping.')
    elif user_ST ==2:
        print('The ST segment is horizontal.')
    else:
        print('The ST segment is downsloping.')

    #Computes and prints diagnosis
    print('Computing likelihood of vessel blockage...')
    prob, diag = svm.makePrediction(user_age, user_gender, user_heartRate, user_ST)
    print(diag)
    print('Your probability of having greater than 50% vessel blockage is', prob.item(0,1)*100, '%')
else:

    #Computes and prints diagnosis
    user_ST = input('Enter the ST segment value (1 for upsloping, 2 for horizontal, and 3 for downsloping): ')
    prob, diag = svm.makePrediction(user_age,user_gender,user_heartRate,user_ST)
    print(diag, ' ', prob)
    print('Your diagnosis of having greater than 50% vessel blockage is', prob.item(0,1)*100, '%')
