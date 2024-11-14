
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Les composites:</h2>
<ul>
    <c:forEach items="${employes}" var="employe">
        <li>
            Identité
            <ul>
                <li>Nom : ${employe.nom}</li>
                <li>Prenom : ${employe.prenom}</li>
            </ul>
        </li>
        <li>
            Les numéros de téléphone
            <ul>
                <c:forEach items="${employe.telephones}" var="telephone">
                    <li>Numéro : ${telephone.numero}</li>
                    <li>Modèle : ${telephone.modele}</li>
                </c:forEach>
            </ul>
        </li>
        <c:if test="${employe.machine != null}">
            <li>
                Machine
                <ul>
                    <li>Adresse Mac : ${employe.machine.adresseMac}</li>
                    <li>Modele : ${employe.machine.modele}</li>
                </ul>
            </li>
        </c:if>
        <c:if test="${employe.service != null}">
            <li>
                Service
                <ul>
                    <li>Nom : ${employe.service.nomService}</li>
                    <li>Membres :
                        <ul>
                            <c:forEach items="${employe.membres}" var="membre">
                                <c:if test="${membre.idEmp != employe.idEmp}">
                                    Identité
                                    <li>Nom : ${membre.nom}</li>
                                    <li>Prenom : ${membre.prenom}</li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </li>
        </c:if>
        <c:if test="${employe.adresse != null}">
            <li>
                Adresse
                <ul>
                    <li>Rue : ${employe.adresse.rue}</li>
                    <li>Code postale : ${employe.adresse.codepostal}</li>
                    <li>Ville : ${employe.adresse.ville}</li>
                    <c:if test="${employe.adresse.pays != null}">
                        <li>
                            Pays
                            <ul>
                                <li>Code : ${employe.pays.codePays}</li>
                                <li>Nom : ${employe.pays.nomPays}</li>
                            </ul>
                        </li>
                    </c:if>
                </ul>
            </li>
        </c:if>

        <c:if test="${employe.projetsEnCours.size() != 0}">
            <li>
                Projet en cours
                <ul>
                    <c:forEach items="${employe.projetsEnCours}" var="projetEnCours">
                        <li>Code : ${projetEnCours.code}</li>
                        <li>Nom : ${projetEnCours.nom}</li>
                        <li>Status : ${projetEnCours.status}</li>
                        </br>
                    </c:forEach>
                </ul>
            </li>
        </c:if>
        </br>
        <hr>
    </c:forEach>
</ul>



<form action="${pageContext.request.contextPath}/">
    <button type="submit">Retour au menu</button>
</form>


</body>
</html>
