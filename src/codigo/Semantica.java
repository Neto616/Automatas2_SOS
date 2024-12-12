package codigo;

public class Semantica {
    private final SymbolTable tablaSimbolos = new SymbolTable();
    
    public boolean existe(String token){
        return tablaSimbolos.exists(token);
    }
    
    public boolean isInteger(String numero){
        try{
            Integer.parseInt(numero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    public boolean isIdentifier(String id){
        String regex = "^[a-zA-Z_]+$";
        return id.matches(regex);
    }
    
    public boolean isDecimal(String numero) {
        String regex = "^-?\\d+\\.\\d+$";
        if (numero.matches(regex)) {
        try {
            Double.parseDouble(numero); // Confirmamos que puede ser parseado como decimal
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    return false; // No cumple el formato de un decimal forzado
    }
    
    public boolean isBool (String opt){
        return opt.equalsIgnoreCase("verdadero") || opt.equalsIgnoreCase("falso");
    }
    
    public boolean isString (String opt){
        return opt != null && !opt.trim().isEmpty() && opt.startsWith("\"") && opt.endsWith("\"");
    }
    
    public void vaciarTabla(){
        tablaSimbolos.dropTable();
    }
    
    public void verifVariable (String tipoDato, String ide, String valor) throws ErrorSemantica{
        if(tipoDato == null || "".equals(tipoDato)){ throw new Error("Agregar algun tipo de dato a la variable");}
        if(valor == null){ throw new Error("Agregar valor a la variable");}
        if(existe(ide)) {throw new Error("Ya existe una variable con el identificador"+ide);}
        
        switch(tipoDato){
            case "entero" -> {
                if(isIdentifier(valor)){
                    if(tablaSimbolos.getSymbol(valor) != null){
                        if(tablaSimbolos.getSymbol(valor).type.toString().toLowerCase().equals(tipoDato)){
                            tablaSimbolos.addSymbol(ide, SymbolTable.DataType.ENTERO, tablaSimbolos.getSymbol(valor).value);
                            System.out.println("La tabla de papu tipos: \n" + tablaSimbolos.getSymbolTable());
                            return;
                        }
                    }
                    throw new ErrorSemantica("Se esta esperando un valor entero");
                }
                if(!isInteger(valor)){
                    throw new ErrorSemantica("Se esta esperando un valor entero");
                }
                tablaSimbolos.addSymbol(ide, SymbolTable.DataType.ENTERO, valor);
            }
            case "decimal" ->{
                if(isIdentifier(valor)){
                    if(tablaSimbolos.getSymbol(valor) != null){
                        if(tablaSimbolos.getSymbol(valor).type.toString().toLowerCase().equals(tipoDato)){
                            tablaSimbolos.addSymbol(ide, SymbolTable.DataType.DECIMAL, tablaSimbolos.getSymbol(valor).value);
                            System.out.println("La tabla de papu tipos: \n" + tablaSimbolos.getSymbolTable());
                            return;
                        }
                    }
                    throw new ErrorSemantica("Se esta esperando un valor decimal");
                }
                if(!isDecimal(valor)){
                    throw new ErrorSemantica("Se esta esperando un valor decimal");
                }
                tablaSimbolos.addSymbol(ide, SymbolTable.DataType.DECIMAL, valor);
            }
            case "bool" ->{
                if(isIdentifier(valor)){
                    if(tablaSimbolos.getSymbol(valor) != null){
                        if(tablaSimbolos.getSymbol(valor).type.toString().toLowerCase().equals(tipoDato)){
                            tablaSimbolos.addSymbol(ide, SymbolTable.DataType.BOOL, tablaSimbolos.getSymbol(valor).value);
                            System.out.println("La tabla de papu tipos: \n" + tablaSimbolos.getSymbolTable());
                            return;
                        }
                    }
                    throw new ErrorSemantica("Se esta esperando un valor booleano");
                }
                if(!isBool(valor)){
                    throw new ErrorSemantica("Se esta esperando un valor booleano");
                }
                tablaSimbolos.addSymbol(ide, SymbolTable.DataType.BOOL, valor);
            }
            case "string" ->{
                if(isIdentifier(valor)){
                    if(tablaSimbolos.getSymbol(valor) != null){
                        if(tablaSimbolos.getSymbol(valor).type.toString().toLowerCase().equals(tipoDato)){
                            tablaSimbolos.addSymbol(ide, SymbolTable.DataType.STRING, tablaSimbolos.getSymbol(valor).value);
                            System.out.println("La tabla de papu tipos: \n" + tablaSimbolos.getSymbolTable());
                            return;
                        }
                    }
                    throw new ErrorSemantica("Se esta esperando un valor string");
                }
                if(!isString(valor)){
                    throw new ErrorSemantica("Se esta esperando un valor string");
                }
                tablaSimbolos.addSymbol(ide, SymbolTable.DataType.STRING, valor);
            }
        }
        System.out.println("La tabla de papu tipos: \n" + tablaSimbolos.getSymbolTable());
    }    

    /*
    1.- Entero
    0.0.- Decimal
    2.- String
    */
    public String operacion(String operadores, String expresion)throws ErrorSemantica{
        if(isString(expresion) || isBool(expresion)){
            throw new ErrorSemantica("No se puede realizar operaciones arimeticas con Strings ni buleanos :v");
        }
        
        if(operadores.equals("+") ||  operadores.equals("-") || operadores.equals("*")){
            if(isIdentifier(expresion)){
                if(tablaSimbolos.getSymbol(expresion) != null){
                    if(tablaSimbolos.getSymbol(expresion).type.toString().toLowerCase().equals("entero")){
                        return operadores+", 1";
                    }else if(tablaSimbolos.getSymbol(expresion).type.toString().toLowerCase().equals("decimal")){
                        return operadores+", 0.0";
                    }   
                }
                throw new ErrorSemantica("No se puede realizar operaciones arimeticas con Strings ni buleanos :v");
            }else{
                if(isInteger(expresion)){ return operadores+",1"; }
                if(isDecimal(expresion)){ return operadores+",0.0"; }
                 throw new ErrorSemantica("No se puede realizar operaciones arimeticas con Strings ni buleanos :v");
            }
        }else{ 
            if(isIdentifier(expresion)){
                if(tablaSimbolos.getSymbol(expresion) != null){
                    if(tablaSimbolos.getSymbol(expresion).type.toString().toLowerCase().equals("entero")
                    || tablaSimbolos.getSymbol(expresion).type.toString().toLowerCase().equals("decimal")){
                        return operadores+",0.0";
                    }   
                }
            }else{
                if(isInteger(expresion) || isDecimal(expresion)){ return operadores+",0.0"; }
                throw new ErrorSemantica("No se puede realizar operaciones arimeticas con Strings ni buleanos :v");
            }
        } return operadores+",\"2\"";
    }

    public String operando(String valor, String operacion)throws ErrorSemantica{
        String[] op = operacion.split(",");
        String operadores = op[0], valor2 = op[1];
        
        if(isString(valor) || isBool(valor) || isString(valor2) || isBool(valor2)){
            throw new ErrorSemantica("No se puede realizar operaciones arimeticas con Strings ni buleanos :v");
        }
        
        if(isIdentifier(valor)){
            if(tablaSimbolos.getSymbol(valor) != null){
                if(tablaSimbolos.getSymbol(valor).type.toString().toLowerCase().equals("entero")
                    && !valor2.equals("0.0")){
                    return "1";
                }else if(tablaSimbolos.getSymbol(valor).type.toString().toLowerCase().equals("decimal")
                    || valor2.equals("0.0")){
                    return "0.0";
                }
            }
            throw new ErrorSemantica("No coinciden los tipos de datos");
        }else{
            if(isInteger(valor) && !valor2.equals("0.0")) {return "1";}
            if(isDecimal(valor) || valor2.equals("0.0")){ return "0.0"; }        
        }
        return "\"2\"";
    }
}

    
  