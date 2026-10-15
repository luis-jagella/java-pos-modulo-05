# Comparação de trade-offs

Exemplo didático: um sistema de pedidos com equipe pequena e demanda inicial moderada. As alternativas abaixo não foram medidas em produção.

| Alternativa | Quando considerar | Benefício | Custo ou risco | Quando evitar |
| --- | --- | --- | --- | --- |
| Cliente-servidor | Interação simples entre cliente e serviço | Poucas partes | Concentração de responsabilidades | Usar acesso direto ao banco onde contratos e segurança exigem mediação |
| Três tiers | Separação física de UI, aplicação e dados | Recursos por tier | Rede e operação adicionais | Separar fisicamente sem necessidade |
| Monolito modular | Domínios claros, operação simples | Chamadas locais e uma entrega | Escala e release da aplicação inteira | Exigir autonomia de implantação de equipes sem avaliar alternativas |
| Camadas | Responsabilidades técnicas conhecidas | Familiaridade e isolamento | Repasse sem trabalho, alterações transversais | Criar camadas vazias apenas por convenção |
| Pipeline | Dados passam por transformações | Etapas reutilizáveis e testáveis | Gargalo e controle de fluxo | Forçar processo interativo complexo em uma sequência |
| Microkernel | Produto varia por cliente ou extensão | Núcleo estável, plugins | Contratos e compatibilidade | Só existem funcionalidades fixas e nenhuma necessidade de extensão |
| Service-based | Serviços amplos por domínio | Separação gradual | Coordenação de dados compartilhados | Equipes precisam mudar schema de forma totalmente autônoma |
| EDA broker | Reações independentes a fatos | Extensibilidade e ritmos diferentes | Diagnóstico, ordem e duplicação | Necessitar resultado imediato e atômico em um único passo |
| EDA mediator | Processo com etapas e compensações | Coordenação explícita | Complexidade no orquestrador | Acrescentar controle central a notificações simples |
| Space-based | Banco limita picos intensos | Processamento apoiado em memória | Replicação, memória e durabilidade | Carga baixa sem gargalo demonstrado |
| Microsserviços | Domínios e equipes precisam de autonomia | Deploy e escala por serviço | Operação, contratos e dados distribuídos | Pequena equipe adotar distribuição só por tendência |
| Clean Architecture | Regras importantes merecem isolamento | Teste e controle de dependências | Adaptadores e mapeamentos | Criar abstrações sem benefício no contexto |

## Perguntas antes de escolher

1. Qual problema medido ou observado precisamos resolver?
2. Quais qualidades são prioritárias e como serão verificadas?
3. Quem opera e mantém a solução?
4. Quais dados exigem consistência imediata?
5. O que uma alternativa mais simples resolve?
6. Que evidência faria mudar a decisão?

## Monolito modular versus microsserviços

No caso inicial, começar modular evita latência e coordenação distribuída. Não impede fronteiras internas ou teste independente de regras. Microsserviços passam a ser candidatos se uma capacidade exigir escala, operação ou entrega autônoma que justifique o custo.

Essa decisão está registrada no [ADR 0001](adr/0001-monolito-modular.md). Os riscos estão no [exemplo de matriz](riscos.md).
