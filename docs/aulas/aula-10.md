# Aula 10: Arquitetura Space-Based

> Origem: `aula-10.mp3`.
Notas organizadas a partir da análise do áudio pelo Gemini. Não são transcrição literal.

### 1. Problema das topologias clássicas

Instâncias web e de aplicação podem crescer enquanto todas continuam dependendo de um banco central. Esse afunilamento, descrito como pirâmide invertida, pode limitar o throughput.

Space-based busca retirar o acesso contínuo ao banco do caminho crítico de determinadas operações, usando dados e processamento distribuídos em memória.

### 2. Processing Units

Unidades de processamento contêm lógica de aplicação e dados em memória.

Componentes descritos:
- In-memory data grid/cache: acesso aos dados usados no processamento.
- Replication engine: coordenação de cópias e sincronização entre unidades.
- Data readers e writers: integração com persistência.

O middleware virtualizado apoia distribuição de requisições, replicação e gestão das unidades.

Message grid:
Distribuição ou roteamento de trabalho.

Data grid:
Gestão dos dados em memória e de sua distribuição.

### 3. Data pump e persistência

Operações podem atualizar o estado em memória e gerar informações para persistência assíncrona. Data writers gravam no armazenamento durável; readers podem carregar dados na inicialização ou recuperação.

O banco pode ficar temporariamente atrás do estado em memória. Não existe atraso universal de milissegundos ou segundos: ele depende de carga, rede, capacidade de escrita e falhas.

### 4. Vantagens pretendidas

- Escala horizontal por adição de unidades.
- Elasticidade para picos.
- Menor latência em operações apoiadas por memória.
- Distribuição de carga e possibilidade de recuperação usando réplicas.

Casos citados:
E-commerce de alta concorrência, leilões e venda de ingressos com picos muito intensos.

### 5. Limitações e riscos

- Complexidade de replicação e consistência.
- Custo e capacidade de memória.
- Rede e sincronização podem se tornar gargalos.
- Persistência precisa acompanhar a produção.
- Recuperação, durabilidade e capacidade operacional precisam ser testadas.

O resumo automático afirmou replicação imediata, crescimento quase linear e recuperação sem perda. Esses são objetivos possíveis em condições específicas, não garantias do estilo.

É necessário definir:
Quando uma operação é considerada confirmada? Quantas réplicas existem? O que ocorre se falham antes da persistência? Como evitar conflitos? Como controlar a fila de gravação?

### 6. Quando considerar

A complexidade pode ser justificável quando picos de carga e acesso a dados representam um problema central que soluções mais simples não resolvem adequadamente.

A análise deve comparar custo operacional, tolerância a divergências, durabilidade e necessidade real de throughput.

## Perguntas de revisão

### 1. Qual gargalo o estilo busca reduzir?
Dependência do banco central no caminho crítico.

### 2. Onde ocorre o processamento principal?
Nas unidades de processamento apoiadas por dados em memória.

### 3. Para que serve replicação?
Manter cópias e coordenar estado conforme as garantias escolhidas.

### 4. O que é data pump?
Mecanismo que encaminha mudanças para persistência assíncrona.

### 5. Qual exemplo pode justificar essa arquitetura?
Vendas de ingressos com concorrência e picos muito altos.
