package CSVfiles;

import Entity.Client;
import Entity.Facture;
import Entity.Facture_Product;
import Entity.Product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVreader {

        public List<Client> readFileClient() {
                List<Client> clients = new ArrayList<>();
                String csvFile = ".\\src\\main\\java\\CSVfiles\\clientes.csv";
                String line = "";
                String cvsSplitBy = ",";

                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                        while ((line = br.readLine()) != null) {
                                // Usamos la coma como separador
                                String[] datos = line.split(cvsSplitBy);
                                Client c = new Client(Integer.parseInt(datos[0]), datos[1], datos[2]);
                                clients.add(c);
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return clients;
        }

        public List<Product> readFileProduct() {
                List<Product> products = new ArrayList<>();
                String csvFile = ".\\src\\main\\java\\CSVfiles\\productos.csv";
                String line = "";
                String cvsSplitBy = ",";

                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                        while ((line = br.readLine()) != null) {
                                // Usamos la coma como separador
                                String[] datos = line.split(cvsSplitBy);
                                Product p = new Product(Integer.parseInt(datos[0]), datos[1], Float.parseFloat(datos[2]));
                                products.add(p);
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return products;
        }

        public List<Facture> readFileFacture() {
                List<Facture> factures = new ArrayList<>();
                String csvFile = ".\\src\\main\\java\\CSVfiles\\facturas.csv";
                String line = "";
                String cvsSplitBy = ",";

                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                        while ((line = br.readLine()) != null) {
                                // Usamos la coma como separador
                                String[] datos = line.split(cvsSplitBy);
                                Facture f = new Facture(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]));
                                factures.add(f);
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return factures;
        }

        public List<Facture_Product> readFileFactureProduct() {
                List<Facture_Product> factures_products = new ArrayList<>();
                String csvFile = ".\\src\\main\\java\\CSVfiles\\facturas-productos.csv";
                String line = "";
                String cvsSplitBy = ",";

                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                        while ((line = br.readLine()) != null) {
                                // Usamos la coma como separador
                                String[] datos = line.split(cvsSplitBy);
                                Facture_Product f = new Facture_Product(Integer.parseInt(datos[0]),
                                        Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));
                                factures_products.add(f);
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return factures_products;
        }
}

