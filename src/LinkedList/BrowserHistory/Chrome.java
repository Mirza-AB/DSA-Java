package LinkedList.BrowserHistory;

public class Chrome {
    public static void main(String[] args) {
        Browser googleChrome = new Browser("google.com");
        googleChrome.visit("facebook.com");
        googleChrome.back(1);
        googleChrome.visit("apple.com");
        System.out.println(googleChrome.forward(1));
    }
}
