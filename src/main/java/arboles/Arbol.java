package arboles;

public class Arbol {

    private NodoArbol raiz;

    public Arbol(){
        raiz = null;
    }

    public Arbol(Empleado dato) {
        raiz = new NodoArbol(dato, null, null);
    }

    public void insertar(Empleado dato) {
        if(raiz == null)
            raiz = new NodoArbol(dato, null, null);
        else
            insertar(new NodoArbol(dato, null, null), raiz);
    }

    private void insertar(NodoArbol nuevo, NodoArbol actual) {
        if(nuevo.getDato().getCodigo() < actual.getDato().getCodigo()) {
            if(actual.getIzquierdo() == null) {
                actual.setIzquierdo(nuevo);
            } else {
                insertar(nuevo, actual.getIzquierdo());
            }
        } else {
            if(actual.getDerecho() == null) {
                actual.setDerecho(nuevo);
            } else {
                insertar(nuevo, actual.getDerecho());
            }
        }
    }

    public String preOrden() {
        if(raiz == null)
            return "No hay elementos.";
        else {
            return preOrden(raiz);
        }
    }

    private String preOrden(NodoArbol actual) {
        if(actual != null) {
            return actual.getDato().toString() + preOrden(actual.getIzquierdo()) + preOrden(actual.getDerecho());
        }
        return "";
    }

    public String inOrden() {
        if(raiz == null)
            return "No hay elementos.";
        else
            return inOrden(raiz);
    }

    private String inOrden(NodoArbol actual) {
        if(actual != null)
            return inOrden(actual.getIzquierdo()) + actual.getDato().toString() + inOrden(actual.getDerecho());
        return "";
    }

    public String posOrden() {
        if(raiz == null)
            return "No hay elementos.";
        else
            return posOrden(raiz);
    }

    private String posOrden(NodoArbol actual) {
        if(actual != null)
            return posOrden(actual.getIzquierdo()) + posOrden(actual.getDerecho()) + actual.getDato().toString();
        return "";
    }
 }
