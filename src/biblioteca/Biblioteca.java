package biblioteca;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Biblioteca {

    public static void main(String[] args) {
        JTextArea hoja = new JTextArea();
        libros libro = new libros();
        String nombre, autor, busqueda, cliente;

        int opcion, opcionModificar;
        boolean estado = true;

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Opciones\n1-Ver libros\n2-Crear libro\n3-prestar libros\n4-Devolver libro\n5-Modificar libro"));
            switch (opcion) {
                case 1:
                    hoja.setText(libro.mostrarLibros());
                    JOptionPane.showMessageDialog(null, hoja);
                    break;
                case 2:
                    nombre = JOptionPane.showInputDialog("ingrese nombre del libro");
                    autor = JOptionPane.showInputDialog("ingrese autor del libro");
                    libro.crearLibro(libro.generarCodigoLibro(nombre), nombre, autor);
                    break;
                case 3:
                    busqueda = JOptionPane.showInputDialog("ingrese nombre o código del libro a prestar");
                    if (libro.buscarxNombreCoddigo(busqueda)) {
                        cliente = JOptionPane.showInputDialog("Nombre de la persona que presta:");
                        libro.reservarLibro(cliente);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron registros en la búsqueda");

                    }
                    break;

                case 4:
                    busqueda = JOptionPane.showInputDialog("ingrese nombre o código del libro a prestar");
                    if (libro.buscarxNombreCoddigo(busqueda)) {
                        libro.devolverLibro();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontraron registros en la búsqueda");

                    }
                    break;

                case 5:
                    opcionModificar = Integer.parseInt(JOptionPane.showInputDialog("Opciones:\n1-Modificar nombre libro\n2-Modificar autor libro"));
                    if (opcionModificar == 1) {
                        busqueda = JOptionPane.showInputDialog("ingrese nombre o código del libro a prestar");
                        if (libro.buscarxNombreCoddigo(busqueda)) {
                            nombre = JOptionPane.showInputDialog("Ingrese nuevo nombre para libro código:" + libro.getLibros()[libro.getPosicionFila()][0]);
                            libro.cambiarNombreLibro(nombre);
                        }
                    } else if (opcionModificar == 2) {
                        busqueda = JOptionPane.showInputDialog("ingrese nombre o código del libro a prestar");
                        if (libro.buscarxNombreCoddigo(busqueda)) {
                                   autor=JOptionPane.showInputDialog("ingrese nombre del autor del libro código"+libro.getLibros()[libro.getPosicionFila()][0]);
                                   libro.cambiarAutorLibro(autor);
                        }

                    }
                    break;
            }
            libro.setSalida("");
            hoja.setText(libro.getSalida());
            libro.setBusqueda(false);
        } while (estado);
    }

}
