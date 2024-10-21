<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View All Expenses</title>
    <%@ include file="../component/css.jsp" %>
</head>
<body>



    <%@ include file="navbar.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-md-8 offset-md-2">
                <div class="card">
                    <div class="card-header text-center">
                        <p class="fs-3">All Expenses</p>
                    </div>
                    <div class="card-body">
                        <c:if test="${not empty expenseList}">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Title</th>
                                        <th scope="col">Date</th>
                                        <th scope="col">Time</th>
                                        <th scope="col">Description</th>
                                        <th scope="col">Price</th>
                                        <th scope="col">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="expense" items="${expenseList}">
                                        <tr>
                                            <td>${expense.title}</td>
                                            <td>${expense.date}</td>
                                            <td>${expense.time}</td>
                                            <td>${expense.desciption}</td>
                                            <td>${expense.price}</td>
                                            <td>
                                                <a href="edit_expense.jsp?id=${expense.id}" class="btn btn-warning">Edit</a>
                                                <a href="DeleteExpense?id=${expense.id}" class="btn btn-danger" 
                                                   onclick="return confirm('Are you sure you want to delete this expense?');">
                                                   Delete
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                        <c:if test="${empty expenseList}">
                            <p>No expenses found.</p>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
