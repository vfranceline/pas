# Recrutamento da Guilda

Compilar e rodar (na pasta codigo-inicial):

    javac -d out $(find . -name "*.java")
    java -cp out guilda.Main

O Decorator (heróis e equipamentos) já vem pronto. Basta implementam o Filter:

- Parte 1: `CriterioClasse` e `CriterioAtaqueMinimo`
- Parte 2: `CriterioE`, `CriterioNao` e as Missões 1 e 2 no `Main`

Procure os `TODO` e compare a saída com os comentários `Esperado:` no `Main`.