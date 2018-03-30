<%-- 
    Document   : hello.jsp
    Created on : Mar 29, 2018, 01:24 AM
    Author     : tbatey

    Based on the Spring Authentication Turtorial by Priyadarshini Balachandran
    https://dzone.com/users/1123099/bpriyada.html
--%>
<%@page import="com.trantbatey.groceries.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.trantbatey.groceries.HomeController"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="css/app.css" />" rel="stylesheet"
              type="text/css">
        <title>GROCERISAURUS</title>
    </head>
    <body>
        <jsp:include page="topBanner.jsp" />
        <h3 align="center">Product List</h3>
        <div>
            <div>
                <table border="1" align="center" >
                    <th>Description</th>
                    <th>Last Sold</th>
                    <th>Shelf Life</th>
                    <th>Department</th>
                    <th>Price</th>
                    <th>Unit</th>
                    <th>xFor</th>
                    <th>Cost</th>
                        <%
                            HomeController aHomeController = new HomeController();
                            List productList = aHomeController.listProduct();
                            Product product;
                            for (int i = 0; i < productList.size(); i++) {
                                out.print("<tr>");
                                product = (Product) productList.get(i);
                                out.print("<td>" + product.getDescription() + "</td>");
                                out.print("<td>" + product.getLastSold() + "</td>");
                                out.print("<td>" + product.getShelfLife() + "</td>");
                                out.print("<td>" + product.getDepartment() + "</td>");
                                out.print("<td>" + product.getPrice() + "</td>");
                                out.print("<td>" + product.getUnit() + "</td>");
                                out.print("<td>" + product.getxFor() + "</td>");
                                out.print("<td>" + product.getCost() + "</td>");
                                out.print("</tr>");
                            }
                        %>           
                </table>
            </div>
        </div>
    </body>
</html>
