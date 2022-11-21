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
            <a href="/Atelier1/LigneCommande/new">ajouter ligne pour la commande <span style="color:green"><c:out value="${codeCmd}" /> </span> </a>
            &nbsp;&nbsp;&nbsp;
            <a  href="/Atelier1/LigneCommande/liste?commandeId=<c:out value='${commandeId}' />">Liste des lignes</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Atelier1/">List des clients</a>
             
        </h2>
    <div align="center">
        <c:if test="${ligne != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${ligne == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${ligne != null}">
                        Modifier Ligne
                    </c:if>
                    <c:if test="${ligne == null}">
                        Ajouter nouveau Ligne
                    </c:if>
                </h2>
            </caption>
                <c:if test="${ligne != null}">
                    <input type="hidden" name="id" value="<c:out value='${ligne.id}' />" />
                </c:if> 
                <input type="hidden" name="commandeId" value="<c:out value='${commandeId}' />" />          
            <tr>
                <th>numero : </th>
                <td>
                    <input type="text" name="numLigne" size="45"
                            value="<c:out value='${ligne.numLigne}' />"
                        />
                </td>
            </tr>
             <tr>
                <th>produit : </th>
                <td>
                
                <select name="produitId" >
	            <c:forEach var="produit" items="${listeProduits}">
	            	<option value='${produit.id}'>${produit.nomProduit}</option>
	            </c:forEach>
				</select>
                </td>
            </tr>
            <tr>
                <th>quantite : </th>
                <td>
                    <input type="number" name="qteCommande" size="45"
                            value="<c:out value='${ligne.qteCommande}' />"
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