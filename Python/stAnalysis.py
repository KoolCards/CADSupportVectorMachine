import wfdb
import numpy as np
from scipy import signal

def analyzeST (database):

    #Get an ECG signal based on user input
    sig, fields = wfdb.rdsamp(database, sampto=500, pbdl=1)
    sig = np.round(sig, decimals=8)

    #Median filter the ECG signal
    final_sig = []
    for i in range(0, 500):
        final_sig.append(sig.item(i, 0))
    sig_plot = final_sig
    final_sig = signal.medfilt(final_sig, kernel_size=[11])

    #Find the maximum in the interval (R peak)
    max = -100
    index = 0
    for counter in range(0, 250):
        if (final_sig[counter]) > max:
            max = final_sig[counter]
            index = counter
    print('R peak of',max,'at',index)

    #Find the bottom of the R peak by scanning until an increase
    isDecresing = True
    currentMin = 0
    minIndex = 0
    while isDecresing:
        if (final_sig[index] >= final_sig[index + 1]):
            isDecresing = True
            currentMin = final_sig[index + 1]
            minIndex = index + 1
        else:
            isDecresing = False
        index = index + 1
    print('Min of',currentMin,'at', minIndex)

    #Find the T point by looking for a large increase
    increaseCount = 0
    while increaseCount < 5:
        if (final_sig[index + 1] > final_sig[index]):
            increaseCount += 1
        else:
            increaseCount = 0
        index += 1

    #Calculate the slope
    elev = (final_sig[index-10] - final_sig[minIndex]) / ((index-10) - minIndex)
    print('Start of U-segment at',index-10)
    print('Average elevation of ',elev)

    #Return the ST diagnostic
    if (elev > 0.001):
        return 1,final_sig, sig_plot
    if (elev < -0.0001):
        return 3, final_sig, sig_plot
    else:
        return 2, final_sig, sig_plot