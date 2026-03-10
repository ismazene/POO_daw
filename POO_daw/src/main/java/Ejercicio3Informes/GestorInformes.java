package Ejercicio3Informes;

import java.util.HashSet;
import java.util.Stack;

public class GestorInformes {
    private Stack<Informe> pila = new Stack<>();

    public void añadirInforme(Informe informe){
        pila.push(informe);
    }

    public Informe eliminarInforme(){
        return pila.pop();
    }

    public void mostrarYDespachar(){
        while(!pila.isEmpty()){
            System.out.println(pila.pop());
        }
    }

    public int contarTiposTareas(){
        HashSet<String> tipos = new HashSet<>();

        for(Informe informe : pila){
            tipos.add(informe.getCodigo() + "-" + informe.getTipo());
        }

        return tipos.size();
    }

}