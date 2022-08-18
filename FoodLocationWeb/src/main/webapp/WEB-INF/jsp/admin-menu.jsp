<%-- 
    Document   : admin-product
    Created on : Aug 12, 2022, 1:50:08 PM
    Author     : kyuut
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="app-main__outer">
    <div class="app-main__inner">
        <a class="btn btn-primary" href="<c:url value="/admin/add-menu" />">Them mon an</a>
        <table class="table" style="margin-top: 20px">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">NAME</th>
                    <th scope="col">PRICE</th>
                    <th scope="col">STORE</th>
                    <th scope="col">NOTE</th>
                    <th scope="col">FROM</th>
                    <th scope="col">TO</th>
                    <th scope="col">TYPE</th>
                    <th scope="col"></th>
                    <th scope="col"></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>ID1</td>
                    <td>NAME1</td>
                    <td>PRICE1</td>
                    <td>STORE1</td>
                    <td>NOTE1</td>
                    <td>FROM1</td>
                    <td>TO1</td>
                    <td>TYPE1</td>
                    <td>
                        <a href="<c:url value="/admin/detail-menu/"/>"><button type="button" class="btn btn-primary">Detail</button></a>
                        <button type="button" class="btn btn-primary">Delete</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>ID2</td>
                    <td>NAME2</td>
                    <td>PRICE2</td>
                    <td>STORE2</td>
                    <td>NOTE2</td>
                    <td>FROM2</td>
                    <td>TO2</td>
                    <td>TYPE2</td>
                    <td>
                        <button type="button" class="btn btn-primary">Detail</button>
                        <button type="button" class="btn btn-primary">Delete</button>
                    </td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>ID3</td>
                    <td>NAME3</td>
                    <td>PRICE3</td>
                    <td>STORE3</td>
                    <td>NOTE3</td>
                    <td>FROM3</td>
                    <td>TO3</td>
                    <td>TYPE3</td>
                    <td>
                        <button type="button" class="btn btn-primary">Detail</button>
                        <button type="button" class="btn btn-primary">Delete</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
