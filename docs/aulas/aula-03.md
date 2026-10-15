# Aula 03: Modularização

> Origem: `aula-03.mp3`.
Notas extraídas da análise do áudio pelo Gemini, com limpeza dos marcadores visuais e normalização das fórmulas. Não são transcrição literal.

### 1. Módulos e modularidade

Módulo é uma unidade que integra um sistema maior e agrupa classes ou funções relacionadas a um propósito. Modularidade organiza o software em unidades coesas, com interfaces definidas.

Uma boa divisão facilita compreensão, manutenção, evolução e reutilização. A independência deve ser entendida como isolamento das responsabilidades e controle de dependências, não ausência de qualquer interação.

### 2. Evolução histórica

A aula aborda os problemas de fluxo irrestrito com GOTO e código difícil de manter, a evolução para linguagens estruturadas e organização em módulos, como Modula e Ada, e a posterior consolidação de classes, pacotes e namespaces.

No Java, são discutidos:
- Pacotes: organização de nomes e agrupamento de classes.
- JARs: distribuição de conjuntos de classes, com possíveis conflitos de class loading.
- JPMS, introduzido no Java 9: declaração de módulos e controle de dependências e exposição de pacotes.

Nota de revisão: a cronologia exata atribuída aos JARs no resumo automático não foi confirmada; o ponto central é distinguir pacote, artefato de distribuição e módulo.

### 3. Coesão e acoplamento

Coesão mede a relação entre os elementos internos de uma unidade. Alta coesão significa que os elementos trabalham para uma responsabilidade bem delimitada.

Acoplamento mede dependências entre unidades. Baixo acoplamento reduz propagação de mudanças e facilita testes e evolução independente.

Alta coesão costuma favorecer uma divisão mais clara, mas essas propriedades devem ser avaliadas separadamente.

### 4. Tipos de coesão

Da mais forte à mais fraca na classificação apresentada:
- Funcional: todos os elementos contribuem para uma única função, como cálculo financeiro.
- Sequencial: a saída de uma operação alimenta a seguinte.
- Comunicacional: operações relacionadas aos mesmos dados de entrada ou saída.
- Procedimental: operações agrupadas por uma ordem obrigatória de execução.
- Temporal: operações realizadas no mesmo período, como inicialização.
- Lógica: operações agrupadas por categoria, apesar de responsabilidades distintas; uma classe de utilidades pode exemplificar esse caso.
- Coincidente ou acidental: elementos sem relação funcional agrupados arbitrariamente.

### 5. LCOM

Lack of Cohesion of Methods é uma família de métricas para estimar falta de coesão entre métodos e atributos.

LCOM alto sugere responsabilidades misturadas e oportunidade de dividir uma classe. LCOM baixo sugere maior compartilhamento e colaboração. A fórmula depende da variante utilizada; a métrica é um sinal para análise, não uma regra automática de refatoração.

### 6. Acoplamento, abstração e instabilidade

Ca — acoplamento aferente:
Quantidade de unidades externas que dependem do módulo; dependências de entrada, ou fan-in.

Ce — acoplamento eferente:
Quantidade de unidades externas das quais o módulo depende; dependências de saída, ou fan-out.

Abstração A:
Proporção de interfaces e classes abstratas em relação ao total considerado. Vai de 0, totalmente concreto, a 1, totalmente abstrato.

Instabilidade I:
I = Ce / (Ce + Ca)

Vai de 0 a 1 quando o denominador é diferente de zero. Um módulo com muitos dependentes tende a ser mais estável no sentido de ser mais custoso alterá-lo. Instabilidade aqui não significa quantidade de bugs.

### 7. Main Sequence de Robert Martin

O diagrama relaciona abstração e instabilidade. A linha de equilíbrio é:
A + I = 1

Zona da Dor:
Baixa abstração e baixa instabilidade. Código concreto do qual muitos dependem pode ser difícil de alterar.

Zona da Inutilidade:
Alta abstração e alta instabilidade. Pode indicar abstrações sem utilização prática.

Essas regiões ajudam a investigar o projeto; não substituem a avaliação do domínio e das responsabilidades.

### 8. Conascência — Connascence

Duas partes possuem conascência quando mudar uma exige uma mudança correspondente na outra para preservar a correção.

Tipos citados no resumo:
Estáticos:
- Nome: chamadas dependem do nome de um método ou identificador.
- Tipo: dependência do tipo de um argumento ou retorno.
- Significado/convenção: valores acordados, como 0 para sucesso e 1 para erro.

Dinâmicos:
- Execução: uma operação precisa ocorrer antes de outra.
- Tempo: sincronização e concorrência, como evitar race conditions.
- Valores: vários valores precisam mudar juntos para manter uma regra.
- Identidade: várias partes precisam referenciar a mesma entidade.

Propriedades:
- Força: dificuldade de entender e modificar a dependência.
- Localidade: dependências próximas são geralmente mais fáceis de controlar.
- Grau: quantidade de elementos afetados.

Diretrizes:
Minimizar dependências globais e fortes; encapsular dados e comportamentos relacionados; preferir interfaces estáveis. O conjunto citado nas notas não pretende ser uma enumeração exaustiva de toda a taxonomia.

## Perguntas de revisão

### 1. O que caracteriza coesão funcional?
Uma responsabilidade única apoiada por todos os elementos da unidade.

### 2. Qual a diferença entre Ca e Ce?
Ca conta quem depende do módulo; Ce conta de quem ele depende.

### 3. O que sugere LCOM alto?
Possível baixa coesão e necessidade de investigar divisão de responsabilidades.

### 4. O que é a Zona da Dor?
Código concreto e difícil de alterar por ter muitos dependentes.

### 5. O que é conascência de significado?
Dependência de uma convenção compartilhada de valores ou códigos.
