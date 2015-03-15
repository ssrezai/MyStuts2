<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: DOTIN SCHOOL 3
  Date: 3/14/2015
  Time: 1:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div>
    <%@ page import="java.util.ResourceBundle" %>
    <% ResourceBundle resource = ResourceBundle.getBundle("message");

        String congratulation = resource.getString("congratulation");
        String error = resource.getString("message.error"); %>
    <%--<%=congratulation %>--%>
    <%--<%=error%>--%>
</div>
<p>
    <%=congratulation %>
<br>
    add new customer and update your data base :)<br>
    </p>
    <s:property value="firstName"/>
    <s:property value="lastName"/>
    <s:if test="hasActionMessages()">
        <s:actionmessage/>
        <script>
            var c = <s:actionmessage/>
                    alert(<s:actionmessage/>);
        </script>
    </s:if>
    </body>
    </html>
