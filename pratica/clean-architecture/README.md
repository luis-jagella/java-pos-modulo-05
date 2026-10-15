# Prática — Clean Architecture com Java 17

Exercício autoral ligado às aulas 03, 05, 12 e 13. Implementa um pedido em rascunho que pode ser confirmado ou cancelado. Estados finalizados não podem mudar. São regras didáticas, não regras de um comércio real.

## Onde está cada responsabilidade

| Pacote | Responsabilidade |
| --- | --- |
| `domain` | Pedido imutável, validação e transições |
| `application` | Caso de uso e porta `PedidoRepository` |
| `infrastructure` | Adaptador de memória, dependente da porta |
| `cli` | Entrada e composição dos colaboradores |
| `tests` | Regras, falhas sem gravação e substituição de adaptador |

O domínio não importa aplicação ou infraestrutura. A aplicação importa domínio; o adaptador implementa o contrato interno. A CLI conecta as implementações pelo construtor, sem container de injeção.

Consulte o [diagrama de dependências](../../docs/catalogo-estilos.md#clean-architecture) e o [ADR](../../docs/adr/0001-monolito-modular.md).

## Executar em PowerShell

Requer `java` e `javac` de um JDK 17 ou superior no PATH. A partir da raiz do repositório:

```powershell
& ./pratica/clean-architecture/verificar.ps1
```

O script compila domínio/aplicação separados da infraestrutura, compila a aplicação e os testes, executa verificações e roda a demonstração. Erros interrompem a execução. A saída gerada em `out/` é ignorada pelo Git.

## Executar em Bash

A partir da raiz, com `rg` e JDK disponíveis:

```bash
cd pratica/clean-architecture
mkdir -p out/app out/tests
javac --release 17 -encoding UTF-8 -d out/app $(rg --files src -g '*.java')
javac --release 17 -encoding UTF-8 -cp out/app -d out/tests $(rg --files tests -g '*.java')
# Git Bash no Windows usa ';' no classpath; Linux/macOS usam ':'.
case "$(uname -s)" in
  MINGW*|MSYS*|CYGWIN*) task_separator=';' ;;
  *) task_separator=':' ;;
esac
java -cp "out/app${task_separator}out/tests" br.com.estudos.pedidos.PedidosTest
java -cp out/app br.com.estudos.pedidos.cli.Main
```

Saída da demonstração:

```text
Criado: RASCUNHO - Pedido de estudo
Confirmado: CONFIRMADO
Consultado: CONFIRMADO
```

## O que verificar

- Criação normaliza título e grava rascunho.
- Título vazio ou nulo falha antes da gravação.
- Confirmar/cancelar atualiza o repositório.
- Uma transição inválida preserva o estado salvo.
- Pedido inexistente não é criado por acidente.
- O caso de uso funciona com outro adaptador de teste.

## Limites e próximos experimentos

Persistência é volátil e o acesso é sequencial. Não há HTTP, autenticação, preço, concorrência, broker ou garantia transacional de produção. Exemplos de Kafka e outros estilos estão no [catálogo](../../docs/catalogo-estilos.md).

Para aprofundar: implementar um adaptador durável; adicionar entrada REST com Quarkus; depois justificar uma integração por evento com identidade e outbox. Cada etapa merece requisitos e testes próprios, sem mover detalhes externos para o domínio.
