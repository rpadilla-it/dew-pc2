<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="container">
    <h1 class="pull-left">Sunat: Pago de contribuyentes </h1>
 
    <div class="clear"></div>
    <br><br><br><br>
    <div class="row pull-right">
        <form:form action="buscar" method="post" commandName="criterioBusqueda" cssClass="form-search">
            <form:input path="ruc" size="10" cssClass="input-xlarge search-query"></form:input>
            <input type="submit" value="Buscar" class="btn"/>
        </form:form>
    </div>        
    <br/>
    <table class="table table-striped">
        <tr>
            <th>C&oacute;digo de Tributo</th>
            <th>Nombre Tributo</th>
            <th>Ejercicio</th>
            <th>periodo</th>
            <th>RUC</th>
            <th>Razón Social</th>
            <th>Tipo Persona</th>
        </tr>
        <c:forEach var="usuario" items="${pagosContribuyente}">
            <tr>
                <td>${pagosContribuyente.idTributo}</td>
                <td>${pagosContribuyente.nombre_tributo}</td>
                <td>${pagosContribuyente.ejercicio}</td>
                <td>${pagosContribuyente.periodo}</td>
                <td>${pagosContribuyente.idcontribuyente_ruc}</td>
                <td>${pagosContribuyente.razon_social}</td>
                <td>${pagosContribuyente.nombre_tipo}</td>
            </tr>
        </c:forEach>
    </table>
</div>
