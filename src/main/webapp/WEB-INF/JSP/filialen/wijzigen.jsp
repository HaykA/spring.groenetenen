<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<head><v:head title='Filiaal ${filiaal.id}'/></head>
<body>
<v:menu/>
<h1>Filiaal ${filiaal.id}</h1>
<spring:url value='/filialen/{id}/wijzigen' var='url'>
<spring:param name='id' value='${filiaal.id}'/>
</spring:url>
<v:filiaalform url='${url}' knopTekst='Wijzigen'/>
</body>
</html>