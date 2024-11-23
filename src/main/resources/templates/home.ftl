<!DOC TYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>

    <!-- Background -->
    <link rel="icon" href="${domainUrl}/static/images/korsikov_blog_snake.webp">

    <!-- Fonts -->
    <link rel="stylesheet" href="${domainUrl}/static/fonts/-.woff2">

    <!-- Stylesheets -->
    <link rel="stylesheet" href="${domainUrl}/static/css/styles.css">
</head>
<body class="magic-book">
<header>
    <div class="avatar-container">
        <a href="${domainUrl}/">
            <img src="${domainUrl}/static/images/korsikov_blog_avatar.webp" alt="Avatar" class="avatar">
        </a>
    </div>
    <h1 class="header-title">${title}</h1>
    <nav class="navigation">
        <ul>
            <li><a href="${domainUrl}/" class="nav-button">Home</a></li>
        </ul>
    </nav>
</header>

<main class="container">
    <section class="card">
        <h2>TEST</h2>
        <p class="highlight">
            TEST..
        </p>
        <img
            src="${domainUrl}/static/images/random/korsikov_blog_image_${random}.webp"
            alt="Home Random Image ${random}"
            class="card-image">
    </section>
</main>

<footer class="footer">
    <div class="container">
        <p>&copy; ${.now?string["yyyy"]} Mykyta's Website. All rights reserved.</p>
        <p><a href="mailto:${blogEmail}">${blogEmail} ✨</a></p>
        <p><a href="${domainUrl}/about">About</a> | <a href="${domainUrl}/">Privacy Policy</a></p>
        <p><a href="${githubUrl}/korsikov-simple-blog">Code on GitHub</a></p>
        <p><a href="${domainUrl}">${domainUrl}</a></p>
    </div>
</footer>
</body>
</html>