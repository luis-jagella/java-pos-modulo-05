# Aula 07: Arquitetura em Camadas e Pipeline

> Origem: `aula-07.mp3`.
Notas organizadas a partir da análise do áudio pelo Gemini. Não são transcrição literal.

### 1. Arquitetura em camadas

Organiza o sistema por responsabilidades horizontais. Estrutura exemplificada:
- Apresentação: interação com o usuário.
- Negócio: regras, validações e casos de uso.
- Persistência: acesso e mapeamento de dados.
- Banco de dados: armazenamento.

A Lei de Conway relaciona estrutura de comunicação da organização e desenho do sistema. Equipes divididas em silos técnicos tendem a produzir fronteiras semelhantes no software. Essa influência não torna a arquitetura inevitável nem uma reprodução perfeitamente exata.

Arquitetura acidental ocorre quando a organização surge por hábito, sem avaliar necessidades e consequências.

### 2. Camadas fechadas e abertas

Fechadas:
Acesso segue as camadas intermediárias. Preserva isolamento e permite alterações internas com menor impacto.

Abertas:
Certos caminhos podem pular uma camada. Pode reduzir repasse e custo, mas exige contratos claros para não criar dependências arbitrárias.

O termo “Fast-Landing Reader” apareceu no resumo automático sem definição clara; não foi adotado como conceito técnico.

### 3. Sinkhole

Requisições atravessam camadas que apenas repassam dados. O custo dessas passagens pode não produzir benefício.

A aula apresenta uma referência aproximada de 80% de repasses como sinal para investigar o desenho. Isso é uma heurística, não um teste universal de qualidade.

### 4. Vantagens e limites

Vantagens:
- Familiaridade e simplicidade.
- Responsabilidades técnicas claras.
- Integração de novos membros.
- Menor esforço inicial em muitos MVPs.

Pontos de atenção:
- Overhead de passagem.
- Mudanças atravessando várias camadas.
- Crescimento de dependências.
- Testes e implantação amplos quando o sistema é um monolito.

Camadas não impedem comunicação assíncrona, replicação ou escala. Parte das limitações citadas depende da implementação e do modelo de implantação, não do particionamento lógico em si.

### 5. Pipeline — Pipes and Filters

Organiza processamento em etapas conectadas. Cada filtro executa uma função e os pipes transportam dados.

Exemplos e analogias:
Pipes Unix, programação funcional, MapReduce, Java Streams, fluxos reativos e rotas Apache Camel.

Pode estruturar lotes ou fluxos contínuos dentro de uma aplicação, sem exigir serviços distribuídos.

### 6. Papéis dos filtros

- Pump ou produtor: inicia o fluxo e fornece dados, como leitura de arquivo.
- Transformer: converte, calcula ou transforma; idealmente uma responsabilidade por filtro.
- Tester: avalia condições e orienta o processamento.
- Consumer ou sink: destino final, como gravação dos resultados.

Nota: “sink” é o termo para o destino; “sync” no resumo automático é uma grafia inadequada nesse contexto.

### 7. Pipes e independência

Filtros devem ter interfaces claras, pouco conhecimento uns dos outros e, quando apropriado, operar sem estado. O modelo básico usa canais entre etapas.

O resumo descreve pipes ponto a ponto. Isso não impede composições mais complexas, mas ajuda a entender o fluxo básico e seus contratos.

### 8. Vantagens e limitações

Vantagens:
Reutilização, teste de etapas isoladas, clareza das transformações e facilidade de compor processamento.

Limitações:
Uma etapa lenta pode limitar o fluxo inteiro. Paralelismo, buffers e controle de demanda podem ser necessários. Processos de negócio com muitas interações e ramificações podem não se encaixar bem em uma sequência simples.

## Perguntas de revisão

### 1. Qual a relação com Conway?
A comunicação das equipes influencia as fronteiras do software.

### 2. Camadas abertas e fechadas diferem em quê?
Na possibilidade de pular certas etapas de acesso.

### 3. O que é Sinkhole?
Passagem por camadas sem trabalho útil.

### 4. Quais são os papéis do pipeline?
Produtor, transformador, avaliador e consumidor final.

### 5. Por que camadas podem servir a um MVP?
Familiaridade, separação de responsabilidades e menor esforço inicial.
