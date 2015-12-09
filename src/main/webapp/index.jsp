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
            border: 1px #000000 solid;
        }
        th, thead {
            text-align: left;
            border: 1px #000000 solid;
            background-color: #90EE90;
        }
        input, textarea {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 15px;
            color: #000000;
            background-color: #FFFFFF;
            border: 1px #000000 solid;
        }
        input[type=text], input[type=password], textarea {
            width: 100%;
            margin: 0;
            box-sizing: border-box; /* Opera/IE 8+ */
            -webkit-box-sizing: border-box; /* Safari/Chrome, other WebKit */
            -moz-box-sizing: border-box; /* Firefox, other Gecko */
        }
    </style>
</head>
<body>

<h1>JAVAMAIL</h1>
<form action="emailServlet">
    <table>
        <tbody>
        <tr>
            <th>From:</th>
            <td><input name="from" type="text"/></td>
        </tr>
        <tr>
            <th>To:</th>
            <td><input name="to" type="text"/></td>
        </tr>
        <tr>
            <th>Cc:</th>
            <td><input name="cc" type="text"/></td>
        </tr>
        <tr>
            <th>Bcc:</th>
            <td><input name="bcc" type="text"/></td>
        </tr>
        <tr>
            <th>Subject:</th>
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
