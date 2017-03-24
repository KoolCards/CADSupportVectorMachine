from sklearn import svm
import pyrebase
from sklearn.externals import joblib
import pickle

config = {
  "apiKey": "AIzaSyAGb4tKNZs8dBjs1ZsmcHlrPMX3L3w6zIA",
  "authDomain": "https://heartattackml-7085c.firebaseio.com/",
  "databaseURL": "https://heartattackml-7085c.firebaseio.com/",
  "storageBucket": "projectId.appspot.com"
}
firebase = pyrebase.initialize_app(config)
db = firebase.database()
data = []
alldiag = []
for counter in range (1,1942):
    age = db.child('patients').child(counter).child('age').get().val()
    sex = db.child('patients').child(counter).child('sex').get().val()
    EKG = db.child('patients').child(counter).child('EKG').get().val()
    thal = db.child('patients').child(counter).child('heart rate').get().val()
    STG = db.child('patients').child(counter).child('STG').get().val()
    diag = db.child('patients').child(counter).child('diagnosis').get().val()
    data.append([age,sex,thal,STG])
    print(diag)
    if (diag == '0'):
        alldiag.append(0)
    else:
        alldiag.append(1)
    progress = (counter / 1942) * 100
    print(progress)
    print(data)
    print(alldiag)

with open('dataout', 'wb') as fp:
    pickle.dump(data, fp)
with open('diagout', 'wb') as fp:
    pickle.dump(alldiag, fp)


