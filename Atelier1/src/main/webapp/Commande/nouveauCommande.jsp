<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gestion de Commandes</title>
</head>
<body>
    <center>
        <h1>Gestion Commandes</h1>
        <h2>
            <a href="/Atelier1/client/new">Ajouter Nouveau Commande de client  <span style="color:green"><c:out value="${nom}" /> <c:out value="${prenom}" /></span></a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Atelier1/Commande/liste">listes des commandes</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${commande != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${commande == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${commande != null}">
                        Modifier Commande
                    </c:if>
                    <c:if test="${commande == null}">
                        Ajouter nouveau Commande
                    </c:if>
                </h2>
            </caption>
                <c:if test="${commande != null}">
                    <input type="hidden" name="id" value="<c:out value='${commande.id}' />" />
                </c:if> 
                <input type="hidden" name="clientId" value="<c:out value='${clientId}' />" />          
            <tr>
                <th>code : </th>
                <td>
                    <input type="text" name="codeCmd" size="45"
                            value="<c:out value='${commande.codeCmd}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>date : </th>
                <td>
                    <input type="date" name="dateCmd" size="45"
                            value="<c:out value='${commande.dateCmd}' />"
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