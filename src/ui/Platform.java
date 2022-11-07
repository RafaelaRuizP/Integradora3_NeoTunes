package ui;
import java.util.*;
import model.NeoTunes;
public class Platform {
    public static Scanner reader=new Scanner(System.in);
    NeoTunes neoController;
    public Platform(){
        neoController = new NeoTunes();
    }
    public static void main(String[] args){
        Platform objIni = new Platform();
        int escoger = 0;

        while(escoger != 6) {
            System.out.println("Menu");
            System.out.println("1. Agregar usuario consumidor");
            System.out.println("2. Agregar usuario productor");
            System.out.println("3. Registrar canciones y podcast");
            System.out.println("4. Crear una lista de reproducción");
            System.out.println("5. Editar una lista de reproducción");
            System.out.println("6. Cerrar menu");
            System.out.print("Opcion: ");
            escoger = reader.nextInt();
            reader.nextLine();

            switch(escoger) {
                case 1:
                    objIni.registerConsumer();
                    break;
                case 2:
                    objIni.registerProducer();
                    break;
                case 3:
                    objIni.addAudio();
                    break;

                case 4:
                    objIni.createPlaylist();
                    break;

                case 5:
                    objIni.editPlaylist();
                    break;
                
                case 6:
                    System.out.println("Cerrando menu...");
                    break;

                default:
                    System.out.println("No escogiste bien.");
                    break;
            }
        }
    }

    public void registerConsumer(){
        Calendar iniDate = Calendar.getInstance();
        System.out.println("Apodo/nickname: ");
        String nickname= reader.nextLine();
        String cc="";
        do {
            System.out.println("Número de cédula: ");
            cc= reader.nextLine();
        } while (neoController.search(cc)==true);

        System.out.println("Tipo de usuario consumidor: \n"+
        "1. Standar \n"+
        "2. Premium \n"+
        "Opción: ");
        int opcion1 =reader.nextInt();
        reader.nextLine();
        System.out.println(neoController.addUser(nickname, cc, iniDate, opcion1)); 
        System.out.println("Usuario agregado con exito\n");
        System.out.println("Quieres ver tus datos?: \n1.Si \n2.No");
        int datos1= reader.nextInt();
        switch (datos1) {
            case 1:
                System.out.println(neoController.giveInformationPeople());
                break;
            default:
                break;
        }
    }

    public void registerProducer(){
        Calendar iniDate = Calendar.getInstance();
        System.out.println("Apodo/nickname: ");
        String nickname= reader.nextLine();
        String cc="";
        do {
            System.out.println("Número de cédula: ");
            cc= reader.nextLine();
        } while (neoController.search(cc)==true);
        System.out.println("Nombre: ");
        String name= reader.nextLine();
        System.out.println("URL de la imagen de perfil: ");
        String url=reader.nextLine();

        System.out.println("Tipo de usuario productor: \n"+
        "1. Artista \n"+
        "2. Creador de contenido \n"+
        "Opción: ");
        int opcion1 =reader.nextInt();
        reader.nextLine();
        System.out.println(neoController.addUser(nickname, cc, iniDate, name, url, opcion1));
        System.out.println("Usuario agregado con exito\n");
        System.out.println("Quieres ver tus datos?: \n1.Si \n2.No");
        int datos1= reader.nextInt();
        switch (datos1) {
            case 1:
                System.out.println( neoController.giveInformationPeople());
                break;
            default:
                break;
        }
    }

    public void addAudio(){
        String show="";
        String name="", url="";
        double length=0;
        int i=0, numRep=0;
        System.out.println("El usuario al que le pertenece el contenido es: \n"+
        "1. Artista \n"+
        "2. Creador de contenido \n"+
        "Opción: ");
        int opcion1 =reader.nextInt();
        reader.nextLine();
        
        switch (opcion1) {
            case 1:
                System.out.println("Escoger artista:");
                show= neoController.showArtists();
                System.out.println(show);
                if(!show.equalsIgnoreCase("")){
                    i= reader.nextInt();
                    reader.nextLine();
                    System.out.println("==Datos de la canción ha agregar==");
                    System.out.println("Nombre de la canción: ");
                    name= reader.nextLine();
                    System.out.println("Url de la carátula del álbum al que pertenece la canción: ");
                    url= reader.nextLine();
                    System.out.println("Nombre del Album al que pertence: ");
                    String album= reader.nextLine();
                    reader.nextLine();
                    System.out.println("Duración de la canción: ");
                    length= reader.nextDouble();
                    System.out.println("Número de reproducciones: ");
                    numRep=reader.nextInt();
                    System.out.println("Número de veces vendida: ");
                    int numSold = reader.nextInt();
                    System.out.println("Género: "+ neoController.showListGenres() +"\nOpcion: ");
                    int genre = reader.nextInt();
                    System.out.println("Precio de venta de la canción: ");
                    double price= reader.nextDouble();
                    System.out.println(neoController.addContent(name, url, length, numRep, album, price, numSold, genre, i));
                    System.out.println("Ver datos...");
                    System.out.println(neoController.giveInformationAudios());
                }
                System.out.println("No hay artistas aún registrados para almacenar su contenido. ");
                break;

            case 2:
                System.out.println("Escoger creador de contenido:");
                show=neoController.showCreators();
                System.out.println(show);
                if(!show.equalsIgnoreCase("")){
                    i= reader.nextInt();
                    reader.nextLine();
                    System.out.println("==Datos del podcast ha agregar==");
                    System.out.println("Nombre del podcast: ");
                    name= reader.nextLine();
                    System.out.println("Url de la imágen representativa del podcast: ");
                    url= reader.nextLine();
                    System.out.println("Descripción del podcast: ");
                    String desc= reader.nextLine();
                    reader.nextLine();
                    System.out.println("Duración del podcast: ");
                    length= reader.nextDouble();
                    System.out.println("Número de reproducciones: ");
                    numRep=reader.nextInt();
                    System.out.println("Categoría: "+ neoController.showListCategories() +"\nOpcion: ");
                    int category = reader.nextInt();
                    System.out.println(neoController.addContent(name, url, length, numRep, desc, category, i));
                    System.out.println("Ver datos...");
                    System.out.println(neoController.giveInformationAudios());
                }
                System.out.println("No hay creadores de contenidos aún registrados para almacenar su contenido. ");
                break;
            
            default:
                break;
        }
    }

    public void createPlaylist(){
        System.out.println("Consumidor de tipo: 1.Standar\n 2.Premium \nOpción: ");
        int opcion= reader.nextInt();
        reader.nextLine();
        System.out.println("Identificación del usuario: ");
        String cc= reader.nextLine();
        System.out.println("Nombre de la playlist: ");
        String name= reader.nextLine();
        System.out.println(neoController.addPlaylist(name, cc, opcion));
    }

    public void editPlaylist(){
        System.out.println("Id de la playlist: ");
        int id= reader.nextInt();
        System.out.println("Qué quieres editar en la playlist?:"+"\n"+
        "1. Editar nombre. "+"\n"+
        "2. Agregar audios."+"\n"+
        "3. Quitar audios"+"\n"+
        "Opción: ");
        int opcion= reader.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Nombre nuevo para la playlist: ");
                String name= reader.nextLine();
                System.out.println(neoController.editPlaylist(name, opcion, id));
                break;
            case 2:
                String obj= neoController.search(id).getName();
                System.out.println(neoController.editPlaylist(obj, opcion, id));
                break;
            case 3:
                String obj2= neoController.search(id).getName();
                System.out.println(neoController.editPlaylist(obj2, opcion, id));
            default:
                break;
        }
    }
}
