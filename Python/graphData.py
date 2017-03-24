import matplotlib.pyplot as plt

def graph (sig):

    #Sets graph attributes
    plt.plot(sig)
    plt.ylabel('Voltage (mV)', size=20)
    plt.xlabel('Time (milliseconds)', size=20)
    plt.xticks(size=15)
    plt.yticks(size=15)
    plt.title('Standard ECG Graph', size=25)
    plt.show()
