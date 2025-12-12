package Player;

public class player {
    private String name;
    private int age;
    private String address;
    private String contactNo;
    private String email;
    private char playerSymbol;

    public void setPlayerDetails(String name, int age, String address, String contactNo, String email, char playerSymbol){
        this.name = name;
        this.age = age;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
        this.playerSymbol = playerSymbol;
    }

    public void setPlayerNameAge(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setPlayerNameEmailSymbolAge(String name,String email, char playerSymbol, int age){
        this.name = name;
        this.playerSymbol = playerSymbol;
        this.age = age;
    }

    public void setPlayerNameSymbol(String name, char playerSymbol){
        this.name = name;
        this.playerSymbol = playerSymbol;
    }

    public String getPlayerName(){
        return this.name;
    }

    public char getPlayerSymbol(){
        return this.playerSymbol;
    }

    public void getPlayerDetails(){
        System.out.println("Player Name : " + this.name);
        System.out.println("Player age : " + this.age);
        System.out.println("Player Symbol : " + this.playerSymbol);
        System.out.println("Player Emailid: " + this.email);
        System.out.println("Player address : " + this.address);
        System.out.println("Player contactNo : " + this.contactNo);
    }

    public void changeSymbol(char playerSymbol){
        this.playerSymbol = playerSymbol;
    }

    public void getPlayerNameandSymbol(){
        System.out.println("Player Name : " + this.name);
        System.out.println("Player Symbol : " + this.playerSymbol);
    }

}

