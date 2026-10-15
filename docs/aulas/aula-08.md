# Aula 08: Microkernel e Service-Based Architecture

> Origem: `aula-08.mp3`.
Notas organizadas a partir da análise do áudio pelo Gemini. Não são transcrição literal.

### 1. Microkernel ou arquitetura de plugins

O sistema possui um núcleo mínimo e extensões.

Core:
Funcionalidades essenciais e estáveis que sustentam a aplicação.

Plugins:
Recursos especializados, variáveis ou customizáveis, adicionados através de contratos.

Separar comportamento estável e variável permite adaptar um produto a diferentes mercados ou usuários.

### 2. Exemplos e analogias

IDEs como Eclipse e editores extensíveis exemplificam bem um núcleo e extensões. Navegadores e plataformas extensíveis também ajudam a visualizar a ideia.

Correção importante: o resumo automático chamou Linux de exemplo de microkernel. O kernel Linux é monolítico modular; ter módulos não o classifica como microkernel de sistema operacional. A analogia de extensibilidade não deve ser confundida com essa classificação.

A comparação Kubernetes/OpenShift no resumo deve ser entendida apenas como analogia de uma base com funcionalidades adicionais.

### 3. Integração e contratos

O núcleo descobre e administra plugins por um registro. A interação usa interfaces e formatos de dados definidos. Pode ocorrer por chamadas locais; integração remota é uma opção conforme o desenho.

Plugins podem ser carregados dinamicamente ou incluídos na composição da aplicação. Dependências de dados e de outros plugins devem ser controladas.

### 4. Vantagens e custos

Vantagens:
- Extensibilidade.
- Adaptação de um produto base.
- Mudanças localizadas.
- Possibilidade de testar extensões separadamente.

Custos:
- Gestão de contratos e versões.
- Compatibilidade entre núcleo e extensões.
- Maior quantidade de módulos para administrar.
- Overhead de abstração.
- Falha no core pode afetar toda a aplicação.

Isolamento não é automático: plugins no mesmo processo podem compartilhar recursos e falhas.

### 5. Service-Based Architecture

Topologia com serviços relativamente abrangentes organizados por domínio, interface de usuário e, frequentemente, banco compartilhado.

É apresentada como alternativa entre uma única aplicação e uma distribuição muito granular. Mantém certas facilidades de dados compartilhados, enquanto separa execução e entrega de partes do negócio.

Nota de terminologia: service-based e SOA não são sinônimos universais. O arquivo trata o estilo service-based exemplificado na aula, sem equipará-lo a toda arquitetura orientada a serviços.

### 6. Organização e comunicação

Serviços podem representar clientes, pedidos ou pagamentos e ser acessados por REST, SOAP ou gRPC.

A aula enfatiza controlar chamadas diretas entre serviços para evitar dependências escondidas, latência e cadeias de falha. Não é uma proibição universal.

Autenticação, logs e monitoramento precisam de uma estratégia consistente, evitando soluções divergentes em cada serviço.

### 7. Dados e trade-offs

Banco compartilhado:
- Pode simplificar certas transações, relatórios e consistência.
- Exige coordenação das mudanças de esquema.
- Pode concentrar carga e disponibilidade.
- Aumenta o risco de acoplamento entre serviços.

Ter um banco comum não torna automaticamente atômico um fluxo de várias requisições. A atomicidade exige uma transação corretamente delimitada.

Microsserviços:
Tendem a possuir autonomia sobre seus dados. Isso significa propriedade e acesso controlado, não necessariamente um servidor físico diferente para cada serviço.

### 8. Vantagens e limitações

Permite separação gradual de um monolito, entrega por serviço e algum isolamento de falhas. As fronteiras precisam refletir o negócio, e o banco comum continua exigindo governança.

Escalabilidade, consistência e disponibilidade precisam ser analisadas considerando comunicação, armazenamento e tolerância a falhas.

## Perguntas de revisão

### 1. O que distingue core e plugin?
Essencial e estável versus extensão especializada ou variável.

### 2. Como os plugins são integrados?
Por contratos e mecanismos de registro ou descoberta, estáticos ou dinâmicos.

### 3. Como service-based costuma organizar dados?
Frequentemente usa armazenamento compartilhado com coordenação entre serviços.

### 4. Por que controlar chamadas entre serviços?
Para reduzir dependências, latência e propagação de falhas.

### 5. Qual o risco de um banco compartilhado?
Gargalo e acoplamento de dados, esquema e disponibilidade.
