function validateForm() {

    let firstName = document.forms["registration"]["firstName"].value;
    let lastName = document.forms["registration"]["lastName"].value;
    let address = document.forms["registration"]["address"].value;
    let userName = document.forms["registration"]["userName"].value;
    let password = document.forms["registration"]["password"].value;
    let passwordConfirmed = document.forms["registration"]["passwordConfirmed"].value;
    let email = document.forms["registration"]["email"].value;

    let userNameRegex = /^[A-Za-z_]{4,10}/$;
    let passwordRegex = /^[A-Za-z]{1}[A-Za-z0-9_]{6,9}/$;
    let emailRegex = /^[A-Za-z]{1}[A-Za-z0-9_-]

    if (firstName == "") {
      alert("first must be filled out");
      return false;
    }

    if (lastName == ""){
        alert("Name must be filled out");
        return false;
    }
    if (address == ""){
        alert("Name must be filled out");
        return false;
    }
    if (userName == ""){
        alert("Name must be filled out");
        return false;
    } else if (!userNameRegex.test(userName)){
        alert("test");
        return false;
    }

    if (password == ""){
        alert("Name must be filled out");
        return false;
    } else if (!passwordRegex.test(password)){
        alert("Password musst have some weird combination of stuff dont ask me why I am not getting paid for this");
        return false;
    } 

    if (passwordConfirmed == ""){
        alert("Name must be filled out");
        return false;
    } else if (password != passwordConfirmed){
        alert("Passwords do not match :(");
        return false;
    }

    if (email == ""){
        alert("Name must be filled out");
        return false;
    }

    return true;
  }