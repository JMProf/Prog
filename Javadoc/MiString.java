public class MiString {

    private char[] caracteres;

    
    public MiString(String cadena) {
        this.caracteres = cadena.toCharArray();
    }

    
    public int longitud() {
        return caracteres.length;
    }

    
    public char obtenerCaracter(int indice) {
        if (indice < 0 || indice >= caracteres.length) {
            throw new IndexOutOfBoundsException("Índice fuera de rango.");
        }
        return caracteres[indice];
    }

    
    public MiString concatenar(MiString otraCadena) {
        char[] nuevaCadena = new char[caracteres.length + otraCadena.longitud()];
        System.arraycopy(caracteres, 0, nuevaCadena, 0, caracteres.length);
        System.arraycopy(otraCadena.caracteres, 0, nuevaCadena, caracteres.length, otraCadena.longitud());
        return new MiString(new String(nuevaCadena));
    }

    
    public MiString aMinusculas() {
        char[] nuevaCadena = new char[caracteres.length];
        for (int i = 0; i < caracteres.length; i++) {
            nuevaCadena[i] = Character.toLowerCase(caracteres[i]);
        }
        return new MiString(new String(nuevaCadena));
    }

    
    public MiString aMayusculas() {
        char[] nuevaCadena = new char[caracteres.length];
        for (int i = 0; i < caracteres.length; i++) {
            nuevaCadena[i] = Character.toUpperCase(caracteres[i]);
        }
        return new MiString(new String(nuevaCadena));
    }

    
    public boolean contiene(MiString subcadena) {
        return new String(caracteres).contains(new String(subcadena.caracteres));
    }

    
    public MiString subcadena(int inicio, int fin) {
        if (inicio < 0 || fin > caracteres.length || inicio > fin) {
            throw new IndexOutOfBoundsException("Índices de subcadena fuera de rango.");
        }
        char[] subcadena = new char[fin - inicio];
        System.arraycopy(caracteres, inicio, subcadena, 0, subcadena.length);
        return new MiString(new String(subcadena));
    }

    
    public MiString reemplazar(char antiguo, char nuevo) {
        char[] nuevaCadena = new char[caracteres.length];
        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == antiguo) {
                nuevaCadena[i] = nuevo;
            } else {
                nuevaCadena[i] = caracteres[i];
            }
        }
        return new MiString(new String(nuevaCadena));
    }

    
    public char[] toArray() {
        return caracteres.clone();
    }

    
    @Override
    public String toString() {
        return new String(caracteres);
    }
}
