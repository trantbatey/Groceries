<%-- 
    Document   : hello.jsp
    Created on : Mar 24, 2018, 01:24 AM
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
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <link href="<c:url value="css/app.css" />" rel="stylesheet"
              type="text/css">
        <title>GROCERISAURUS</title>
    </head>
    <body>
        <div class="sidenav">
            <p style="font-size: x-large; color: maroon; padding-left: 10px">Filters</p>
            <div class="search-container">
                <form action="productSearch" method="post"
                      style="width: 150px; padding-left: 10px">
                    <label for="description"><b>Description: </b></label>
                    <input type="text" placeholder="Filter..." value=""
                           id="description" name="description" style="font-size:12px"> 
                    <br>
                    <label for="department"><b>Department: </b></label>
                    <input type="text" placeholder="Filter..." value=""
                           id="department" name="department" style="font-size:12px"> 
                    <br>
                    <label for="maxPrice"><b>Max Price: </b></label>
                    <input type="number" value="" min="0" step="0.01"
                           id="maxPrice" name="maxPrice" style="font-size:12px"> 
                    <br>
                    <label for="minPrice"><b>Min Price: </b></label>
                    <input type="number" value="" min="0" step="0.01"
                           id="minPrice" name="minPrice" style="font-size:12px"> 
                    <br>
                    <button type="submit" style="height: 35px; width: 100px; margin-top: 10px">
                        Submit</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form>
            </div>
        </div>
        <script>
             var vars = [], hash;
             var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
             for(var i = 0; i < hashes.length; i++)
             {
                 hash = hashes[i].split('=');
                 vars[hash[0]] = hash[1];
             }
             if (vars['description']) {
                 document.getElementById('description').value = vars['description'];
             }
             if (vars['department']) {
                 document.getElementById('department').value = vars['department'];
             }
             document.getElementById('maxPrice').value = vars['maxPrice'];
             document.getElementById('minPrice').value = vars['minPrice'];
        </script>
        <jsp:include page="topBanner.jsp" />

        <div style="margin-bottom: 40px; padding-left: 150px">
            <h3 align="center">Product List</h3>
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
        <jsp:include page="baseBanner.jsp" />
    </body>
</html>
