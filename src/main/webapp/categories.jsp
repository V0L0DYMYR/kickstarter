<%@ page import="java.util.List" %>
<%@ page import="ua.goit.model.Category" %>
<html>
<head>
        <script src=""></script>
</head>
<body>

 <ul>
     <%
         List<Category> categories = (List<Category>)request.getAttribute("categories");
         for(Category category: categories) {
     %>

     <li><%= category.getName() %></li>

     <%
         }
     %>
 </ul>
</body>
</html>