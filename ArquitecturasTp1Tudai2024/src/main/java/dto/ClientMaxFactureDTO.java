package dto;

public class ClientMaxFactureDTO {

    private int id;
    private String name;
    private String mail;
    private int totalFacturado;

    public ClientMaxFactureDTO(int id, String name, String mail, int totalFacturado) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.totalFacturado = totalFacturado;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public int getTotalFacturado() {
        return totalFacturado;
    }

    @Override
    public String toString() {
        return "ClientMaxFactureDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", totalFacturado=" + totalFacturado +
                '}';
    }
}
