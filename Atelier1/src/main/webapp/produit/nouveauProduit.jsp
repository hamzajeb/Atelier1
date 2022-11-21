<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
    <center>
        <h1>Gestion Produit</h1>
        <h2>
            <a href="/Atelier1/produit/new">Ajouter Nouveau Produit</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Atelier1/produit/liste">listes des produits</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${produit != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${produit == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${produit != null}">
                        Modifier Produit
                    </c:if>
                    <c:if test="${produit == null}">
                        Ajouter nouveau Produit
                    </c:if>
                </h2>
            </caption>
                <c:if test="${produit != null}">
                    <input type="hidden" name="id" value="<c:out value='${produit.id}' />" />
                </c:if>           
            <tr>
                <th>code de Produit: </th>
                <td>
                    <input type="text" name="codeProduit" size="45"
                            value="<c:out value='${produit.codeProduit}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>nom de Produit : </th>
                <td>
                    <input type="text" name="nomProduit" size="45"
                            value="<c:out value='${produit.nomProduit}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>prix : </th>
                <td>
                    <input type="number" name="prix" size="45"
                            value="<c:out value='${produit.prix}' />"
                    />
                </td>
            </tr>
 

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>