package codigo;

import static codigo.Tokens.*;
%% 
%class Lexer
%type Tokens
letra=[a-zA-Z_]+
numero=[0-9]+
linea = \n
numeroDecimal=[0-9]+\.[0-9]+
tipoStr=\"[a-zA-Z_ ]+\"
espacio=[ \t\r\n]+
%{
    public String lexeme;
%}
%%

// Tipo de datos específicos
(entero) { lexeme = yytext(); return entero; }
(decimal) { lexeme = yytext(); return decimal; }
(string) { lexeme = yytext(); return string; }
(bool) { lexeme = yytext(); return bool; }
 
// Signos de operación
("=") { lexeme = yytext(); return igual; }
("+") { lexeme = yytext(); return suma; }
("-") { lexeme = yytext(); return resta; }
("/") { lexeme = yytext(); return division; }
("*") { lexeme = yytext(); return producto; }

// Signos de comparación
("<") { lexeme = yytext(); return menorQue; }
(">") { lexeme = yytext(); return mayorQue; }
("<=") { lexeme = yytext(); return menorIgual; }
(">=") { lexeme = yytext(); return mayorIgual; }
("&") { lexeme = yytext(); return y; }
("|") { lexeme = yytext(); return o; }
("!") { lexeme = yytext(); return no; }
("==") { lexeme = yytext(); return igualA; }
("!=") { lexeme = yytext(); return diferenteA; }
("true") { lexeme = yytext(); return verdadero; }
("false") { lexeme = yytext(); return falso; }

// Palabras y signos reservados
(";") { lexeme = yytext(); return finLinea; }
("print") { lexeme = yytext(); return imprimir; }
"'" { lexeme = yytext(); return comillaSimple; }
\" { lexeme = yytext(); return comillaDoble; }
("(") { lexeme = yytext(); return parentesisA; }
(")") { lexeme = yytext(); return parentesisC; }
("{") { lexeme = yytext(); return llaveA; }
("}") { lexeme = yytext(); return llaveC; }
("main") { lexeme = yytext(); return funcMain; }
("si") { lexeme = yytext(); return si; }
("sino") { lexeme = yytext(); return sino; }
("mientras") { lexeme = yytext(); return mientras; }

// Léxico general
{linea} { return linea;}
{espacio} {/* ignora */}
{letra} { lexeme = yytext(); return letra; }
{numero} { lexeme = yytext(); return numero; }
{numeroDecimal} { lexeme = yytext(); return numeroDecimal; }
{tipoStr} { lexeme = yytext(); return tipoStr; }
. { lexeme = yytext(); return ERROR; }
