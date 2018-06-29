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
<div class="form-group shadow-textarea" >
        <#list individuals as individual>
            <h3 margin="10px">Карточка пациента</h3>
            <textarea class="form-control z-depth-1" id="exampleFormControlTextarea6" rows="2" disabled="true" ">
                ${individual.name}
            </textarea>
        </#list>
    </br>

<#list eventPatients as eventPatient>
    <div>
        <form action="/eventPatients/${eventPatient.id?c}/eventPatientsAgree" method="get">
            <input type="submit" value="Согласие"/>
        </form>
    </div>

</#list>


</div>


</br>
<div class="eventPatientsCard">
    <table class="table table-sm" width="300px">
        <tr>
            <th width="50%">
                Название услуги
            </th>
            <th align="center">
                Статус
            </th>
            <th  align="center">

            </th>

        </tr>
        <#list eventPatientsCard as eventPatient>

            <tr>

                <td width="50%">
                    ${eventPatient.serviceName}
                </td>
                <td width="25%" valign="top" >
                    ${eventPatient.status}
                </td>
                <td width="25%" valign="top" align="center">
                    <form  action="/eventPatientsCard/${eventPatient.id?c}/eventPatientsCardAgree" method="get">
                        <input type="submit" value="Изменить"/>
                    </form>
                </td>


            </tr>
        </#list>
    </table>
</div>
</body>
</html>