<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register - Galgotias University</title>
    <link rel="stylesheet" href="style.css">
    <!-- Link to external script.js file -->
    <script src="script.js" defer></script>
</head>
<body>
    <header>
        <h1>Register for Galgotias University</h1>
    </header>

    <section class="form-container">
        <form action="register_action.php" method="POST" onsubmit="return validateForm(event)">
            <div class="form-group">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="rollno">Roll Number</label>
                <input type="number" id="rollno" name="rollno" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Register</button>
        </form>
    </section>

    <footer>
        <p>&copy; 2024 Galgotias University. All rights reserved.</p>
    </footer>
</body>
</html>