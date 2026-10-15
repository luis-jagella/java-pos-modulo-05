# Aula 06: Fundamentos de Estilos Arquiteturais

> Origem: `aula-06.mp3`.
Notas organizadas a partir da análise do áudio pelo Gemini. Não são transcrição literal.

### 1. Estilos e vocabulário

Um estilo descreve organização, responsabilidades e relações entre componentes. É um vocabulário compartilhado que facilita discutir o sistema, assim como padrões de projeto ajudam a discutir soluções locais.

### 2. Big Ball of Mud

Ausência de estrutura arquitetural clara: responsabilidades misturadas, dependências difíceis de entender e efeitos colaterais imprevisíveis.

Consequências:
Mudanças arriscadas, dificuldade de teste, manutenção e evolução.

Prevenção:
Modularização, responsabilidades definidas, revisões e refatorações contínuas. Adotar um nome de estilo não basta; é preciso preservar suas fronteiras.

### 3. Cliente-servidor

Modelo em que um cliente solicita funcionalidades a um servidor. A aula usa aplicações desktop em VB ou Delphi conectadas ao banco e aplicações web com navegador e servidor.

A comunicação direta pode simplificar projetos pequenos. Com crescimento, concentração de responsabilidades e dependências pode dificultar manutenção e escala. Cliente-servidor é um modelo de interação; não exige sempre duas únicas camadas lógicas.

### 4. Três camadas

Apresentação, lógica de negócio e dados. Separar o negócio permite reutilizá-lo por diferentes interfaces e evoluir responsabilidades com mais clareza.

São citados servidores de aplicação Java e bancos relacionais no contexto enterprise. Camadas lógicas e tiers físicos devem ser distinguidos: uma separação de responsabilidades não implica necessariamente três processos separados.

### 5. Monolítico e distribuído

Monolito:
Uma unidade principal de implantação. Simplifica comunicação, transações e operação. Escala geralmente como unidade e exige disciplina modular.

Distribuído:
Vários serviços ou componentes separados interagem pela rede. Permite escala e entrega por unidade, mas introduz latência, falhas parciais, segurança e coordenação.

Distribuição não garante isolamento de falhas automaticamente: dependências síncronas e recursos compartilhados podem propagar problemas.

### 6. Falácias da computação distribuída

Premissas que não devem ser assumidas:
- A rede é confiável.
- A latência é zero.
- A largura de banda é infinita.
- A rede é segura.
- A topologia não muda.
- Existe apenas um administrador.
- O custo de transporte é zero.
- A rede é homogênea.

O resumo automático enumerou apenas sete, apesar do título “oito”. A lista acima explicita a premissa de custo de transporte que faltava.

Implicações:
Planejar timeouts, falhas, autenticação, volume de dados e mudanças de infraestrutura. Retries precisam ser limitados e considerar idempotência.

### 7. Logs e monitoramento

No distribuído, informações ficam espalhadas. Centralização, identificação de requisições e correlação ajudam a reconstruir um fluxo. São citados ELK, Splunk e Graylog como exemplos.

Mesmo um monolito pode ter várias réplicas; portanto logs não são necessariamente um único arquivo sequencial.

### 8. Transações

Transações locais ACID não se estendem automaticamente a vários serviços e bancos.

2PC:
Coordenação de confirmação em duas fases, com custos e limitações de disponibilidade.

Consistência eventual:
Aceita divergências temporárias; a convergência depende dos mecanismos de entrega, reconciliação e ausência de novas atualizações conflitantes.

Saga:
Sequência de transações locais coordenadas por orquestração ou coreografia. Falhas podem disparar compensações.

Exemplo:
Uma viagem reserva avião e hotel, mas falha ao reservar carro; ações compensatórias podem cancelar reservas anteriores.

Compensação é uma ação de negócio, não um rollback técnico perfeito. Pode falhar e demandar intervenção.

BASE:
Basically Available, Soft state, Eventual consistency; abordagem que tolera estados intermediários em favor de disponibilidade em determinados contextos.

## Perguntas de revisão

### 1. O que é Big Ball of Mud?
Um sistema sem fronteiras e estrutura compreensíveis, difícil de alterar.

### 2. O que três camadas acrescentam?
Uma separação explícita da lógica de negócio.

### 3. Cite três falácias.
Rede confiável, latência zero e largura de banda infinita.

### 4. Como investigar fluxos distribuídos?
Com logs centralizados e informações de correlação entre serviços.

### 5. Como funciona Saga?
Transações locais coordenadas e compensações quando necessário.
