package codigo;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa una tabla de símbolos para almacenar variables y sus atributos.
 */
public class SymbolTable {
    private Map<String, Symbol> symbols;

    public SymbolTable() {
        symbols = new HashMap<>();
    }

    public void addSymbol(String name, DataType type, Object value) {
        symbols.put(name, new Symbol(name, type, value));
    }

    public Symbol getSymbol(String name) {
        return symbols.get(name);
    }

    public boolean exists(String name) {
        return symbols.containsKey(name);
    }

    public String getSymbolTable() {
        StringBuilder table = new StringBuilder();
        for (Map.Entry<String, Symbol> entry : symbols.entrySet()) {
            table.append("Nombre: ").append(entry.getKey()).append(", Tipo: ").append(entry.getValue().type).append("\n");
        }
        return table.toString();
    }

    static class Symbol {
        String name;
        DataType type;
        Object value;

        public Symbol(String name, DataType type, Object value) {
            this.name = name;
            this.type = type;
            this.value = value;
        }
    }

    public enum DataType {
        ENTERO,
        DECIMAL,
        STRING,
        BOOL
    }
}
