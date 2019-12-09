function init(event){

    addRowHandlers(event,'rowCtr');

}

function addRowHandlers(event,tableId) {
    if(document.getElementById(tableId)!=null){
        var table = document.getElementById(tableId);
        var rows = table.getElementsByTagName('tr');
        var revemail = '';
        var paperid = '';
        var techmerit = '';
        var overallrecomm = '';
        var commentforcommittee = '';
        var commentforauthor = '';
        for ( var i = 1; i < rows.length; i++) {

            var selectedRow = table.rows[i];
            if (selectedRow.cells[6].childNodes[0].checked){

                revemail = selectedRow.cells[0].innerHTML;
                paperid = selectedRow.cells[1].innerHTML;
                techmerit = selectedRow.cells[2].innerHTML;
                overallrecomm = selectedRow.cells[3].innerHTML;
                commentforcommittee = selectedRow.cells[4].innerHTML;
                commentforauthor = selectedRow.cells[5].innerHTML;
                //alert('revemail: '+revemail+' paperid: '+paperid+' techmerit: '+techmerit+' overallrecomm: '+overallrecomm+' commentforcommittee: '+commentforcommittee);
                location.href ="http://localhost:8080/employee";
            };
        }
    }
}