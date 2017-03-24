from sklearn import svm
from sklearn.metrics import accuracy_score
import pyrebase
from sklearn.model_selection import cross_val_score
import warnings

def makePrediction(patient_age, patient_sex, patient_heartRate, patient_ST):

    #Set configurations for firebase
    config = {
        "apiKey": "AIzaSyAGb4tKNZs8dBjs1ZsmcHlrPMX3L3w6zIA",
        "authDomain": "https://heartattackml-7085c.firebaseio.com/",
        "databaseURL": "https://heartattackml-7085c.firebaseio.com/",
        "storageBucket": "gs://heartattackml-7085c.appspot.com/"
    }

    #Initialize firebase and ignore unnecessary warnings
    warnings.filterwarnings('ignore')
    firebase = pyrebase.initialize_app(config)
    db = firebase.database()

    #Get training data
    X = db.child('algorithmData').get().val()
    y = db.child('algorithmDataDiag').get().val()

    #Train the algorithm with optimized C
    svm_model = svm.SVC(probability=True, C=1, kernel = "rbf", gamma='auto', random_state = None)
    svm_model.fit(X, y)

    #Find k-fold cross-validation score
    scores = cross_val_score(svm_model, X, y, cv = 10)
    print('K-Fold Cross-Validation Score is: ', scores, scores.mean())

    #Create an array of SVM predictions and one of actual diagnoses
    predictionArray = []
    actualArray = []
    for counter in range (0,1941):
        prediction = svm_model.predict(X[counter])
        actual = y[counter]
        predictionArray.append(prediction)
        actualArray.append(actual)

    #Calculate the sensitivity
    positiveCount = 0
    positiveTotal = 0
    for x in range (0,len(predictionArray)):
        if actualArray[x] == 1:
            if predictionArray[x] == 1:
                positiveCount +=1
            positiveTotal +=1
    sens = positiveCount/positiveTotal * 100
    print('Sensitivity is: ', sens, '%')

    #Calculate the specificity
    negCount = 0
    negTotal = 0
    for x in range (0,len(predictionArray)):
        if actualArray[x] == 0:
            if predictionArray[x] == 0:
                negCount +=1
            negTotal +=1
    spec = negCount/negTotal * 100
    print('Specificity is: ', spec, '%')

    #Calculate training accuracy
    accuracy = accuracy_score(actualArray,predictionArray)*100
    print('Algorithm Accuracy is: ',accuracy,'%')

    #Return the prediction based on user input
    sample = [patient_age, patient_sex, patient_heartRate, patient_ST]
    return svm_model.predict_proba(sample),svm_model.predict(sample)