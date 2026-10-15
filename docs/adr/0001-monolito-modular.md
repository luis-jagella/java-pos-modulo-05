# ADR 0001 — Começar o exercício de pedidos como monolito modular

**Status:** aceito para o exercício didático. **Data:** 2026-10-14.

## Contexto

Queremos compreender domínio, casos de uso e inversão de dependência com uma equipe de estudo individual. Não há requisitos medidos de alta carga, implantação por equipes diferentes ou persistência durável neste exercício.

## Alternativas

1. Script com todas as responsabilidades misturadas: simples, mas esconde as fronteiras estudadas.
2. Aplicação modular com porta e adaptador: permite testar políticas sem infraestrutura externa.
3. Microsserviços com broker e bancos: acrescentam custos sem um requisito que os justifique.

## Decisão

Usar uma aplicação Java 17 com domínio, caso de uso, contrato de repositório e adaptador em memória. A interface de entrada é CLI. A branch `modulo-01-arquitetura` contém a implementação.

As dependências de aplicação apontam para o domínio; o adaptador implementa o contrato interno. Banco, HTTP e Kafka não entram nas regras de negócio.

## Consequências

- Compilação e testes sem serviços ou bibliotecas externas.
- Uma unidade de implantação e fronteiras visíveis no código.
- Dados são perdidos ao encerrar o processo; isso é uma limitação explícita do exercício.
- Não demonstramos persistência, transações entre serviços ou operação de cluster.
- Uma futura implementação durável deve ser outro adaptador com testes do contrato e decisão própria.

## Critérios para revisão

Reavaliar se o exercício passar a exigir persistência, concorrência, autenticação, interface web ou escala independente. Registrar nova decisão preservando este histórico.

## Verificação

Compilar o núcleo sem o adaptador, executar casos de criação e transição de estado, e verificar que entrada inválida não grava dados. Consulte o README da prática na branch do módulo.
