let countries=[];
let data = []
let dataDupe = []
$(document).ready(async function() {
    $('#from').val('2020-03-01')
    $('#to').val('2020-06-30')
    
    $('#from').change(filterDate)
    $('#to').change(filterDate)

    countries = await getCountries()
    generateDropdown(countries);
    // console.log(countries)

    $('#countries').change(changeCountry)
})

function filterDate() {
    const from = $('#from').val()
    const to = $('#to').val()
    if (!!from && !!to) {
        if (from > to) {
            console.log('error')
        }
        else {
            dataDupe = data.filter(a => {
                var date = a.Date;
                return (date >= from && date <= to);
            });
            // console.log(dataDupe)
            chargeChart(dataDupe);
        }
    }
}

async function getCountries(){
    // No tocar
	try {
		const response = await fetch("https://api.covid19api.com/countries", {
			method: "GET",
			headers: {
				'Content-Type': 'application/json'
			}
		});
		let datos = await response.json()
		return datos;
	} catch (error) {
		return error;
	}
}

function generateDropdown(array) {
    //No tocar
    array.sort((a,b) => a.Country.localeCompare(b.Country))
    options = '';
    array.forEach(element => {
        options+=`<option value="${element.Slug}">${element.Country}</option>`;
    });
    $('#countries').append(options);
}

function changeCountry() {
    $('#country').text($(this).val())
    getCovidPerCountryData(this.value)
}

async function getCovidPerCountryData(slug) {
    data=await getData(slug)
    dataDupe = [...data]
    filterDate()
    chargeChart(dataDupe)
}

async function getData(slug) {
    try {
		const response = await fetch(`https://api.covid19api.com/total/country/${slug}`, {
			method: "GET",
			headers: {
				'Content-Type': 'application/json'
			}
		});
		let datos = await response.json()
		return datos;
	} catch (error) {
		return error;
	}
}

function chargeChart(array) {
    am4core.useTheme(am4themes_animated);
    var chart = am4core.create("chartdiv", am4charts.XYChart);
    
    // Increase contrast by taking evey second color
    chart.colors.step = 2;
    
    chart.data = array;
    // console.log(chart.data[0])
    
    // Create axes
    var dateAxis = chart.xAxes.push(new am4charts.DateAxis());
    var valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
    dateAxis.renderer.minGridDistance = 50;
    
    // Create series
    function createAxisAndSeries(field, name, opposite, bullet) {

        var series = chart.series.push(new am4charts.LineSeries());
        series.dataFields.valueY = field;
        series.dataFields.dateX = "Date";
        series.strokeWidth = 2;
        series.yAxis = valueAxis;
        series.name = name;
        series.tooltipText = "{name}: [bold]{valueY}[/]";
        series.tensionX = 0.8;
        series.showOnInit = true;
        
        var interfaceColors = new am4core.InterfaceColorSet();
        
        switch(bullet) {
            case "triangle":
                var bullet = series.bullets.push(new am4charts.Bullet());
                bullet.width = 12;
                bullet.height = 12;
                bullet.horizontalCenter = "middle";
                bullet.verticalCenter = "middle";
                
                var triangle = bullet.createChild(am4core.Triangle);
                triangle.stroke = interfaceColors.getFor("background");
                triangle.strokeWidth = 2;
                triangle.direction = "top";
                triangle.width = 12;
                triangle.height = 12;
                break;
            case "rectangle":
                var bullet = series.bullets.push(new am4charts.Bullet());
                bullet.width = 10;
                bullet.height = 10;
                bullet.horizontalCenter = "middle";
                bullet.verticalCenter = "middle";
                
                var rectangle = bullet.createChild(am4core.Rectangle);
                rectangle.stroke = interfaceColors.getFor("background");
                rectangle.strokeWidth = 2;
                rectangle.width = 10;
                rectangle.height = 10;
                break;
            default:
                var bullet = series.bullets.push(new am4charts.CircleBullet());
                bullet.circle.stroke = interfaceColors.getFor("background");
                bullet.circle.strokeWidth = 2;
                break;
        }
        
        valueAxis.renderer.line.strokeOpacity = 1;
        valueAxis.renderer.line.strokeWidth = 2;
        valueAxis.renderer.line.stroke = series.stroke;
        valueAxis.renderer.labels.template.fill = series.stroke;
        valueAxis.renderer.opposite = opposite;
    }
    
    createAxisAndSeries("Confirmed", "Confirmed", false, "circle");
    createAxisAndSeries("Deaths", "Deaths", true, "triangle");
    createAxisAndSeries("Recovered", "Recovered", true, "rectangle");
    
    // Add legend and cursor
    chart.legend = new am4charts.Legend();
    chart.cursor = new am4charts.XYCursor();
}


// function filterByDate() {
// }