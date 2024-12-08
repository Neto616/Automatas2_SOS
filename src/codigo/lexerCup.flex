package codigo;
import java_cup.runtime.Symbol;

%% 
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
letra=[a-zA-Z_]+
numero=[0-9]+
numeroDecimal=[0-9]+\.[0-9]+
tipoStr=\"[a-zA-Z_ ]+\"
espacio=[ \t\r\n]+
%{
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type) {
            return new Symbol(type, yyline, yycolumn);
    }
%}
%%

// Tipo de datos:
entero {return new Symbol(sym.entero, yychar, yyline, yytext());}
decimal {return new Symbol(sym.decimal, yychar, yyline, yytext());}
string {return new Symbol(sym.string, yychar, yyline, yytext());}
bool {return new Symbol(sym.bool, yychar, yyline, yytext());}

// Signos de operación
"=" {return new Symbol(sym.igual, yychar, yyline, yytext());}
"+" {return new Symbol(sym.suma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.resta, yychar, yyline, yytext());}
"/" {return new Symbol(sym.division, yychar, yyline, yytext());}
"*" {return new Symbol(sym.producto, yychar, yyline, yytext());}

// Signos de comparación
"<" {return new Symbol(sym.menorQue, yychar, yyline, yytext());}
">" {return new Symbol(sym.mayorQue, yychar, yyline, yytext());}
"<=" {return new Symbol(sym.menorIgual, yychar, yyline, yytext());}
">=" {return new Symbol(sym.mayorIgual, yychar, yyline, yytext());}
"&" {return new Symbol(sym.y, yychar, yyline, yytext());}
"|" {return new Symbol(sym.o, yychar, yyline, yytext());}
"!" {return new Symbol(sym.no, yychar, yyline, yytext());}
"==" {return new Symbol(sym.igualA, yychar, yyline, yytext());}
"!=" {return new Symbol(sym.diferenteA, yychar, yyline, yytext());}
"true" {return new Symbol(sym.verdadero, yychar, yyline, yytext());}
"false" {return new Symbol(sym.falso, yychar, yyline, yytext());}

// Palabras o signos reservados
";" {return new Symbol(sym.finLinea, yychar, yyline, yytext());}
"print" {return new Symbol(sym.imprimir, yychar, yyline, yytext());}
"'" {return new Symbol(sym.comillaSimple, yychar, yyline, yytext());}
\" {return new Symbol(sym.comillaDoble, yychar, yyline, yytext());}
"(" {return new Symbol(sym.parentesisA, yychar, yyline, yytext());}
")" {return new Symbol(sym.parentesisC, yychar, yyline, yytext());}
"{" {return new Symbol(sym.llaveA, yychar, yyline, yytext());}
"}" {return new Symbol(sym.llaveC, yychar, yyline, yytext());}
"main" {return new Symbol(sym.funcMain, yychar, yyline, yytext());}
"si" {return new Symbol(sym.si, yychar, yyline, yytext());}
"sino" {return new Symbol(sym.sino, yychar, yyline, yytext());}
"mientras" { return new Symbol(sym.mientras, yychar, yyline, yytext()); }


// Léxico general
{espacio} {/* ignora */}
{letra} {return new Symbol(sym.letra, yychar, yyline, yytext());}
{numero} {return new Symbol(sym.numero, yychar, yyline, yytext());}
{numeroDecimal} {return new Symbol(sym.numeroDecimal, yychar, yyline, yytext());}
{tipoStr} {return new Symbol(sym.tipoStr, yychar, yyline, yytext());}
. {return new Symbol(sym.ERROR, yychar, yyline, yytext());}
