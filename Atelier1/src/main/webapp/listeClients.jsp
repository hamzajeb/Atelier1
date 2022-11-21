<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gestion de Commandes</title>
</head>
<body>
    <center>
        <h1>Gestion des Clients</h1>
        <h1><a href="/Atelier1/produit/list">Gestion des produits</a></h1>
        <h2>
            <a href="/Atelier1/client/new">ajouter client</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Atelier1/">List des clients</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List des Clients</h2></caption>
            <tr>
                <th>ID</th>
                <th>NOM</th>
                <th>PRENOM</th>
                <th>EMAIL</th>
                <th>ADRESSE</th>
                <th>TELEPHONE</th>
                <th>VILLE</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="client" items="${listeClients}">
                <tr>
                    <td><c:out value="${client.id}" /></td>
                    <td><c:out value="${client.nom}" /></td>
                    <td><c:out value="${client.prenom}" /></td>
                    <td><c:out value="${client.email}" /></td>
                    <td><c:out value="${client.adresse}" /></td>
                    <td><c:out value="${client.telephone}" /></td>
                    <td><c:out value="${client.ville}" /></td>
                    <td>
                        <a href="/Atelier1/client/edit?id=<c:out value='${client.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Atelier1/client/delete?id=<c:out value='${client.id}' />">Delete</a>      
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Atelier1/Commande/liste?clientId=<c:out value='${client.id}' />">Commandes</a>                 
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>