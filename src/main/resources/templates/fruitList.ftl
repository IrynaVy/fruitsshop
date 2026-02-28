<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Fruit List</title>
</head>
<body>

<h1>Fruit List</h1>

<#-- @ftlvariable name="fruits" type="java.util.List<uaedunung.se.models.Fruit>" -->

<#if fruits?? && (fruits?size > 0)>
    <ul>
        <#list fruits as fruit>
            <li>${fruit.name} — ${fruit.price} EUR — ${fruit.quantity} pcs</li>
        </#list>
    </ul>
<#else>
    <p>No fruits added yet.</p>
</#if>

<a href="/fruitsshop/add-fruit">Add another fruit</a>

</body>
</html>