@import exercise.dto.users.UsersPage
@param UsersPage page
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
@if(page.getUsers().isEmpty())
    <p>Пока не добавлено ни одного пользователя</p>
@else
    @for(var user : page.getUsers())
        <div>
            <h2><a href="/courses/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
            <p>${user.getEmail()}</p>
        </div>
    @endfor
@endif
</body>
</html>