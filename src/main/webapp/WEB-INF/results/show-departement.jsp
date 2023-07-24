<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mapping Dept</title>

</head>
<body>

  <div style="background-color:#E6F3FF; height:300px; display:flex; flex-direction:column; justify-content:center; align-items:center">
<p>Resultats</p>
Numero du departement : 
${key.deptNum}
<br>
Nom du departement : 
${key.deptName}

<!-- key est l'objet et . accede au getter -->
</div>
</body>
</html>