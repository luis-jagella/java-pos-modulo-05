# Aula 13: Clean Architecture

> Origem: `aula-13.mp3`.
Notas organizadas a partir da análise do áudio pelo Gemini. Não são transcrição literal.
O nome diferente atribuído pelo resumo automático foi normalizado para o arquivo original.

### 1. Proposta

Organizar o software para proteger regras de negócio de detalhes de interface, armazenamento e frameworks. A aula relaciona a abordagem a outras formas de separar políticas e mecanismos, como portas e adaptadores.

A representação em círculos é uma forma de explicar responsabilidades e dependências, não uma estrutura obrigatória de pastas.

### 2. Objetivos

- Testar regras sem iniciar banco ou servidor web.
- Alterar interfaces sem reescrever o domínio.
- Isolar persistência.
- Reduzir influência de bibliotecas e serviços externos sobre o negócio.
- Permitir adiar certas decisões técnicas.

Independência não significa troca de tecnologia sem qualquer trabalho: adaptadores, configuração e testes ainda precisam ser modificados.

### 3. Responsabilidades

Entidades:
Regras mais gerais do negócio.

Casos de uso:
Regras e coordenação específicas da aplicação.

Adaptadores de interface:
Conversão entre modelos internos e formatos de apresentação, API ou armazenamento. Podem incluir controllers, presenters e implementações de gateways.

Frameworks e drivers:
Detalhes externos como web, banco, UI e bibliotecas.

### 4. Dependency Rule

Dependências de código-fonte apontam para políticas mais internas. O núcleo não importa tipos, nomes ou estruturas definidos por detalhes externos.

Objetivo:
Evitar que ORM, HTTP, framework e representação de banco ditem as regras do domínio.

Importante:
Direção de dependência não é a mesma coisa que direção de execução. Um caso de uso pode chamar persistência por uma interface interna implementada externamente.

### 5. Inversão de dependência

Quando o caso de uso precisa salvar algo, uma porta descreve o contrato necessário. O adaptador de banco implementa esse contrato.

Exemplo didático de conexão com Java:
- Caso de uso recebe uma interface de repositório.
- Implementação concreta usa a tecnologia de persistência.
- A composição da aplicação conecta ambos.
- O teste fornece uma implementação em memória ou um substituto apropriado.

Esse exemplo é uma explicação adicional, não uma transcrição de código apresentado no áudio.

DIP, inversão de controle e injeção de dependência são relacionados, mas não idênticos. Injeção é uma forma de fornecer colaboradores sem fixar a implementação no consumidor.

### 6. Dados nas fronteiras

Transferir formatos simples e adequados ao contrato. Evitar expor ao núcleo tipos vinculados a bibliotecas externas ou registros de persistência.

Converter formatos custa código, mas controla vazamento de detalhes.

### 7. Riscos de centralizar no framework ou banco

Framework-centric:
As convenções da ferramenta passam a definir o desenho, dificultando evolução e testes.

Database-centric:
O modelo de armazenamento domina responsabilidades e fluxos. Um desenho que apenas espelha tabelas pode não expressar adequadamente regras e comportamento.

Usar framework ou banco não é um erro; o problema é perder controle das dependências relevantes.

### 8. Benefícios e custos

Benefícios:
Testabilidade, clareza das políticas, manutenção e isolamento de detalhes.

Custos:
Interfaces, adaptadores, mapeamentos e disciplina. A complexidade deve ser proporcional ao projeto, evitando abstrações sem necessidade.

### 9. Monolitos e microsserviços

Pode organizar internamente tanto um monolito quanto um serviço. Não determina o modelo de implantação.

Um monolito modular pode separar responsabilidades sem acrescentar comunicação de rede. Uma eventual extração para serviços ainda exige avaliação de dados, integração e operação.

## Perguntas de revisão

### 1. O que estabelece a Dependency Rule?
Dependências de código apontam para dentro.

### 2. Entidades e casos de uso diferem em quê?
Regras gerais de negócio versus políticas específicas da aplicação.

### 3. Para que servem adaptadores?
Traduzir modelos e integrar detalhes externos.

### 4. Por que evitar domínio subordinado ao framework?
Para preservar flexibilidade e teste das regras.

### 5. Qual o custo principal?
Código de fronteiras, abstrações e disciplina de manutenção.

Referência complementar para a regra de dependência:
Robert C. Martin — The Clean Architecture:
https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
