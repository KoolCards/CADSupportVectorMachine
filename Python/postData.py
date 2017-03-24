import pyrebase

config = {
  "apiKey": "AIzaSyAGb4tKNZs8dBjs1ZsmcHlrPMX3L3w6zIA",
  "authDomain": "https://heartattackml-7085c.firebaseio.com/",
  "databaseURL": "https://heartattackml-7085c.firebaseio.com/",
  "storageBucket": "projectId.appspot.com"
}
firebase = pyrebase.initialize_app(config)
db = firebase.database()
file = open('trainingPython.txt', 'r')
count = 1
for counter in range (1,1942):
    patient_age = file.readline()
    patient_sex = file.readline()
    patient_BP = file.readline()
    patient_cholesterol = file.readline()
    patient_EKG = file.readline()
    patient_thal = file.readline()
    patient_STG = file.readline()
    patient_diag = file.readline()
    patient_data = {'age': patient_age.strip(), 'sex':patient_sex.strip(),
            'blood pressure': patient_BP.strip(), 'cholesterol': patient_cholesterol.strip(),
            'EKG': patient_EKG.strip(), 'heart rate': patient_thal.strip(),
            'STG': patient_STG.strip(), 'diagnosis': patient_diag.strip()}
    db.child('patients').child(counter).set(patient_data)
    progress = (counter/1942)*100
    print('Your progress')
    print(progress)
print('Firebase Success!!')
