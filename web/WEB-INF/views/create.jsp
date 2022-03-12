<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book create page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="card text-white mx-auto mb-3 my-5" style="max-width: 36rem;">
    <div class="card-header text-center bg-secondary "><h3>Add book</h3></div>
    <div class="card-body">
        <form action="/book/create" method="post">
            <input class="form-control mb-2" name="title" placeholder="title"/>
            <input class="form-control mb-2" name="author" placeholder="author"/>
            <input class="form-control mb-2" name="price" placeholder="price"/>
            <input class="form-control mb-2 btn btn-primary btn-block" type="submit" value="Submit">
        </form>
    </div>
</div>

</body>
</html>
