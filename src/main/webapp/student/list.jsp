<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>JSP 2.0 Expression Language - Implicit Objects</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  </head>
  <body>
  <div class="container">
    <a href="/student/students" style="text-decoration: none; color: black;"><h1 style="text-align: center;">List student</h1></a>
    <div class="row">
        <div class="col-md-8">
            <a href="/student/classes" class="btn btn-secondary"><i class="fa-solid fa-list"></i> List classes</a>
            <a href="/student/students?action=createGet" class="btn btn-primary"><i class="fa-solid fa-plus"></i> Create</a>
            <a href="/student/students?action=sortStudent&type=ASC" class="btn btn-info">Sort by age asc</a>
            <a href="/student/students?action=sortStudent&type=DESC" class="btn btn-info">Sort by age desc</a>
        </div>
        <div class="col-md-4" style="float: right;">
            <form action="/student/students?action=searchStudent" method="post">
                <div class="input-group mb-3">
                    <input type="text" name="name" class="form-control" placeholder="Name search" value="${nameSearch}">
                    <span class="input-group-text" id="basic-addon2"><button class="btn btn-primary"><i class="fa-solid fa-magnifying-glass"></i></button></span>
                </div>
            </form>
        </div>
    </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>STT</th>
                <th>Name</th>
                <th>Age</th>
                <th>Address</th>
                <th>Gender</th>
                <th>Classes</th>
                <th colspan="2" style="width: 20%; text-align: center;">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${students}" var="s" varStatus="student">
                <tr>
                    <td>${student.count}</td>
                    <td><a href="/student/students?action=detail&id=${s.id}">${s.name}</a></td>
                    <td>${s.age}</td>
                    <td>${s.address}</td>
                    <td>${s.gender}</td>
                    <td><a href="/student/students?action=findByClasses&classId=${s.classes.id}">${s.classes.name}</a></td>
                    <td><a href="/student/students?action=updateGet&id=${s.id}" class="btn btn-warning"><i class="fa-solid fa-pen-to-square"></i> Update</a></td>
                    <td><button onclick="deleteStudent('${s.id}', '${s.name}')" class="btn btn-danger"><i class="fa-solid fa-trash"></i> Delete</button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </body>
    <script>
        function deleteStudent(id, name) {
            if (confirm("Bạn có chắc chắn muốn xóa học viên này?: " + name)) {
                window.location.href = "http://localhost:8080/student/students?action=deleteStudent&id=" + id
            }
        }
    </script>
</html>
