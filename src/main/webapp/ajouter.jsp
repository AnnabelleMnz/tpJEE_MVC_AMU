<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter departement</title>
</head>
<body>
<div style="background-color:lightgreen; height:300px; display:flex; flex-direction:column; justify-content:center; align-items:center">
<form action="CreateDeptPair" method="POST">
<p>Entrez le département à ajouter</p>
    <input type="text" name="dept-num" placeholder="numero du département">
    <input type="text" name="dept-nom" placeholder="nom du département">
    <input type="submit" value="envoyer">
    </form>
</div>
</body>
</html>