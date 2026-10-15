# Revisão final

Use as [aulas](../README.md#aulas-e-anotações) para aprofundar. As questões abaixo são um roteiro autoral de estudo; não registram resultado da avaliação do portal.

## Questões comentadas

1. **O que é Entity Trap?** Definir fronteiras copiando entidades ou tabelas, ignorando os fluxos de negócio. O componente deve ter responsabilidades coesas.
2. **Por que usar ADR?** Para preservar contexto, opções, decisão e consequências. Pode ser substituído por uma nova decisão, sem apagar o histórico.
3. **O que é connascence?** Mudança em uma parte exige mudança correspondente em outra para manter correção. Controlar força, alcance e localidade da dependência.
4. **Quando usar microkernel?** Quando um núcleo estável precisa suportar extensões. É necessário controlar contratos e versões dos plugins.
5. **Qual benefício de microsserviços?** Autonomia de entrega ou escala por domínio. O custo é operar e coordenar uma distribuição.
6. **Como tratar risco médio?** Monitorar, priorizar e mitigar proporcionalmente. Não tratá-lo automaticamente como crítico.
7. **Qual o papel da camada de negócio?** Implementar regras e casos de uso, separando apresentação e armazenamento.
8. **Por que discutir riscos coletivamente?** Diferentes especialistas veem falhas diferentes; a discussão ajusta percepção e plano de ação.
9. **Core e plugin diferem em quê?** Essencial/estável versus extensão especializada, com contrato de integração.
10. **Monolito é Big Ball of Mud?** Não. Um monolito pode ter módulos e dependências controlados.
11. **Escalabilidade é elasticidade?** Não. Escala trata de capacidade; elasticidade trata de ajuste à demanda.
12. **Eventos eliminam acoplamento?** Não. Contratos, semântica, entrega e dados continuam sendo dependências.
13. **Outbox publica dentro da transação do banco?** Registra o evento na transação local e publica depois. Consumidores precisam considerar reentrega.
14. **Saga é rollback global?** Não. Compensações são operações de negócio e podem falhar.
15. **Space-based garante perda zero?** Não. É necessário definir replicação, confirmação, durabilidade e recuperação.
16. **Qual a Dependency Rule?** Código interno não depende de detalhes externos. A direção da execução pode ser diferente.
17. **CQRS resolve atomicidade distribuída?** Não. Separar comandos e consultas não substitui coordenação transacional.
18. **Linux é microkernel por ter módulos?** Não. Modularidade e classificação de kernel são conceitos diferentes.
19. **Uma porta precisa de framework de DI?** Não. O construtor pode receber a implementação na composição da aplicação.
20. **Inglês perfeito garante vaga internacional?** Não. O podcast enfatiza comunicação e experiência; requisitos variam entre vagas.

## Roteiro de consolidação

- Fundamentos: explicar coesão, acoplamento, características e trade-offs sem consultar.
- Estilos: desenhar camadas, pipeline, plugins e serviços e citar um antiuso.
- Distribuição: explicar falhas parciais, idempotência, Saga, outbox e observabilidade.
- Decisão: comparar duas alternativas para um mesmo problema e escrever um ADR.
- Clean Architecture: localizar domínio, porta, caso de uso e adaptador no exercício Java.

## Pontos de atenção registrados

- Não equiparar service-based e toda SOA.
- Não inferir uma máquina de banco por microsserviço.
- Não confundir números ilustrativos do podcast com dados atuais de mercado.
- Não transformar diretrizes e métricas em regras universais.

A aula 01 tem cinco perguntas; as outras 13 notas também possuem cinco perguntas cada, além das vinte questões comentadas deste guia.
