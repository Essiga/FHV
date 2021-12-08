<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 02/12/2021
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <title>Title</title>
<body>
<header>
    <nav class="bg-green-400 shadow-lg">
        <div class="max-w-6xl px-4">
            <div class="flex justify-between">
                <div class="flex space-x-7">
                    <!-- Website Logo -->
                    <div>
                        <a href="/PayaraHelloWorld-1.0-SNAPSHOT/index.html" class="flex items-center py-4 px-2">
                            <img src="/PayaraHelloWorld-1.0-SNAPSHOT/pictures/logo.png" alt="Logo" class="h-8 w-8 mr-2" />
                            <span class="font-semibold text-gray-500 text-lg">Navigation</span>
                        </a>
                    </div>
                    <!-- Primary Navbar items -->
                    <div class="flex items-center space-x-1">
                        <a href="/PayaraHelloWorld-1.0-SNAPSHOT/index.html" class="py-4 px-2 text-gray-100 font-semibold ">Home</a>
                        <a href="/PayaraHelloWorld-1.0-SNAPSHOT/paintball.jsp"
                           class="py-4 px-2 text-gray-500 font-semibold hover:text-gray-100 transition duration-300">Paintball</a>
                        <a href="/PayaraHelloWorld-1.0-SNAPSHOT/schach.jsp"
                           class="py-4 px-2 text-gray-500 font-semibold hover:text-gray-100 transition duration-300">Chess</a>
                    </div>
                    <div class="flex items-center space-x-1">
                        <a href="mailto:aes6270@students.fhv.at"
                           class="py-4 px-2 text-gray-500 font-semibold hover:text-gray-100 transition duration-300"><img class="h-8 w-8 mr-2" src="/PayaraHelloWorld-1.0-SNAPSHOT/pictures/email.png" alt="email icon"></a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
    <div class="relative h-64 overflow-hidden">
        <div class="absolute block w-6/12 h-full">
            <img class="object-cover min-w-full" src="/PayaraHelloWorld-1.0-SNAPSHOT/pictures/paintball-resized.png" alt="chess board">

        </div>

        <div class="absolute right-0 block w-6/12 h-full">
            <img class="object-cover min-w-full h-full" src="/PayaraHelloWorld-1.0-SNAPSHOT/pictures/chess-resized.png"
                 alt="chess board">

        </div>

    </div>

</header>
<main>
    <div class="flex justify-center py-8 border-2">
        <div>Hello ${requestScope.userID}</div>

    </div>


</main>
<div class="flex flex-col h-screen justify-between"></div>
<footer class="h-10 bg-green-500">
    <div>

    </div>

</footer>
</div>
</body>
</html>
