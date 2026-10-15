# Glossário

| Termo | Significado | Não confundir com |
| --- | --- | --- |
| Arquitetura | Estrutura e decisões relevantes ao sistema | Apenas o nome de um estilo |
| Design | Detalhamento de responsabilidades e colaboração | Etapa isolada da arquitetura |
| Módulo | Unidade lógica com responsabilidade delimitada | Necessariamente um processo |
| Componente | Unidade de composição; seu escopo depende do modelo | Necessariamente uma tabela |
| Coesão | Relação entre elementos internos | Quantidade de classes |
| Acoplamento | Dependência entre unidades | Toda comunicação ser ruim |
| Connascence | Mudanças que precisam ocorrer em conjunto para preservar correção | Apenas dependências de imports |
| Ca | Quantidade de dependentes externos | Ce, dependências utilizadas |
| Ce | Quantidade de dependências externas utilizadas | Ca, dependências recebidas |
| Instabilidade | `I = Ce / (Ce + Ca)` quando o denominador não é zero | Quantidade de bugs |
| Abstração | Proporção de tipos abstratos no módulo | Toda interface ser necessária |
| LCOM | Família de métricas de falta de coesão | Uma fórmula única universal |
| Característica arquitetural | Qualidade ou restrição relevante à estrutura | Funcionalidade de negócio |
| Escalabilidade | Atender crescimento de carga com recursos adequados | Elasticidade automática |
| Elasticidade | Ajustar capacidade à variação da demanda | Apenas usar containers |
| Disponibilidade | Operação acessível quando necessária | Ausência de qualquer falha |
| Resiliência | Absorver falhas e recuperar comportamento | Nunca falhar |
| Trade-off | Benefícios e custos de uma escolha | Uma solução sempre melhor |
| Monolito modular | Uma implantação com fronteiras internas claras | Big Ball of Mud |
| Bounded context | Limite onde um modelo de domínio tem significado consistente | Uma tabela ou serviço obrigatório |
| Evento | Registro de um fato ocorrido | Comando solicitando uma ação |
| Idempotência | Repetir uma operação não duplica seu efeito lógico | Mensagem nunca se repetir |
| Outbox | Registro do evento junto à mudança local; publicação posterior | Transação automática banco + broker |
| Saga | Transações locais coordenadas com compensações | Rollback global perfeito |
| Circuit breaker | Interromper insistência em chamadas que falham | Retry ou fallback |
| Bulkhead | Isolar recursos para limitar impacto | Apenas separar processos |
| ADR | Contexto, decisão e consequências registrados | Proibição de mudar a decisão |
| Dependency Rule | Dependências de código voltadas às políticas internas | Direção única da execução |
| Porta | Contrato necessário à aplicação | Implementação de banco |
| Adaptador | Implementação ou tradução na fronteira | Regra central de negócio |

Os termos são ferramentas de análise. A fronteira correta depende do problema, e não de uma contagem de camadas, arquivos ou linhas.
