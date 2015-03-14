<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<h2>Hello World!</h2>
<s:form action="addNewCustomer">
    <s:textfield name="firstName" label="first name"/>
    <s:textfield name="lastName" label="last name"/>
    <s:textfield name="age" label="age"/>
    <s:textfield name="email" label="email"/>
    <s:submit value="addNewCustomer"/>
</s:form>

<s:if test="customerList.size() > 0">
    <table border="1px" cellpadding="8px">
        <tr>
            <th>Customer Id</th>
            <th>Name</th>
            <th>Last Name</th>
        </tr>
        <s:iterator value="customerList" status="userStatus">
            <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="firstName"/></td>
                <td><s:property value="lastName"/></td>

            </tr>
        </s:iterator>
    </table>
</s:if>
</body>
</html>
