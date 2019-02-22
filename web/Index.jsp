<%-- 
    Document   : Index
    Created on : Feb 22, 2019, 2:46:00 PM
    Author     : Adi
--%>
<%@page import="model.Cell.Value"%>
<%@page import="model.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <Title>Tic Tac Toe</Title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="css/style.css"/>
        <script>
            function myFunction() {
                document.getElementById("demo").innerHTML = "X";
            }
        </script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand">
                        Tic Tac Toe
                    </a>
                </div>
            </div>
        </nav>
        <div class="game-area panel panel-default">
            <div class="panel-body">
                <form action="${pageContext.request.contextPath}/gc" method="post">
                    <h4 class="game-status">
                        <%
                            HttpSession sess = request.getSession(true);
                            GameMain game = (GameMain) sess.getAttribute("board");
                            if (game == null) {
                                game = new GameMain();
                                sess.setAttribute("board", game);
                            }
                            switch (game.getCurrentState()) {
                                case PLAYING:
                        %>
                        <span class="label label-default">
                            <% if (game.isNextMoveCross()) {
                            %>'X'<%
                            } else {
                            %>'O'<%
                                }
                            %> turn. Think Carefully</span>
                            <%
                                    break;
                                case CROSS_WON:
                            %>
                        <span class="label label-success">'X' Won </span>
                        <%
                                break;
                            case NOUGHT_WON:
                        %>
                        <span class="label label-success">'O' Won </span>
                        <%
                                break;
                            case DRAW:
                        %>
                        <span class="label label-info">Mehhh, It's a Draw</span>
                        <%
                                    break;
                            }
                        %>
                    </h4>
                    <table class="board">
                        <%
                            for (Cell[] row : game.getBoard().getCells()) {
                        %>
                        <tr class="board-row">
                            <%
                                for (Cell c : row) {
                            %>
                            <td>
                                <%
                                    if (c.getContent() == Value.CROSS) {
                                %>
                                <div class="board-row-tile x-value">X</div>
                                <%
                                } else if (c.getContent() == Value.NOUGHT) {
                                %>
                                <div class="board-row-tile o-value">O</div>
                                <%
                                } else if (game.isGameOver()) {
                                %>
                                <div class="board-row-tile"></div>
                                <%
                                } else if (c.getContent() == Value.EMPTY) {
                                    String temp = c.getRow() + "-" + c.getCol();
                                %>
                                <button class="board-row-tile" name="cellId" value="<%= temp%>" type="submit"></button>
                                <%
                                    }
                                %>
                            </td>
                            <%
                                }
                            %>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                    <div class="row">
                        <div class="col-sm-4"></div>
                        <div class="col-sm-1">
                            <label for="sel1">Board Size :</label>
                        </div>
                        <div class="col-sm-1">
                            <select class="form-control" id="sel1" name="size">
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                            </select>
                        </div>
                        <div class="col-sm-1">
                            <button type="submit" class="btn btn-primary" name="cellId" value="0">New Game</button>
                        </div>
                        <div class="col-sm-5"></div>
                    </div>
                </form>
            </div>
        </div>
                    ${test}
    </body>
</html>