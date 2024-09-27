<!DOCTYPE html>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
    <h2>Upload hình ảnh</h2>
    <form action="/student/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" accept="image/*" />
        <input type="submit" value="Tải lên" />
    </form>
</body>
</html>