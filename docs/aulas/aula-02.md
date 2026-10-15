# Aula 02: Pensamento Arquitetural

> Origem: `aula-02.mp3`.
Notas extraídas da análise do áudio pelo Gemini, com limpeza dos marcadores visuais. Não são transcrição literal.

### 1. Introdução ao pensamento arquitetural

O pensamento arquitetural é uma postura mental que considera o sistema inteiro, a interação de seus componentes e o contexto de negócio. Sua visão ampla busca antecipar problemas, evitando decisões precipitadas e excesso de engenharia. Envolve colaboração, escuta ativa e avaliação das consequências das escolhas.

### 2. Arquitetura e design

No modelo tradicional, existe um muro entre arquiteto e desenvolvedor. O arquiteto escolhe estilos, componentes e características em isolamento e repassa as decisões para implementação. A comunicação unidirecional pode gerar desalinhamento entre planejamento e execução.

No modelo colaborativo, a comunicação é bidirecional. O arquiteto atua como líder e mentor, e os desenvolvedores participam do planejamento e da implantação. Arquitetura e design evoluem juntos, com retorno contínuo da implementação.

### 3. Amplitude e profundidade: a pirâmide do conhecimento

A pirâmide distingue:
- O que você sabe: domínio técnico de ferramentas, linguagens e frameworks.
- O que sabe que não sabe: tecnologias conhecidas, mas ainda não dominadas.
- O que nem sabe que não sabe: pontos cegos que podem limitar as soluções consideradas.

O desenvolvedor tende a aprofundar sua stack principal. O arquiteto precisa ampliar o repertório para compreender várias tecnologias, domínios e interações, sem precisar dominar tudo igualmente. Ambos precisam acompanhar a evolução tecnológica; novas versões do Java são um exemplo.

### 4. Trade-offs e decisões

Toda escolha tem vantagens e custos. Não existe uma solução perfeita para todos os requisitos. Uma decisão pode melhorar um atributo e comprometer outro. A análise deve considerar restrições de negócio, ambiente tecnológico, orçamento, prazo e custo.

Decisões arquiteturais envolvem consequências interdependentes. Não basta escolher uma tecnologia conhecida: é necessário justificar sua adequação ao contexto e avaliar o que será perdido ou ficará mais difícil.

### 5. Exemplo: sistema de leilão online

Um produtor de lances, Bid Producer, precisa enviar informações para Capture, Tracking e Analytics.

Opção Pub/Sub:
- O produtor publica em um tópico, e os consumidores o assinam.
- Vantagens: pouco conhecimento dos consumidores pelo produtor, extensibilidade e distribuição de um contrato comum.
- Adicionar um consumidor pode exigir apenas sua conexão ao tópico.
- Pontos de atenção: controle de acesso, acompanhamento de cada consumidor e compatibilidade das mudanças de formato.
- Uma permissão mal configurada pode expor mensagens a consumidores indevidos.

Opção com filas individuais:
- O produtor direciona mensagens ou cópias para filas dedicadas.
- Vantagens: isolamento por destino, personalização e monitoramento granular.
- As filas podem reter mensagens enquanto um consumidor está indisponível, conforme as garantias do broker.
- Custos: o produtor passa a conhecer vários destinos, e novos consumidores aumentam manutenção e configuração.

O exemplo demonstra que a escolha depende das prioridades. Não significa que tópicos sejam inerentemente inseguros nem que filas garantam ausência de perda sem configuração adequada.

### 6. Drivers de negócio e atributos de qualidade

O arquiteto traduz crescimento, expansão, volume de usuários, custos e prazos em decisões tecnológicas.

Atributos considerados:
- Desempenho: latência e capacidade de processamento, especialmente em transações críticas.
- Disponibilidade: continuidade da operação, redundância e tolerância a falhas.
- Segurança: criptografia, autorização e auditoria, com atenção a domínios como finanças e saúde.
- Escalabilidade: capacidade de acompanhar aumento de demanda.

### 7. Arquiteto com atuação prática

Manter contato com implementação ajuda a fundamentar decisões. Essa atuação não deve transformar o arquiteto em gargalo.

Formas de participação:
- PoCs para testar hipóteses ou novas tecnologias.
- Refatorações pontuais complexas.
- Revisão de código.
- Avaliação de recursos técnicos, como mecanismos de concorrência.

## Perguntas de revisão

### 1. Como muda a comunicação entre os dois modelos?
Tradicional: unidirecional. Colaborativo: bidirecional, com participação da equipe.

### 2. Por que o arquiteto precisa de amplitude?
Para reconhecer alternativas e consequências sistêmicas, reduzindo pontos cegos.

### 3. Por que trade-offs são inevitáveis?
Porque melhorar um atributo pode aumentar custo ou prejudicar outro.

### 4. Qual é a vantagem central de Pub/Sub no exemplo?
Adicionar consumidores com menos alterações no produtor.

### 5. Como manter prática sem criar gargalo?
Participar de PoCs, revisões e refatorações selecionadas, preservando a visão geral.
