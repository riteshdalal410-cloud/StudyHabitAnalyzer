console.log("Dashboard Loaded");
const ctx = document.getElementById('studyChart');

new Chart(ctx, {

type: 'line',

data: {

labels: [

'Mon',

'Tue',

'Wed',

'Thu',

'Fri',

'Sat',

'Sun'

],

datasets: [

{

label:'Study Hours',

data:[2,4,3,5,6,4,7],

borderColor:'#2563eb',

backgroundColor:'rgba(37,99,235,.15)',

fill:true,

tension:.4

}

]

},

options:{

responsive:true

}

});