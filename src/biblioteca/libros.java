package biblioteca;

import javax.swing.JOptionPane;

public class libros {

    private String nombre;
    private String autor;
    private String codigoLibro;
    private boolean estadoPrestamo;
    private String Libros[][];
    private String salida;
    private int ContadorLibros;
    private boolean busqueda;
    private int posicionFila;

    public libros() {
        this.Libros = new String[25][5];
        this.ContadorLibros = 0;
        salida = "";
        this.busqueda = false;
        dimensionarBiblioteca();

    }

    public void dimensionarBiblioteca() {
        for (int fila = 0; fila < 25; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                if (Libros[fila][columna] == null) {
                    Libros[fila][0] = "sin asignar";
                    Libros[fila][1] = "sin nombre";
                    Libros[fila][2] = "sin autor";
                    Libros[fila][3] = "sin asignar";
                    Libros[fila][4] = "sin registro";
                }
            }
        }
    }

    public String mostrarLibros() {
        salida += "CÓDIGO\tNOMBRE\tAUTOR\tESTADO\tPRESTADO POR\n";
        for (int fila = 0; fila < 25; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                salida += Libros[fila][columna] + "\t";
            }
            salida += "\n";
        }
        return this.salida;
    }

    public String generarCodigoLibro(String nombre) {
        String codigo;
        codigo = nombre.substring(0, 3);
        codigo += (this.ContadorLibros + 1);
        return codigo;
    }

    public void crearLibro(String codigoLibro, String nombreLibro, String autorLibro) {
        if (!codigoLibro.isEmpty() && !nombreLibro.isEmpty() && !autorLibro.isEmpty()) {
            this.Libros[ContadorLibros][0] = codigoLibro;
            this.Libros[ContadorLibros][1] = nombreLibro;
            this.Libros[ContadorLibros][2] = autorLibro;
            this.Libros[ContadorLibros][3] = "disponible";
            this.ContadorLibros++;

        } else {
            JOptionPane.showMessageDialog(null, "Error, faltan campos obligatorios");
        }

    }

    public boolean buscarxNombreCoddigo(String busqueda) {
        for (int fila = 0; fila < 25; fila++) {
            if (Libros[fila][0].equals(busqueda) || Libros[fila][1].equals(busqueda)) {
                this.posicionFila = fila;
                this.busqueda = true;
                return this.busqueda;
            }
        }
        return this.busqueda;
    }

    public void reservarLibro(String cliente) {
        if (Libros[this.posicionFila][3].equals("reservado")) {
            JOptionPane.showMessageDialog(null, "El libro ya se encuentra reservado");
        } else {
            this.Libros[this.posicionFila][3] = "reservado";
            this.Libros[this.posicionFila][4] = cliente;
        }

    }

    public void devolverLibro() {
        if (Libros[this.posicionFila][3].equals("disponible")) {
            JOptionPane.showMessageDialog(null, "El libro ya se encuentra almacenado");
        } else {
            this.Libros[this.posicionFila][3] = "disponible";
            this.Libros[this.posicionFila][4] = "sin registro";
        }
    }

    public void cambiarNombreLibro(String nombre) {
        if (!nombre.isEmpty()) {
            this.Libros[this.posicionFila][1] = nombre;
            JOptionPane.showMessageDialog(null, "Cambio con éxito!");
        } else {
            JOptionPane.showMessageDialog(null, "Nombre de libro requerido");
        }

    }

    public void cambiarAutorLibro(String autor) {
        if (!autor.isEmpty()) {
            this.Libros[this.posicionFila][2] = autor;
            JOptionPane.showMessageDialog(null, "Cambio con éxito!");
        } else {
            JOptionPane.showMessageDialog(null, "Autor de libro requerido");
        }
    }



    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }

    public boolean isBusqueda() {
        return busqueda;
    }

    public void setBusqueda(boolean busqueda) {
        this.busqueda = busqueda;
    }

    public String[][] getLibros() {
        return Libros;
    }

    public void setLibros(String[][] Libros) {
        this.Libros = Libros;
    }

    public int getContadorLibros() {
        return ContadorLibros;
    }

    public void setContadorLibros(int ContadorLibros) {
        this.ContadorLibros = ContadorLibros;
    }

    public int getPosicionFila() {
        return posicionFila;
    }

    public void setPosicionFila(int posicionFila) {
        this.posicionFila = posicionFila;
    }
    
    

}
