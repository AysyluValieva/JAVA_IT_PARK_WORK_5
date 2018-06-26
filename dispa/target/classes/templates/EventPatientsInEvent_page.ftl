<#ftl encoding='UTF-8'>
<!doctype html>
<head>
        <meta charset="UTF-8">
        <title>EventPatient</title>
    <link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </head>
<body>

<div class="eventPatients">
    <table class="table table-sm">
        <tr>
            <th>
                ФИО
            </th>
            <th>
                Пол
            </th>
            <th>
                ДР
            </th>
            <th>
                Мероприятие
            </th>

        </tr>
        <#list eventPatients as eventPatient>
            <tr>
                <td>
                    <p id="eventPatient_fio">${eventPatient.surname} ${eventPatient.name} ${eventPatient.patrName}</p>
                </td>
                <td>
                    ${eventPatient.gender}
                </td>
                <td>
                    ${eventPatient.birthDt}
                </td>
                <td>
                    ${eventPatient.eventName}
                </td>

            </tr>
        </#list>
        </table>
    </div>
</body>
</html>