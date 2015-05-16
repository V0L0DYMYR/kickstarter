<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link rel="stylesheet" href="/css/bootstrap.min.css">
</head>
<body>

<%@include file="head.jsp"%>

<div class="container">

  <div class="row">
    <div class="jumbotron">
      <h1>Welcome to kickstarter!</h1>
      <p>...</p>
      <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
    </div>
  </div>

  <div class="row">

    <c:forEach var="c" items="${categories}">

      <div class="col-md-4">
        <div class="thumbnail">
          <a href="#">
            <div class="caption">
              <h3><c:out value="${c.name}"/></h3>
            </div>
          </a>
        </div>
      </div>

    </c:forEach>

  </div>
</div>

</body>
</html>