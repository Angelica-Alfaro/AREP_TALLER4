var app = (function () {

   var saveData = function () {
    cadena = $("#cadena").val();
    console.log(cadena)
    apiclient.saveString(cadena)
    getData
   };

   var getData = function (){
       apiclient.getStrings(updateTable)
   }

   var updateTable = function(data){
       console.log(data)
       //Vaciar tabla del HTML.
       var tabla = $("table");
       var body = $("tbody");
       if (body != null) {
           body.remove();
       }
       tabla.append("<tbody>");

       //Llenar tabla del HTLM con la información.
       var cols = ""
       for (const val in data){
           cols = cols + '<tr> <td>' + data[val].string + '</td>'
           cols = cols + '<td>' + data[val].date + '</td> </tr>'
       }
       $("tbody").append(cols)
   }

   return {
       saveData: saveData,
       getData: getData,
       updateTable: updateTable,
   }
})();