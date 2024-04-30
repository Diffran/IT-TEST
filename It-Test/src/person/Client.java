package person;

public class Client extends Person{
    private String address;

    public Client(String name, String address) {
        super(name);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString(){
        return "Client: "+super.name+" address: "+address;
    }
}
