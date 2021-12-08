<%--
  Created by IntelliJ IDEA.
  User: Adrian
  Date: 01/12/2021
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="keywords" content="Sport, Chess, Paintball">
    <meta name="description" content="Sport club for Chess and Paintball">
    <meta name="author" content="Adrian Essig">
    <title>Sportverein - Schach</title>
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
    <script src="/PayaraHelloWorld-1.0-SNAPSHOT/formvalidation.js"></script>
    <script src="setcookie.js"></script>
</head>
<body onload="setCookie()">
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
        <form name="registration" action="register-validation-servlet" onsubmit="return validateForm()" method="POST" class="w-full max-w-lg">
            <div class="flex flex-wrap -mx-3 ">
                <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="firstName">
                        First Name
                    </label>
                    <input class="appearance-none block w-full bg-gray-200 text-gray-700 border rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white" id="firstName" type="text" name="firstName" placeholder="Jane">

                </div>
                <div class="w-full md:w-1/2 px-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="lastName">
                        Last Name
                    </label>
                    <input class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="lastName" type="text" name="lastName" placeholder="Doe">
                </div>
            </div>

            <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" style="max-width: 400px">
                <span class="text-gray-700">ADDRESS</span>
                <textarea name="address"
                          class="form-textarea bg-gray-200 mt-1 block w-full"
                          rows="3"
                          placeholder="Enter some long form content."
                          id="address"
                ></textarea>
            </label>

            <div class="relative">
                <select class="block appearance-none w-full bg-gray-200 border border-gray-200 text-gray-700 py-3 px-4 pr-8 rounded leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="country" name="country">
                    <option>Österreich</option>
                    <option>Schweiz</option>
                    <option>Deutschland</option>
                    <option>Andere</option>
                </select>
                <div class="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
                    <svg class="fill-current h-4 w-4" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z"/></svg>
                </div>
            </div>
            <br/>
            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full px-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="userName">
                        Username
                    </label>
                    <input class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="userName" type="text" name="userName" placeholder="xXGamerBoiXx">
                    <div class="bg-red-200">Username: ${requestScope.userID} already taken.</div>
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="password">
                        Password
                    </label>
                    <input class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="password" type="password" name="password" placeholder="******************">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="passwordConfirmed">
                        Confirm Password
                    </label>
                    <input class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="passwordConfirmed" type="password" name="passwordConfirmed" placeholder="******************">
                </div>
            </div>




            <div class="flex flex-wrap -mx-3 mb-2">
                <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                    <input type="radio" id="female" name="gender" value="FEMALE">
                    <label for="female">female</label><br>


                </div>
                <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                    <input type="radio" id="male" name="gender" value="MALE">
                    <label for="male">male</label><br>
                </div>
                <div class="w-full md:w-1/3 px-3 mb-6 md:mb-0">
                    <input type="radio" id="other" name="gender" value="OTHER">
                    <label for="other">other</label>
                </div>
            </div>

            <select class="w-1/2" multiple size="2" name="sport">
                <option value="Paintball">Paintball</option>
                <option value="Chess">Chess</option>

            </select>
            <div>
                <br/>
                <div class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">Permissions:</div>
                <input type="checkbox" id="player" name="permissions" value="Player">
                <label for="player">Player</label><br>
                <input type="checkbox" id="manager" name="permissions" value="Manager">
                <label for="manager"> Manager</label><br>
                <input type="checkbox" id="admin" name="permissions" value="Admin">
                <label for="admin">Admin</label><br><br>

            </div>

            <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2" for="email">
                Email
            </label>
            <input class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500" id="email" type="text" name="email" placeholder="xXGamerBoiXx@hotmail.com">
            <br/>

            <div class="flex justify-evenly">
                <input type="reset">
                <input type="submit" value="Submit">
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

