<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.mongodb.client.MongoDatabase" %>
<%@ page import="org.bson.Document" %>
<%@ page import="com.mongodb.client.MongoCollection" %>
<%@ page import="com.mongodb.client.FindIterable" %>
<%@ page import="org.bson.conversions.Bson" %>
<%@ page import="com.mongodb.client.*" %>
<%@ page import="com.mongodb.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.mongodb.client.model.Filters" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="static com.mongodb.client.model.Filters.gte" %>
<%@ page import="static javax.management.Query.and" %>
<%@ page import="static com.mongodb.client.model.Filters.eq" %>
<%@ page import="model.Game" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <title>JSP - Hello World</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="./resources/css/bootstrap-table.css" rel="stylesheet" />
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="searchMatch.js"></script>

    <style>
        body {
            font-family: "Lato", sans-serif;
        }

        .sidenav {
            height: 100%;
            width: 200px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            overflow-x: hidden;
            padding-top: 20px;
        }

        .sidenav a {
            padding: 6px 6px 6px 32px;
            text-decoration: none;
            font-size: 25px;
            color: #818181;
            display: block;
        }

        .sidenav a:hover {
            color:#111111;
        }

        .main {
            margin-left: 200px; /* Same as the width of the sidenav */
        }

        @media screen and (max-height: 450px) {
            .sidenav {padding-top: 15px;}
            .sidenav a {font-size: 18px;}
        }

    </style>
    <!-- Bootstrap CSS -->
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div class="sidenav" style="background-image: url('giochi.jpeg');">
    <div class="transbox" style="margin: 15px; background-color: #ffffff; opacity: 0.9; height: 100%">
        <img src="logo_standard.png" style="width: 40%; margin-top: 30%; margin-left:30%  ">
        <a href="index.jsp">Home</a>
        <a href="OneQuery.jsp">Find By Platform</a>

        <a href="TwoQuery.jsp">Find By Genre</a>

        <a href="ThreeQuery.jsp">Find By Name</a>

        <a href="FourQuery.jsp">Find By Year</a>

        <a href="FiveQuery.jsp">Find By Publisher</a>


    </div>
</div>

<div class="main">

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Search Game using a Year to start from searching:</h6>
        </div>
        <div class="card-body">
            <form id="searchQueryUno" action="ServletQuerys" method="post">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label class="text-black">Year</label>
                        <input type="number" name="Year" class="form-control" required name="Year" placeholder="Game from Year">
                        <input type="hidden" name="query" value="four">
                    </div>
                </div>
                <button type="submit" class="btn btn-primary right">Search</button>
                <br/>
                <label>Ordine di aggregazione</label>
                <br/>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="Order" id="inlineRadio1" value="NessunOrdinamento" checked>
                    <label class="form-check-label" for="inlineRadio1">Nessun ordinamento</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="Order" id="inlineRadio2" value="OrdinamentoCrescente">
                    <label class="form-check-label" for="inlineRadio2">Ordinamento crescente</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="Order" id="inlineRadio3" value="OrdinamentoDecrescente">
                    <label class="form-check-label" for="inlineRadio3">Ordinamento decrescente</label>
                </div>
            </form>
        </div>
    </div>

    <% 	if(request.getAttribute("result")!=null){
        ArrayList<Game> result = (ArrayList<Game>) request.getAttribute("result");

    %>



    <div class="table-responsive" id="matchTable" style=" width: 90%;
    margin-left: 5%;">
        <table class="table table-bordered"  width="100%" cellspacing="0">
            <thead>
            <tr style="background-color:#007bff">
                <th>Rank</th>
                <th>Name</th>
                <th>Platform</th>
                <th>Year</th>
                <th>Genre</th>
                <th>Publisher</th>
                <th>NA_Sales</th>
                <th>EU_Sales</th>
                <th>JP_Sales</th>
                <th>Other_Sales</th>
                <th>Global_Sales</th>
            </tr>
            <% for (Game g : result)
            {%>
            <tr>
                <td><%=g.getRank()%></td>
                <td><%=g.getName()%></td>
                <td><%=g.getPlatform()%></td>
                <td><%=g.getYear()%></td>
                <td><%=g.getGenre()%></td>
                <td><%=g.getPublisher()%></td>
                <td><%=g.getNA_Sales()%></td>
                <td><%=g.getEU_Sales()%></td>
                <td><%=g.getJP_Sales()%></td>
                <td><%=g.getOther_Sales()%></td>
                <td><%=g.getGlobal_Sales()%></td>
            </tr>
            <%}%>
            </thead>
        </table>

        <% }%>
    </div>
</div>
<footer class="sticky-footer bg-white">
    <div class="container my-auto">
        <div class="copyright text-center my-auto">
            <span>Copyright &copy; UNISA</span>
        </div>
    </div>
</footer>
</body>
</html>