<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book update page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<div class="modal-dialog modal-lm">
    <div class="modal-content">
        <div class="card-header text-white text-center bg-secondary "><h3>Updating book</h3></div>
        <div class="card-body">
            <form action="/book/update" method="post" >
                <input class="form-control mb-2" name="id" value="${updatingBook.id}" type="hidden"
                       placeholder="name"/>
                <input class="form-control mb-2" name="title" value="${updatingBook.title}" placeholder="title"/>
                <input class="form-control mb-2" name="author" value="${updatingBook.author}" placeholder="author"/>
                <input class="form-control mb-2" name="price" value="${updatingBook.price}" placeholder="price"/>
                <input class="form-control mb-2 btn btn-warning btn-block" type="submit" value="Edit">
            </form>
        </div>
    </div>
</div>
</body>
</html>
