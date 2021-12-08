<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 06/12/2021
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sportverein</title>
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <script src="redirect.js"></script>

</head>

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
                        <a href="/PayaraHelloWorld-1.0-SNAPSHOT/schach.html"
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
    <div class="px-10 py-3">
        <form action="verify-login-servlet" method="post" class="w-full max-w-lg">
            <div class="flex flex-wrap -mx-3 mb-6">
                <h2 class="px-4 pt-3 pb-2 text-gray-800 text-lg font-bold">Login</h2>
                <div class="w-full md:w-full px-3 mb-2 mt-2">
                    <label class="uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="userName">
                        Username:
                    </label>
                    <input id="userName" class="bg-gray-100 rounded border border-gray-400 leading-normal resize-none w-full  py-2 px-3 font-medium placeholder-gray-700 focus:outline-none focus:bg-white" name="userName" placeholder='username' required/>
                    <label class="uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="password">
                        Password:
                    </label>
                    <input type="password" id="password" class="bg-gray-100 rounded border border-gray-400 leading-normal resize-none w-full  py-2 px-3 font-medium placeholder-gray-700 focus:outline-none focus:bg-white" name="password" placeholder='**********' required/>

                </div>
                <div class="w-full">
                    <input class="float-right px-4 mx-4 my-4" type="submit" value="Submit">
                </div>
            </div>
        </form>
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