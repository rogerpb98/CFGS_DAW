// https://www.amcharts.com/docs/v4/getting-started/basics/

function fallchart() {
  let chart = am4core.create('fallchart', am4charts.XYChart);
  //Crear Eje X
  let categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
  categoryAxis.dataFields.category = "state";
  categoryAxis.title.text = "State";
  //Crear Eje Y
  let valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
  valueAxis.title.text = "Count";
  //Rellenar
  let series = chart.series.push(new am4charts.ColumnSeries());
  series.dataFields.categoryX = "state";
  series.dataFields.valueY = "count";

  chart.data = fallStats;
}
function weightchart() {
  let chart = am4core.create('weightchart', am4charts.XYChart);
  //Crear Eje X
  let categoryAxis = chart.xAxes.push(new am4charts.CategoryAxis());
  categoryAxis.dataFields.category = "type";
  categoryAxis.title.text = "Type";
  //Crear Eje Y
  let valueAxis = chart.yAxes.push(new am4charts.ValueAxis());
  valueAxis.title.text = "Count";
  //Rellenar
  let series = chart.series.push(new am4charts.ColumnSeries());
  series.dataFields.categoryX = "type";
  series.dataFields.valueY = "count";

  chart.data = weightStats;
}
