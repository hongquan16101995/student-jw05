<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>JSP 2.0 Expression Language - Implicit Objects</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
      form {
        width: 600px;
        margin: auto;
      }
    </style>
  </head>
    <body>
      <div class="container">
        <h1 style="text-align: center;">Form create student</h1>
        <form action="/student/students?action=createPost" method="post">
          <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name">
          </div>
          <div class="mb-3">
            <label for="age" class="form-label">Age</label>
            <input type="text" class="form-control" id="age" name="age">
          </div>
          <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <input type="text" class="form-control" id="address" name="address">
          </div>
          <div class="mb-3">
            <label for="gender" class="form-label">Gender</label>
            <select class="form-select" name="gender" id="gender">
              <option>--- Select gender ---</option>
              <option value="Nam">Nam</option>
              <option value="Nữ">Nữ</option>
            </select>
          </div>
          <div class="mb-3">
            <label for="classes" class="form-label">Classes</label>
            <select class="form-select" name="classes"  id="classes">
              <option>--- Select classes ---</option>
              <c:forEach items="${classes}" var="c">
                    <option value="${c.id}">${c.name}</option>
                  </c:forEach>
            </select>
          </div>
          <div class="mb-3">
            <button class="btn btn-primary">Create</button>
          </div>
        </form>
        <a href="/student/students" class="btn btn-secondary">Back to home</a>
      </div>
    </body>
</html>
