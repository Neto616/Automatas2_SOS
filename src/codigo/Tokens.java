package codigo;

/**
 *
 * @author ben10
 */
public enum Tokens {
    // Tipo de datos
    entero,
    decimal,
    string,
    bool,
    // Signos de operación
    igual,
    suma,
    resta,
    division,
    producto,
    // Signos de comparación
    menorQue,
    mayorQue,
    menorIgual,
    mayorIgual,
    y,
    o,
    no,
    igualA,
    diferenteA,
    verdadero,
    falso,
    // Palabras reservadas
    linea,
    finLinea,
    imprimir,
    comillaSimple,
    comillaDoble,
    parentesisA,
    parentesisC,
    llaveA,
    llaveC,
    funcMain,
    si,
    sino,
    mientras,
    // Léxico
    letra,
    numero,
    numeroDecimal,
    tipoStr,
    ERROR
}