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

<div class="eventPatientsCard">
    <table class="table table-sm">
        <tr>
            <th>
                Название услуги
            </th>
            <th>
                Статус
            </th>


        </tr>
        <#list eventPatientsCard as eventPatient>
            <tr>

                <td>
                    ${eventPatient.serviceName}
                </td>
                <td>
                    ${eventPatient.status}
                </td>


            </tr>
        </#list>
    </table>
</div>
</body>
</html>