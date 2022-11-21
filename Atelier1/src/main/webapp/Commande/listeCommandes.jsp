<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gestion de Commandes</title>
</head>
<body>
    <center>
        <h1>Gestion de Commandes</h1>
        <h2>
            <a href="/Atelier1/Commande/new">ajouter commande</a>
            &nbsp;&nbsp;&nbsp;
            <a  href="/Atelier1/Commande/liste?clientId=<c:out value='${clientId}' />">List des commandes</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Atelier1/">List des clients</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>commandes de Client <span style="color:green"><c:out value="${nom}" /> <c:out value="${prenom}" /></span>  </h2></caption>
            <tr>
                <th>ID</th>
                <th>code_commande</th>
                <th>date_commande</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="commande" items="${listeCommandes}">
                <tr>
                    <td><c:out value="${commande.id}" /></td>
                    <td><c:out value="${commande.codeCmd}" /></td>
                    <td><c:out value="${commande.dateCmd}" /></td>

                    <td>
                        <a href="/Atelier1/Commande/edit?id=<c:out value='${commande.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Atelier1/Commande/delete?id=<c:out value='${commande.id}' />">Delete</a>      
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Atelier1/LigneCommande/liste?commandeId=<c:out value='${commande.id}' />">Lignes</a>                
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>  
</body>
</html>