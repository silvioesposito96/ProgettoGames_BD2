
<!DOCTYPE html>
<html lang="en">
<head>
    <title>JSP - Hello World</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

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
            color: #111111;
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
            <h6 class="m-0 font-weight-bold text-primary">Game Project </h6>
        </div>
        <div class="card-body">

            <br> <b> Content </b> <br>
            Il dataset utilizzato vgsales, preso dal sito kaggle.com, rappresenta le vendite di videogiochi nel mondo dal 1980 a 2016 ed include i seguenti attributi:



            <ul>

                <li>Rank: Ordine di vendita di ogni gioco nel mondo</li>
                <li>Name: Nome del gioco</li>
                <li>Platform: Piattaforma/consolle compatibile con il gioco</li>
                <li>Year: Anno di rilascio del gioco</li>
                <li>Genre: Genere del gioco (azione, strategia, ecc)</li>
                <li>Publisher: Compagnia che ha rilasciato il gioco</li>
                <li>NA_Sales: Vendite del gioco in Nord-America (mln di euro)</li>
                <li>EU_Sales: Vendite del gioco in Europa (mln di euro)</li>
                <li>JP_Sales: Vendite del gioco in Giappone (mln di euro)</li>
                <li>Other_Sales: Vendite del gioco nel resto del mondo (mln di euro)</li>
                <li>Global_Sales: Vendite complessive nel mondo (mln di euro)</li>



            </ul>


        </div>
    </div>
</div>
</div>


<footer class="sticky-footer bg-white">
    <div class="container my-auto">
        <div class="copyright text-center my-auto">
            <span>Copyright &copy; UNISA</span>

        </div>
    </div>
</footer>
</div>

</body>
</html>