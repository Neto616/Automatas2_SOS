package codigo;

import java.util.Stack;

public class SemanticAnalyzer {
    private SymbolTable symbolTable;
    private Stack<String> typeStack;
    private StringBuilder errors;

    public SemanticAnalyzer() {
        symbolTable = new SymbolTable();
        typeStack = new Stack<>();
        errors = new StringBuilder();
    }

    public void analyzeToken(Tokens token, String lexeme) {
        switch (token) {
            case entero:
            case decimal:
            case string:
            case bool:
                pushType(token.name().toLowerCase());
                break;
            case letra:
                if (!typeStack.isEmpty()) {
                String type = typeStack.pop(); // Obtener el tipo
                declareVariable(lexeme, type);
            } else {
                addError("Error: No se encontró un tipo para la variable '" + lexeme + "'.");
            }
                break;
            case igual:
                break;
        }
    }

    public boolean hasErrors() {
        return errors.length() > 0;
    }

    public void declareVariable(String name, String type) {
        if (symbolTable.exists(name)) {
            addError("Variable '" + name + "' ya ha sido declarada.");
        } else {
            symbolTable.addSymbol(name, SymbolTable.DataType.valueOf(type.toUpperCase()), null);
        }
    }

    public void checkVariableUsage(String name) {
        if (!symbolTable.exists(name)) {
        addError("Variable '" + name + "' no ha sido declarada.");
    } else {
        if (!typeStack.isEmpty()) {
            String type = symbolTable.getSymbol(name).type.name().toLowerCase();
            typeStack.push(type);
        } else {
            addError("Error: No hay tipo disponible en la pila para la variable '" + name + "'.");
        }
    }
    }

    public void checkAssignment(String name, String expectedType) {
        if (!symbolTable.exists(name)) {
            addError("Variable '" + name + "' no ha sido declarada.");
        } else {
            String actualType = typeStack.pop();
            if (!actualType.equals(expectedType)) {
                addError("Tipo incompatible en asignación a '" + name + "'. Se esperaba " + expectedType + ", se encontró " + actualType);
            }
        }
    }

    public void checkArithmeticOperation(String operation) {
        String right = typeStack.pop();
        String left = typeStack.pop();
        if (!right.equals("entero") || !left.equals("entero")) {
            addError("Operación aritmética '" + operation + "' requiere operandos enteros.");
        }
        typeStack.push("entero");
    }

    public void checkComparison(String operation) {
        String right = typeStack.pop();
        String left = typeStack.pop();
        if (!right.equals(left)) {
            addError("Comparación '" + operation + "' requiere operandos del mismo tipo.");
        }
        typeStack.push("bool");
    }

    public void checkConditional() {
        String conditionType = typeStack.pop();
        if (!conditionType.equals("bool")) {
            addError("La condición en una estructura 'si' debe ser de tipo booleano.");
        }
    }

    public void pushType(String type) {
        typeStack.push(type);
    }

    public void addError(String message) {
        errors.append(message).append("\n");
    }

    public String getErrors() {
        return errors.toString();
    }

    public String getSymbolTable() {
        return symbolTable.getSymbolTableFrame();
    }
}
