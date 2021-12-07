<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.lang.reflect.Array" %><%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 25/11/2021
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

<%--    <% for (int i = 0; i <= 10; i++) {--%>
<%--        out.println("hello");--%>
<%--    }%>--%>

    <table>

    <tr>
        <%
           String columnsText = request.getParameter("columns");
           String rowsText = request.getParameter("rows");

           if(rowsText != null && !rowsText.equals("") && columnsText != null && !columnsText.equals("")){
               int rows = Integer.parseInt(rowsText);
               int columns = Integer.parseInt(columnsText);

               for(int i = 0; i < columns; i++){
                   out.println("<th>column "+i+"</th>");
               }



        %>
    </tr>


        <%
                String colorArray[] = {"00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "AA", "BB", "CC", "DD", "FF", "F0"};
                for(int i = 0; i < rows; i++) {
                    out.println("<tr>");
                    for(int j = 0; j < columns; j++){
                        out.println("<td style=\"background-color: #"+colorArray[j]+colorArray[i]+colorArray[j]+"\">" +j+"|"+i+"</td>");
                    }
                    out.println("</tr>");

                }
           }
        %>


    </table>
</head>
<body>

</body>
</html>
