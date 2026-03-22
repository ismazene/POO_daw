package EjerciciosColecciones.Impresora;


public class AppImpresora {

    static void main(String[] args) {

        System.out.println("**** BIENVENIDO A TU IMPRESORA ONLINE ****");

        ImpresoraOnline.anyadirDocumento("hola.txt");
        ImpresoraOnline.anyadirDocumento("doc.pdf");
        ImpresoraOnline.anyadirDocumento("doc2.pdf");
        ImpresoraOnline.anyadirDocumento("doc2.pdf");
        ImpresoraOnline.anyadirDocumento("doc3.pdf");
        ImpresoraOnline.anyadirDocumento("doc4.pdf");

        ImpresoraOnline.imprimirDocumento();

        System.out.println("Quedan " + ImpresoraOnline.ObtenerNumPeticiones() + " documentos en la cola.");

        ImpresoraOnline.verInfo();

        ImpresoraOnline.imprimirTodo();
    }
}