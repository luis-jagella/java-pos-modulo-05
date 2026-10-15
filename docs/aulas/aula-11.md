# Aula 11: Arquitetura Microservices

> Origem: `aula-11.mp3`.
Notas organizadas a partir da análise do áudio pelo Gemini após nova tentativa. Não são transcrição literal.

### 1. Definição e fronteiras

Aplicação composta por serviços com responsabilidades de negócio bem delimitadas, contratos e ciclos de entrega relativamente independentes.

DDD ajuda a pensar em bounded contexts, linguagem do domínio e responsabilidades. Um bounded context não precisa corresponder mecanicamente a um único serviço.

A aula contrasta microsserviços com organizações mais centralizadas e serviços abrangentes. SOA é um conceito amplo e não exige universalmente banco compartilhado.

### 2. Princípios

- Fronteiras de domínio claras.
- Coesão e responsabilidade delimitada.
- Baixo acoplamento.
- Interfaces estáveis.
- Propriedade e autonomia sobre dados.
- Equipes capazes de desenvolver e operar seus serviços.

“Pequeno” não significa uma contagem arbitrária de linhas.

### 3. Benefícios possíveis

Escala e elasticidade granulares:
Aumentar recursos apenas onde há demanda.

Entrega:
Alterar e implantar serviços separadamente.

Manutenção:
Concentrar mudanças em um domínio bem delimitado.

Tecnologia:
Escolher ferramentas adequadas a cada problema, com governança.

Resiliência:
Limitar propagação de falhas por isolamento e mecanismos apropriados.

Esses benefícios dependem das fronteiras e da implementação. Serviços separados com dependências rígidas podem formar um monolito distribuído.

### 4. Custos

- Latência e falhas parciais de rede.
- CI/CD e operação de vários artefatos.
- Governança de APIs e versões.
- Segurança entre serviços.
- Diagnóstico distribuído.
- Consistência e transações que atravessam fronteiras.
- Coordenação entre equipes.

Containers e orquestração ajudam a operacionalizar o modelo, mas não são requisitos definidores de microsserviços.

### 5. Dados

Cada serviço deve controlar acesso e mudança de seus dados. Isso não exige necessariamente um servidor físico de banco exclusivo.

Transações locais ACID continuam disponíveis. Transações entre serviços exigem outra estratégia, como Saga e compensações, conforme o processo.

Nota: CQRS separa modelos de comando e consulta; não é, por si só, um protocolo para resolver atomicidade distribuída.

### 6. Conway e equipes

A comunicação da organização influencia o sistema. Equipes multidisciplinares responsáveis por uma capacidade de negócio favorecem autonomia de entrega.

Essa relação é uma tendência e ferramenta de análise; não significa que toda equipe em silos produzirá necessariamente um monolito.

### 7. Infraestrutura

Containers:
Empacotam a aplicação e suas dependências. Reduzem divergências de ambiente, sem garantir identidade absoluta de comportamento.

Orquestração:
Coordena implantação, escala e recuperação das instâncias.

Service discovery:
Permite localizar instâncias dinamicamente; pode usar registros ou mecanismos de plataforma e DNS.

API gateway:
Entrada que pode concentrar roteamento e políticas. Seu desenho precisa evitar excesso de lógica e gargalos.

Configuração:
Gerenciamento consistente de parâmetros. Segredos precisam de proteção apropriada; nem toda alteração pode ser aplicada sem reinício.

Service mesh:
Infraestrutura de comunicação, com funções de tráfego, segurança e observação.

Data plane:
Encaminha tráfego e aplica políticas.

Control plane:
Distribui configuração e coordena o comportamento dos componentes.

Sidecars são uma forma de implementação, não uma exigência universal de todo mesh.

### 8. Comunicação

Síncrona:
REST ou gRPC oferecem resposta direta e simplicidade de integração, mas criam dependência temporal e podem propagar atrasos e falhas.

Assíncrona:
Kafka ou RabbitMQ permitem ritmos diferentes e absorção de picos, mas exigem lidar com duplicação, entrega, ordem e estados intermediários.

### 9. Observabilidade

Logs:
Registro de ocorrências, com agregação e correlação.

Métricas:
Carga, latência, recursos e taxas de erro.

Tracing:
Percurso de uma operação por serviços.

São citados ELK, CloudWatch, Zipkin, Jaeger e OpenTelemetry. OpenTelemetry instrumenta e exporta telemetria; Jaeger é um backend para análise de traces.

### 10. Resiliência

Circuit breaker:
Suspende temporariamente chamadas quando há falhas, com recuperação controlada. Fallback é uma decisão separada.

Timeout:
Limita a espera.

Retry:
Repete falhas apropriadas com limites e atraso; considerar idempotência.

Bulkhead:
Isola recursos, como pools e conexões, para limitar o impacto de sobrecarga.

Degradação graciosa:
Oferece comportamento reduzido, cache ou resposta alternativa quando isso é seguro para o negócio.

### 11. Micro-frontends

Aplica princípios de divisão por domínio e autonomia à interface. Introduz desafios de integração, desempenho, consistência visual e diagnóstico.

## Perguntas de revisão

### 1. O que significa autonomia de dados?
O serviço controla seus dados e contratos de acesso.

### 2. Como Conway se relaciona às equipes?
Fronteiras de comunicação influenciam as fronteiras do software.

### 3. Para que serve circuit breaker?
Evitar insistência em dependências falhando e permitir recuperação.

### 4. Data plane e control plane diferem em quê?
Tráfego real versus distribuição e coordenação de configurações.

### 5. Como bulkhead ajuda?
Isola recursos para impedir que uma sobrecarga esgote toda a aplicação.
