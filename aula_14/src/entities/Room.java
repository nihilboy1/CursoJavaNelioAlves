package entities;

public class Room{
    private String tenantName;
    private String tenantEmail;
    private int number;

    public Room(String tenantName, String tenantEmail, int number){
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.number = number;
    }

    public String getTenantName(){
        return tenantName;
    }

    public String getTenantEmail(){
        return tenantEmail;
    }

    public int getNumber(){
        return number;
    }

    public void showData(){
        System.out.printf("%d: %s, %s \n", this.number, this.tenantName, this.tenantEmail);
    }

    @Override
    public String toString(){
        return number + ": " +  tenantName + ", " + tenantEmail;
    }
}
