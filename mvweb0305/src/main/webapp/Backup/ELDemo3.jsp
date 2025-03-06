<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EL Demo</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 8px;
        }
    </style>
</head>
<body>
    <h2>EL Expression Language Demo</h2>

    <h3>Numeric Comparisons</h3>
    <table>
        <tr><th><b>EL Expression</b>b></th><th><b>Result</b>b></th></tr>
        <tr><td>\${1 < 2}</td><td>${1 lt 2}</td></tr>
        <tr><td>\${1 > (4/2)}</td><td>${1 gt (4/2)}</td></tr>
        <tr><td>\${4.0 >= 3}</td><td>${4.0 ge 3}</td></tr>
        <tr><td>\${4 <= 3}</td><td>${4 le 3}</td></tr>
        <tr><td>\${100.0 == 100}</td><td>${100.0 eq 100}</td></tr>
        <tr><td>\${(10*10) != 100}</td><td>${(10*10) ne 100}</td></tr>
    </table>

    <h3>Alphabetic Comparisons</h3>
    <table>
        <tr><th>EL Expression</th><th>Result</th></tr>
        <tr><td>\${'a' < 'b'}</td><td>${'a' lt 'b'}</td></tr>
        <tr><td>\${'hip' > 'hit'}</td><td>${'hip' gt 'hit'}</td></tr>
        <tr><td>\${'4' > 3}</td><td>${'4' gt 3}</td></tr>
    </table>
</body>
</html>
