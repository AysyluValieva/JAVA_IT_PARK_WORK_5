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
    <style>
        select {
            width: 300px; /* Ширина списка в пикселах */
        }
    </style>
    </head>
<body>

<!-- Кнопка пуска модальное окно -->
<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#myModal">
    Добавить пациента
</button>
</br>
<!-- Модальное окно -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Добавить пациента</h4>
            </div>
            <div class="modal-body">
                <form action="/eventPatients" method="post">
                   <!-- <input id="eventID" type="text" name="eventID" placeholder="Мероприятие" />
                    <input id="indivID" type="text" name="indivID" placeholder="Пациент" />-->
                    <select id = "indivID">
                       <#list indivID as individual>
                           <option value="${individual.id?c}">${individual.surname}</option>
                       </#list>

                        <select id = "eventID">
                       <#list eventID as event>
                           <option value="${event.id?c}">${event.name}</option>
                       </#list>

                    </select>
                    <input type="submit" value="Сохранить"/>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
            </div>
        </div>
    </div>
</div>


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
            <th>
                Карточка
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
                <td>
                    <form action="/eventPatients/${eventPatient.id?c}/eventPatientsCard" method="get">
                        <input type="submit" value="Карта"/>
                    </form>
                </td>


            </tr>
        </#list>
        </table>
    </div>
</body>
</html>