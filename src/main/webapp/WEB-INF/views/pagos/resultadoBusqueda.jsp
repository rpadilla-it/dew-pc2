<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="container">
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
        <c:forEach var="pago" items="${resultado}">
            <tr>
                <td>${pago.idTributo}</td>
                <td>${pago.nombre_tributo}</td>
                <td>${pago.ejercicio}</td>
                <td>${pago.periodo}</td>
                <td>${pago.idcontribuyente_ruc}</td>
                <td>${pago.razon_social}</td>
                <td>${pago.nombre_tipo}</td>
            </tr>
        </c:forEach>
    </table>
</div>
