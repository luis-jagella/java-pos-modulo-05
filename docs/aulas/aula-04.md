# Aula 04: Características Arquiteturais

> Origem: `aula-04.mp3`.
Notas extraídas da análise do áudio pelo Gemini, com limpeza dos marcadores visuais. Não são transcrição literal.

### 1. Funcionalidades e características arquiteturais

Requisitos funcionais descrevem o que o sistema faz: cadastro, login e processamento de pedidos.

Características arquiteturais expressam qualidades e restrições relevantes à estrutura: desempenho, segurança, escalabilidade e disponibilidade. Também aparecem como atributos de qualidade ou requisitos não funcionais. O nome não os torna secundários.

O arquiteto precisa identificar ambos, inclusive necessidades que não tenham sido documentadas pelos usuários.

### 2. Critérios apresentados

Uma característica arquitetural:
- Não descreve diretamente uma regra funcional do domínio.
- Influencia a estrutura ou o desenho do sistema.
- É importante para o sucesso da aplicação.

Uma qualidade só justifica decisões estruturais na medida em que seja relevante ao contexto.

### 3. Explícitas e implícitas

Explícitas são documentadas ou solicitadas, como suportar 5.000 usuários ou atender determinada obrigação regulatória.

Implícitas são esperadas no contexto, como proteção contra invasões ou continuidade de operação em um serviço crítico. Devem ser investigadas e documentadas para não se transformarem em surpresas de produção.

### 4. Categorias

Operacionais — comportamento em execução:
- Desempenho: responder e processar carga dentro de limites aceitáveis; o resumo usa 200 ms como exemplo.
- Disponibilidade: proporção de tempo em operação; envolve monitoramento e recuperação.
- Escalabilidade: capacidade de atender aumento de carga.
- Confiabilidade e tolerância a falhas: manter comportamento adequado diante de falhas, com recuperação e backups.
- Robustez: lidar com situações inesperadas e degradação controlada.

Nota: aumentar e reduzir recursos automaticamente é elasticidade; convém distinguir esse conceito de escalabilidade.

Estruturais — organização e evolução:
- Modularidade e manutenibilidade: localizar mudanças e limitar seu impacto.
- Extensibilidade: acrescentar funcionalidades sem reconstruir o núcleo.
- Reutilização: aproveitar componentes em outros contextos.
- Portabilidade: executar em diferentes plataformas ou ambientes.
- Configurabilidade: alterar comportamento por configuração externa.
- Suportabilidade: facilitar diagnóstico com logs, métricas e rastreamentos.

Transversais — impacto em diferentes partes:
- Segurança: autenticação, autorização, confidencialidade e integridade.
- Privacidade: controle de acesso e tratamento apropriado de dados pessoais.
- Conformidade: atendimento a leis e normas do setor.
- Acessibilidade: permitir uso por pessoas com diferentes necessidades.
- Usabilidade: facilitar compreensão e operação.
- Arquivamento e retenção: definir armazenamento e descarte de dados.

### 5. Trade-offs e complexidade acumulada

Características podem competir. Criptografia mais exigente pode aumentar custo de processamento; redundância melhora disponibilidade, mas aumenta custo e operação.

Tentar maximizar todas as qualidades eleva a complexidade. A arquitetura adequada resulta de priorização, negociação e concessões conscientes.

A aula usa o navio Vasa, de 1628, como analogia dos riscos de acumular exigências incompatíveis. A lição é evitar um projeto que busque todas as qualidades máximas sem avaliar estabilidade e viabilidade.

A orientação apresentada é buscar a arquitetura menos problemática para o contexto e priorizar inicialmente um conjunto pequeno, de aproximadamente 3 a 5 características. Isso é uma diretriz de foco, não um limite universal.

### 6. Identificação das prioridades

- Entender o domínio e o problema.
- Investigar documentação e requisitos explícitos.
- Conversar com stakeholders.
- Consultar especialistas e padrões setoriais.
- Identificar necessidades implícitas.
- Tornar expectativas verificáveis por métricas e critérios de aceitação.
- Negociar prioridades e custos.

## Perguntas de revisão

### 1. Funcionalidade e característica arquitetural diferem em quê?
Funcionalidade descreve o que fazer; característica descreve qualidade ou restrição relevante à estrutura.

### 2. Quais critérios são apresentados?
Influência estrutural, relevância para sucesso e distinção da regra funcional.

### 3. Qual a lição da analogia com o Vasa?
Acumular exigências máximas sem priorização pode inviabilizar o projeto.

### 4. Por que algumas características são transversais?
Porque afetam diversas partes do sistema e da organização.

### 5. O que significa buscar a arquitetura menos problemática?
Escolher conscientemente os trade-offs que melhor atendem ao contexto.
