<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Fruit</title>
</head>
<body>

<h1>Add New Fruit</h1>

<form action="/fruitsshop/add-fruit" method="post">

    <label for="name">Name:</label>
    <input id="name" type="text" name="name" required><br><br>

    <label for="price">Price:</label>
    <input id="price" type="number" step="0.01" name="price" required><br><br>

    <label for="quantity">Quantity:</label>
    <input id="quantity" type="number" name="quantity" required><br><br>

    <button type="submit">Add</button>
</form>

</body>
</html>