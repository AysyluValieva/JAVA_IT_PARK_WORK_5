<#ftl encoding='UTF-8'>
<!doctype html>
<head>
    <meta charset="UTF-8">
    <title>eventpatient</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<div class="form-style-6">
    <table>
        <tr>
            <th>eventName</th>
            <th>surname</th>
        </tr>
        <c:forEach var="eventpatient" items="${eventpatient}">
            <tr>
                <td>${eventpatient.eventName}</td>
                <td>${eventpatient.surname}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>