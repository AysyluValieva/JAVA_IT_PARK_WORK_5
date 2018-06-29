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
    <style>
        .shadow-textarea textarea.form-control::placeholder {
            font-weight: 300;
        }
        .shadow-textarea textarea.form-control {
            padding-left: 0.8rem;
        }
        .table {
            border-collapse: collapse; /* Отображать двойные линии как одинарные */
        }
        .th {
            background: #ccc; /* Цвет фона */
            text-align: center; /* Выравнивание по левому краю */
        }
        .td, th {
        }

        .h4{
            margin-left: 20%;
        }
    </style>
</head>
<body>

<div class="eventPatientsCardAgree">
    <form action="/eventPatientsCard/{eventPatientsCard-id}/eventPatientsCardAgree" method="post">

        <select hidden="true" name="srvRendered" onChange="document.OrderForm.TT.value=document.OrderForm.srvRendered.options[document.OrderForm.srvRendered.selectedIndex].text;"">
                       <#list srvRendered as srvRendered>
                           <option value="${srvRendered.id?c}">${srvRendered.serviceName}</option>
                       </#list>
        </select>

        <div class="form-group shadow-textarea" >
       <#list srvRendered as srvRendered>
            <p><h4 margin="10px">Услуга</h4></p>
            <textarea class="form-control z-depth-1" id="exampleFormControlTextarea6" rows="2" disabled="true" ">
            ${srvRendered.serviceName}
            </textarea>

        </#list>
        </div>
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