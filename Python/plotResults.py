import plotly.plotly as py
import plotly.graph_objs as go
import plotly

plotly.tools.set_credentials_file(username='KoolCards', api_key='w911CnIJBDLca13Gpf10')
trace1 = go.Bar(
    x=['Sensitivity', 'Specificity'],
    y=[37.5,78],
    name='ECG Diagnosis'
)
trace2 = go.Bar(
    x=['Sensitivity', 'Specificity'],
    y=[91.8,92.3],
    name='SVM Diagnosis'
)

data = [trace1, trace2]
layout = go.Layout(
    barmode='group'
)

fig = go.Figure(data=data, layout=layout)
py.iplot(fig, filename='CompareSpec')