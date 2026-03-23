package EjerciciosColecciones.Impresora;

import java.util.LinkedList;
import java.util.Queue;

public class ImpresoraOnline {

    static final String ID_MAQUINA = "PC3493";

    static Queue<Peticion> cola = new LinkedList<>();

    /// Este metodo es para añadir documentos, lo qeu hacemos es un if para comprobar que el nombre del archivo termina en
    /// ". pdf" y si es asi sale y se va al for que comprueba en la lista si ya está,
    /// si el id es igual al id de la máquina y el nombre de la peticion es igual al nombre del archivo entonces la peticion ya existe
    /// si nada de eso se cumple se añade una nueva peticion a la cola
    public static void anyadirDocumento(String nombreArchivo){

        if(!nombreArchivo.endsWith(".pdf")){
            System.out.println("El archivo " + nombreArchivo + " no es un pdf. No se puede añadir a la cola");
            return;
        }

        for(Peticion peticion : cola){
            //Si ya existe con el mismo nombre y la maquina entonces ya existe
            if(peticion.getId().equals(ID_MAQUINA) && peticion.getNombre().equals(nombreArchivo)){
                System.out.println("La petición ya existe");
                return;
            }
        }

        Peticion nueva = new Peticion(ID_MAQUINA, nombreArchivo);
        cola.add(nueva);

        System.out.println("Documento añadido: " + nombreArchivo);
    }

    /// Solo imprime la cola, no tiene mucho misterio, si la peticion es igual a null es que no hay una peticion en la cola
    public static void imprimirDocumento(){

        Peticion peticion = cola.poll();

        if(peticion == null){
            System.out.println("No hay documentos");
        }else{
            System.out.println("Imprimiendo: " + peticion.getNombre());
        }

    }

    /// ,size para obtener el numero total de peticiones
    public static int ObtenerNumPeticiones(){
        return cola.size();
    }

    /// Un for que me enseña lo que hay dentro de la cola
    public static void verInfo(){

        for(Peticion peticion : cola){
            System.out.println(peticion);
        }

    }

    /// NI lo entiendo pero es un while que llama al metodo imprimirDocumento
    public static void imprimirTodo(){

        while(!cola.isEmpty()){
            imprimirDocumento();
        }

    }
}