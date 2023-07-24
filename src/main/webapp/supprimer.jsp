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
        <h1 style="color:darkblue">Suppression d'un département</h1>
        <h2 style="color:white">Vous pouvez supprimer un département de la base de données en saisissant son numéro et nom</h2>
<form action="RemoveDept" method="POST">
<p>Entrez le département à supprimer</p>
    <input type="text" name="dept-num" placeholder="numero du département ">
    <input type="text" name="dept-nom" placeholder="nom du département">
    <input type="submit" value="envoyer">
    </form>
</div>
</body>
</html>