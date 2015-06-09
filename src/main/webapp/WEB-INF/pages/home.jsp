<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Home page</title>
    <script src="<c:url value="http://code.jquery.com/jquery-2.1.4.min.js"/>"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <script type="text/javascript">
        function sendData(){
            $.post("/lessons/add", {
                name: "Name",
                subject_id: 1,
                group_id: 1,
                room_id: 1,
                number: 1,
                day_id: 1//$('#first_name').val()
            });
        }
        var Lessons = [];
        function getData(){
            $.ajax({
                dataType: 'json',
                url:"/lessons/all",
                success:function(data){
                    Lessons = data;
                    console.log(data);
                    Lessons.forEach(function(lesson){
                        $('.data table').append("<tr><td>" + lesson.id + "</td><td>" + lesson.name + "</td><td>" + lesson.day_id + "</tr>");
                    });
                }
            });
        }
    </script>
</head>
<body>
<h1>Home page</h1>
<p>
${message}<br/>
<a href="${pageContext.request.contextPath}/team/add.html">Add new team</a><br/>
<a href="${pageContext.request.contextPath}/team/list.html">Team list</a><br/>
</p>
<div class="container">

<a class="btn" onclick="getData()" href="#">Показати всі заняття</a>
    <div class="data">
        <table>
            <tr>
                <td>Id</td><td>Ім'я</td><td>День</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>