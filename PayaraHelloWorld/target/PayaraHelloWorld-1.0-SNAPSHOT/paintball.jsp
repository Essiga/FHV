<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.lang.reflect.Array" %><%--
Created by IntelliJ IDEA.
User: Adrian
Date: 25/11/2021
Time: 20:32
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<c:if test="${sessionScope.isLoggedIn == false || sessionScope.isLoggedIn == null}">
  <c:set var="originalDestination" value="paintball.jsp" scope="session"/>
  <c:redirect url="login.jsp"/>
</c:if>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sportverein</title>
    <link rel="stylesheet" href="https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css" rel="stylesheet">
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
                <span class="font-semibold text-gray-500 text-lg">Navigation</span
                >
              </a>
            </div>
            <!-- Primary Navbar items -->
            <div class="flex items-center space-x-1">
              <a
                href="/PayaraHelloWorld-1.0-SNAPSHOT/index.html"
                class="py-4 px-2 text-gray-500 font-semibold hover:text-gray-100 transition duration-300"
                >Home</a
              >
              <a
                href="/PayaraHelloWorld-1.0-SNAPSHOT/paintball.jsp"
                class="py-4 px-2 text-gray-100 font-semibold "
                >Paintball</a
              >
              <a
                href="/PayaraHelloWorld-1.0-SNAPSHOT/schach.jsp"
                class="py-4 px-2 text-gray-500 font-semibold hover:text-gray-100 transition duration-300"
                >Chess</a
              >
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
        <img class="object-cover min-w-full w-4/12" src="/PayaraHelloWorld-1.0-SNAPSHOT/pictures/paintball-resized.png" alt="chess board">
        <div class="absolute py-2.5 bottom-6 right-auto inset-x-0 text-white text-5xl text-center">Paintball</div>
      </div>
  
      <div class="absolute right-0 block w-6/12 h-full">
         <img class="object-cover min-w-full h-full filter grayscale brightness-75" src="/PayaraHelloWorld-1.0-SNAPSHOT/pictures/chess-resized.png"
            alt="chess board">
  
      </div>
  
    </div>
  </header>
  <main>
    <div class="px-10 py-3">
      <p class="text-2xl font-extrabold text-green-800">Overview</p>
      <div class="px-10 py-3">
        <p>Saison: Winter21</p>
        <p>Leader: Peter Aintball</p>
      </div>
    
    <br/>
    <div class="text-2xl font-extrabold text-green-800">Description</div>
    <div class="px-10 py-3">
    <p>Paintball ist ein taktischer Mannschaftssport, bei dem sich Spieler mittels Markierern mit Farbkugeln markieren. Der getroffene und damit markierte Spieler muss das Spielfeld in der Regel verlassen.</p>
  </div>
  <br/>
  <div class="text-2xl font-extrabold text-green-800">Dates</div>
</div>
    

    <div class="flex flex-col px-10 py-3">
      <div class="-my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
        <div class="py-2 align-middle inline-block min-w-full sm:px-6 lg:px-8">
          <div class="shadow overflow-hidden border-b border-gray-200 sm:rounded-lg">
            <table class="min-w-full divide-y divide-gray-200">
              <thead class="bg-gray-50">
                <tr>
                  <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Team
                  </th>
                  <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Location
                  </th>
                  <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Opponent
                  </th>
                  <th scope="col" class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">
                    Date
                  </th>
                </tr>
              </thead>
              <tbody class="bg-white divide-y divide-gray-200">
                <tr>
                  <td class="px-6 py-4 whitespace-nowrap">
                    <div class="flex items-center">
                      <div class="ml-4">
                        <div class="text-sm font-medium text-gray-900">
                          The Daltons
                        </div>
                      </div>
                    </div>
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap">
                    <div class="text-sm text-gray-900">Dornbirn</div>
                    <div class="text-sm text-gray-500">Lustenauer Str. 118</div>
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap">
                    <div class="text-sm text-gray-900">The Lukes</div>
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                    12.07.2022
                  </td>
                </tr>
                <tr>
                  <td class="px-6 py-4 whitespace-nowrap">
                    <div class="flex items-center">
                      <div class="ml-4">
                        <div class="text-sm font-medium text-gray-900">
                          The Daltons
                        </div>
                      </div>
                    </div>
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap">
                    <div class="text-sm text-gray-900">Dornbirn</div>
                    <div class="text-sm text-gray-500">Lustenauer Str. 118</div>
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap">
                    <div class="text-sm text-gray-900">Chicago Aftershock</div>
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                    25.08.2022
                  </td>
                </tr>
                <tr>
                  <td class="px-6 py-4 whitespace-nowrap">
                    <div class="flex items-center">
                      <div class="ml-4">
                        <div class="text-sm font-medium text-gray-900">
                          Painter Brigade
                        </div>
                      </div>
                    </div>
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap">
                    <div class="text-sm text-gray-900">New York</div>
                    <div class="text-sm text-gray-500">2727 Arthur Kill Rd, Staten Island</div>
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap">
                    <div class="text-sm text-gray-900">NY Thunder</div>
                  </td>
                  <td class="px-6 py-4 whitespace-nowrap text-sm text-gray-500">
                    25.08.2022
                  </td>
                </tr>
    
              </tbody>
            </table>
          </div>
        </div>
      </div>
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

