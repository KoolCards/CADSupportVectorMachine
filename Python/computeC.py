from sklearn import svm
import pyrebase
from sklearn.model_selection import cross_val_score
import warnings

# Set configurations for firebase
config = {
        "apiKey": "AIzaSyAGb4tKNZs8dBjs1ZsmcHlrPMX3L3w6zIA",
        "authDomain": "https://heartattackml-7085c.firebaseio.com/",
        "databaseURL": "https://heartattackml-7085c.firebaseio.com/",
        "storageBucket": "gs://heartattackml-7085c.appspot.com/"
    }

# Initialize firebase and ignore unnecessary warnings
warnings.filterwarnings('ignore')
firebase = pyrebase.initialize_app(config)
db = firebase.database()

# Get training data
X = db.child('algorithmData').get().val()
y = db.child('algorithmDataDiag').get().val()

#Sets range of C values
C_2d_range = [1e-2, 1, 1e2, 1e4]
classifiers = []

#Calculates k-fold cross-validation score of each C
for C in C_2d_range:
    svm_model = svm.SVC(probability=True, C=C, kernel="rbf", gamma='auto', random_state=None)
    svm_model.fit(X,y)
    score = cross_val_score(svm_model, X, y, cv=1)
    classifiers.append((C,svm_model))

print(classifiers)