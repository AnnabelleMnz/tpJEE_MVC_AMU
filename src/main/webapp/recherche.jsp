<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher les departements</title>


</head>
<body>
<div style="background-color:cornflowerblue; height:300px; padding: 1em; display:flex; flex-direction:column; justify-content:center; align-items:center; text-align: center">
<h1 style="color:darkblue">Entrez le département à rechercher</h1>
<form action="ShowDept" method="get">
    <input style="padding:5px" type="text" name="dept-num" placeholder="numero du département">
    <input style="margin-top: 1em; background-color:deepskyblue; padding:10px"  type="submit" value="envoyer">
    </form>
    </div>
</body>
</html>