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
<p>Entrez le d�partement � ajouter</p>
    <input type="text" name="dept-num" placeholder="numero du d�partement">
    <input type="text" name="dept-nom" placeholder="nom du d�partement">
    <input type="submit" value="envoyer">
    </form>
</div>
</body>
</html>