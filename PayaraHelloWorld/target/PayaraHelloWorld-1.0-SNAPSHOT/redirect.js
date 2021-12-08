function redirect() {
    let lastLocation = getCookie("lastLocation");
    if(lastLocation === document.location.pathname || lastLocation === ""){
        document.cookie = "lastLocation="+document.location.pathname;
    }
    else {
        window.location.replace(lastLocation);
    }


}
function getCookie(cname) {
    let name = cname + "=";
    let decodedCookie = decodeURIComponent(document.cookie);
    let ca = decodedCookie.split(';');
    for(let i = 0; i <ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}