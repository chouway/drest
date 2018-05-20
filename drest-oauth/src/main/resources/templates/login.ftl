<html>

<head>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>

<body>

<div class="container">

    <form role="form" action="login" method="post">

        <div class="form-group">

            <label for="username">Username:</label>

            <input type="text" class="form-control" id="username" name="username" value="${username!}"/>

        </div>

        <div class="form-group">

            <label for="password">Password:</label>

            <input type="password" class="form-control" id="password" name="password"/>

        </div>

        <div class="form-group">

            <#if SPRING_SECURITY_LAST_EXCEPTION?? >

                <span style="margin-left:10px; color:red">${SPRING_SECURITY_LAST_EXCEPTION.message}</span>

            </#if>

        </div>

        <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>


        <button type="submit" class="btn btn-primary">Submit</button>




    </form>

</div>

<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</body>

</html>