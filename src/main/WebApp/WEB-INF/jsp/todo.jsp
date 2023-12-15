
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container"><h3>Welcome</h3>

    <h1>Enter Todo Details</h1>
    <%--@elvariable id="todo" type="com.springbootproject.todowebapp.myfirstwebapp.todo.Todo"--%>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="desc">Description</form:label>
            <form:input type="text" path="desc"/>
            <form:errors path="desc" cssClass="text-warning"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>


        <form:input type="hidden" path="id"/>

        <form:input type="hidden" path="done"/>

        <br><br>
        <input type="submit" class="btn btn-primary" />
    </form:form>
    </div>

<%@ include file="common/footer.jspf" %>

<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>