<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Javamail</title>

    <style type="text/css">
        body {
            width: 800px;
            margin: 0 auto;
        }
        h1 {
            text-align: center;
        }
        table {
            width: 100%;
        }
        input[type=text], input[type=password], textarea {
            width: 100%;
            margin: 0;
            box-sizing: border-box;
            -moz-box-sizing: border-box;
            -webkit-box-sizing: border-box;
        }
    </style>
</head>
<body>

<h1>JAVAMAIL</h1>

<form action="emailServlet">
    <table border="1">
        <tbody>
        <tr>
            <td>FROM:</td>
            <td><input name="from" type="text"/></td>
        </tr>
        <tr>
            <td>TO:</td>
            <td><input name="to" type="text"/></td>
        </tr>
        <tr>
            <td>CC:</td>
            <td><input name="cc" type="text"/></td>
        </tr>
        <tr>
            <td>BCC:</td>
            <td><input name="bcc" type="text"/></td>
        </tr>
        <tr>
            <td>SUBJECT:</td>
            <td><input name="subject" type="text"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <textarea name="message" rows="10" cols="100"></textarea>
            </td>
        </tr>
        </tbody>
    </table>

    <br/>

    <input type="submit" value="Send"/>
</form>

</body>
</html>
