function validateForm() {

    var img = new Image();
    img.src = "/pictures/banana.png";


    var w = 480, h = 340;


    if (document.getElementById) {
        w = screen.availWidth;
        h = screen.availHeight;
     }  
     
    var popW = 800, popH = 700;

    var leftPos = (w-popW)/2;
    var topPos = (h-popH)/2;

    msgWindow = window.open('','popup','width=' + img.width + ',height=' + img.height + 
                         ',top=' + topPos + ',left=' + leftPos + ',       scrollbars=yes');

    msgWindow.document.write(`<HTML><img src="${img.src}"></HTML>`);

    let doc = document.forms["registration"];
    let firstName = document.forms["registration"]["firstName"].value;
    let lastName = document.forms["registration"]["lastName"].value;
    let address = document.forms["registration"]["address"].value;
    let country = document.forms["registration"]["country"].value;
    let userName = document.forms["registration"]["userName"].value;
    let password = document.forms["registration"]["password"].value;
    let gender = document.forms["registration"]["gender"].value;
    let sport = document.forms["registration"]["sport"].value;
    let permissions = document.forms["registration"]["permissions"].value;
    let passwordConfirmed = document.forms["registration"]["passwordConfirmed"].value;
    let email = document.forms["registration"]["email"].value;

    let userNameRegex = /^[A-Za-z_]{4,10}$/;
    let passwordRegex = /^[A-Za-z]{1}[A-Za-z0-9_]{6,9}$/;
    let emailRegex = /^[A-z]{1}(\.?[\w-]+)*[^.]*@[^-]([a-zA-Z0-9-]\.?){1,63}[^-.]$/;

//  name:[A-Za-z]{1}[^.](\.?[\w-]+)*
//  @ and subdomain: @([^-][a-zA-Z0-9-.][^-])
//  name @ and subdomain: [A-Za-z]{1}(\.?[\w-]+)*@[^-]([a-zA-Z0-9-]\.?){3,63}[^-]


    if (firstName == "") {
        document.getElementById("firstName").focus();
        doc.reset();
        alert("first name must be filled out");
      return false;
    }

    if (lastName == ""){
        document.getElementById("lastName").focus();
        doc.reset();
        alert("Name must be filled out");
        return false;
    }
    if (address == ""){
        document.getElementById("address").focus();
        doc.reset();
        alert("Name must be filled out");
        return false;
    }
    if (country == ""){
        document.getElementById("country").focus();
        doc.reset();
        alert("country must be filled out");
        return false;
    }

    if (userName == ""){
        document.getElementById("userName").focus();
        doc.reset();
        alert("Name must be filled out");
        return false;
    } else if (!userNameRegex.test(userName)){
        document.getElementById("userName").focus();
        doc.reset();
        alert("test");
        return false;
    }

    if (password == ""){
        document.getElementById("password").focus();
        doc.reset();
        alert("Name must be filled out");
        return false;
    } else if (!passwordRegex.test(password)){
        doc.reset();
        alert("Password musst have some weird combination of stuff dont ask me why I am not getting paid for this");
        document.getElementById("password").focus();
        return false;
    } 

    if (passwordConfirmed == ""){
        document.getElementById("passwordConfirmed").focus();
        doc.reset();
        alert("please confirm the password");
        return false;
    } else if (password != passwordConfirmed){
        document.getElementById("passwordConfirmed").focus();
        doc.reset();
        alert("Passwords do not match");
        return false;
    }

    if (gender == ""){
        doc.reset();
        alert("gender must be filled out");
        return false;
    }
    if (sport == ""){
        doc.reset();
        alert("sports must be filled out");
        return false;
    }
    if (permissions == ""){
        doc.reset();
        alert("permissions must be filled out");
        return false;
    }

    if (email == ""){
        document.getElementById("email").focus();
        doc.reset();
        alert("email must be filled out");
        return false;
    } else if (!emailRegex.exec(email)) {
        document.getElementById("email").focus();
        doc.reset();
        alert("The email must follow a certain set of constraints. Which? Good luck finding that out.")
        return false;
    }

    return true;
  }