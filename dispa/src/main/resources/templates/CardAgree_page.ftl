<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>EventPatientCard</title>
    <link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>

<div class="eventPatientsCardAgree">
    <form action="/eventPatientsCard/{eventPatientsCard-id}/eventPatientsCardAgree" method="post">

        <select name="srvRendered" onChange="document.OrderForm.TT.value=document.OrderForm.srvRendered.options[document.OrderForm.srvRendered.selectedIndex].text;"">
                       <#list srvRendered as srvRendered>
                           <option value="${srvRendered.id?c}">${srvRendered.serviceName}</option>
                       </#list>
        </select>

        <label for="status">
            <span>Статус</span>
        </label>
        <select name="status" onChange="document.OrderForm.TT.value=document.OrderForm.status.options[document.OrderForm.status.selectedIndex].text;"">
                       <#list serviceStatus as event>
                           <option value="${event.name}">${event.name}</option>
                       </#list>
        </select>

         <input type="submit" value="Сохранить"/>
    </form>
</div>
</body>
</html>