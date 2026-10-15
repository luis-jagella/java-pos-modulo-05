# Módulo 05 — Arquitetura de Sistemas

Material de estudo da pós-graduação **Java Applied Engineering**: 13 aulas, um podcast, diagramas e revisão. O foco é escolher uma arquitetura a partir do problema, dos atributos de qualidade e dos trade-offs.

## Aulas e anotações

Os checks indicam **conteúdo documentado neste repositório**, não conclusão ou nota no portal. As notas foram produzidas a partir dos resumos dos áudios, com revisão textual e correções técnicas; não são transcrições literais. Exemplos adicionais e ressalvas estão identificados nos textos.

| Registro | Aula | Ideia principal |
| --- | --- | --- |
| [x] | [01 — Introdução](docs/aulas/aula-01.md) | Estrutura, qualidades, decisões e papel do arquiteto |
| [x] | [02 — Pensamento Arquitetural](docs/aulas/aula-02.md) | Colaboração, amplitude e trade-offs |
| [x] | [03 — Modularização](docs/aulas/aula-03.md) | Coesão, acoplamento, métricas e connascence |
| [x] | [04 — Características Arquiteturais](docs/aulas/aula-04.md) | Prioridades explícitas e implícitas |
| [x] | [05 — Pensamento Component-Based](docs/aulas/aula-05.md) | Fronteiras, granularidade e Entity Trap |
| [x] | [06 — Fundamentos de Estilos Arquiteturais](docs/aulas/aula-06.md) | Monolitos, distribuição e suas falácias |
| [x] | [07 — Camadas e Pipeline](docs/aulas/aula-07.md) | Isolamento de responsabilidades e processamento em etapas |
| [x] | [08 — Microkernel e Service-Based](docs/aulas/aula-08.md) | Plugins e serviços de domínio abrangentes |
| [x] | [09 — Event-Driven](docs/aulas/aula-09.md) | Broker, mediator, entrega e idempotência |
| [x] | [10 — Space-Based](docs/aulas/aula-10.md) | Dados em memória, replicação e persistência assíncrona |
| [x] | [11 — Microservices](docs/aulas/aula-11.md) | Autonomia, dados, comunicação e operação |
| [x] | [12 — Escolhas, Decisões e Riscos](docs/aulas/aula-12.md) | ADRs, matriz de riscos e Risk Storming |
| [x] | [13 — Clean Architecture](docs/aulas/aula-13.md) | Dependências voltadas às regras de negócio |
| [x] | [Podcast — Carreira Internacional e Java na Gringa](docs/aulas/aula-14-podcast.md) | Inglês funcional, experiência e posicionamento |

Cada nota contém perguntas e respostas de revisão. O podcast registra opiniões e valores mencionados no episódio, sem tratá-los como pesquisa atual de mercado.

## Material para consolidar

- [Glossário](docs/glossario.md): os termos que aparecem nas aulas.
- [Catálogo de estilos e diagramas](docs/catalogo-estilos.md): contexto, riscos, antiuso e conexão com Java, Quarkus e Kafka.
- [Comparação de trade-offs](docs/comparacao.md): como decidir sem escolher pela popularidade.
- [ADR de exemplo](docs/adr/0001-monolito-modular.md): começar um sistema de pedidos como monolito modular.
- [Análise de riscos](docs/riscos.md): exemplo de priorização e mitigação.
- [Revisão final](docs/revisao.md): questões comentadas e roteiro de estudo.

## Organização e prática

- `main`: anotações consolidadas e material de referência.
- [`modulo-01-arquitetura`](https://github.com/luis-jagella/java-pos-modulo-05/tree/modulo-01-arquitetura): prática Java com domínio, caso de uso, porta e adaptador em memória. Consulte o README da prática nessa branch para compilar, executar e testar com JDK 17.
- `feat/<tema>`: experimentos pontuais quando houver uma prática independente.

Os diagramas representam alternativas de desenho. O exercício executável implementa apenas a separação de dependências da Clean Architecture; não simula Kafka, cluster Space-Based ou microsserviços em produção.

## Acompanhamento

- [GitHub Project — Pós: Módulo 05](https://github.com/users/luis-jagella/projects/2).
- [Milestone do módulo](https://github.com/luis-jagella/java-pos-modulo-05/milestone/1).
- [Issues](https://github.com/luis-jagella/java-pos-modulo-05/issues): blocos de aulas, catálogo e revisão.

## Entregas de estudo

- [x] Notas das 13 aulas e do podcast.
- [x] Glossário e revisão comentada.
- [x] Diagramas e comparação dos estilos.
- [x] ADR e riscos de um caso didático.
- [x] Conexões com Java, Quarkus e Kafka no catálogo.

Para praticar a explicação, escolha um estilo, justifique onde o usaria e diga qual custo aceitaria. Depois compare com uma alternativa mais simples.
