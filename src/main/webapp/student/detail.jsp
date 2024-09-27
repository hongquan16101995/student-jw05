<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>JSP 2.0 Expression Language - Implicit Objects</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        .container {
            width: 600px;
        }
    </style> 
  </head>
  <body>
  <div class="container">
    <a href="/student/students" style="text-decoration: none; color: black;"><h1 style="text-align: center;">List student</h1></a>
        <table class="table table-hover">
            <tbody>
            <tr>
                <th>Name</th>
                <td>${student.name}</td>
            </tr>
            <tr>
                <th>Age</th>
                <td>${student.age}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${student.address}</td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>${student.gender}</td>
            </tr>
            <tr></tr>
                <th>Classes</th>
                <td>${student.classes.name}</td>
            </tr>
            </tbody>
        </table>
        <a href="/student/students" class="btn btn-secondary">Back to home</a>
    </div>
    </body>
</html>
