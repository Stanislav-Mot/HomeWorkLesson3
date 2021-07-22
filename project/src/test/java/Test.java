public class Test {
    public static void main(String[] args){
        Options.Run();
        Options.testLogin(Options.EMAIL, Options.PASSWORD);
        Options.testAddAddress(Options.map);
        Options.testEditAddress(Options.COUNTRY);
        Options.testDeleteAddress();
        Options.testLogout();
        Options.quit();
    }
}