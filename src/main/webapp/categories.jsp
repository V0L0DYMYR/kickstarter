<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <style>
        .menu {
            background-color: cadetblue;
            height: 100%;
        }
    </style>
</head>
<body>

<div class="container">


    <div class="row">


    <div class="col-md-3">
        <ul class=" nav nav-pills list-unstyled">
            <li><a href="#"><i class="glyphicon glyphicon-eur"></i>Create new category</a></li>
            <li><a href="#">View all categories</a></li>
        </ul>
    </div>

    <div class="col-md-9">
        <ul class="list-unstyled">
            <c:forEach var="c" items="${categories}">
                <li><c:out value="${c.name}"/></li>
            </c:forEach>
        </ul>


        <div>
            <form action="/servlet/category" method="POST">
                <input type="text" name="category_name">

                <button class="btn btn-default" type="submit">Submit</button>
            </form>

        </div>
    </div>
    </div>

</div>


</body>
</html>