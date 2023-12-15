<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container"><h3>Welcome</h3>

    <h1>Your Todos </h1>
    <table class="table">
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
            <th colspan="2">actions</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href="delete-todo?id=${todo.id}"
                       class="btn btn-danger">Delete</a></td>
<%--                <td><a href="delete-todo?id=${todo.id}"--%>
<%--                       class="btn btn-danger">DELETE</a></td>--%>
                <td><a href="update-todo?id=${todo.id}"
                       class="btn btn-success">Upadate</a></td>
            </tr>
        </c:forEach>
        </tbody>


    </table>
    <a href="add-todos" class="btn btn-primary">Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>