<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gestion de Commandes</title>
</head>
<body>
    <center>
        <h1>Gestion des produits</h1>
        <h1><a href="/Atelier1/">Gestion des Clients</a></h1>
        <h2>
            <a href="/Atelier1/produit/new">ajouter produit</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Atelier1/produit/list">List des produits</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List des Produits</h2></caption>
            <tr>
                <th>ID</th>
                <th>CODE DE PRODUIT</th>
                <th>NOM DE PRODUIT</th>
                <th>PRIX</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="produit" items="${listeProduits}">
                <tr>
                    <td><c:out value="${produit.id}" /></td>
                    <td><c:out value="${produit.codeProduit}" /></td>
                    <td><c:out value="${produit.nomProduit}" /></td>
                    <td><c:out value="${produit.prix}" /></td>
                    <td>
                        <a href="/Atelier1/produit/edit?id=<c:out value='${produit.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Atelier1/produit/delete?id=<c:out value='${produit.id}' />">Delete</a>      
              
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>