# RPNStacker

## Descrição
Tasks de Compiladores 2021.2 EC

## Task 01
- Rever a Aula 07 sobre notacao pós-fixa [_reverse polish notation_]
- Implementar uma linguagem RPN stacker em Java usando uma pilha como estrutura de dados
- Programa lê um arquivo com a expressao em RPN e avalia


Exemplo de entrada:
```
10
10
+
Saida: 20
``` 

## Task 02
- Rever a Aula 11 sobre introdução à análise léxica [_scanning_]
- Evoluir o projeto da Task 01 para implementar uma _feature_ de _scanning_:
   - No geral, nosso programa lê um arquivo com a expressao em RPN e devolve a expressão avaliada;
   - A _feature_ de _scanning_ deve retornar uma lista de _tokens_;
   - A partir dessa lista de _tokens_ que é realizada a interpretacao das expressões com uma pilha;
   - A _feature_ de _scanning_ deve retornar um erro caso não reconheça um "num" [número] ou "op" [operador].

Exemplo de entrada [com sucesso]:
``` 
10
10
+

// a lista de tokens reconhecida [caso a imprima]
Token [type=NUM, lexeme=10]
Token [type=NUM, lexeme=10]
Token [type=PLUS, lexeme=+]

Saida: 20
``` 

Exemplo de entrada [com falha]:
``` 
10
s
+

Error: Unexpected character: s
``` 

## Task 03
A gramática atual da nossa RPN é a seguinte:

```
Expr = num
         |  Expr Expr op

op    = [+-/*]
num = [0-9]+
```

Agora, nossa linguagem dará suporte para variáveis (IDs), por conseguinte, temos a seguinte mudança gramatical:

```
Expr = num
         |  id
         | Expr Expr op

op    = [+-/*]
num = [0-9]+
id = ... (regra livre de identificadores a seu critério)
```

Baseado na gramática acima [incluindo ID expr], atualize o projeto Postfix para dar suporte ao uso de variaveis/ids.

Exemplos de entrada: 
``` 
10 10 +      = 20
10 y +       = 20 [onde y foi entrado com valor 10] ou seja, [y -> 10]
10 w +       = w cannot be resolved [onde w não foi entrado no mapeamento... ou seja, apenas temos o y [y -> 10]
``` 

## Aluno
Uanderson Ricardo (urfs)