<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="background-color:cornflowerblue; height:300px; padding: 1em; display:flex; flex-direction:column; justify-content:center; align-items:center; text-align: center">
        <h1 style="color:darkblue">Suppression d'un d�partement</h1>
        <h2 style="color:white">Vous pouvez supprimer un d�partement de la base de donn�es en saisissant son num�ro et nom</h2>
<form action="RemoveDept" method="POST">
<p>Entrez le d�partement � supprimer</p>
    <input type="text" name="dept-num" placeholder="numero du d�partement ">
    <input type="text" name="dept-nom" placeholder="nom du d�partement">
    <input type="submit" value="envoyer">
    </form>
</div>
</body>
</html>