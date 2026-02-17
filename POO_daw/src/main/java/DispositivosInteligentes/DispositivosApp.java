//package DispositivosInteligentes;
//
//import interfaces.Superman;
//
//import java.util.ArrayList;
//
//public class DispositivosApp {
//    static void main() {
//        Televisor Samsung = new Televisor("Samsung", false);
//        ParlanteInteligente LG = new ParlanteInteligente("LG", false);
//        AireAcondicionado Hisense = new AireAcondicionado("Hisense", false);
//
//
//        ArrayList<Dispositivo> listaDispositivos = new ArrayList<>();
//        listaDispositivos.add(Samsung);
//        listaDispositivos.add(LG);
//        listaDispositivos.add(Hisense);
//
//
//        Samsung.encender();
//        LG.encender();
//        Hisense.encender();
//
//        Samsung.sincronizar();
//        Hisense.sincronizar();
//
//        Samsung.mostrarEstado();
//        LG.mostrarEstado();
//        Hisense.mostrarEstado();
//
//        Samsung.apagar();
//        LG.apagar();
//        Hisense.apagar();
//
//        Dispositivo proyector = new Dispositivo("Optoma", false) {
//            @Override
//            void encender() {
//                if (estado){
//                    System.out.println("El proyector ya esta encendido");
//                } else {
//                    System.out.println("Encendiendo el proyector con ajuste de billo automatico...");
//                    estado = true;
//                }
//            }
//        };
//
//        proyector.encender();
//        ControlRemoto proyector_sinc = new ControlRemoto() {
//            @Override
//            public void sincronizar() {
//                System.out.println("Sincronizando el proyector...");
//            }
//        };
//        proyector_sinc.sincronizar();
//        Dispositivo horno_ia = new Dispositivo("Ismael", false) {
//            @Override
//            void encender() {
//                if (estado){
//                    System.out.println("El horno ya esta encendido");
//                } else {
//                    System.out.println("Encendiendo el horno con ajuste de calor automatico...");
//                    estado = true;
//                }
//            }
//        };
//        horno_ia .encender();
//
//        listaDispositivos.add(proyector);
//        listaDispositivos.add(horno_ia);
//
//        for (Dispositivo dispositivo: listaDispositivos) {
//
//            dispositivo.encender();
//            dispositivo.encender();
//
//            if (dispositivo instanceof ControlRemoto){
//                ((ControlRemoto) dispositivo).sincronizar();
//            } else if (dispositivo.nombre.equals("Optoma")) {
//                proyector_sinc.sincronizar();
//            }
//
//            dispositivo.mostrarEstado();
//            dispositivo.apagar();
//            dispositivo.apagar();
//        }
//    }
//}
