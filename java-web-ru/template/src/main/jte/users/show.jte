@import exercise.dto.users.UserPage;
@param UserPage page
<html>
<head>
    <title>Пользователь</title>
</head>
<body>
    <div>
        <h2><a href="/courses/${page.getUser().getId()}">${page.getUser().getFirstName()} ${page.getUser().getLastName()}</a></h2>
        <p>${page.getUser().getEmail()}</p>
    </div>
</body>
</html>