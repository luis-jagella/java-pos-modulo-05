# Aula 05: Pensamento Component-Based

> Origem: `aula-05.mp3`.
Notas organizadas a partir da análise do áudio pelo Gemini. Não são transcrição literal.

### 1. Componentização

Grande parte do trabalho arquitetural envolve definir responsabilidades, fronteiras e interações entre componentes. A divisão influencia manutenção, testes, implantação e evolução.

Na terminologia apresentada, módulo é um agrupamento lógico de código e componente é sua manifestação física, como JAR ou DLL. Um componente pode conter vários módulos. O uso desses termos varia entre autores, por isso é importante explicitar a definição adotada.

### 2. Escopos

- Biblioteca: código reutilizável chamado pela aplicação.
- Subsistema ou camada: agrupamento maior de classes e módulos.
- Serviço: unidade executada em processo próprio e acessada pela rede, permitindo implantação ou escala independente.

O arquiteto define a estrutura macro com especialistas, analistas e desenvolvedores. Tech leads e devs refinam a implementação. Detalhes internos entram na discussão arquitetural quando alteram características importantes do sistema.

### 3. Particionamento

Por camadas:
Organização técnica em apresentação, negócio e persistência. Um fluxo de negócio atravessa diversas camadas. Favorece especialização técnica e reutilização, mas mudanças de negócio podem atravessar vários componentes. Dependências de dados compartilhados exigem atenção.

Por domínio:
Organização em capacidades de negócio, como pagamentos e estoque. Favorece coesão, isolamento e possível evolução para serviços. Pode introduzir duplicação e exige cuidado com responsabilidades transversais.

Essas abordagens não obrigam, por si só, uma arquitetura a ser monolítica ou distribuída.

### 4. Descoberta e refinamento

A identificação é iterativa:
### 1. Propor componentes iniciais.
### 2. Associar requisitos funcionais e qualidades esperadas.
### 3. Avaliar papéis, responsabilidades e granularidade.
### 4. Validar desempenho, segurança e escalabilidade.
### 5. Refinar conforme surgem casos de uso e detalhes.

Componentes pequenos demais podem multiplicar chamadas, latência e trabalho operacional. Componentes grandes demais dificultam isolamento, testes e entregas independentes. A divisão depende do domínio e das necessidades de mudança.

### 5. Entity Trap

A armadilha da entidade é criar um componente para cada tabela ou entidade, ignorando os processos reais. Fluxos de negócio frequentemente atravessam várias entidades. Espelhar o banco pode criar fronteiras inadequadas e forte acoplamento.

A descoberta deve partir das capacidades e responsabilidades do sistema, não apenas do modelo de armazenamento.

### 6. Técnicas citadas

- Atores e ações: identificar quem interage e quais tarefas executa.
- Event Storming: mapear eventos e processos de negócio com a equipe.
- Workflows: identificar etapas e responsabilidades nos fluxos de trabalho.

### 7. Monolito e serviços

Monolito:
Implantação mais simples, chamadas locais rápidas, transações e diagnóstico mais diretos. Pode ter boa modularidade.

Microsserviços:
Processos separados, comunicação em rede e ciclos de entrega independentes. Aumentam integração, operação e observabilidade.

O exemplo de plataformas de grande escala destaca que “micro” não é uma contagem de linhas. Autonomia, domínio e independência de entrega são mais relevantes. A atribuição pessoal e os números específicos citados pelo resumo automático não foram verificados.

## Perguntas de revisão

### 1. Módulo e componente diferem em quê na aula?
Agrupamento lógico versus unidade física que o materializa.

### 2. Camadas e domínios diferem em quê?
Separação técnica versus separação por capacidade de negócio.

### 3. Por que evitar Entity Trap?
Porque tabelas não representam necessariamente fronteiras de responsabilidade.

### 4. Quais técnicas ajudam a descobrir componentes?
Atores e ações, Event Storming e workflows.

### 5. Microsserviço precisa ter pouco código?
Não; sua fronteira e autonomia são mais importantes que o tamanho.
