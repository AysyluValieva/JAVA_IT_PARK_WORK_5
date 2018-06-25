<#ftl encoding='UTF-8'>
<!doctype html>
<head>
        <meta charset="UTF-8">
        <title>EventPatient</title>
        <link rel="stylesheet" type="text/css" href="/static/css/style.css"/>
    </head>
<body>
<div class="eventPatients">
    <table>
        <tr>
            <th>
                ID
            </th>
            <th>
                Логин
            </th>

        </tr>
        <#list eventPatients as user>
            <tr>
                <td>
                    <p id="eventPatients_id">${user.id}</p>
                </td>
                <td>
                    ${user.surname}
                </td>

            </tr>
        </#list>
        </table>
    </div>
</body>
</html>