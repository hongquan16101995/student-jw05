<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>JSP 2.0 Expression Language - Implicit Objects</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        .container {
            width: 600px;
        }
    </style> 
  </head>
  <body>
  <div class="container">
        <a href="/student/classes" style="text-decoration: none; color: black;"><h1 style="text-align: center;">List classes</h1></a>     
        <a href="/student/classes?action=createGet" class="btn btn-primary"><i class="fa-solid fa-plus"></i> Create</a>
        <a href="/student/students" class="btn btn-secondary"><i class="fa-solid fa-list"></i> List student</a>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>STT</th>
                <th>Name</th>
                <th>Date</th>
                <th style="width: 20%; text-align: center;">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${classes}" var="c" varStatus="cla">
                <tr>
                    <td>${cla.count}</td>
                    <td><a href="/student/students?action=findByClasses&classId=${c.id}">${c.name}</a></td>
                    <td>${c.date}</td>
                    <td><a href="/student/classes?action=updateGet&id=${c.id}" class="btn btn-warning"><i class="fa-solid fa-pen-to-square"></i> Update</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </body>
</html>
