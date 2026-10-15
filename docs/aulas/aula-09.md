# Aula 09: Arquitetura Event-Driven

> Origem: `aula-09.mp3`.
Notas organizadas a partir da análise do áudio pelo Gemini. Não são transcrição literal.

### 1. Eventos e comunicação

EDA organiza interações em torno de fatos publicados. Um evento registra algo que aconteceu, como PedidoRealizado. Consumidores interessados reagem ao fato para executar suas responsabilidades.

Produtor:
Emite o evento.

Consumidor:
Processa eventos de interesse.

Canal:
Fila ou tópico que transporta informações.

Broker:
Intermediário que recebe e distribui mensagens, podendo armazená-las conforme configuração.

A comunicação frequentemente é assíncrona. O produtor não precisa conhecer todos os consumidores nem aguardar suas ações. Isso reduz acoplamento temporal, mas não elimina dependências de contratos, dados e regras de negócio.

### 2. Comparação com request-response

Request-response pode facilitar obter um resultado direto, mas cadeias síncronas dependem da disponibilidade e do tempo de resposta dos serviços.

Eventos permitem processamento desacoplado e consumidores com ritmos diferentes. Em troca, exigem acompanhar estados intermediários, entrega, falhas e consistência.

Nenhum modelo garante escalabilidade ou independência absoluta apenas por sua escolha.

### 3. Topologia broker — coreografia

Não existe um coordenador único do fluxo de negócio. Componentes publicam fatos e reagem aos eventos relevantes.

Vantagens:
Extensibilidade, distribuição de processamento e menor centralização.

Custos:
Dificuldade de reconstruir fluxos, identificar falhas globais e controlar processos que atravessam muitos componentes.

### 4. Topologia mediator — orquestração

Um mediador recebe o evento inicial e coordena etapas e sequências.

Vantagens:
Fluxo explícito, tratamento de erro mais centralizado e melhor visibilidade de processos complexos.

Custos:
Maior responsabilidade concentrada, possíveis gargalos e necessidade de resiliência no coordenador.

O mediador não torna automaticamente atômicas as transações distribuídas.

### 5. Padrões

Event workflow:
Etapas de negócio desencadeadas e coordenadas por mensagens.

Pub/Sub:
Um fato alcança diferentes assinantes interessados. Exemplos: notificações, integração e processamento de eventos IoT.

Request-reply assíncrono:
A solicitação e a resposta são mensagens separadas. Um correlation ID permite relacionar a resposta à solicitação.

### 6. Confiabilidade

Durabilidade e ACK:
Confirmações e persistência de mensagens ajudam a controlar entrega e recuperação. As garantias dependem da configuração.

At-least-once:
Uma mensagem pode ser entregue mais de uma vez.

Idempotência e deduplicação:
Evitar efeitos de negócio duplicados quando ocorre reprocessamento.

Outbox:
Gravar a mudança de negócio e um registro do evento na mesma transação do banco. Um publicador envia depois esse registro ao broker. Não é simplesmente publicar no broker dentro da transação local; essa diferença corrige uma simplificação do resumo automático.

DLQ:
Isolar mensagens que não puderam ser processadas após a política de tentativas, permitindo investigação e eventual reprocessamento.

### 7. Tecnologias citadas pelo resumo

Kafka, RabbitMQ e ActiveMQ são exemplos de plataformas de eventos ou brokers. Spring Integration e recursos de mensageria do Quarkus/SmallRye são exemplos de integração Java.

A escolha deve considerar retenção, ordenação, modelo de consumo, operação e garantias exigidas, e não apenas popularidade.

## Perguntas de revisão

Referência de revisão do padrão Outbox:
https://microservices.io/patterns/data/transactional-outbox.html

### 1. Qual o objetivo da EDA?
Reduzir dependências de comunicação direta e permitir reação a fatos.

### 2. Broker e mediator diferem em quê?
Coreografia sem coordenador de negócio versus orquestração explícita.

### 3. O que caracteriza Pub/Sub?
Vários interessados podem reagir a um evento publicado.

### 4. Como correlacionar request-reply?
Com um identificador compartilhado entre solicitação e resposta.

### 5. Para que serve uma DLQ?
Separar mensagens problemáticas para análise e recuperação.
