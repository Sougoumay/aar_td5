<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
</head>
<body>
<h1>Chargement d'entities liés (XToMany)</h1>

<h3>L'application à l'air de fonctionner</h3>


<form action="manuel">
    <button type="submit">fetch manuel</button>
</form>

<form action="fetchjoin">
    <button type="submit">fetch par join</button>
</form>

<form action="entitygraph">
    <button type="submit">entity graph</button>
</form>

<form action="dto">
    <button type="submit">DTO</button>
</form>


</body>
</html>