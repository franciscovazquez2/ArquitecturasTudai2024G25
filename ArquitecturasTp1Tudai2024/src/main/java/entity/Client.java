package entity;

public class Client {
    private int idClient;
    private String name;
    private String email;

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Client(int idClient,String name, String email){
        this.idClient=idClient;
        this.name=name;
        this.email=email;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdClient() {
        return idClient;
    }


    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }


    public Client getClient(){return new Client(this.idClient,this.name,this.email);}

    @Override
    public String toString() {


        return  "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", email='" + email + "}";
    }
}
