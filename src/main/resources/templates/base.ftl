<!-- base.ftl -->
<html>
<head>
    <title>${title}</title>
</head>
<body>
    <h1>${heading}</h1>
    <br></br>
    <p>${message}</p>

    <!-- Display environment variables -->
    <h3>Environment Details:</h3>
    <p>App Environment: ${appEnv}</p>
    <p>App Secret: ${appSecret}</p>
</body>
</html>