package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Clase principal para generar los archivos necesarios para el análisis léxico y sintáctico.
 * 
 * @author ben10
 */
public class Main {
    public static void main(String[] args) {
        try {
            // Rutas de entrada
            String ruta1 = "C:/Users/ben10/OneDrive/Documents/NetBeansProjects/COMPILADOR_AUTOMATAS2/src/codigo/lexer.flex";
            String ruta2 = "C:/Users/ben10/OneDrive/Documents/NetBeansProjects/COMPILADOR_AUTOMATAS2/src/codigo/lexerCup.flex";
            String[] rutaS = {"-parser", "Sintax", "C:/Users/ben10/OneDrive/Documents/NetBeansProjects/COMPILADOR_AUTOMATAS2/src/codigo/Sintax.cup"};
            
            // Generar los archivos
            generar(ruta1, ruta2, rutaS);
        } catch (Exception e) {
            System.err.println("Error durante la generación: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception {
        generarLexer(ruta1);
        generarLexer(ruta2);
        generarParser(rutaS);
        moverArchivosGenerados();
    }

    private static void generarLexer(String ruta) throws IOException {
        File archivo = new File(ruta);
        System.out.println("Generando Lexer desde: " + ruta);
        JFlex.Main.generate(archivo);
    }

    private static void generarParser(String[] rutaS) throws Exception {
        System.out.println("Generando Parser...");
        java_cup.Main.main(rutaS);
    }

    private static void moverArchivosGenerados() throws IOException {
        moverArchivo("C:/Users/ben10/OneDrive/Documents/NetBeansProjects/COMPILADOR_AUTOMATAS2/sym.java", 
                     "C:/Users/ben10/OneDrive/Documents/NetBeansProjects/COMPILADOR_AUTOMATAS2/src/codigo/sym.java");
        moverArchivo("C:/Users/ben10/OneDrive/Documents/NetBeansProjects/COMPILADOR_AUTOMATAS2/Sintax.java", 
                     "C:/Users/ben10/OneDrive/Documents/NetBeansProjects/COMPILADOR_AUTOMATAS2/src/codigo/Sintax.java");
    }

    private static void moverArchivo(String origen, String destino) throws IOException {
        Path rutaOrigen = Paths.get(origen);
        Path rutaDestino = Paths.get(destino);
        
        if (Files.exists(rutaDestino)) {
            Files.delete(rutaDestino);
        }
        
        if (Files.exists(rutaOrigen)) {
            Files.move(rutaOrigen, rutaDestino);
            System.out.println("Archivo movido: " + origen + " a " + destino);
        } else {
            System.err.println("El archivo origen no existe: " + origen);
        }
    }
}
