# Aula 01 — Introdução

> Origem: `aula-01.mp3`. Notas baseadas no resumo do áudio; não são transcrição literal.

## O que compõe a arquitetura

A arquitetura descreve a organização do sistema e as decisões relevantes para atender ao negócio. Dizer apenas “usamos microsserviços” não informa fronteiras, contratos, dados ou razões.

Quatro dimensões discutidas:

- Estrutura: componentes, módulos e suas relações.
- Características arquiteturais: desempenho, disponibilidade, segurança e manutenibilidade.
- Decisões: escolhas e restrições que orientam a construção.
- Princípios de design: orientações para manter consistência nas decisões locais.

O que importa muda conforme o sistema. Pagamentos podem priorizar integridade e auditoria; venda de ingressos pode enfrentar picos de concorrência. São exemplos didáticos de aplicação dos conceitos.

## Papel do arquiteto

O papel varia entre organizações. Envolve experiência técnica, compreensão do domínio e diálogo com desenvolvimento, operação e gestão.

- Comparar alternativas e justificar decisões.
- Avaliar continuamente a estrutura e sua degradação.
- Acompanhar tecnologias relevantes ao contexto.
- Comunicar padrões e discutir exceções.
- Compreender requisitos explícitos e implícitos.
- Desenvolver liderança, mentoria e comunicação.

Conhecer tecnologias ajuda a reconhecer alternativas, mas não dispensa investigar necessidades reais. A função não se resume a desenhar diagramas ou escolher frameworks.

## Princípios, regras e exceções

Uma regra pode proibir acesso direto da apresentação ao banco. Um princípio pode orientar baixo acoplamento ou composição. A regra impõe uma restrição específica; o princípio ajuda a raciocinar em diferentes contextos.

Exceções precisam de justificativa e avaliação de impacto. Flexibilidade sem registro pode criar dependências arbitrárias.

## Engenharia, operação e dados

Testes, integração contínua e entrega influenciam a capacidade de evolução. Operação acrescenta implantação, observabilidade e recuperação. Dados acrescentam consistência, replicação, cache e modelos de armazenamento.

Esses fatores entram no desenho desde o início, e não apenas após uma falha em produção.

## Duas orientações centrais

Toda decisão tem trade-offs: melhorar uma qualidade pode aumentar custo, complexidade ou prejudicar outra. Se uma alternativa parece ter apenas benefícios, a análise provavelmente está incompleta.

Preservar o motivo da escolha é essencial. A implementação pode mudar, mas conhecer problema e restrições ajuda a revisar a arquitetura sem perder o contexto.

## Perguntas de revisão

1. O nome do estilo descreve tudo? Não; faltam fronteiras, dados, contratos, qualidades e decisões.
2. Qualidades são secundárias? Não; podem determinar se o sistema atende ao negócio.
3. Regra e princípio diferem em quê? Restrição concreta versus orientação.
4. Por que envolver operação? Implantação, observabilidade e recuperação influenciam a estrutura.
5. Por que registrar o motivo? Para preservar contexto e permitir evolução consciente.
