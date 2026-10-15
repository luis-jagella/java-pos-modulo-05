# Aula 12: Escolhas, Decisões e Riscos

> Origem: `aula-12.mp3`.
Notas organizadas a partir da análise do áudio pelo Gemini. Não são transcrição literal.

### 1. Escolha de estilos

Não existe um estilo universalmente melhor. A decisão depende do problema, negócio, experiência da equipe, dados, operação e trade-offs.

Tecnologias mudam e fatores externos, como expansão, fusões, custos e exigências legais, podem exigir revisão da arquitetura.

O resumo automático chamou esta aula de encerramento, mas o arquivo é identificado aqui pela numeração fornecida: aula 12.

### 2. Critérios

- Domínio: necessidades e processos do negócio.
- Qualidades: escala, desempenho, disponibilidade e segurança.
- Dados: sistemas legados, consistência e fluxos.
- Organização: maturidade da equipe e processos.
- Operação: recursos, custos, prazo e suporte.
- Adequação: o estilo deve responder ao problema.

Exemplos:
Microkernel pode atender customizações por plugins. Serviços podem ajudar quando existem fronteiras de domínio e autonomia de entrega justificadas.

### 3. Decisão e comunicação

Coletar informações, comparar opções e consequências, justificar e comunicar a escolha.

A decisão precisa estar acessível aos envolvidos em desenvolvimento, operação e gestão. “Pública” nesse contexto significa compartilhada com o time autorizado, não obrigatoriamente publicada na internet.

### 4. Antipadrões

Covering your assets:
Evitar ou adiar decisões por receio de responsabilidade. A saída é reunir evidências, envolver a equipe e assumir uma decisão revisável.

Groundhog Day:
A mesma decisão é reaberta repetidamente porque os motivos se perderam. Registrar contexto e justificativa evita reiniciar discussões sem novas informações.

Email-driven architecture:
Decisões dispersas em e-mail ou chat tornam difícil localizar o que vale. Usar um registro central e canais de comunicação para notificação.

### 5. ADR — Architecture Decision Record

Documento curto e versionável que registra uma decisão relevante.

Estrutura:
- Título.
- Status.
- Contexto e problema.
- Alternativas.
- Decisão.
- Motivos.
- Consequências e trade-offs.

Benefícios:
Rastreabilidade, integração de novos membros, entendimento do histórico e revisão consciente.

Uma decisão aceita pode ser substituída por um novo ADR, preservando o histórico. ADR não impede mudanças nem substitui toda documentação.

Ferramentas como ArchUnit podem verificar regras implementadas a partir de decisões; o documento sozinho não executa testes.

### 6. Riscos

Identificar ameaças à operação, segurança, desempenho e disponibilidade.

Uma matriz de impacto e probabilidade ajuda a classificar prioridades. O produto das pontuações pode funcionar como indicador, mas sua precisão depende da escala utilizada. Não é uma previsão exata.

Para cada risco:
Definir situação, impacto, probabilidade, responsável, mitigação e revisão. Monitorar mudança de tendência.

Risco médio não deve consumir automaticamente todos os recursos como se fosse crítico. A resposta depende de contexto, custo e evolução.

### 7. Risk Storming

Atividade colaborativa apoiada em um diagrama da arquitetura.

Etapas:
### 1. Participantes identificam riscos individualmente.
### 2. A equipe consolida os achados.
### 3. Discute percepções divergentes.
### 4. Ajusta avaliação de impacto e probabilidade.
### 5. Prioriza mitigação e acompanhamento.

O valor está em combinar perspectivas e tornar as decisões de risco explícitas.

## Perguntas de revisão

### 1. O que registra um ADR?
Contexto, alternativas, decisão, motivos e consequências.

### 2. Quais antipadrões são discutidos?
Adiamento por medo, rediscussão sem memória e decisões dispersas em mensagens.

### 3. Para que serve a matriz?
Apoiar priorização com impacto e probabilidade.

### 4. O que é Risk Storming?
Identificação individual seguida de discussão coletiva sobre riscos.

### 5. Por que compartilhar decisões?
Para alinhar equipe e preservar o entendimento do que foi escolhido e por quê.
