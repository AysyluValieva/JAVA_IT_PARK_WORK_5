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
        body {
            margin: 10; /* Убираем отступы */
        }
    </style>
    </head>
<body>
<nav class="navbar navbar-light fixed-top" style="background-color:#555c69; color:white;">
    <a class="navbar-brand">
        <h1><span class="fa fa-male"></span><span class="fa fa-female"></span><span class="fa fa-medkit"></span> Диспансеризация населения</h1>
    </a>
</nav>
</br></br></br></br></br>
<!-- Кнопка пуска модальное окно -->
<button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#myModal">
    Добавить пациента
</button>
</br></br></br>
<!-- Модальное окно -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">

                <h4 class="modal-title" id="myModalLabel">Добавить пациента</h4>

            </div>
            <div class="modal-body">
                <form action="/eventPatients" method="post">
                    <label for="eventID">
                        <span>Мероприятие<span class="required">*</span></span>
                    </label></br>
                    <select name="eventID" onChange="document.OrderForm.TT.value=document.OrderForm.eventID.options[document.OrderForm.eventID.selectedIndex].text;"">
                       <#list events as event>
                           <option value="${event.id?c}">${event.name}</option>
                       </#list>
                    </select>
                    </br></br>
                    <label for="indivID">
                        <span>Пациент<span class="required">*</span></span>
                    </label></br>
                    <select name="indivID" onChange="document.OrderForm.TT.value=document.OrderForm.indivID.options[document.OrderForm.indivID.selectedIndex].text;"">
                       <#list individuals as individual>
                           <option value="${individual.id?c}">${individual.name}</option>
                       </#list>
                    </select>
                    </br></br>
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