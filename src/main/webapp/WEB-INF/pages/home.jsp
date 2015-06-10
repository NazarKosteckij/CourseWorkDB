<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Розклад занять</title>
    <script src="<c:url value="http://code.jquery.com/jquery-2.1.4.min.js"/>"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="http://materializecss.com/bin/materialize.js"></script>
    <link type="text/css" rel="stylesheet" href="http://makoframework.com/assets/css/materialize.min.css" media="screen,projection">
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <script type="text/javascript">
        $(document).ready(function(){
            // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
            $('.modal-trigger').leanModal();
            $('select').material_select();
            getData();
        });

        var Lessons = [];
        var Days = [];

        function getDays(){
            $.ajax({
                dataType: 'json',
                url:"/databases/days/all",
                success:function(data){
                   if(data.length!=0) Days = data
                    else Days = [{names:'error: initialize data'},{names:'error: initialize data'},{names:'error: initialize data'},{names:'error: initialize data'},{names:'error: initialize data'},{names:'error: initialize data'}];

                }
            });
        }

        function sendData(){
            $.post("/databases/lessons/add", {
                name: $('input#name').val(),
                subject_id: 1,
                group_id: 1,
                room_id: 1,
                number: parseInt($('input#number').val()),
                day_id: parseInt($('select#days').val())//$('#first_name').val()
            });
            getData();
        }
        function deleteLesson(id){
            if(id){
                Materialize.toast('Deleted',2000);
            }
        }
        function getData(){
            $.ajax({
                dataType: 'json',
                url:"/databases/lessons/all",
                success:function(data){
                    Lessons = data;
                    console.log(data);
                    $('.data tbody').empty();
                    if(Days.length==0){
                        getDays();
                        getData();
                    } else Lessons.forEach(function(lesson){
                        $('.data tbody').append("<tr><td>" + lesson.id + "</td><td>" + Days[lesson.day_id].names  + "</td><td>"  + lesson.name + "</td><td>" + lesson.number + "</td><td>" + lesson.group_id + "</td><td>" + lesson.room_id
                        + "<td><a  class='btn-floating red' onclick='deleteLesson(this.id)' id='" + lesson.day_id + "'>"
                        + "<i class='large mdi-editor-mode-edit'>" +
                        "</i>  </a></td></tr> ");
                    });
                }
            });
        }
    </script>
</head>
<body>
<h1>Розклад занять</h1>
<!--<p>
${message}<br/>
<a href="${pageContext.request.contextPath}/team/add.html">Add new team</a><br/>
<a href="${pageContext.request.contextPath}/team/list.html">Team list</a><br/>
</p> -->
<div class="container">
    <a class="modal-trigger waves-effect waves-light btn" href="#add">Додати новий</a>
    <a class="btn waves-effect waves-teal" onclick="getData()" href="#">Показати всі заняття</a>
    <div>
        <table class="striped data">
            <thead>
                <td>Id</td><td>День</td><td>Назва</td><td>№ Пари</td><td>Група</td><td>Аудиторія</td><td>Дія</td>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>


<!-- Modal Add data -->
<div id="add" class="modal modal-fixed-footer">
    <div class="modal-content">
        <h4>Додати заннятя</h4>
        <div class="row">
            <div class="input-field col s6">
                <input id="number" type="text" class="validate">
                <label for="number">№ Пари</label>
            </div>
            <div class="input-field col s6">
                <input id="name" type="text" class="validate">
                <label for="name">Назва заняття</label>
            </div>
            <div class=" col s6">
                <select class="initialized" id="days">
                    <option value="1">Понеділок</option>
                    <option value="2">Вівторок</option>
                    <option value="3">Середа</option>
                    <option value="4">Четвер</option>
                    <option value="5">П'ятниця</option>
                    <option value="6">Субота</option>
                </select>
                <label>Materialize Select</label>

            </div>
            <div class=" col s6">
                <select class="initialized" id="rooms">
                    <option value="1">Понеділок</option>
                    <option value="2">Вівторок</option>
                    <option value="3">Середа</option>
                    <option value="4">Четвер</option>
                    <option value="5">П'ятниця</option>
                    <option value="6">Субота</option>
                </select>
                <label>Materialize Select</label>

            </div>
        </div>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat" onclick="Materialize.toast('Дані додано', 3000);sendData()" href="#">Додати</a>
    </div>
</div>

</body>
</html>
