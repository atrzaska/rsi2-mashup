<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Zajevents</title>
    <meta name="description" content="Zajevents - wydarzenia dla Ciebie">
    <meta name="author" content="Andrzej Trzaska Rafał Szypulewski">
    <meta name="keywords" content="Zajevents, events, mashup"/>
    <link type="image/ico" rel="icon" href="css/favicon.ico" />

    <!-- Le Stylesheets -->
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css" />
    <link type="text/css" rel="stylesheet" href="css/bootstrap-theme.min.css" />
    <link type="text/css" rel="stylesheet" href="css/slimbox-style.css" />
    <link type="text/css" rel="stylesheet" href="css/slimbox2.css" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
</head>

<body>
    <div class="main">
        <div class="page">
            <div class="header"><img src="res/header.jpg" alt="" height="304" width="998"/></div>
            <div class="content">
                <div class="leftpanel">
                    <h2>Main Menu</h2>
                    <ul>
                        <li style="border-top: medium none;"><a href="index.jsp">Strona główna</a></li>
                        <li><a href="popularEvents">Popularne wydarzenia</a></li>
                        <li><a href="scanLocation.jsp">Wydarzenia w twoim regionie</a></li>
                    </ul>

                </div> <!-- .leftpanel -->


                <div class="rightpanel">
                    <br/>
                    <form action="locationSearch" method="GET">
                        <div>
                            Wyszukaj po miejscomości:
                            <br/>
                            <input class="searchbox"  type="text" name="q" /><input value="Szukaj" type="submit" />
                            <br/>

                        </div>
                    </form>
                    <br/>
                    <form action="keywordSearch" method="GET">
                        <div>
                            Wyszukaj po słowach kluczowych
                            <br/>
                            <input class="searchbox" type="text" name="q" /><input value="Szukaj" type="submit" />
                            <br/>

                        </div>
                    </form>
                    <br/>
                    <form action="categorySearch" method="GET">
                        <div>
                            Wyszukaj po słowach kategorii
                            <br/>
                            <input class="searchbox" type="text" name="q" /><input value="Szukaj" type="submit" />
                            <br/>

                        </div>
                    </form>




                </div> <!-- .rightpanel -->
            </div> <!-- #content -->
            <!--DO NOT Remove The Footer Links-->
            <div class="footer">&copy; 2010 zajevents.com Designed by <a
                class="footer-link" target="_blank"
                href="http://www.htmltemplates.net/">htmltemplates.net</a>
               <!--DO NOT Remove The Footer Links-->
            </div> <!-- .footer -->
        </div> <!-- #page -->
    </div> <!-- #main -->

    <!-- Le Javascripts -->

    <!-- Le HTML5 shim and Respond.js, for IE6-8 support of HTML elements and media queries -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript" src="js/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/slimbox2.js"></script>
</body>
</html>
