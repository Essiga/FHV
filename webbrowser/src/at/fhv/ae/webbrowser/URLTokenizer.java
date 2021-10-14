package at.fhv.ae.webbrowser;

public class URLTokenizer {

    private String url;

    public URLTokenizer(String url) {
        this.url = url;
    }

    private String removeProtocol(String address) {
        if (address.contains("://")) {
            address = address.split("://")[1];
        }

        return address;
    }

    private String removePath(String address) {
        if (address.contains("/")) {
            address = address.split("/")[0];
        }
        return address;
    }

    public String getDomain() {
        String domain = url;

        domain = removeProtocol(domain);
        domain = removePath(domain);

        return domain;
    }

    public String getPath() {
        String path = "";
        String temp = url;
        temp = removeProtocol(temp);
        if (temp.contains("/")) {
            path = temp.split("/")[1];
        }

        return path;
    }

}
