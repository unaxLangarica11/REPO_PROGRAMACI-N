public class Main {

    public static void main(String[] args) {

        // 1. Definición de Estudiantes y Asignaturas (Arrays Unidimensionales)

        String[] estudiantes = {
                "Ana García",
                "Juan Pérez",
                "María López",
                "Carlos Ruiz"
        };

        String[] asignaturas = {
                "Programacion",
                "Entornos",
                "Bases de Datos",
                "IPEi",
                "Sostenibilidad",
                "Ingles",
                "Lenguaje de Marcas",
                "Digitalizacion"
        };

        final double NOTA_NO_REGISTRADA = -1.0; // Valor para indicar que no hay nota/no está matriculado

        // 2. Array Bidimensional para Notas
        // Filas: Estudiantes (4) | Columnas: Asignaturas (8)
        double[][] notas = new double[estudiantes.length][asignaturas.length];

        // Inicializar el array de notas a -1.0 (NOTA_NO_REGISTRADA)
        for (int i = 0; i < notas.length; i++) {
            for (int j = 0; j < notas[0].length; j++) {
                notas[i][j] = NOTA_NO_REGISTRADA;
            }
        }

        // 3. Carga de Datos (Manual o a través de un bucle de entrada)
        // Ejemplo de carga:

        // Ana García (Indice 0)
        asignarNota(notas, estudiantes, asignaturas, "Ana García", "Programacion", 7.5);
        asignarNota(notas, estudiantes, asignaturas, "Ana García", "Entornos", 8.0);
        asignarNota(notas, estudiantes, asignaturas, "Ana García", "Bases de Datos", 6.5);
        asignarNota(notas, estudiantes, asignaturas, "Ana García", "IPEi", 9.0);

        // Juan Pérez (Indice 1)
        asignarNota(notas, estudiantes, asignaturas, "Juan Pérez", "Programacion", 5.0);
        asignarNota(notas, estudiantes, asignaturas, "Juan Pérez", "Entornos", 6.0);
        asignarNota(notas, estudiantes, asignaturas, "Juan Pérez", "Sostenibilidad", 7.0);
        asignarNota(notas, estudiantes, asignaturas, "Juan Pérez", "Ingles", 8.5);
        asignarNota(notas, estudiantes, asignaturas, "Juan Pérez", "Digitalizacion", 6.0);

        // María López (Indice 2)
        asignarNota(notas, estudiantes, asignaturas, "María López", "Programacion", 9.0);
        asignarNota(notas, estudiantes, asignaturas, "María López", "Bases de Datos", 7.5);
        asignarNota(notas, estudiantes, asignaturas, "María López", "Lenguaje de Marcas", 8.0);

        // Carlos Ruiz (Indice 3)
        asignarNota(notas, estudiantes, asignaturas, "Carlos Ruiz", "Programacion", 4.0);
        asignarNota(notas, estudiantes, asignaturas, "Carlos Ruiz", "Bases de Datos", 5.0);
        asignarNota(notas, estudiantes, asignaturas, "Carlos Ruiz", "Ingles", 6.0);
        asignarNota(notas, estudiantes, asignaturas, "Carlos Ruiz", "Digitalizacion", 7.0);
        asignarNota(notas, estudiantes, asignaturas, "Carlos Ruiz", "Entornos", 5.5);


        // --- 4. Cálculos y Salida de Resultados ---
        System.out.println("==================================================");
        System.out.println("           RESULTADOS CURSO 141GA                 ");
        System.out.println("==================================================");

        // A. Nota media en la asignatura de Programación
        calcularMediaAsignatura(notas, asignaturas, "Programacion", NOTA_NO_REGISTRADA);

        System.out.println("\n--------------------------------------------------");

        // B. Nota media de cada alumno/a
        calcularMediaEstudiantes(notas, estudiantes, NOTA_NO_REGISTRADA);

        System.out.println("==================================================");
    }

    // ----------------- Métodos Auxiliares -----------------

    /**
     * Busca los índices y asigna la nota en la matriz bidimensional.
     */
    private static void asignarNota(double[][] notas, String[] estudiantes, String[] asignaturas,
                                    String nombreEst, String nombreAsig, double calificacion) {

        int indiceEstudiante = -1;
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i].equals(nombreEst)) {
                indiceEstudiante = i;
                break;
            }
        }

        int indiceAsignatura = -1;
        for (int j = 0; j < asignaturas.length; j++) {
            if (asignaturas[j].equals(nombreAsig)) {
                indiceAsignatura = j;
                break;
            }
        }

        if (indiceEstudiante != -1 && indiceAsignatura != -1) {
            notas[indiceEstudiante][indiceAsignatura] = calificacion;
        } else {
            System.err.println("Error: Estudiante o Asignatura no encontrados.");
        }
    }

    /**
     * Calcula y muestra la nota media de una asignatura específica.
     */
    public static void calcularMediaAsignatura(double[][] notas, String[] asignaturas,
                                               String asignatura, double noRegistrada) {

        int indiceAsignatura = -1;
        for (int j = 0; j < asignaturas.length; j++) {
            if (asignaturas[j].equals(asignatura)) {
                indiceAsignatura = j;
                break;
            }
        }

        if (indiceAsignatura == -1) {
            System.out.println("Asignatura no encontrada.");
            return;
        }

        double sumaNotas = 0;
        int numNotas = 0;

        // Recorrer la columna de la asignatura
        for (int i = 0; i < notas.length; i++) {
            double nota = notas[i][indiceAsignatura];
            if (nota != noRegistrada) {
                sumaNotas += nota;
                numNotas++;
            }
        }

        if (numNotas > 0) {
            double media = sumaNotas / numNotas;
            System.out.printf("👉 Nota Media en **%s**: %.2f (basada en %d notas)\n",
                    asignatura, media, numNotas);
        } else {
            System.out.println("No hay notas registradas para la asignatura de " + asignatura);
        }
    }

    /**
     * Calcula y muestra la nota media de cada estudiante.
     */
    public static void calcularMediaEstudiantes(double[][] notas, String[] estudiantes, double noRegistrada) {
        System.out.println("Notas medias de cada estudiante:");

        // Recorrer las filas (estudiantes)
        for (int i = 0; i < estudiantes.length; i++) {
            double suma = 0;
            int contador = 0;

            // Recorrer las columnas (asignaturas) para el estudiante actual
            for (int j = 0; j < notas[i].length; j++) {
                double nota = notas[i][j];
                if (nota != noRegistrada) {
                    suma += nota;
                    contador++;
                }
            }

            double media = (contador > 0) ? (suma / contador) : 0.0;

            System.out.printf("  * **%s**: %.2f (de %d asignaturas)\n",
                    estudiantes[i], media, contador);
        }
    }
}