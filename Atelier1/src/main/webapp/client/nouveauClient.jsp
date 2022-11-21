<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Gestion de Commandes</title>
</head>
<body>
    <center>
        <h1>Gestion Client</h1>
        <h2>
            <a href="/Atelier1/client/new">Ajouter Nouveau Client</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Atelier1/">listes des clients</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${client != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${client == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${client != null}">
                        Modifier Client
                    </c:if>
                    <c:if test="${client == null}">
                        Ajouter nouveau Client
                    </c:if>
                </h2>
            </caption>
                <c:if test="${client != null}">
                    <input type="hidden" name="id" value="<c:out value='${client.id}' />" />
                </c:if>           
            <tr>
                <th>nom : </th>
                <td>
                    <input type="text" name="nom" size="45"
                            value="<c:out value='${client.nom}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>prenom : </th>
                <td>
                    <input type="text" name="prenom" size="45"
                            value="<c:out value='${client.prenom}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>adresse : </th>
                <td>
                    <input type="text" name="adresse" size="45"
                            value="<c:out value='${client.adresse}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>ville : </th>
                <td>
                    <input type="text" name="ville" size="45"
                            value="<c:out value='${client.ville}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>email : </th>
                <td>
                    <input type="text" name="email" size="45"
                            value="<c:out value='${client.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>telephone : </th>
                <td>
                    <input type="text" name="telephone" size="45"
                            value="<c:out value='${client.telephone}' />"
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