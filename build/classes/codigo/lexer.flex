package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens

coma = ","
espacio=[ \t\r]+
letra=[a-zA-Z_]+
tipoStr = \"[a-zA-Z0-9 !¡?¿@#\$\(/=\|°]*\"
numero=[0-9]+
numeroDecimal=[0-9]+\.[0-9]+
%{
    public String lexer;
%}
%%
"entero" {lexer= yytext(); return entero;}
"decimal" {lexer= yytext(); return decimal;}
"string" {lexer= yytext(); return string;}
"buleano" {lexer= yytext(); return bool;}
{coma} {lexer= yytext(); return coma;}
"=" {lexer= yytext(); return igual;}
"+" {lexer= yytext(); return suma;}
"-" {lexer= yytext(); return resta;}
"/" {lexer= yytext(); return division;}
"*" {lexer= yytext(); return producto;}
"." {lexer= yytext(); return punto;}
"<" {lexer= yytext(); return menorQue;}
">" {lexer= yytext(); return mayorQue;}
"<=" {lexer= yytext(); return menorIgual;}
">=" {lexer= yytext(); return mayorIgual;}
"&" {lexer= yytext(); return y;}
"|" {lexer= yytext(); return o;}
"!" {lexer= yytext(); return no;}
"==" {lexer= yytext(); return igualA;}
"!=" {lexer= yytext(); return diferenteA;}
"true" {lexer= yytext(); return verdadero;}
"false" {lexer= yytext(); return falso;}
";" {lexer= yytext(); return finLinea;}
"print" {lexer= yytext(); return imprimir;}
"'" {lexer= yytext(); return comillaSimple;}
\" {lexer= yytext(); return comillaDoble;}
"(" {lexer= yytext(); return parentesisA;}
")" {lexer= yytext(); return parentesisC;}
"{" {lexer= yytext(); return llaveA;}
"}" {lexer= yytext(); return llaveC;}
"main" {lexer= yytext(); return funcMain;}
"if" {lexer= yytext(); return si;}
"else" {lexer= yytext(); return sino;}
"while" {lexer= yytext(); return cicloMientras;}
"\n" {return linea;}
{espacio} {/*ignora*/}
{letra} {lexer= yytext(); return letra;}
{numero} {lexer= yytext(); return numero;}
{numeroDecimal} {lexer= yytext(); return numeroDecimal;}
{tipoStr} {lexer= yytext(); return tipoStr;}
. {lexer= yytext(); return error;}