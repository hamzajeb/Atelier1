<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gestion de Commandes</title>
</head>
<body>
    <center>
        <h1>Gestion De Ligne Des Commandes</h1>
        <h2>
            <a href="/Atelier1/LigneCommande/new">ajouter ligne</a>
            &nbsp;&nbsp;&nbsp;
            <a  href="/Atelier1/LigneCommande/liste?commandeId=<c:out value='${commandeId}' />">Liste des lignes</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Atelier1/">List des clients</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>lignes de Commande <span style="color:green"><c:out value="${codeCmd}" /> </span>  </h2></caption>
            <tr>
                <th>ID</th>
                <th>Numero</th>
                <th>Produit_Id</th>
                <th>Quantite Produit</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="ligne" items="${listeLignes}">
                <tr>
                    <td><c:out value="${ligne.id}" /></td>
                    <td><c:out value="${ligne.numLigne}" /></td>
                    <td><c:out value="${ligne.produitId}" /></td>
                    <td><c:out value="${ligne.qteCommande}" /></td>



                    <td>
                        <a href="/Atelier1/LigneCommande/edit?id=<c:out value='${ligne.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Atelier1/LigneCommande/delete?id=<c:out value='${ligne.id}' />">Delete</a>                   
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>  
</body>
</html>